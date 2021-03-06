package com.cedar.wechat.model.req.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QrSubscribeReqMsg extends SubscribeReqMsg {
    // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String EventKey;
    // 二维码的ticket，可用来换取二维码图片
    private String Ticket;
}
