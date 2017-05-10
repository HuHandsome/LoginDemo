package com.bbs.service;

import com.bbs.common.Constant;
import com.bbs.util.GsonUtil;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Arrays;

public class ConfigInitService {
    private static Logger logger = LoggerFactory.getLogger(ConfigInitService.class);

    public void loaderEscapeURI() {
        try {
            URL url = Resources.getResource("data/escapeuri.json");
            String json = Resources.toString(url, Charsets.UTF_8);
            Constant.ESCAPE_URI = GsonUtil.json2Obj(json, String[].class);
            logger.debug("游客可访问的资源：" + Arrays.toString(Constant.ESCAPE_URI));
        } catch (Exception e) {
            logger.error("ESCAPE_URI资源加载失败", e);
        }
    }
}
