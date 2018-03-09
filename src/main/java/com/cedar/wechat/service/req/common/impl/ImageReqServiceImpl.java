package com.cedar.wechat.service.req.common.impl;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.req.common.ImageReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.service.req.common.ImageReqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("imageReqService")
@Slf4j
public class ImageReqServiceImpl implements ImageReqService {

    @Override
    public BaseRespMsg processRequest(BaseReqMsg request) {
        log.info("imageReqService-processRequest");
        ImageReqMsg imageReqMsg = (ImageReqMsg) request;
        log.info(imageReqMsg.toString());
        return null;
    }
}
