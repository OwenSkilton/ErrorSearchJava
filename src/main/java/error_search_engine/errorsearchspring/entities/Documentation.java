package error_search_engine.errorsearchspring.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Documentation {

    @Id
    @Column(nullable = false)
    private String documentationid;

    @Column(nullable = false)
    private String link;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentationid")
    private List<DocumentationFavourites> documentationToDocumentationFavourites;

    public String getDocumentationid() {
        return documentationid;
    }
    public void setDocumentationid(String documentationid) {
        this.documentationid = documentationid;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public Documentation(String documentationid, String link) throws UnsupportedEncodingException {
        this.documentationid = documentationid;
        this.link = link;
    }

}

