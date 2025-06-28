package soap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", nullable = false, unique = true, length = 10)
    private String dni;

    @Column(name = "name", nullable = false, length = 50)
    private String nombre;

    @Column(name = "lastname", nullable = false, length = 50)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;
}
