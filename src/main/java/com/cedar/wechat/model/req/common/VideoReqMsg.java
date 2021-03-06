package com.cedar.wechat.model.req.common;

import com.cedar.wechat.util.ReqMsgUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 视频消息
 */
@Getter
@Setter
@ToString
public class VideoReqMsg extends CommonReqMsg {
    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;

    @Override
    public String getMsgType() {
        return ReqMsgUtil.ReqMsgType.VIDEO;
    }
}
