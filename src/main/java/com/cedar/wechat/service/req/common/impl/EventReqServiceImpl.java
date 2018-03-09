package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.ReqService;
import com.cedar.wechat.service.req.common.EventReqService;
import com.cedar.wechat.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service("eventReqService")
@Slf4j
public class EventReqServiceImpl implements EventReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("eventReqService-processRequest");
        String event;
        try {
            Method getEvent = request.getClass().getMethod("getEvent");
            event = (String) getEvent.invoke(request);
        } catch (Exception e) {
            log.error("执行getEvent方法异常", e);
            return null;
        }
        ReqService reqService = SpringContextHolder.getReqService(StringUtils.lowerCase(event) + "Event");
        return reqService.processRequest(request);
    }
}
