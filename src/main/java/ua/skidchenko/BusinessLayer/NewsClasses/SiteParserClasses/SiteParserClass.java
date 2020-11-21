package ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses;

import ua.skidchenko.Model.News;

import java.util.Date;

public abstract class SiteParserClass {
    public String siteUrl;

    public abstract News getNews(String url, String title);

    public News updateNews(News news) {
        News news1 = getNews(news.getSource(), news.getTitle());
        if (!news1.getText().equals(news.getText())) {
            news.setChecked(news1.isChecked());
            news.setHref(news1.getHref());
            news.setLastUpdateTime(new Date());
            news.setText(news1.getText());
        }
        return news;
    }
}
