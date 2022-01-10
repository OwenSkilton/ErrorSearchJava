package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import error_search_engine.errorsearchspring.CompositeIDS.ForumFavouritesID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class ForumFavourites implements Serializable {

    @EmbeddedId
    private ForumFavouritesID forumFavouritesID = new ForumFavouritesID();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Posts postid;

    private String date;

    public ForumFavourites(ForumFavouritesID forumFavouritesID, Users userid, Posts postid) {
        this.forumFavouritesID = forumFavouritesID;
        this.userid = userid;
        this.postid = postid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public ForumFavourites(Users userid, Posts postid) {
        this.userid = userid;
        this.postid = postid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public ForumFavourites(ForumFavouritesID forumFavouritesID) {
        this.forumFavouritesID = forumFavouritesID;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
