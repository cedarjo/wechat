package com.cedar.wechat.model.req.common;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 音频消息
 */
@Getter
@Setter
@ToString
public class VoiceReqMsg extends CommonReqMsg {
    // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    // 语音格式，如amr，speex等
    private String Format;

    @Override
    public String getMsgType() {
        return ReqMsgUtil.ReqMsgType.VOICE;
    }
}
