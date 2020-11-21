package ua.skidchenko.DAOLayer.Forms;

import ua.skidchenko.Model.Note;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class NoteForm {
    Long id;
    String title;
    String body;


    public static NoteForm fromNote(Note note) {
        return new NoteForm(note.getId(), note.getTitle(), note.getBody());
    }
}
