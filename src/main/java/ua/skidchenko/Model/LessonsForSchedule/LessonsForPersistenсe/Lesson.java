package ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe;

import ua.skidchenko.Model.Identifiable;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString(exclude = {"lessons"})
@EqualsAndHashCode(exclude = {"lessons"})
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "lesson",schema = "public")
public class Lesson implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    private String lesson_name;

    @Setter
    private int day_number;
    @Setter
    private String day_name;
    @Setter
    private int lesson_number;
    @Setter
    private String lesson_room;
    @Setter
    private String lesson_type;
    @Setter
    private int lesson_week;
    @Setter
    private String time_start;
    @Setter
    private String teacher_name;

    @Setter

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "lessons_id",
            nullable = false,
            updatable = false)
    private Lessons lessons;



}


