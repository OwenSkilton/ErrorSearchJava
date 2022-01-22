package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class CrawlerItem {

    @Id
    @Column(nullable = false)
    private String linkid;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "linkid")
    private List<CrawlerFavourites> crawlerToCrawlerFavourites;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public CrawlerItem(String linkid) {
        this.linkid = linkid;
    }
}


