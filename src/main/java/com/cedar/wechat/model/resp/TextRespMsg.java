package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 文本消息
 */
@Getter
@Setter
@ToString
@XStreamAlias(RespMsgUtil.XmlNodeName.XML)
public class TextRespMsg extends BaseRespMsg {
    // 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    private String Content;

    public TextRespMsg() {
        super(RespMsgUtil.RespMsgType.TEXT);
    }
}
