package ua.skidchenko.ControllerLayer.Services.ScheduleService;

import ua.skidchenko.Exceptions.RetrievingDataFromNetException;
import ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe.Lessons;

public interface ScheduleService {
    Lessons getScheduleByGroupName(String groupName) throws Exception;

    Lessons getScheduleFromDatabaseByGroupName(String groupName);

    Lessons getScheduleFromSourceByGroupName (String groupName) throws RetrievingDataFromNetException;
}
