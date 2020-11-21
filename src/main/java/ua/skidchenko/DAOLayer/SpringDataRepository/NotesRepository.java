package ua.skidchenko.DAOLayer.SpringDataRepository;

import ua.skidchenko.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository <Note, Long> {

}
