package ua.skidchenko.Model.LessonsForSchedule.LessonsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class LessonDTO {

    private int day_number;
    private String day_name;
    private String lesson_name;
    private int lesson_number;
    private String lesson_room;
    private String lesson_type;
    private int lesson_week;
    private String time_start;

    private List<TeacherDTO> teachers;

    public LessonDTO() {
    }



}

