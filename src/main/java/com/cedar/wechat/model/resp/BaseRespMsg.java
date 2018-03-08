package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 消息基类（公众帐号 -> 普通用户）
 */
@Getter
@Setter
@ToString
public abstract class BaseRespMsg {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private Long CreateTime;
    // 消息类型
    private RespMsgTypeEnum MsgType;

    protected abstract RespMsgTypeEnum getMsgType();
}
