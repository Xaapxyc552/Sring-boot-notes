package ua.skidchenko.Model.LessonsForSchedule.LessonsDTO;

import ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor


public class TeacherDTO {

    private String teacher_name;

    private Long lesson_id;

    private Lesson lesson;

    public TeacherDTO() {
    }

    public String getTeacher_name() {
        return teacher_name;
    }
}
