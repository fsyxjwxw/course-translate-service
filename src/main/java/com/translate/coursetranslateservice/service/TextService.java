package com.translate.coursetranslateservice.service;

import cn.hutool.core.util.StrUtil;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.ParagraphStyle;
import com.translate.coursetranslateservice.model.TranslateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TextService {

    public List<String>  readWordText(String fileName){

        Document document = new Document();
        document.loadFromFile(fileName);
        String text = document.getText();
        text = text.replaceAll("\r", "&nbsp;");
        text = text.replaceAll("\n", "&nbsp;");
        text = text.replaceAll("\\?", "?&nbsp;");
        text = text.replaceAll("!", "!&nbsp;");
        text = text.replaceAll("\\.", ".&nbsp;");
        text = text.trim();
        String[] split = text.split("&nbsp;");

        List<String> list = new ArrayList<>();
        for (String s:split){
            if (!(StrUtil.isBlank(s) ||(s.indexOf("Evaluation Warning") > -1) || (s.indexOf("Doc for JAVA") > -1))){
                list.add(s.trim());
            }
        }
        return list;
    }

    public void generateWord(TranslateResult translate) {
        Document document = new Document();
        Section section = document.addSection();
        Paragraph para = section.addParagraph();
        String text = "";
        List<String> rawList = translate.getRaw();
        List<String> transList = translate.getTranslate();
        for (int i=0;i<rawList.size();i++){
            text += rawList.get(i)+"\n"+transList.get(i)+"\n";
        }
        para.appendText(text);

        ParagraphStyle style2 = new ParagraphStyle(document);
        style2.setName("paraStyle");
        style2.getCharacterFormat().setFontName("楷体");
        style2.getCharacterFormat().setFontSize(12);
        document.getStyles().add(style2);
        para.applyStyle("paraStyle");

        document.saveToFile(translate.getFileName()+"-translated.docx", FileFormat.Docx);
    }
}
