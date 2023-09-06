package com.translate.coursetranslateservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaiduResult {
    private String from;
    private String to;
    private List<Map<String,Object>> trans_result;
}
