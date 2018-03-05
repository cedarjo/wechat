package com.cedar.wechat.model.req;

/**
 * 文本消息
 */
public class TextReqMsg extends BaseReqMsg {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
