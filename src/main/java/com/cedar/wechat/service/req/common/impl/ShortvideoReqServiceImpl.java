package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.common.ShortvideoReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("shortvideoReqService")
@Slf4j
public class ShortvideoReqServiceImpl implements ShortvideoReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("shortvideoReqService-processRequest");
        return null;
    }
}
