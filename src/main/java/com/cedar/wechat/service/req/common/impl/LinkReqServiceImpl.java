package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.service.req.common.LinkReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("linkReqService")
@Slf4j
public class LinkReqServiceImpl implements LinkReqService {

    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("linkReqService-processRequest");
        return null;
    }
}
