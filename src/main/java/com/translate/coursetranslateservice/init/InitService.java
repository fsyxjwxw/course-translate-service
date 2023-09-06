package com.translate.coursetranslateservice.init;

import com.translate.coursetranslateservice.handler.ManagerHandler;
import com.translate.coursetranslateservice.service.TextService;
import com.translate.coursetranslateservice.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Scanner;

@Component
@Slf4j
public class InitService implements CommandLineRunner {

    @Resource
    ManagerHandler managerHandler;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in, "UTF-8");
        log.info("请输入文件名:");
        while (sc.hasNext()){
            String fileName = sc.nextLine();
            managerHandler.handler(fileName);
        }
        sc.close();
    }
}
