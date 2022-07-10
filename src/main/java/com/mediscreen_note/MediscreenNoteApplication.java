package com.mediscreen_note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mediscreen_note.Model.Note;
import com.mediscreen_note.repositories.NoteRepository;

@SpringBootApplication
public class MediscreenNoteApplication implements CommandLineRunner {
	
	 private final Logger logger = LoggerFactory.getLogger(MediscreenNoteApplication.class);
	
	 @Autowired
     private NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(MediscreenNoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Note newN1 = new Note();
		newN1.setId("1");
		newN1.setPatientId(1);
		newN1.setNote("note 1");
		noteRepository.insert(newN1);   
		
		Note newN2 = new Note();
		newN1.setId("2");
		newN1.setPatientId(2);
		newN1.setNote("note 2");
		noteRepository.insert(newN2);
		
		
		Note newN3 = new Note();
		newN1.setId("3");
		newN1.setPatientId(3);
		newN1.setNote("note 3");
		noteRepository.insert(newN3);
		
		noteRepository.findAll().forEach(n->{
			System.out.println("id :" +n.getId()+ "patient id :"+n.getPatientId()+ "note : "+n.getNote());
		});
		  
	}

}
