package com.translate.coursetranslateservice.config;

import com.translate.coursetranslateservice.model.BaseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseConfig {
    @Value("${word.font:楷体}")
    private String font;

    @Value("${word.size:20}")
    private Integer size;

    @Value("${word.rowSize:50}")
    private Integer rowSize;

    @Value("${baidu.appId:x}")
    private String appId;

    @Value("${baidu.securityKey:x}")
    private String securityKey;

    @Bean
    public BaseData init() {
        return BaseData.builder()
                .font(font)
                .size(size)
                .rowSize(rowSize)
                .appId(appId)
                .securityKey(securityKey)
                .build();
    }
}
