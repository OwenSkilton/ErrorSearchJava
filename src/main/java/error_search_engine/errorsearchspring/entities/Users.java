package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {

    @Id
    @Column(nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userid")
    private List<Favourites> usersToFavourites;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userid")
    private List<SearchHistory> usersToSearchHistory;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Users() {
    }
    public Users(String email) {
        this.email = email;
    }
}
