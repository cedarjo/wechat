package com.cedar.wechat.service;

import com.cedar.wechat.model.req.BaseReqMsg;
import com.cedar.wechat.model.resp.BaseRespMsg;

public interface ReqService {

    BaseRespMsg processRequest(BaseReqMsg request);

}
