package ua.skidchenko.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "news", schema = "public")
public class News {

    public News() {

    }

    public News(String text,
                String href,
                String source,
                Date lastUpdateTime,
                boolean Checked,
                String title) {
        this.text = text;
        this.href = href;
        this.source = source;
        this.lastUpdateTime = lastUpdateTime;
        this.checked = Checked;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "title")
    private String title;

    @Setter
    @Column(name = "text",nullable = false)
    private String text;

    @Setter
    @Column(name = "href",nullable = false)
    private String href;

    @Setter
    @Column(name = "source",nullable = false,unique = true)
    private String source;

    @Setter
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Setter
    @Column(name = "is_checked")
    private boolean checked;
}
