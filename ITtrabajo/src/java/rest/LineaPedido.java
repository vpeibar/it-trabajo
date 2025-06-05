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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "linea_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaPedido.findAll", query = "SELECT l FROM LineaPedido l")
    , @NamedQuery(name = "LineaPedido.findById", query = "SELECT l FROM LineaPedido l WHERE l.id = :id")
    , @NamedQuery(name = "LineaPedido.findByPedidoId", query = "SELECT l FROM LineaPedido l WHERE l.pedidoId = :pedidoId")
    , @NamedQuery(name = "LineaPedido.findByPlatoId", query = "SELECT l FROM LineaPedido l WHERE l.platoId = :platoId")
    , @NamedQuery(name = "LineaPedido.findByCantidad", query = "SELECT l FROM LineaPedido l WHERE l.cantidad = :cantidad")})
public class LineaPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pedido_id")
    private int pedidoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plato_id")
    private int platoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;

    public LineaPedido() {
    }

    public LineaPedido(Integer id) {
        this.id = id;
    }

    public LineaPedido(Integer id, int pedidoId, int platoId, int cantidad) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.platoId = platoId;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getPlatoId() {
        return platoId;
    }

    public void setPlatoId(int platoId) {
        this.platoId = platoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        if (!(object instanceof LineaPedido)) {
            return false;
        }
        LineaPedido other = (LineaPedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.LineaPedido[ id=" + id + " ]";
    }
    
}
