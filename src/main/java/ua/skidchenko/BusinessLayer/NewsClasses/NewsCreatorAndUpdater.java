package ua.skidchenko.BusinessLayer.NewsClasses;

import ua.skidchenko.Model.News;

public interface NewsCreatorAndUpdater {

    News createNewNews(String url, String title) throws Exception;

    void updateAllNews () throws Exception;

    News updateNews (News news) throws Exception;

}
