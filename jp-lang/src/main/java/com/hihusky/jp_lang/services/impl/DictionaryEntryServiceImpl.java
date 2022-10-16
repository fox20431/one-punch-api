package com.hihusky.jp_lang.services.impl;

import org.springframework.stereotype.Service;

import com.hihusky.jp_lang.entities.DictionaryEntry;
import com.hihusky.jp_lang.repositories.DictionaryEntryRepository;
import com.hihusky.jp_lang.services.DictionaryEntryService;

@Service
public class DictionaryEntryServiceImpl implements DictionaryEntryService {
	DictionaryEntryRepository dictionaryEntryRepository;
	public DictionaryEntryServiceImpl(DictionaryEntryRepository dictionaryEntryRepository) {
		this.dictionaryEntryRepository = dictionaryEntryRepository;
	}
	@Override
	public DictionaryEntry save(DictionaryEntry dictionaryEntry) {
		return dictionaryEntryRepository.save(dictionaryEntry);
	}
	
	
}
