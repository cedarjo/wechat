package com.cedar.wechat.model.req.common;

import com.cedar.wechat.model.req.BaseReqMsg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 消息基类（普通用户 -> 公众帐号）
 */
@Getter
@Setter
@ToString
public abstract class CommonReqMsg extends BaseReqMsg {
    // 消息id，64位整型
    private Long MsgId;
}
