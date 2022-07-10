package com.mediscreen_note.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mediscreen_note.Model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
	public List<Note>  findAllByPatientId(int patientId);
	
	

}
