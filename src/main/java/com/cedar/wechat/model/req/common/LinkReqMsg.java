package com.cedar.wechat.model.req.common;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 链接消息
 */
@Getter
@Setter
@ToString
public class LinkReqMsg extends CommonReqMsg {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    @Override
    public String getMsgType() {
        return ReqMsgUtil.ReqMsgType.LINK;
    }
}
