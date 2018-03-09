package com.cedar.wechat.model.req.event;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QrScanReqMsg extends EventReqMsg {
    // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String EventKey;
    // 二维码的ticket，可用来换取二维码图片
    private String Ticket;

    @Override
    public String getEvent() {
        return ReqMsgUtil.ReqMsgEventType.SCAN;
    }
}
