package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.common.VoiceRecognitionReqMsg;
import com.cedar.wechat.model.req.common.VoiceReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.common.VoiceReqService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("voiceReqService")
@Slf4j
public class VoiceReqServiceImpl implements VoiceReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("voiceReqService-processRequest");
        VoiceRecognitionReqMsg voiceRecognitionReqMsg = (VoiceRecognitionReqMsg) request;
        if (StringUtils.isNotBlank(voiceRecognitionReqMsg.getRecognition())) {
            // 语音识别
            return voiceRecognitionProcessRequest(voiceRecognitionReqMsg);
        }
        VoiceReqMsg voiceReqMsg = voiceRecognitionReqMsg;
        return voiceProcessRequest(voiceReqMsg);
    }

    private BaseRespMsg voiceProcessRequest(VoiceReqMsg voiceReqMsg) {
        return null;
    }

    private BaseRespMsg voiceRecognitionProcessRequest(VoiceRecognitionReqMsg voiceRecognitionReqMsg) {
        return null;
    }
}
