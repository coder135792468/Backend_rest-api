package com.note_share_res_api.backend_rest_api.controllers;

import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.note_share_res_api.backend_rest_api.modesl.*;
import com.note_share_res_api.backend_rest_api.repository.*;

@RestController
public class NoteController {

    NoteRepository noteService;

    NoteController(NoteRepository noteService) {
        this.noteService = noteService;
    }

    @CrossOrigin
    @GetMapping(value = "/library")
    public ResponseEntity<Map<String, Object>> getAllNotes(
            @RequestParam(required = false, defaultValue = "") String college,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "") String search) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            orders.add(new Sort.Order(Sort.Direction.ASC, "views"));

            List<Library> library = new ArrayList<Library>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Library> notesPage;
            if (college.length() > 0) {
                notesPage = noteService.findByInstitution(search.toLowerCase(), college.toLowerCase(), pagingSort);
            } else if (search.length() > 0) {
                notesPage = noteService.searchNotes(search.toLowerCase(), pagingSort);
            } else {
                notesPage = noteService.findAll(pagingSort);
            }

            library = notesPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("library", library);
            response.put("currentPage", notesPage.getNumber());
            response.put("totalItems", notesPage.getTotalElements());
            response.put("totalPages", notesPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/library/{id}")
    public ResponseEntity<Optional<Library>> getCurNote(@PathVariable Integer id) {
        Optional<Library> notes = noteService.findById(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/note")
    public ResponseEntity<Library> addLibrary(@RequestBody Library library) {
        try {
            Library lib = noteService.save(library);
            return new ResponseEntity<>(lib, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
