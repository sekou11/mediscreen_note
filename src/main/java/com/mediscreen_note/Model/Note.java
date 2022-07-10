package com.mediscreen_note.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "notes")
@Data @NoArgsConstructor @AllArgsConstructor
public class Note {
	@Id
	private String id;
	private Integer patientId;
	private String note;
	

}
