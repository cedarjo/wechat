package com.cedar.wechat.util;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.common.*;
import com.cedar.wechat.model.req.event.EventReqMsg;

/**
 * 请求消息类型
 */
public enum ReqMsgTypeEnum {

    // 文本
    TEXT("text", TextReqMsg.class),
    // 图片
    IMAGE("image", ImageReqMsg.class),
    // 链接
    LINK("link", LinkReqMsg.class),
    // 地理位置
    LOCATION("location", LocationReqMsg.class),
    // 音频
    VOICE("voice", VoiceReqMsg.class),
    // 视频
    VIDEO("video", VideoReqMsg.class),
    // 小视频
    SHORTVIDEO("shortvideo", ShortvideoReqMsg.class),
    // 推送
    EVENT("event", EventReqMsg.class);

    private String value;

    private Class<? extends BaseReqMsg> modelClass;

    ReqMsgTypeEnum(String value, Class modelClass) {
        this.value = value;
        this.modelClass = modelClass;
    }

    public String getValue() {
        return this.value;
    }

    public Class<? extends BaseReqMsg> getModelClass() {
        return this.modelClass;
    }

}
