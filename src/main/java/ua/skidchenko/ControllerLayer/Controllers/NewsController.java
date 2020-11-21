package ua.skidchenko.ControllerLayer.Controllers;


import ua.skidchenko.ControllerLayer.Services.NewsService.NewsService;
import ua.skidchenko.DAOLayer.Forms.NewsForm;
import ua.skidchenko.DAOLayer.SpringDataRepository.NewsRepository;
import ua.skidchenko.Model.News;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Log4j2
@Controller
@RequestMapping(value = "/news")
@SessionAttributes("listOfNews")
public class NewsController {

    final
    NewsRepository newsRepository;
    final
    NewsService newsService;


    public NewsController(NewsService newsService, NewsRepository newsRepository) {
        this.newsService = newsService;
        this.newsRepository = newsRepository;
    }

    @RequestMapping(value = "/insertForm")
    public String setNewsFormAndGetCreateNewsPage(Model model) {
        log.info("Start inserting newsForm in model");
        NewsForm form = new NewsForm();
        model.addAttribute("newsForm", form);
        log.info("Attribute newsForm inserted into model." + form);
        return "CreateNewsPage";
    }

    @RequestMapping(value = "/create")
    public String createNews(@ModelAttribute("newsForm") NewsForm form) throws Exception {
        log.info("Starting Creating News from source. Form: " + form);
        News news;
        if (form == null) {
            log.error("NewsForm is null!");
            throw new Exception("Null value of newsForm");
        }
        news = newsService.createNewNewsBySource(form.getSource(), form.getTitle());
        newsRepository.save(news);
        log.info("New instance of News was created and saved id DB. News: " + news);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/redirect-at-new/{id}")
    public String redirectAtNews(@PathVariable(name = "id") Long id, HttpSession session) throws Exception {
        News news = findNewsInSessionAttributesByIdElseNull(id, session);
        news.setChecked(true);
        newsRepository.save(news);
        return "redirect:" + news.getHref();
    }

    @RequestMapping(value = "/mark-as-unread/{id}")
    public String markAsUnread(@PathVariable(name = "id") Long id,
                               HttpSession session) throws Exception {
        News news = findNewsInSessionAttributesByIdElseNull(id, session);
        news.setChecked(false);
        newsRepository.save(news);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/update-all")
    public String updateAllNews(HttpSession session) {
        newsService.updateAllNews();
        List<News> all = newsRepository.findAll();
        session.setAttribute("listOfNews", all);
        return "redirect:/notes";
    }

    private News findNewsInSessionAttributesByIdElseNull(Long id, HttpSession session
//            ,@ModelAttribute List<News> listOfNews
    ) throws Exception {
        List<News> listOfNews = (List<News>) session.getAttribute("listOfNews");
        News news = null;
        for (News news1 : listOfNews
        ) {
            if (Objects.equals(news1.getId(), id)) {
                news = news1;
                break;
            }
        }
        if (news == null) {
            throw new Exception("Sought News instance not found in list, retrieved from session.");
        }
        return news;
    }

}
