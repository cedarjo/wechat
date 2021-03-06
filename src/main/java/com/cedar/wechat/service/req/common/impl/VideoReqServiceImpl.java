package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.common.VideoReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("videoReqService")
@Slf4j
public class VideoReqServiceImpl implements VideoReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("videoReqService-processRequest");
        return null;
    }
}
