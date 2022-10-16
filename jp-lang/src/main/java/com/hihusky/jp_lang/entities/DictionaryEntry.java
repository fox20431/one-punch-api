package com.hihusky.jp_lang.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("dictionary")
public class DictionaryEntry {
	@Id
	@Column("id")
	private Long id;
	@Column("text")
	private String text;
	@Column("furigana")
	private String furigana;
	@Column("definition")
	private String definition;

	public DictionaryEntry() {
	}

	public DictionaryEntry(String text, String furigana, String definition) {
		this.text = text;
		this.furigana = furigana;
		this.definition = definition;
	}

	public DictionaryEntry(Long id, String text, String furigana, String definition) {
		this.id = id;
		this.text = text;
		this.furigana = furigana;
		this.definition = definition;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getFurigana() {
		return furigana;
	}

	public String getDefinition() {
		return definition;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setFurigana(String furigana) {
		this.furigana = furigana;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", text=" + text + ", furigana=" + furigana + ", definition=" + definition + "]";
	}
}
