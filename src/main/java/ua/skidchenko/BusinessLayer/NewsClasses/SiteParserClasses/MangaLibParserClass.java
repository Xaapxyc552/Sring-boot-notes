package ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses;

import ua.skidchenko.Model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

public class MangaLibParserClass extends SiteParserClass {

    public MangaLibParserClass() {
        siteUrl = "mangalib.me";
    }

    @Override
    public News getNews(String url, String title) {
        String text = null;
        String href = null;
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements elementsByClass = doc.body().getElementsByClass("chapter-item__name");
            text = elementsByClass.eachText().get(0);
            href = elementsByClass.get(0).getAllElements().attr("href");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new News(text, href, url, new Date(), false, title);
    }
}
