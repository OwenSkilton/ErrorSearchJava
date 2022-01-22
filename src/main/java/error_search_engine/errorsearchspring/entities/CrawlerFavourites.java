package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import error_search_engine.errorsearchspring.CompositeIDS.CrawlerFavouritesID;
import error_search_engine.errorsearchspring.CompositeIDS.ForumFavouritesID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class CrawlerFavourites {

    @EmbeddedId
    private CrawlerFavouritesID crawlerFavouritesID = new CrawlerFavouritesID();


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("linkId")
    @JoinColumn(name = "link_id")
    private CrawlerItem linkid;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users userid;

    private String date;

    public CrawlerFavourites(Users userid, CrawlerItem linkid) {
        this.linkid = linkid;
        this.userid = userid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}

