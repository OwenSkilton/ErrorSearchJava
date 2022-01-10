package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Posts {

    @Id
    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String link;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postid")
    private List<ForumFavourites> postsToForumFavourites;

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

    public Posts(Long postid, String link) {
        this.postid = postid;
        this.link = link;
    }

    public Posts(Long postid) {
        this.postid = postid;
        this.link = "https://stackoverflow.com/questions/"+postid;
    }
}
