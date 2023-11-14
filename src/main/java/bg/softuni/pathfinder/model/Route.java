package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    public Route() {
    }
}
