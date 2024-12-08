package hu.posta.szekesfehervar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cases")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long category;
    private String licensePlate;
    private String type;
    private String description;
    private String solution;

}
