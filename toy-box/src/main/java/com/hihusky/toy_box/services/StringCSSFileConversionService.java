package com.hihusky.toy_box.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StringCSSFileConversionService {
    String concatenateIntoCSSText(MultipartFile file) throws IOException;
}
