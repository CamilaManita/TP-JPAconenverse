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
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "precio")
    private int precio;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "articulo_categoria",  // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "articulo_id"),  // Clave foránea a Articulo
            inverseJoinColumns = @JoinColumn(name = "categoria_id")  // Clave foránea a Categoria
    )
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();
}
