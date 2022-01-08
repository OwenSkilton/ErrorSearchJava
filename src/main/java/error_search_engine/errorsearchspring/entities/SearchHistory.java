package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

    private SearchParameter searchParameter;

    private String date;

    public SearchHistory(String keywords, Users userid, SearchParameter searchParameter) {
        this.keywords = keywords;
        this.userid = userid;
        this.searchParameter = searchParameter;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public SearchHistory(String keywords, String language, Users userid, SearchParameter searchParameter) {
        this.keywords = keywords;
        this.language = language;
        this.userid = userid;
        this.searchParameter = searchParameter;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public SearchHistory(String keywords, String language, String framework, Users userid, SearchParameter searchParameter) {
        this.keywords = keywords;
        this.language = language;
        this.framework = framework;
        this.userid = userid;
        this.searchParameter = searchParameter;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
