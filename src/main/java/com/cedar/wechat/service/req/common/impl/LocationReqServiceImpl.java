package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.common.LocationReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("locationReqService")
@Slf4j
public class LocationReqServiceImpl implements LocationReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("locationReqService-processRequest");
        return null;
    }
}
