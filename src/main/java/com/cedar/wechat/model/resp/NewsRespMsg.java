package com.cedar.wechat.model.resp;

import com.cedar.wechat.util.RespMsgUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Slf4j
@XStreamAlias(RespMsgUtil.XmlNodeName.XML)
public class NewsRespMsg extends BaseRespMsg {
    // 图文消息个数，限制为8条以内
    private Integer ArticleCount;

    public void setArticleCount(Integer articleCount) {
        if (articleCount != null && articleCount > 8) {
            this.ArticleCount = 8;
        } else {
            this.ArticleCount = articleCount;
        }
    }

    // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
    private List<Article> Articles = new ArrayList<>(0);
    // 图文消息标题
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;

    public NewsRespMsg() {
        super(RespMsgUtil.RespMsgType.NEWS);
    }
}
