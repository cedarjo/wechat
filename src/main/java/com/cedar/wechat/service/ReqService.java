package com.cedar.wechat.service;

import com.cedar.wechat.model.req.BaseReqMsg;

public interface ReqService {

    <T extends BaseReqMsg> String processRequest(T request);

}
