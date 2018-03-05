package com.cedar.wechat.model.req;

/**
 * 菜单
 */
public class MenuReqMsg extends BaseReqMsg {
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}