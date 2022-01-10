package error_search_engine.errorsearchspring.CompositeIDS;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class ForumFavouritesID implements Serializable {

    @Column(name = "user_id")
    private String userId;
    @Column(name = "post_id")
    private Long postId;
}
