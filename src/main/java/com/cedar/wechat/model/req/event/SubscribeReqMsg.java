package com.cedar.wechat.model.req.event;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubscribeReqMsg extends EventReqMsg {
    @Override
    public String getEvent() {
        return ReqMsgUtil.ReqMsgEventType.SUBSCRIBE;
    }
}
