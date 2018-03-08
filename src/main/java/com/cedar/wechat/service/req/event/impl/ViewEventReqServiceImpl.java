package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.MenuViewReqMsg;
import com.cedar.wechat.service.req.event.ViewEventReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("viewEventReqService")
@Slf4j
public class ViewEventReqServiceImpl implements ViewEventReqService {
    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("viewEventReqService-processRequest");
        MenuViewReqMsg menuViewReqMsg = (MenuViewReqMsg) request;
        return null;
    }
}
