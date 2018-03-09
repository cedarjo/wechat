package com.cedar.wechat.model.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 消息基类（普通用户 -> 公众帐号）
 */
@Getter
@Setter
@ToString
public abstract class BaseReqMsg {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private Long CreateTime;
    // 消息类型
    private String MsgType;

    protected abstract String getMsgType();

}
