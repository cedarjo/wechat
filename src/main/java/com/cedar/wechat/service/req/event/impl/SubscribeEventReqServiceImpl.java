package com.cedar.wechat.service.req.event.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.event.QrSubscribeReqMsg;
import com.cedar.wechat.model.req.event.SubscribeReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.model.resp.TextRespMsg;
import com.cedar.wechat.service.req.event.SubscribeEventReqService;
import com.cedar.wechat.util.RespMsgUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("subscribeEventReqService")
@Slf4j
public class SubscribeEventReqServiceImpl implements SubscribeEventReqService {
    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("subscribeEventReqService-processRequest");
        QrSubscribeReqMsg qrSubscribeReqMsg = (QrSubscribeReqMsg) request;
        if (StringUtils.isNotBlank(qrSubscribeReqMsg.getEventKey())) {
            return qrSubscribeProcessRequest(qrSubscribeReqMsg);
        }
        // 点击关注订阅
        SubscribeReqMsg subscribeReqMsg = qrSubscribeReqMsg;
        return subscribeProcessRequest(subscribeReqMsg);
    }

    private BaseRespMsg subscribeProcessRequest(SubscribeReqMsg subscribeReqMsg) {
        TextRespMsg response = RespMsgUtil.initResponse(subscribeReqMsg, RespMsgUtil.RespMsgType.TEXT);
        response.setContent("点击关注来获取关注");
        return response;
    }

    private BaseRespMsg qrSubscribeProcessRequest(QrSubscribeReqMsg qrSubscribeReqMsg) {
        TextRespMsg response = RespMsgUtil.initResponse(qrSubscribeReqMsg, RespMsgUtil.RespMsgType.TEXT);
        response.setContent("扫描二维码获取关注");
        return response;
    }


}
