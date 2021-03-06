package com.cedar.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cedar.wechat.model.resp.Article;
import com.cedar.wechat.model.resp.BaseRespMsg;
import com.cedar.wechat.model.resp.NewsRespMsg;
import com.cedar.wechat.model.resp.TextRespMsg;
import com.cedar.wechat.service.CoreService;
import com.cedar.wechat.service.ReqService;
import com.cedar.wechat.util.ReqMsgUtil;
import com.cedar.wechat.util.RespMsgUtil;
import com.cedar.wechat.util.SpringContextHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class CoreServiceImpl implements CoreService {

    private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    /**
     * 处理微信发来的请求（包括事件的推送）
     *
     * @param request
     * @return
     */
    public String processRequest(HttpServletRequest request) {
        try {
            // xml请求解析
            String json = ReqMsgUtil.parseJson(request);
            log.info("入参：{}", json);

            JSONObject obj = JSON.parseObject(json);
            // 消息类型
            String msgType = obj.getString(ReqMsgUtil.ReqMsgKey.MSG_TYPE);
            ReqService reqService = SpringContextHolder.getReqService(StringUtils.lowerCase(msgType));
            BaseRespMsg response = reqService.processRequest(ReqMsgUtil.jsonToModel(json));
            return RespMsgUtil.modelToXml(response);
        } catch (Exception e) {
            log.error("请求处理异常，请稍候尝试！", e);
            return "请求处理异常，请稍候尝试！";
        }
    }

    private String init(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";
            // xml请求解析
            Properties params = null;//MsgUtil.parseXml(request);
            log.info("入参：{}", params.toString());
            // 发送方帐号（open_id）
            String fromUserName = params.getProperty("FromUserName");
            // 公众帐号
            String toUserName = params.getProperty("ToUserName");
            // 消息类型
            String msgType = params.getProperty("MsgType");
            // 回复文本消息
            TextRespMsg textRespMsg = new TextRespMsg();
            textRespMsg.setToUserName(fromUserName);
            textRespMsg.setFromUserName(toUserName);
            textRespMsg.setCreateTime(new Date().getTime());
            textRespMsg.setMsgType(RespMsgUtil.RespMsgType.TEXT);

            // 创建图文消息
            NewsRespMsg articleRespMsg = new NewsRespMsg();
            articleRespMsg.setToUserName(fromUserName);
            articleRespMsg.setFromUserName(toUserName);
            articleRespMsg.setCreateTime(new Date().getTime());
            articleRespMsg.setMsgType(RespMsgUtil.RespMsgType.NEWS);

            List<Article> articleList = new ArrayList<>();
            //点击菜单id
            String EventKey = params.getProperty("EventKey");
            // 接收文本消息内容
            String content = params.getProperty("Content");
            // 自动回复文本消息
            if (msgType.equals(ReqMsgUtil.ReqMsgType.TEXT)) {

                // 如果用户发送表情，则回复同样表情。
                if (ReqMsgUtil.isQqFace(content)) {
                    respContent = content;
                    textRespMsg.setContent(respContent);
                    // 将文本消息对象转换成xml字符串
                    respMessage = RespMsgUtil.modelToXml(textRespMsg);
                } else {
                    //回复固定消息
                    switch (content) {

                        case "1": {
                            StringBuffer buffer = new StringBuffer();
                            buffer.append("您好，我是小8，请回复数字选择服务：").append("\n\n");
                            buffer.append("11 可查看测试单图文").append("\n");
                            buffer.append("12  可测试多图文发送").append("\n");
                            buffer.append("13  可测试网址").append("\n");

                            buffer.append("或者您可以尝试发送表情").append("\n\n");
                            buffer.append("回复“1”显示此帮助菜单").append("\n");
                            respContent = String.valueOf(buffer);
                            textRespMsg.setContent(respContent);
                            respMessage = RespMsgUtil.modelToXml(textRespMsg);
                            break;
                        }
                        case "11": {
                            //测试单图文回复
                            Article article = new Article();
                            article.setTitle("微信公众帐号开发教程Java版");
                            // 图文消息中可以使用QQ表情、符号表情
                            article.setDescription("这是测试有没有换行\n\n如果有空行就代表换行成功\n\n点击图文可以跳转到百度首页");
                            // 将图片置为空
                            article.setPicUrl(
                                    "http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
                            article.setUrl("http://www.baidu.com");
                            articleList.add(article);
                            articleRespMsg.setArticleCount(articleList.size());
                            articleRespMsg.setArticles(articleList);
                            respMessage = RespMsgUtil.modelToXml(articleRespMsg);
                            break;
                        }
                        case "12": {
                            //多图文发送
                            Article article1 = new Article();
                            article1.setTitle("紧急通知，不要捡这种钱！湛江都已经传疯了！\n");
                            article1.setDescription("");
                            article1.setPicUrl(
                                    "http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
                            article1.setUrl(
                                    "http://mp.weixin.qq" +
                                            ".com/s?__biz=MjM5Njc2OTI4NQ==&mid=2650924309&idx=1&sn=8bb6ae54d6396c1faa9182a96f30b225&chksm=bd117e7f8a66f769dc886d38ca2d4e4e675c55e6a5e01e768b383f5859e09384e485da7bed98&scene=4#wechat_redirect");

                            Article article2 = new Article();
                            article2.setTitle("湛江谁有这种女儿，请给我来一打！");
                            article2.setDescription("");
                            article2.setPicUrl(
                                    "http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
                            article2.setUrl(
                                    "http://mp.weixin.qq" +
                                            ".com/s?__biz=MjM5Njc2OTI4NQ==&mid=2650924309&idx=2&sn=d7ffc840c7e6d91b0a1c886b16797ee9&chksm=bd117e7f8a66f7698d094c2771a1114853b97dab9c172897c3f9f982eacb6619fba5e6675ea3&scene=4#wechat_redirect");

                            Article article3 = new Article();
                            article3.setTitle("以上图片我就随意放了");
                            article3.setDescription("");
                            article3.setPicUrl(
                                    "http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
                            article3.setUrl(
                                    "http://mp.weixin.qq" +
                                            ".com/s?__biz=MjM5Njc2OTI4NQ==&mid=2650924309&idx=3&sn=63e13fe558ff0d564c0da313b7bdfce0&chksm=bd117e7f8a66f7693a26853dc65c3e9ef9495235ef6ed6c7796f1b63abf1df599aaf9b33aafa&scene=4#wechat_redirect");

                            articleList.add(article1);
                            articleList.add(article2);
                            articleList.add(article3);
                            articleRespMsg.setArticleCount(articleList.size());
                            articleRespMsg.setArticles(articleList);
                            respMessage = RespMsgUtil.modelToXml(articleRespMsg);
                            break;
                        }

                        case "13": {
                            //测试网址回复
                            respContent = "<a href=\"http://www.baidu.com\">百度主页</a>";
                            textRespMsg.setContent(respContent);
                            // 将文本消息对象转换成xml字符串
                            respMessage = RespMsgUtil.modelToXml(textRespMsg);
                            break;
                        }

                        default: {
                            respContent = "（这是里面的）很抱歉，现在小8暂时无法提供此功能给您使用。\n\n回复“1”显示帮助信息";
                            textRespMsg.setContent(respContent);
                            // 将文本消息对象转换成xml字符串
                            respMessage = RespMsgUtil.modelToXml(textRespMsg);
                        }
                    }
                }
            }


            // 图片消息
            else if (msgType.equals(ReqMsgUtil.ReqMsgType.IMAGE)) {
                respContent = "您发送的是图片消息！";
                textRespMsg.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = RespMsgUtil.modelToXml(textRespMsg);
            }
            // 地理位置消息
            else if (msgType.equals(ReqMsgUtil.ReqMsgType.LOCATION)) {
                respContent = "您发送的是地理位置消息！";
                textRespMsg.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = RespMsgUtil.modelToXml(textRespMsg);
            }
            // 链接消息
            else if (msgType.equals(ReqMsgUtil.ReqMsgType.LINK)) {
                respContent = "您发送的是链接消息！";
                textRespMsg.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = RespMsgUtil.modelToXml(textRespMsg);

            }
            // 音频消息
            else if (msgType.equals(ReqMsgUtil.ReqMsgType.VOICE)) {
                respContent = "您发送的是音频消息！";
                textRespMsg.setContent(respContent);
                // 将文本消息对象转换成xml字符串
                respMessage = RespMsgUtil.modelToXml(textRespMsg);
            }
            // 事件推送
            else if (msgType.equals(ReqMsgUtil.ReqMsgType.EVENT)) {
                // 事件类型
                String eventType = params.getProperty("Event");
                // 自定义菜单点击事件
                if (eventType.equals(ReqMsgUtil.ReqMsgEventType.CLICK)) {
                    switch (EventKey) {
                        case "11": {
                            respContent = "这是第一栏第一个";
                            break;
                        }
                        case "12": {
                            respContent = "这是第一栏第一个";
                            break;
                        }
                        case "21": {
                            respContent = "这是第二栏第一个";
                            break;
                        }

                        default: {
                            log.error("开发者反馈：EventKey值没找到，它是:" + EventKey);
                            respContent = "很抱歉，此按键功能正在升级无法使用";
                        }
                    }
                    textRespMsg.setContent(respContent);
                    // 将文本消息对象转换成xml字符串
                    respMessage = RespMsgUtil.modelToXml(textRespMsg);
                } else if (eventType.equals(ReqMsgUtil.ReqMsgEventType.VIEW)) {
                    // 对于点击菜单转网页暂时不做推送
                }

                // 订阅
                else if (eventType.equals(ReqMsgUtil.ReqMsgEventType.SUBSCRIBE)) {
                    //测试单图文回复
                    Article article = new Article();
                    article.setTitle("谢谢您的关注！");
                    // 图文消息中可以使用QQ表情、符号表情
                    article.setDescription("点击图文可以跳转到百度首页");
                    // 将图片置为空
                    article.setPicUrl("http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
                    article.setUrl("http://www.baidu.com");
                    articleList.add(article);
                    articleRespMsg.setArticleCount(articleList.size());
                    articleRespMsg.setArticles(articleList);
                    respMessage = RespMsgUtil.modelToXml(articleRespMsg);
                } else if (eventType.equals(ReqMsgUtil.ReqMsgEventType.SCAN)) {
                    //测试单图文回复
                    Article article = new Article();
                    article.setTitle("这是已关注用户扫描二维码弹到的界面");
                    // 图文消息中可以使用QQ表情、符号表情
                    article.setDescription("点击图文可以跳转到百度首页");
                    // 将图片置为空
                    article.setPicUrl("http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
                    article.setUrl("http://www.baidu.com");
                    articleList.add(article);
                    articleRespMsg.setArticleCount(articleList.size());
                    articleRespMsg.setArticles(articleList);
                    respMessage = RespMsgUtil.modelToXml(articleRespMsg);
                }
                // 取消订阅
                else if (eventType.equals(ReqMsgUtil.ReqMsgEventType.UN_SUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }

}
