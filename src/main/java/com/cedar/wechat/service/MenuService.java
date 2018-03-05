package com.cedar.wechat.service;

import java.util.Map;

import net.sf.json.JSONObject;

public interface MenuService {

    JSONObject getMenu(String accessToken);

    int createMenu(Map<String, Object> menu, String accessToken);

    int deleteMenu(String accessToken);

}
