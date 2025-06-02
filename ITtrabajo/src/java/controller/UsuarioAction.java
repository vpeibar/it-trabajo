/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.Usuario;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class UsuarioAction extends ActionSupport {

    private Usuario usuario;
    private String mensaje;

    public String login() {
        try {
            URL url = new URL("http://localhost:8080/DirectoAlPlatoREST/webresources/usuarios/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            Gson gson = new Gson();
            String jsonInput = gson.toJson(usuario);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes());
                os.flush();
            }

            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Usuario u = gson.fromJson(in, Usuario.class);
                mensaje = "Bienvenido " + u.getNombre();
                return u.getTipo().equals("cocinero") ? "cocinero" : "cliente";
            } else {
                mensaje = "Usuario o contraseña incorrectos.";
                return ERROR;
            }
        } catch (Exception e) {
            mensaje = "Error en la conexión.";
            return ERROR;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }
}
