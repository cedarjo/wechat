package com.cedar.wechat.util;

/**
 * 请求消息的key值
 */
public enum ReqMsgKeyEnum {

    // 发送方账号
    FROM_USER_NAME("FromUserName"),
    // 公众账号
    TO_USER_NAME("ToUserName"),
    // 消息类型
    MSG_TYPE("MsgType"),
    // 事件类型
    EVENT("Event"),
    // 文本消息内容
    CONTENT("Content");

    private String value;

    ReqMsgKeyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
