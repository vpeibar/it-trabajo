/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.Pedido;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PedidoAction extends ActionSupport {

    private Pedido pedido;

    public String crear() {
        try {
            URL url = new URL("http://localhost:8080/DirectoAlPlatoREST/webresources/pedidos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(pedido);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
            }

            return conn.getResponseCode() == 201 ? SUCCESS : ERROR;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
*/