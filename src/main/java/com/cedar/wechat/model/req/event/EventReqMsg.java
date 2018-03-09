package com.cedar.wechat.model.req.event;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class EventReqMsg extends BaseReqMsg {
    private String Event;

    protected abstract String getEvent();

    @Override
    public String getMsgType() {
        return ReqMsgUtil.ReqMsgType.EVENT;
    }
}
