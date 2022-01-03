package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long searchhistoryid;

    @Column(nullable = false)
    private String keywords;

    private String language;
    private String framework;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private Users userid;

    public SearchHistory(String keywords, Users userid) {
        this.keywords = keywords;
        this.userid = userid;
    }

    public SearchHistory(String keywords, String language, Users userid) {
        this.keywords = keywords;
        this.language = language;
        this.userid = userid;
    }

    public SearchHistory(String keywords, String language, String framework, Users userid) {
        this.keywords = keywords;
        this.language = language;
        this.framework = framework;
        this.userid = userid;
    }
}
