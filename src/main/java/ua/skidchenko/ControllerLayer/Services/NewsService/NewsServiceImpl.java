package ua.skidchenko.ControllerLayer.Services.NewsService;

import ua.skidchenko.BusinessLayer.NewsClasses.NewsCreatorAndUpdater;
import ua.skidchenko.DAOLayer.SpringDataRepository.NewsRepository;
import ua.skidchenko.Model.News;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class NewsServiceImpl implements NewsService {

    final
    NewsCreatorAndUpdater newsCreatorAndUpdater;
    final
    NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository, NewsCreatorAndUpdater newsCreatorAndUpdater) {
        this.newsRepository = newsRepository;
        this.newsCreatorAndUpdater = newsCreatorAndUpdater;
    }

    @Override
    public List<News> getAllNews() {
        log.info("Retrieving from DB list of all news.");
        List<News> all = newsRepository.findAll();
        log.info(" List of all news successfully retrieved from DB.");
        return all;
    }

    @Override
    public void updateAllNews() {
        log.info("Updating all news in DB.");
        try {
            newsCreatorAndUpdater.updateAllNews();
        } catch (Exception e) {
            log.error("Error during updating all news in DB.", e);
            e.printStackTrace();
        }
        log.info("All news in DB successfully updated.");
    }

    @Override
    public News createNewNewsBySource(String url, String title) {
        log.info("Starting creating new instance of News using URL " + url);
        News news = null;
        try {
            news = newsCreatorAndUpdater.createNewNews(url,title);
        } catch (Exception e) {
            log.error("Error during creating new news in DB. Problem URL: " + url, e);
            e.printStackTrace();
        }
        log.info("New instance of News successfully created.");
        return news;
    }

}
