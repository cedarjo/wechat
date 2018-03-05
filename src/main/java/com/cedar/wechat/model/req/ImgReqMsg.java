package com.cedar.wechat.model.req;

/**
 * 图片消息
 */
public class ImgReqMsg extends BaseReqMsg {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
