package error_search_engine.errorsearchspring.CompositeIDS;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class CrawlerFavouritesID implements Serializable {

    @Column(name = "user_id")
    private String userId;
    @Column(name = "link_id")
    private String linkId;
}

