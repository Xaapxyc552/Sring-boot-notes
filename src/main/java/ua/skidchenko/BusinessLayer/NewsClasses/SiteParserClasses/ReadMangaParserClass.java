package ua.skidchenko.BusinessLayer.NewsClasses.SiteParserClasses;

import ua.skidchenko.Model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

public class ReadMangaParserClass extends SiteParserClass {

    public ReadMangaParserClass() {
        siteUrl = "readmanga.live";
    }

    @Override
    public News getNews(String url, String title) {
        String text = null;
        String href = null;
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements elementsByClass = doc.body().getElementsByClass("table table-hover");
            text = elementsByClass.get(0).child(1).child(0).child(0).text();
            href = "https://readmanga.live" + elementsByClass.get(0).getAllElements().attr("href");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new News(text, href, url, new Date(), false,title);
    }
}
