package ua.skidchenko.Model;

import ua.skidchenko.DAOLayer.Forms.NoteForm;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "body")
@Builder

@Entity
@Table(name = "notes",schema = "public")
public class Note implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Setter
    @Column(name = "title", length = 50,unique = true)
    String title;

    @Setter
    @Column(name = "body", length = 1000)
    String body;

    @Setter
    @Column(name = "modification_date")
    Date modificationDate;


    public static Note fromForm (NoteForm form) {
        return new Note(form.getId(),form.getTitle(), form.getBody(),new Date());
    }
}
