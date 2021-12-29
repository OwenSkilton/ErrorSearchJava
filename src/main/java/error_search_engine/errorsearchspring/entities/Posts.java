package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Posts {

    @Id
    @Column(nullable = false)
    private int postid;

    @Column(nullable = false)
    private String link;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Favourites.class, mappedBy = "postid")
    private List<Favourites> postsToFavourites;


    public int getPostID() {
        return postid;
    }
    public void setPostID(int postID) {
        this.postid = postID;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }


}
