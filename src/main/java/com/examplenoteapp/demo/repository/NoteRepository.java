package com.examplenoteapp.demo.repository;


import com.examplenoteapp.demo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
