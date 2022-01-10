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
public class DocumentationFavouritesID implements Serializable {

    @Column(name = "user_id")
    private String userId;
    @Column(name = "documentation_id")
    private String documentationId;
}

