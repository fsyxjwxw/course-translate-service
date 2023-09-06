package com.translate.coursetranslateservice.handler;

import com.translate.coursetranslateservice.model.TranslateResult;
import com.translate.coursetranslateservice.service.TextService;
import com.translate.coursetranslateservice.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ManagerHandler {
    @Resource
    TextService textService;

    @Resource
    TranslateService translateService;

    public void handler(String fileName){
        Long theTime = System.currentTimeMillis();
        log.info("【读取word】"+fileName);
        List<String> strings = textService.readWordText(fileName);
        log.info("【读取完毕】用时:"+(System.currentTimeMillis()-theTime) +"ms");

        log.info("【内容翻译】开始翻译");
        TranslateResult translate = translateService.translate(strings);
        log.info("【内容翻译】翻译完毕");
        log.info("【生成文档】开始生成...");
        translate.setFileName(fileName);
        textService.generateWord(translate);
        log.info("【生成文档】生成完毕,总耗时"+(System.currentTimeMillis()-theTime) +"ms");

    }

}
