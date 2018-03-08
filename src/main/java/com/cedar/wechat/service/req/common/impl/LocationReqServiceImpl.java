package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.service.req.common.LocationReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("locationReqService")
@Slf4j
public class LocationReqServiceImpl implements LocationReqService {

    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("locationReqService-processRequest");
        return null;
    }
}
