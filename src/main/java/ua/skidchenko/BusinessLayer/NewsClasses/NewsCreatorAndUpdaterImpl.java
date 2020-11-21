package ua.skidchenko.BusinessLayer.NewsClasses;

import ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses.Dota2ruParserClass;
import ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses.MangaLibParserClass;
import ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses.ReadMangaParserClass;
import ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses.SiteParserClass;
import ua.skidchenko.DAOLayer.SpringDataRepository.NewsRepository;
import ua.skidchenko.Model.News;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NewsCreatorAndUpdaterImpl implements NewsCreatorAndUpdater {

    final
    NewsRepository newsRepository;

    private static final Set<SiteParserClass> siteParserClasses = new HashSet<>();

    static {
        siteParserClasses.add(new Dota2ruParserClass());
        siteParserClasses.add(new MangaLibParserClass());
        siteParserClasses.add(new ReadMangaParserClass());
    }

    public NewsCreatorAndUpdaterImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News createNewNews(String url, String title) throws Exception {
        News news;
        SiteParserClass siteParserClass = getSiteParserClassByUrlMatch(url);
        news = siteParserClass.getNews(url,title);
        newsRepository.save(news);
        return news;
    }

    @Override
    public void updateAllNews() throws Exception {
        for (News news : newsRepository.findAll()) updateNews(news);
    }

    @Override
    public News updateNews(News news) throws Exception {
        SiteParserClass siteParserClass = getSiteParserClassByUrlMatch(news.getSource());
        News news1 = siteParserClass.updateNews(news);
        newsRepository.save(news1);
        return news1;

    }

    private SiteParserClass getSiteParserClassByUrlMatch(String url) throws Exception {
        SiteParserClass siteParserClass = null;
        for (SiteParserClass parser : siteParserClasses) {
            if (url.contains(parser.siteUrl)) {
                siteParserClass = parser;
            }
        }
        if (siteParserClass == null) {
            throw new Exception("Provided URL does not match with any of sought. (siteParserClass == null)");
        }
        return siteParserClass;
    }
}
