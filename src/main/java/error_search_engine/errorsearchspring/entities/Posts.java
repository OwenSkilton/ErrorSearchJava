package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Posts {

    @Id
    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String link;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postid")
    private List<Favourites> postsToFavourites;

    public Long getPostid() {
        return postid;
    }
    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }


}
