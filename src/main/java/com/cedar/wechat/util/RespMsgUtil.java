package com.cedar.wechat.util;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.resp.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RespMsgUtil {

    public static class RespMsgType {
        // 文本
        public static final String TEXT = "text";
        // 图片
        public static final String IMAGE = "image";
        // 音频
        public static final String VOICE = "voice";
        // 视频
        public static final String VIDEO = "video";
        // 音乐
        public static final String MUSIC = "music";
        // 图文消息
        public static final String NEWS = "news";

        public static final Map<String, RespMsgConfig> CONFIG;

        static {
            CONFIG = new HashMap<>();
            CONFIG.put(TEXT, new RespMsgConfig(TEXT, TextRespMsg.class));
            CONFIG.put(IMAGE, new RespMsgConfig(IMAGE, ImageRespMsg.class));
            CONFIG.put(VOICE, new RespMsgConfig(VOICE, VoiceRespMsg.class));
            CONFIG.put(VIDEO, new RespMsgConfig(VIDEO, VideoRespMsg.class));
            CONFIG.put(MUSIC, new RespMsgConfig(MUSIC, MusicRespMsg.class));
            CONFIG.put(NEWS, new RespMsgConfig(NEWS, NewsRespMsg.class));
        }
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RespMsgConfig {
        private String code;
        private Class<? extends BaseRespMsg> modelClass;
    }

    public static class XmlNodeName {
        public static final String XML = "xml";
        public static final String ITEM = "item";
    }

    public static <T extends BaseRespMsg> T initResponse(BaseReqMsg request, String msgType) {
        RespMsgConfig respMsgConfig = RespMsgType.CONFIG.get(msgType);
        Class<? extends BaseRespMsg> modelClass = respMsgConfig.getModelClass();
        T t;
        try {
            t = (T) modelClass.newInstance();
        } catch (Exception e) {
            log.error("实例化返回值model失败", e);
            return null;
        }
        t.setFromUserName(request.getToUserName());
        t.setToUserName(request.getFromUserName());
        t.setCreateTime(new Date().getTime());
        return t;
    }

    /**
     * 实体转成xml
     *
     * @param response
     * @param <T>
     * @return
     */
    public static <T extends BaseRespMsg> String modelToXml(T response) {
        xstream.autodetectAnnotations(true);
        return xstream.toXML(response);
    }

    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

}
