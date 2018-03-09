package com.cedar.wechat.model.req.event;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReportLocationReqMsg extends EventReqMsg {
    // 地理位置纬度
    private String Latitude;
    // 地理位置经度
    private String Longitude;
    // 地理位置精度
    private String Precision;

    @Override
    public String getEvent() {
        return ReqMsgUtil.ReqMsgEventType.LOCATION;
    }
}
