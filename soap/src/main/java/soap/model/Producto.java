package soap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name-prod", nullable = false, length = 50)
    private String nombre;

    @Column(name = "price")
    private Double precio;

    @XmlTransient
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
