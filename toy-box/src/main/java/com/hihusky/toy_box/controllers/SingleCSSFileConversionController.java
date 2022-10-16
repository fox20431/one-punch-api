package com.hihusky.toy_box.controllers;

import com.hihusky.toy_box.services.StringCSSFileConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class SingleCSSFileConversionController {

    StringCSSFileConversionService stringCSSFileConversionService;
    public SingleCSSFileConversionController(StringCSSFileConversionService stringCSSFileConversionService) {
        this.stringCSSFileConversionService = stringCSSFileConversionService;
    }

    @PostMapping(value = "/css-file", consumes = {"multipart/form-data"})
    public String convertFontFileToString(
            @RequestPart(value = "file") MultipartFile file
    ) throws IOException {
        return stringCSSFileConversionService.concatenateIntoCSSText(file);
    }
}
