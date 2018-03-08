package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageRespMsg extends BaseRespMsg {
    // 	通过素材管理中的接口上传多媒体文件，得到的id。
    private String MediaId;

    @Override
    public RespMsgTypeEnum getMsgType() {
        return RespMsgTypeEnum.IMAGE;
    }
}
