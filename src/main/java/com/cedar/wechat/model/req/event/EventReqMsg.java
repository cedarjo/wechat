package com.cedar.wechat.model.req.event;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.util.ReqEventTypeEnum;
import com.cedar.wechat.util.ReqMsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class EventReqMsg extends BaseReqMsg {
    private ReqEventTypeEnum Event;

    protected abstract ReqEventTypeEnum getEvent();

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.EVENT;
    }
}
