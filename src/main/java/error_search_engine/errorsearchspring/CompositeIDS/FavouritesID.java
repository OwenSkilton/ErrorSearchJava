package error_search_engine.errorsearchspring.CompositeIDS;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class FavouritesID implements Serializable {

    private int userid;
    private int postid;

    public FavouritesID(int userid, int postid) {
        this.userid = userid;
        this.postid = postid;
    }
}
