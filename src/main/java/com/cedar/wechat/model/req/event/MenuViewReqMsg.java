package com.cedar.wechat.model.req.event;

import com.cedar.wechat.util.ReqEventTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuViewReqMsg extends EventReqMsg {
    // 事件KEY值，设置的跳转URL
    private String EventKey;

    @Override
    public ReqEventTypeEnum getEvent() {
        return ReqEventTypeEnum.VIEW;
    }
}
