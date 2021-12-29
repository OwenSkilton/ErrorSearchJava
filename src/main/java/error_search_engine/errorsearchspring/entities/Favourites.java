package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Favourites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favouritesid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postid")
    private Posts postid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private Users userid;


    public int getFavouritesid() {
        return favouritesid;
    }

    public Posts getPostid() {
        return postid;
    }
    public void setPostid(Posts postid) {
        this.postid = postid;
    }

    public Users getUserid() {
        return userid;
    }
    public void setUserid(Users userid) {
        this.userid = userid;
    }
}
