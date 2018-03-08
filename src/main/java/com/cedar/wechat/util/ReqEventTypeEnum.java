package com.cedar.wechat.util;

import com.cedar.wechat.model.req.common.LocationReqMsg;
import com.cedar.wechat.model.req.event.*;

/**
 * 推送类型
 */
public enum ReqEventTypeEnum {

    // 订阅
    SUBSCRIBE("subscribe", QrSubscribeReqMsg.class),
    // 取消订阅
    UNSUBSCRIBE("unsubscribe", UnsubscribeReqMsg.class),
    // 扫描二维码已关注
    SCAN("SCAN", QrScanReqMsg.class),
    // 上报地理位置
    LOCATION("LOCATION", LocationReqMsg.class),
    // 点击菜单拉取消息
    CLICK("CLICK", MenuClickReqMsg.class),
    // 点击菜单跳转链接
    VIEW("VIEW", MenuViewReqMsg.class);

    private String value;

    private Class<? extends EventReqMsg> modelClass;

    ReqEventTypeEnum(String value, Class modelClass) {
        this.value = value;
        this.modelClass = modelClass;
    }

    public String getValue() {
        return this.value;
    }

    public Class<? extends EventReqMsg> getModelClass() {
        return this.modelClass;
    }

}
