package com.sbs.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private long id;
	private String legDate;
	private String title;
	private String body;
	private long hit;
}
