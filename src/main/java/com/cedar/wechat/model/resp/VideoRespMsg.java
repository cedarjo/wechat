package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias(RespMsgUtil.XmlNodeName.XML)
public class VideoRespMsg extends BaseRespMsg {
    // 通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;
    // 视频消息的标题
    private String Title;
    // 视频消息的描述
    private String Description;

    public VideoRespMsg() {
        super(RespMsgUtil.RespMsgType.VIDEO);
    }
}
