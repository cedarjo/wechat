package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.QrScanReqMsg;
import com.cedar.wechat.service.req.event.ScanEventReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("scanEventReqService")
@Slf4j
public class ScanEventReqServiceImpl implements ScanEventReqService {
    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("scanEventReqService-processRequest");
        QrScanReqMsg qrScanReqMsg = (QrScanReqMsg) request;
        return null;
    }
}
