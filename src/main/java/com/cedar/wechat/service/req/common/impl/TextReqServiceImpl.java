package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.common.TextReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.common.TextReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("textReqService")
@Slf4j
public class TextReqServiceImpl implements TextReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("textReqService-processRequest");
        TextReqMsg textReqMsg = (TextReqMsg) request;

        return null;
    }
}
