package ua.skidchenko.ControllerLayer.Services.NewsService;

import ua.skidchenko.Model.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews ();

    void updateAllNews();

    News createNewNewsBySource(String url, String title);
}
