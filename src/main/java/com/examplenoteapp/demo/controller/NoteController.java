package com.examplenoteapp.demo.controller;


import com.examplenoteapp.demo.model.Note;
import com.examplenoteapp.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/add-note")
    public String addNote(@RequestParam String title, @RequestParam String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);
        return "redirect:/index.html";
    }

    @GetMapping("/notes")
    @ResponseBody
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Show a form for editing
    @GetMapping("/edit-note")
    @ResponseBody
    public Note getNoteById(@RequestParam Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    // Update note
    @PostMapping("/update-note")
    public String updateNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setTitle(title);
            note.setContent(content);
            noteRepository.save(note);
        }
        return "redirect:/index.html";
    }


    @PostMapping("/delete-note")
    public String deleteNote(@RequestParam Long id) {
        noteRepository.deleteById(id);
        return "redirect:/index.html";
    }
}
