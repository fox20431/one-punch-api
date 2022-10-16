package com.hihusky.jp_lang.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hihusky.jp_lang.entities.DictionaryEntry;

@Repository
public interface DictionaryEntryRepository extends PagingAndSortingRepository<DictionaryEntry, Long> {
	
}
