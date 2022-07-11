package com.mediscreen_note.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen_note.Model.Note;
import com.mediscreen_note.Model.Dto.NoteDto;
import com.mediscreen_note.service.NoteService;

@RestController
@RequestMapping("note")
public class NoteController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);

	    @Autowired
	    private ModelMapper modelMapper;
	@Autowired
	private NoteService noteService;
	
	 @GetMapping("/")
	    public String index() {
	        return "Greeting to Note Microservice";
	    }
	 
	 @GetMapping("/list")
	    public List<NoteDto> getAll(){
	        LOGGER.info("GET /note/list ");
	        return noteService.getAllNote().stream().map(note -> modelMapper.map(note, NoteDto.class))
	                .collect(Collectors.toList());
	    }
	 
	 @GetMapping("/patient/{id}")
	    public List<NoteDto> getNotesForPatientId(@PathVariable("id") int id){
	        LOGGER.info("GET /note/patient/{id} patientId=" + id);
	        return noteService.getNotesByPatientId(id).stream().map(note -> modelMapper.map(note, NoteDto.class))
	                .collect(Collectors.toList());
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<NoteDto> findNote(@PathVariable("id") String id){
	        LOGGER.info("GET /note/id noteId=" + id);

	        Note note = noteService.findNote(id);
	        if (note != null) {
	            NoteDto noteResponse = modelMapper.map(note, NoteDto.class);
	            return ResponseEntity.ok().body(noteResponse);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	
	    @PostMapping("/add")
	    public ResponseEntity<NoteDto> saveNote(@Valid @RequestBody NoteDto noteDto){
	        LOGGER.info("POST /api/v1/add newNote= " + noteDto.getId());
	        Note noteRequest = modelMapper.map(noteDto, Note.class);
	        Note note = noteService.saveNote(noteRequest);
	        NoteDto savedNote = modelMapper.map(note, NoteDto.class);
	        return new ResponseEntity<NoteDto>(savedNote, HttpStatus.CREATED);
	    }

	   
	    @PostMapping("/update")
	    public ResponseEntity<NoteDto> updateNote(@Valid @RequestBody NoteDto noteToUpdate) {
	        LOGGER.info("POST /note/update noteToUpdate id = " + noteToUpdate.getId());
	        Note noteRequest = modelMapper.map(noteToUpdate, Note.class);
	        Note note = noteService.updateNote(noteRequest);
	        NoteDto noteResponse = modelMapper.map(note, NoteDto.class);
	        return new ResponseEntity<NoteDto>(noteResponse, HttpStatus.OK);
	    }

	   
	    @GetMapping("/delete/{id}")
	    public void delete(@PathVariable String id) {
	    	  LOGGER.info("POST /note/delete noteToDelete id = " + id);
	        noteService.deleteNote(id);
	    }  

}
