package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.MenuClickReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.event.ClickEventReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("clickEventReqService")
@Slf4j
public class ClickEventReqServiceImpl implements ClickEventReqService {
    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("clickEventReqService-processRequest");
        MenuClickReqMsg menuClickReqMsg = (MenuClickReqMsg) request;
        return null;
    }
}
