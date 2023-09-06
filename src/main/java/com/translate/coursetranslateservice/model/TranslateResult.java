package com.translate.coursetranslateservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TranslateResult {
    private String fileName;
    private List<String> raw;
    private List<String> translate;
}
