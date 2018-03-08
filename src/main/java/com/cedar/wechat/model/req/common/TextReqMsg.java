package com.cedar.wechat.model.req.common;

import com.cedar.wechat.util.ReqMsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 文本消息
 */
@Getter
@Setter
@ToString
public class TextReqMsg extends CommonReqMsg {
    // 文本消息内容
    private String Content;

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.TEXT;
    }
}
