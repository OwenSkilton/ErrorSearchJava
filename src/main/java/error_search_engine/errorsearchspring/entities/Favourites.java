package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import error_search_engine.errorsearchspring.CompositeIDS.FavouritesID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class Favourites implements Serializable {

    @EmbeddedId
    private FavouritesID favouritesID = new FavouritesID();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Posts postid;

    private String date;

    public Favourites(FavouritesID favouritesID, Users userid, Posts postid) {
        this.favouritesID = favouritesID;
        this.userid = userid;
        this.postid = postid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Favourites(Users userid, Posts postid) {
        this.userid = userid;
        this.postid = postid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Favourites(FavouritesID favouritesID) {
        this.favouritesID = favouritesID;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
