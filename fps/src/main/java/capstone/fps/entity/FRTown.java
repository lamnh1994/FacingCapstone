package capstone.fps.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "fr_town", catalog = "fpsdb", schema = "")
@XmlRootElement
public class FRTown {
    private static final long serialVersionUID = 1L;
    @Id
    @Expose
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Expose
    @Column(name = "name", length = 50)
    private String name;
    @Expose
    @ManyToOne
    @JoinColumn(name = "city_id")
    private FRCity city;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "town")
    private Collection<FROrder> orderCollection;

    public FRTown() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FRCity getCity() {
        return city;
    }

    public void setCity(FRCity city) {
        this.city = city;
    }
}
