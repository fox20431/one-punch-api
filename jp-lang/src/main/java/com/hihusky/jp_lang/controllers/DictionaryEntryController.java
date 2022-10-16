package com.hihusky.jp_lang.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hihusky.jp_lang.entities.DictionaryEntry;
import com.hihusky.jp_lang.services.DictionaryEntryService;

@RestController
@RequestMapping("/dictionary")
public class DictionaryEntryController {

	DictionaryEntryService dictionaryEntryService;

	public DictionaryEntryController(DictionaryEntryService dictionaryEntryService) {
		this.dictionaryEntryService = dictionaryEntryService;
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void addRecord(@RequestBody DictionaryEntry dictionaryEntry) {
		dictionaryEntryService.save(dictionaryEntry);
	}
}
