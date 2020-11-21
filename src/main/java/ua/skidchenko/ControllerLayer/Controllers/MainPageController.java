package ua.skidchenko.ControllerLayer.Controllers;


import ua.skidchenko.ControllerLayer.Services.NotesService.NoteService;
import ua.skidchenko.Model.Note;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MainPageController {

    final
    NoteService noteService;

    public MainPageController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/main")
    public String mainPage (Model model) {
        ArrayList<Note> noteArrayList = (ArrayList<Note>) noteService.getAllNotes();
        model.addAttribute("allNotes",noteArrayList);
         return "MainPage";
    }



}
