package com.cedar.wechat.model.resp;

/**
 * 文本消息
 */
public class TextRespMsg extends BaseRespMsg {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}