package com.mediscreen_note.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import com.mediscreen_note.Model.Note;
import com.mediscreen_note.repositories.NoteRepository;
@SpringBootTest
class NoteServiceImplTest {
	
	 @Mock
	  private NoteRepository noteRepository;

	    @InjectMocks
	    private NoteServiceImpl noteService;

	    private static final Note note = new Note();

	    @BeforeAll
	    static void setUp(){
	        note.setId("noteId");
	        note.setPatientId(1);
	        note.setNote("medical comments");
	    }

	@Test
	void testGetAllNote() {
		 Mockito.when(noteRepository.findAll()).thenReturn(Collections.singletonList(note));

	        List<Note> result = noteService.getAllNote();

	        Assertions.assertEquals(1, result.size());
	        Assertions.assertEquals("noteId", result.get(0).getId());
	    }
	

	@Test
	void testGetNotesByPatientId() {
	Mockito.when(noteRepository.findAllByPatientId(1)).thenReturn(Collections.singletonList(note));

    List<Note> result = noteService.getNotesByPatientId(1);

    Assertions.assertEquals(1, result.size());
    Assertions.assertEquals("noteId", result.get(0).getId());
		
	}

	@Test
	void testFindNoteWhenNoteExists() {
		 Mockito.when(noteRepository.findById("noteId")).thenReturn(Optional.of(note));

	        Assertions.assertEquals(1, (int) noteService.findNote("noteId").getPatientId());
		
	}
	@Test
    public void findNoteNotFoundTest(){
        Mockito.when(noteRepository.findById("badId")).thenReturn(Optional.empty());

        Assertions.assertNull(noteService.findNote("badId"));
    }

	@Test
	void testSaveNote() {
		Note noteToSave = new Note();
    noteToSave.setPatientId(1);
    noteToSave.setNote("medical comments");

    Mockito.when(noteRepository.save(noteToSave)).thenReturn(note);

    Note result = noteService.saveNote(noteToSave);

    Assertions.assertEquals(note.getId(), result.getId());
	}

	@Test
	void testUpdateNote() {
		 when(noteRepository.findById("noteId")).thenReturn(Optional.of(note));
	        when(noteRepository.save(note)).thenReturn(note);
	        System.out.println("note = " + note);

	        noteService.updateNote(note);

	        verify(noteRepository, times(1)).save(note);
	}

	@Test
	void testDeleteNote() {
		 when(noteRepository.findById("noteId")).thenReturn(Optional.of(note));
	        noteService.deleteNote("noteId");

	        verify(noteRepository, times(1)).findById("noteId");
		
	}

}
