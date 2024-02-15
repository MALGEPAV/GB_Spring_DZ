package malgepav.dz6basic.repositories;

import malgepav.dz6basic.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
