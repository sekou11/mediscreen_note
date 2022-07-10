package com.mediscreen_note.service;

import java.util.List;

import com.mediscreen_note.Model.Note;

public interface NoteService {
	public List<Note> getAllNote();
	public List<Note> getNotesByPatientId(int patientId);
	public Note findNote(String noteId);
	public Note saveNote(Note noteToSave);
	public Note updateNote(Note note);
	public void deleteNote(String id);

}
