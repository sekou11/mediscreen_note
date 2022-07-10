package com.mediscreen_note.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen_note.Model.Note;
import com.mediscreen_note.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
    private NoteRepository noteRepository;

	@Override
	public List<Note> getAllNote() {
		
		return noteRepository.findAll();
	}

	@Override
	public List<Note> getNotesByPatientId(int patientId) {
		
		return noteRepository.findAllByPatientId(patientId);
	}

	@Override
	public Note findNote(String noteId) {
		
	       return noteRepository.findById(noteId).orElse(null);
	}

	@Override
	public Note saveNote(Note noteToSave) {
		
		 return noteRepository.save(noteToSave);
	}

	@Override
	public Note updateNote(Note note) {
		noteRepository.save(note);
        return note;
	}

	@Override
	public void deleteNote(String id) {
		Optional<Note> note = noteRepository.findById(id);
        note.ifPresent(getNote -> noteRepository.delete(getNote));

	}

}
