//package error_search_engine.errorsearchspring.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import error_search_engine.errorsearchspring.CompositeIDS.FavouritesID;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Getter
//@Setter
//@NoArgsConstructor
//public class Favourites implements Serializable {
//
//    @EmbeddedId
//    private FavouritesID favouritesID;
//
//    @MapsId("userid")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Users userid;
//
//    @MapsId("postid")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Posts postid;
//
//    public Favourites(FavouritesID favouritesID) {
//        this.favouritesID = favouritesID;
//    }
//}
