package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.UnsubscribeReqMsg;
import com.cedar.wechat.service.req.event.UnsubscribeEventReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("unsubscribeEventReqService")
@Slf4j
public class UnsubscribeEventReqServiceImpl implements UnsubscribeEventReqService {
    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("unsubscribeEventReqService-processRequest");
        UnsubscribeReqMsg unsubscribeReqMsg = (UnsubscribeReqMsg) request;
        return null;
    }
}
