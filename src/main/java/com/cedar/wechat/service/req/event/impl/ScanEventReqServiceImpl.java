package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.QrScanReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.model.resp.TextRespMsg;
import com.cedar.wechat.service.req.event.ScanEventReqService;
import com.cedar.wechat.util.RespMsgUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("scanEventReqService")
@Slf4j
public class ScanEventReqServiceImpl implements ScanEventReqService {
    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("scanEventReqService-processRequest");
        QrScanReqMsg qrScanReqMsg = (QrScanReqMsg) request;

        TextRespMsg response = RespMsgUtil.initResponse(qrScanReqMsg, RespMsgUtil.RespMsgType.TEXT);
        response.setContent("已经关注过了");
        return response;
    }
}
