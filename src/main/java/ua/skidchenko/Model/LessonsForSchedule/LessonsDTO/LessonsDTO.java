package ua.skidchenko.Model.LessonsForSchedule.LessonsDTO;

import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class LessonsDTO {



    private String groupName;

    private List<LessonDTO> data;

    private Date updatingDate;

}

