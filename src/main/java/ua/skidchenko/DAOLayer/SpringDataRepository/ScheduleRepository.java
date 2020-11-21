package ua.skidchenko.DAOLayer.SpringDataRepository;

import ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Lessons,Long> {

    Lessons findByGroupName (String groupName);
}
