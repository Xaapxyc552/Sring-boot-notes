package ua.skidchenko.BusinessLayer.ScheduleClasses;

import ua.skidchenko.Model.LessonsForSchedule.LessonsDTO.LessonsDTO;

import java.net.URL;

public interface ScheduleJSONFromNetRetriever {

    LessonsDTO getLessonsFromJsonFromNet();

    URL getUrl();
}
