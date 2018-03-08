package com.cedar.wechat.model.req.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 语音识别
 */
@Getter
@Setter
@ToString
public class VoiceRecognitionReqMsg extends VoiceReqMsg {
    // 语音识别结果，UTF8编码
    private String Recognition;
}
