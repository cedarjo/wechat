package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.ReportLocationReqMsg;
import com.cedar.wechat.service.req.event.LocationEventReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("locationEventReqService")
@Slf4j
public class LocationEventReqServiceImpl implements LocationEventReqService {
    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("locationEventReqService-processRequest");
        ReportLocationReqMsg reportLocationReqMsg = (ReportLocationReqMsg) request;
        return null;
    }
}
