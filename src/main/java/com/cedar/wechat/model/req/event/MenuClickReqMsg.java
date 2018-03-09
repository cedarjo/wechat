package com.cedar.wechat.model.req.event;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuClickReqMsg extends EventReqMsg {
    // 事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;

    @Override
    public String getEvent() {
        return ReqMsgUtil.ReqMsgEventType.CLICK;
    }
}
