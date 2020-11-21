package ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses;

import ua.skidchenko.Model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

public class Dota2ruParserClass extends SiteParserClass {


    public Dota2ruParserClass() {
        siteUrl = "dota2.ru";
    }

    @Override
    public News getNews(String url, String title) {
        String text = null;
        String href = null;
        String source = "https://dota2.ru/news/updates/";
        Document doc;
        try {
            doc = Jsoup.connect(source).get();
            Elements elementsByClass = doc.body().getElementsByClass("m-news js-news-list");
            href = "https://dota2.ru" +elementsByClass.get(0).child(0).child(0).attr("href");
            text =  elementsByClass.get(0).child(0).child(0).child(0).child(0).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new News(text, href, source, new Date(), false, title);
    }
}
