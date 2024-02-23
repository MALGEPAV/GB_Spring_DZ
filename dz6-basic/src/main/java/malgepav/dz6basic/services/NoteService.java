package malgepav.dz6basic.services;

import lombok.RequiredArgsConstructor;
import malgepav.dz6basic.aspects.TrackUserAction;
import malgepav.dz6basic.models.Note;
import malgepav.dz6basic.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @TrackUserAction
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @TrackUserAction
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @TrackUserAction
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    @TrackUserAction
    public Note updateNote(Long id, Note note) {
        Note noteById = getNoteById(id);

        noteById.setContent(note.getContent());
        noteById.setTitle(note.getTitle());

        return noteRepository.save(noteById);
    }

    @TrackUserAction
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
