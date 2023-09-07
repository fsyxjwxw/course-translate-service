package com.translate.coursetranslateservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseData {
    private String font;

    private Integer size;

    private Integer rowSize;

    private String appId;

    private String securityKey;
}
