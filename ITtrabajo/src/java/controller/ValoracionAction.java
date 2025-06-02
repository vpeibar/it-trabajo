/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.Valoracion;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ValoracionAction extends ActionSupport {

    private Valoracion valoracion;

    public String registrar() {
        try {
            URL url = new URL("http://localhost:8080/DirectoAlPlatoREST/webresources/valoraciones");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(valoracion);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            return conn.getResponseCode() == 201 ? SUCCESS : ERROR;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }
}
