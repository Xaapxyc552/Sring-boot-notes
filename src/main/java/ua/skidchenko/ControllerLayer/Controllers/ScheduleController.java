package ua.skidchenko.ControllerLayer.Controllers;


import ua.skidchenko.ControllerLayer.Services.ScheduleService.ScheduleService;
import ua.skidchenko.Model.LessonsForSchedule.LessonsForPersistenсe.Lessons;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@RequestMapping(value = "/schedule")
@Controller
public class ScheduleController {


    final
    ScheduleService service;

    public ScheduleController(ScheduleService scheduleService) {
        this.service = scheduleService;
    }

    @GetMapping(value = "/")
    public ModelAndView getSchedule() {

        log.info("Executing getSchedule method..");
        ModelAndView modelAndView = new ModelAndView("SchedulePage");
        Lessons lessons = new Lessons();
        try {
            lessons = service.getScheduleByGroupName("PG-p81");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception during retrieving data.", e);
        }
        log.info("Data successfully retrieved : " + lessons);
        modelAndView.addObject("lessons", lessons);
        return modelAndView;
    }
}
