package error_search_engine.errorsearchspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Favourites.class, mappedBy = "userid")
    private List<Favourites> usersToFavourites;

    public int getUserID() {
        return userid;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
