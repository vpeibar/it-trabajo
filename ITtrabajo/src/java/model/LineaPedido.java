/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author maria
 */
public class LineaPedido {
    private int id;
    private int pedido_id;
    private int plato_id;
    private int cantidad;

    public LineaPedido(int id, int pedido_id, int plato_id, int cantidad) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.plato_id = plato_id;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(int plato_id) {
        this.plato_id = plato_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
