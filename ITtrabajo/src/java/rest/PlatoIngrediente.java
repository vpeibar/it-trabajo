/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "plato_ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlatoIngrediente.findAll", query = "SELECT p FROM PlatoIngrediente p")
    , @NamedQuery(name = "PlatoIngrediente.findById", query = "SELECT p FROM PlatoIngrediente p WHERE p.id = :id")
    , @NamedQuery(name = "PlatoIngrediente.findByCantidad", query = "SELECT p FROM PlatoIngrediente p WHERE p.cantidad = :cantidad")})
public class PlatoIngrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "plato_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Plato platoId;
    @JoinColumn(name = "ingrediente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingrediente ingredienteId;

    public PlatoIngrediente() {
    }

    public PlatoIngrediente(Integer id) {
        this.id = id;
    }

    public PlatoIngrediente(Integer id, String cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Plato getPlatoId() {
        return platoId;
    }

    public void setPlatoId(Plato platoId) {
        this.platoId = platoId;
    }

    public Ingrediente getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Ingrediente ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatoIngrediente)) {
            return false;
        }
        PlatoIngrediente other = (PlatoIngrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.PlatoIngrediente[ id=" + id + " ]";
    }
    
}
