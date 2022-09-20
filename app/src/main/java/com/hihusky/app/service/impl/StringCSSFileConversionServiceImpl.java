package com.hihusky.app.service.impl;

import com.google.common.io.Files;
import com.hihusky.app.service.StringCSSFileConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class StringCSSFileConversionServiceImpl implements StringCSSFileConversionService {
    @Override
    public String concatenateIntoCSSText(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        String cssBase64Text = new String(encodedBytes);
        String filename = file.getOriginalFilename();
        String name = Files.getNameWithoutExtension(filename);
        String ext = Files.getFileExtension(filename);
        String result = "@font-face { \n" +
                "\tfont-family:" + name + ";\n" +
                "\tfont-style: normal;\n" +
                "\tsrc: url('" + cssBase64Text + "') format('"+ ext +"');\n" +
                "}\n";
        return result;
    }
}
