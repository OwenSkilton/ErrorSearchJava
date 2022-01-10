package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import error_search_engine.errorsearchspring.CompositeIDS.DocumentationFavouritesID;
import error_search_engine.errorsearchspring.CompositeIDS.ForumFavouritesID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class DocumentationFavourites implements Serializable {

    @EmbeddedId
    private DocumentationFavouritesID documentationFavouritesID = new DocumentationFavouritesID();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("documentationId")
    @JoinColumn(name = "documentation_id")
    private Documentation documentationid;

    private String date;

    public DocumentationFavourites(DocumentationFavouritesID documentationFavouritesID, Users userid, Documentation documentationid) {
        this.documentationFavouritesID = documentationFavouritesID;
        this.userid = userid;
        this.documentationid = documentationid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public DocumentationFavourites(Users userid, Documentation documentationid) {
        this.userid = userid;
        this.documentationid = documentationid;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public DocumentationFavourites(DocumentationFavouritesID documentationFavouritesID) {
        this.documentationFavouritesID = documentationFavouritesID;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
