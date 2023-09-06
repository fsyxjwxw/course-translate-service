package com.translate.coursetranslateservice.service;

import com.alibaba.fastjson2.JSON;
import com.translate.coursetranslateservice.baidu.TransApi;
import com.translate.coursetranslateservice.model.BaiduResult;
import com.translate.coursetranslateservice.model.TranslateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TranslateService {

    private static final String APP_ID = "xx";
    private static final String SECURITY_KEY = "aa";

    public TranslateResult translate(List<String> strings) {
        List<String> translateList = new ArrayList<>();
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        for (String text: strings){
            log.info("【内容翻译】翻译进行中..."+text);
            try{
                String transResult = api.getTransResult(text, "en", "zh");
                BaiduResult baiduResult = JSON.parseObject(transResult, BaiduResult.class);
                translateList.add(baiduResult.getTrans_result().get(0).get("dst").toString());
            }catch (Exception e){
                e.printStackTrace();
                translateList.add("");
            }

        }
        return TranslateResult.builder().raw(strings).translate(translateList).build();
    }


}
