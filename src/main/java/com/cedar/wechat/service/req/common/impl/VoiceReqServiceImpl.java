package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.service.req.common.VoiceReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("voiceReqService")
@Slf4j
public class VoiceReqServiceImpl implements VoiceReqService {

    @Override
    public <T extends BaseReqMsg> String processRequest(T request) {
        log.info("voiceReqService-processRequest");
        return null;
    }
}