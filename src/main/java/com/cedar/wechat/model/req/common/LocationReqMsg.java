package com.cedar.wechat.model.req.common;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 地理位置消息
 */
@Getter
@Setter
@ToString
public class LocationReqMsg extends CommonReqMsg {
    // 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;

    @Override
    public String getMsgType() {
        return ReqMsgUtil.ReqMsgType.LOCATION;
    }
}
