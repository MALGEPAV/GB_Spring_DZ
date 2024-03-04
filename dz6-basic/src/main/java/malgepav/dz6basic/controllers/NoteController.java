package malgepav.dz6basic.controllers;

import lombok.RequiredArgsConstructor;
import malgepav.dz6basic.models.Note;
import malgepav.dz6basic.services.FileGateWay;
import malgepav.dz6basic.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    private final FileGateWay fileGateWay;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        fileGateWay.writeToFile(note.getTitle() + ".txt", note.getContent());
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
        Note noteById;
        try {
            noteById = noteService.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable("id") Long id,
                                               @RequestBody Note note) {
        Note updatedNote;
        try {
            updatedNote = noteService.updateNote(id, note);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }
}