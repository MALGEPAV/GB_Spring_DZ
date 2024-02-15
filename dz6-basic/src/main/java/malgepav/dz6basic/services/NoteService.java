package malgepav.dz6basic.services;

import lombok.RequiredArgsConstructor;
import malgepav.dz6basic.models.Note;
import malgepav.dz6basic.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    public Note updateNote(Long id, Note note) {
        Note noteById = getNoteById(id);

        noteById.setContent(note.getContent());
        noteById.setTitle(note.getTitle());

        return noteRepository.save(noteById);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
