package ua.skidchenko.ControllerLayer.Services.NotesService;

import ua.skidchenko.DAOLayer.SpringDataRepository.NotesRepository;
import ua.skidchenko.Model.Note;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class NoteServiceImpl implements NoteService {

    final
    NotesRepository notesRepository;

    public NoteServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Note getByIdOrNullIfNotPresent(Long id) {
        log.info("Retrieving Note with id =" + id + " from DB.");
        Optional<Note> noteOpt = notesRepository.findById(id);
        if (noteOpt.isPresent()) {
            log.info("Object Note with id = " +id + " retrieved from DB.");
            return noteOpt.get();
        }
        log.error("Object Note with id = " +id + " is not present in DB.");
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        log.info("Retrieving list of all Notes from DB.");
        return notesRepository.findAll();
    }

    @Override
    public void deleteNoteById(Long id) {
        if (notesRepository.findById(id).isPresent()) {

            notesRepository.deleteById(id);
            log.info("Object Note with id =" + id + "successfully deleted from DB.");
            return;
        }
        log.error("Object Note with id =" + id +
                " cannot be deleted from DB because it not exists in DB.");
    }

    @Override
    public Note saveNote(Note note) {
        log.info("Saving to DB object: " + note);
        return notesRepository.save(note);
    }

    @Override
    public void updateNote(Note note) {
        if (note.getId() != null) {
            notesRepository.save(note);
            log.info("Object " + note + " updated in DB.");
            return;
        }
        log.error("Object " + note + " cannot be updated DB because it's not exists in BD.");
    }
}
