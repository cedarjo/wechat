package com.cedar.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.EventReqMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class ReqMsgUtil {

    private static Class<? extends BaseReqMsg> initClass(String msgType, String event) {
        log.info("MsgType:{}", msgType);
        ReqMsgTypeEnum reqMsgTypeEnum = ReqMsgTypeEnum.valueOf(StringUtils.upperCase(msgType));
        Class modelClass = reqMsgTypeEnum.getModelClass();
        if (EventReqMsg.class.equals(modelClass)) {
            log.info("Event:{}", event);
            ReqEventTypeEnum reqEventTypeEnum = ReqEventTypeEnum.valueOf(StringUtils.upperCase(event));
            modelClass = reqEventTypeEnum.getModelClass();
        }
        log.info("ModelClass:{}", modelClass.getSimpleName());
        return modelClass;
    }

    public static <T extends BaseReqMsg> T initParams(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String msgType = jsonObject.getString(ReqMsgKeyEnum.MSG_TYPE.getValue());
        String event = jsonObject.getString(ReqMsgKeyEnum.EVENT.getValue());
        Class<? extends BaseReqMsg> clazz = initClass(msgType, event);
        T t = (T) JSON.parseObject(json, clazz);
        return t;
    }

}
