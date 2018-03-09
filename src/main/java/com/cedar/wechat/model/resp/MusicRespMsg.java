package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XStreamAlias(RespMsgUtil.XmlNodeName.XML)
public class MusicRespMsg extends BaseRespMsg {
    // 音乐标题
    private String Title;
    // 音乐描述
    private String Description;
    // 音乐链接
    private String MusicURL;
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;
    // 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
    private String ThumbMediaId;

    public MusicRespMsg() {
        super(RespMsgUtil.RespMsgType.MUSIC);
    }
}
