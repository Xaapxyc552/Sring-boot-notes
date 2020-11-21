package ua.skidchenko.DAOLayer.Forms;

import ua.skidchenko.Model.News;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class NewsForm {
    String title;
    String source;

    public News fromNewsForm() {
        News news = new News();
        news.setTitle(this.title);
        news.setSource(this.source);
        news.setChecked(false);
        return news;
    }
}
