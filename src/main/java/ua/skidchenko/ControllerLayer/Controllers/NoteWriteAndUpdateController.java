package ua.skidchenko.ControllerLayer.Controllers;

import ua.skidchenko.ControllerLayer.Services.NewsService.NewsService;
import ua.skidchenko.ControllerLayer.Services.NotesService.NoteService;
import ua.skidchenko.ControllerLayer.Services.NotesService.NoteServiceImpl;
import ua.skidchenko.DAOLayer.Forms.NoteForm;
import ua.skidchenko.Model.News;
import ua.skidchenko.Model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
public class NoteWriteAndUpdateController {

    final
    NewsService newsService;

    final
    NoteService noteService;

    public NoteWriteAndUpdateController(NoteServiceImpl noteService, NewsService newsService) {
        this.noteService = noteService;
        this.newsService = newsService;
    }

    //написать юнит тест вот для этого с помощью мокито
    @GetMapping(value = {"/notes/{id}", "/notes"})
    public String notesPage(@PathVariable(name = "id", required = false) Long noteToDisplayId,
                            HttpServletRequest request,
                            Model model,
                            HttpSession session) {
        List<Note> allNotes = noteService.getAllNotes();
        model.addAttribute("allNotes", allNotes);

        if (noteToDisplayId != null) {
            //переделать на стримах или еще на чем то (поиск есть ли в списке элемент с подходящим значением поля)
            //отсюда
            Note soughtNote = getNoteByIdFromListNullIfNotFound(noteToDisplayId, allNotes);
            // вот досюда
            if (soughtNote == null) {
                model.addAttribute("noteNotFoundedId", noteToDisplayId);
                return "AllNotesPage";
            }

            if (!model.asMap().containsKey("noteForm")) {
                NoteForm form = NoteForm.fromNote(soughtNote);
                model.addAttribute("noteForm", form);
            }
            request.getSession().setAttribute("currentNoteId", soughtNote.getId());
        }
        model.addAttribute("pathToSend", "/notes/update");
        model.addAttribute("buttonText", "Обновить записку");

        List<News> newsList = newsService.getAllNews();
        model.addAttribute("listOfNews", newsList);
        session.setAttribute("listOfNews", newsList);
        return "AllNotesPage";

    }

    @PostMapping(value = "/notes/update")
    public String updateNote(@ModelAttribute("noteForm") NoteForm form,
                             HttpSession session) {
        form.setId((Long) session.getAttribute("currentNoteId"));
        Note note = Note.fromForm(form);
        noteService.saveNote(note);
        return "redirect:/notes/" + note.getId();
    }

    @GetMapping(value = "/notes/new")
    public String getCreatingNotePage(Model model,
                                      HttpSession session) {
        NoteForm form = new NoteForm();
        model.addAttribute("noteForm", form);
        model.addAttribute("allNotes", noteService.getAllNotes());
        model.addAttribute("pathToSend", "/notes/new/create");
        model.addAttribute("buttonText", "Создать записку");
        List<News> newsList = newsService.getAllNews();
        model.addAttribute("listOfNews", newsList);
        session.setAttribute("listOfNews", newsList);
        return "AllNotesPage";
    }

    @PostMapping(value = "/notes/new/create")
    String createNewNote(@ModelAttribute("noteForm") NoteForm form, HttpSession session) {
        Note noteFromForm = Note.fromForm(form);
        System.out.println(noteFromForm);
        noteFromForm = noteService.saveNote(noteFromForm);
        session.setAttribute("currentNoteId", noteFromForm.getId());


        return "redirect:/notes/" + noteFromForm.getId();
    }


    @GetMapping(value = {"notes/delete/{id}", "notes/delete/{id}/{sure}"})
    String sureWantToDelete(@PathVariable("id") Long id,
                            HttpSession session,
                            @PathVariable(value = "sure", required = false) String sure) {
        if (sure != null && sure.equals("sure") && session.getAttribute("noteToDeleteId") == id) {
            noteService.deleteNoteById(id);
            session.removeAttribute("noteToDeleteId");
            return "redirect:/notes";
        }
        session.setAttribute("noteToDeleteId", id);
        return "SureWantToDeleteNotePage";
    }


    private Note getNoteByIdFromListNullIfNotFound(Long noteToDisplayId, List<Note> allNotes) {
        Iterator<Note> iterator = allNotes.iterator();
        Note soughtNote = null;
        Note tempNote;
        while (iterator.hasNext()) {
            if ((tempNote = iterator.next()).getId().equals(noteToDisplayId)) {
                soughtNote = tempNote;
                break;
            }
        }
        return soughtNote;
    }


}
