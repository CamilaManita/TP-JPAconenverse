package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo")
@Builder
@Getter
@Setter
@Audited
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "denominacion")
    private String denominacion;
    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private List<org.example.Articulo> articulos = new ArrayList<org.example.Articulo>();
}
