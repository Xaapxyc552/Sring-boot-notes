package ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe;

import ua.skidchenko.Model.Identifiable;
import ua.skidchenko.Model.LessonsForSchedule.LessonsDTO.LessonDTO;
import ua.skidchenko.Model.LessonsForSchedule.LessonsDTO.LessonsDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@ToString(exclude = {"lesson"})
@EqualsAndHashCode(exclude = {"lesson"})
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "lessons",schema = "public")
public class Lessons implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "group_name",unique = true)
    private String groupName;

    @Setter
    @Column(name = "updating_time")
    private Date updatingDate;

    @Setter
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "lessons",cascade={CascadeType.PERSIST})
    private List<Lesson> lesson;


    public static Lessons getLessonsFromLessonsDTO(LessonsDTO lessonsDTO) {
        Lessons lessons = new Lessons();
        lessons.groupName = "PG-p81";
        lessons.setUpdatingDate(new Date());
        lessons.setLesson(getLessonsDataFromDTO(lessonsDTO,lessons));
        return lessons;
    }

    private static List <Lesson> getLessonsDataFromDTO(LessonsDTO lessonsDTO,Lessons lessons) {
        List<Lesson> lessonList = new LinkedList<>();
        for (LessonDTO lesson : lessonsDTO.getData()
        ) {
            Lesson lesson1 = new Lesson();
            lesson1.setDay_name(lesson.getDay_name());
            lesson1.setDay_number(lesson.getDay_number());
            lesson1.setLesson_name(lesson.getLesson_name());
            lesson1.setLesson_room(lesson.getLesson_room());
            lesson1.setLesson_type(lesson.getLesson_type());
            lesson1.setLesson_week(lesson.getLesson_week());
            lesson1.setTime_start(lesson.getTime_start());
            lesson1.setLessons(lessons);
            lesson1.setLesson_number(lesson.getLesson_number());
            lesson1.setTeacher_name(lesson.getTeachers().get(0).getTeacher_name());
            lessonList.add(lesson1);
        }
        return lessonList;
    }

    public void setId(Long id) {
    }
}

