package com.cedar.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.common.*;
import com.cedar.wechat.model.req.event.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ReqMsgUtil {

    public static class ReqMsgKey {
        // 发送方账号
        public static final String FROM_USER_NAME = "FromUserName";
        // 公众账号
        public static final String TO_USER_NAME = "ToUserName";
        // 消息类型
        public static final String MSG_TYPE = "MsgType";
        // 事件类型
        public static final String EVENT = "Event";
        // 文本消息内容
        public static final String CONTENT = "Content";
    }

    public static class ReqMsgType {
        // 文本
        public static final String TEXT = "text";
        // 图片
        public static final String IMAGE = "image";
        // 链接
        public static final String LINK = "link";
        // 地理位置
        public static final String LOCATION = "location";
        // 音频
        public static final String VOICE = "voice";
        // 视频
        public static final String VIDEO = "video";
        // 小视频
        public static final String SHORT_VIDEO = "shortvideo";
        // 推送
        public static final String EVENT = "event";

        public static final Map<String, ReqMsgConfig> CONFIG;

        static {
            CONFIG = new HashMap<>();
            CONFIG.put(TEXT, new ReqMsgConfig(TEXT, TextReqMsg.class));
            CONFIG.put(IMAGE, new ReqMsgConfig(IMAGE, ImageReqMsg.class));
            CONFIG.put(LINK, new ReqMsgConfig(LINK, LinkReqMsg.class));
            CONFIG.put(LOCATION, new ReqMsgConfig(LOCATION, LocationReqMsg.class));
            CONFIG.put(VOICE, new ReqMsgConfig(VOICE, VoiceRecognitionReqMsg.class));
            CONFIG.put(VIDEO, new ReqMsgConfig(VIDEO, VideoReqMsg.class));
            CONFIG.put(SHORT_VIDEO, new ReqMsgConfig(SHORT_VIDEO, ShortvideoReqMsg.class));
            CONFIG.put(EVENT, new ReqMsgConfig(EVENT, EventReqMsg.class));
        }

    }

    public static class ReqMsgEventType {
        // 订阅
        public static final String SUBSCRIBE = "subscribe";
        // 取消订阅
        public static final String UNSUBSCRIBE = "unsubscribe";
        // 扫描二维码已关注
        public static final String SCAN = "SCAN";
        // 上报地理位置
        public static final String LOCATION = "LOCATION";
        // 点击菜单拉取消息
        public static final String CLICK = "CLICK";
        // 点击菜单跳转链接
        public static final String VIEW = "VIEW";

        public static final Map<String, ReqMsgConfig> CONFIG;

        static {
            CONFIG = new HashMap<>();
            CONFIG.put(SUBSCRIBE, new ReqMsgConfig(SUBSCRIBE, QrSubscribeReqMsg.class));
            CONFIG.put(UNSUBSCRIBE, new ReqMsgConfig(UNSUBSCRIBE, UnsubscribeReqMsg.class));
            CONFIG.put(SCAN, new ReqMsgConfig(SCAN, QrScanReqMsg.class));
            CONFIG.put(LOCATION, new ReqMsgConfig(LOCATION, ReportLocationReqMsg.class));
            CONFIG.put(CLICK, new ReqMsgConfig(CLICK, MenuClickReqMsg.class));
            CONFIG.put(VIEW, new ReqMsgConfig(VIEW, MenuViewReqMsg.class));
        }
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqMsgConfig {
        private String code;
        private Class modelClass;
    }

    private static Class<? extends BaseReqMsg> initClass(String msgType, String event) {
        log.info("MsgType:{}", msgType);
        ReqMsgConfig typeConfig = ReqMsgType.CONFIG.get(msgType);
        Class modelClass = typeConfig.getModelClass();
        if (EventReqMsg.class.equals(modelClass)) {
            log.info("Event:{}", event);
            ReqMsgConfig eventConfig = ReqMsgEventType.CONFIG.get(event);
            modelClass = eventConfig.getModelClass();
        }
        log.info("ModelClass:{}", modelClass.getSimpleName());
        return modelClass;
    }

    public static <T extends BaseReqMsg> T initParams(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String msgType = jsonObject.getString(ReqMsgKey.MSG_TYPE);
        String event = jsonObject.getString(ReqMsgKey.EVENT);
        Class<? extends BaseReqMsg> clazz = initClass(msgType, event);
        T t = (T) JSON.parseObject(json, clazz);
        return t;
    }

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static String parseJson(HttpServletRequest request) throws Exception {
        // 将解析结果拼接一个json串
        StringBuilder json = new StringBuilder();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        json.append("{");
        for (Element e : elementList) {
            json.append("\"").append(e.getName()).append("\":\"").append(e.getText()).append("\",");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("}");

        // 释放资源
        inputStream.close();
        inputStream = null;

        return json.toString();
    }

}
