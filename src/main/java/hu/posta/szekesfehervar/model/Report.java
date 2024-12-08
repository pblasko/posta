package hu.posta.szekesfehervar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reports")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int allVehicles;
    private int inGarage;
    private int inService;
    private int inFamiliar;
    private int inPackage;
    private int inNetwork;
    private int inParking;

}
