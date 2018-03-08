package com.cedar.wechat.model.req.common;

import com.cedar.wechat.util.ReqMsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 图片消息
 */
@Getter
@Setter
@ToString
public class ImageReqMsg extends CommonReqMsg {
    // 图片链接（由系统生成）
    private String PicUrl;
    // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;

    @Override
    public ReqMsgTypeEnum getMsgType() {
        return ReqMsgTypeEnum.IMAGE;
    }
}
