package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.QrSubscribeReqMsg;
import com.cedar.wechat.service.req.event.SubscribeEventReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("subscribeEventReqService")
@Slf4j
public class SubscribeEventReqServiceImpl implements SubscribeEventReqService {
    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("subscribeEventReqService-processRequest");
        QrSubscribeReqMsg qrSubscribeReqMsg = (QrSubscribeReqMsg) request;
        return null;
    }
}
