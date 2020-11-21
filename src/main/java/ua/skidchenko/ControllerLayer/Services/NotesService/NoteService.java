package ua.skidchenko.ControllerLayer.Services.NotesService;

import ua.skidchenko.Model.Note;

import java.util.List;

public interface NoteService {
    Note getByIdOrNullIfNotPresent(Long id);

    List<Note> getAllNotes();

    void deleteNoteById(Long id);

    Note saveNote(Note note);

    void updateNote(Note note);

}
