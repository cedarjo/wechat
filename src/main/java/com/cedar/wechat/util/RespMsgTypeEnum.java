package com.cedar.wechat.util;

/**
 * 响应消息类型
 */
public enum RespMsgTypeEnum {

    // 文本
    TEXT("text"),
    // 图片
    IMAGE("image"),
    // 音频
    VOICE("voice"),
    // 视频
    VIDEO("video"),
    // 音乐
    MUSIC("music"),
    // 图文消息
    NEWS("news");

    private String value;

    RespMsgTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
