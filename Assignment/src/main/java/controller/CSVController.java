package controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Tutorial;
import repository.TutorialRepository;


@RestController
@RequestMapping
public class CSVController {
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllTutorials(
			@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "11") int size
			) {
		try {
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			Pageable paging = PageRequest.of(page, size);
			
			Page<Tutorial> pageTuts;
			if(title == null)
				pageTuts = tutorialRepository.findAll(paging);
			else
				pageTuts = tutorialRepository.findByTitleContaining(title, paging);
			
			tutorials = pageTuts.getContent();
			
			Map<String, Object> response = new HashMap<>();
			response.put("tutorials", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalpages", pageTuts.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tutorials/published")
	public ResponseEntity<Map<String, Object>> findByPublished(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "11") int size
			) {
		try {
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			Pageable paging = PageRequest.of(page, size);
			
			Page<Tutorial> pageTuts = tutorialRepository.findByPublished(true, paging);
			tutorials = pageTuts.getContent();
			
			Map<String, Object> response = new HashMap<>();
			response.put("tutorials", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
