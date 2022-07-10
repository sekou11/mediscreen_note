package com.mediscreen_note.Model.Dto;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class NoteDto {
	@Id
	private String id;
	 @NotNull
	private Integer patientId;
	 @NotNull
	private String note;
	

}
