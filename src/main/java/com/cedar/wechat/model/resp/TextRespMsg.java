package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 文本消息
 */
@Getter
@Setter
@ToString
public class TextRespMsg extends BaseRespMsg {
    // 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    private String Content;

    @Override
    public RespMsgTypeEnum getMsgType() {
        return RespMsgTypeEnum.TEXT;
    }
}
