package org.hdcd.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

//롬복 애너테이션

@ToString
@Builder
public class Board_lom {

	private int boardNo;
	@NonNull
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
}
