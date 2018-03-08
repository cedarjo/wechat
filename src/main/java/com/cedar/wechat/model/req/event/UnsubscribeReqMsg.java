package com.cedar.wechat.model.req.event;

import com.cedar.wechat.util.ReqEventTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UnsubscribeReqMsg extends EventReqMsg {
    @Override
    public ReqEventTypeEnum getEvent() {
        return ReqEventTypeEnum.UNSUBSCRIBE;
    }
}
