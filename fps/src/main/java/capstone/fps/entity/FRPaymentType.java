package capstone.fps.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "fr_payment_type", catalog = "fpsdb", schema = "fpsdb")
@XmlRootElement
public class FRPaymentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "type", length = 50)
    private String type;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "description", length = 300)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentType")
    private Collection<FRPaymentInformation> paymentInformationCollection;

    public FRPaymentType() {
    }

    public FRPaymentType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
