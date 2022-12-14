package com.hihusky.toy_box.services.impl;

import com.google.common.io.Files;
import com.hihusky.toy_box.services.StringCSSFileConversionService;
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
                "\tsrc: url('data:font/" + ext + ";charset=utf-8;base64," + cssBase64Text + "') format('"+ ext +"');\n" +
                "}\n";
        return result;
    }
}
