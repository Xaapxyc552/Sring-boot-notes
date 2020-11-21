package ua.skidchenko.ControllerLayer.Services.ScheduleService;

import ua.skidchenko.BusinessLayer.ScheduleClasses.ScheduleJSONFromNetRetriever;
import ua.skidchenko.DAOLayer.SpringDataRepository.ScheduleRepository;
import ua.skidchenko.Exceptions.RetrievingDataFromNetException;
import ua.skidchenko.Model.LessonsForSchedule.LessonsDTO.LessonsDTO;
import ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe.Lessons;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    final
    ScheduleRepository scheduleRepository;
    final
    ScheduleJSONFromNetRetriever jsonFromNet;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository,
                               ScheduleJSONFromNetRetriever retrievingScheduleJSONFromNet) {
        this.scheduleRepository = scheduleRepository;
        this.jsonFromNet = retrievingScheduleJSONFromNet;
    }

    @Override
    public Lessons getScheduleByGroupName(String groupName) throws Exception {
        Lessons lessons = getScheduleFromDatabaseByGroupName(groupName);
        if (lessons != null) return lessons;
        lessons = getScheduleFromSourceByGroupName(groupName);
        if (lessons != null) {
            scheduleRepository.save(lessons);
            return lessons;
        }
        throw new Exception("Null value after retrieving data from database and Web.");

    }

    @Override
    public Lessons getScheduleFromDatabaseByGroupName(String groupName) {
        return scheduleRepository.findByGroupName(groupName);
    }

    public Lessons getScheduleFromSourceByGroupName(String groupName) throws RetrievingDataFromNetException {
        LessonsDTO lessonsFromJsonFromNet = jsonFromNet.getLessonsFromJsonFromNet();
        if (lessonsFromJsonFromNet != null)
            return Lessons.getLessonsFromLessonsDTO(lessonsFromJsonFromNet);
        throw new RetrievingDataFromNetException(
                "Error while retrieving data from external resource. " +
                        "Requested data: lessons for group " + groupName +
                        ". Requested resource: " + jsonFromNet.getUrl().toString());
    }
}
