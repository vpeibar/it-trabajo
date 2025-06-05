/*package controller;

import com.opensymphony.xwork2.ActionSupport;
import com.google.gson.Gson;
import model.Categoria;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public class CategoriaAction extends ActionSupport {

    private List<Categoria> categorias;
    private String mensaje;

    public String execute() {
        try {
            URL url = new URL("http://localhost:8080/DirectoAlPlatoREST/webresources/categorias");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();

                Categoria[] array = gson.fromJson(in, Categoria[].class);
                categorias = Arrays.asList(array);

                mensaje = "Categorías cargadas correctamente";
                return SUCCESS;
            } else {
                mensaje = "No se pudieron cargar las categorías. Código: " + conn.getResponseCode();
                return ERROR;
            }
        } catch (Exception e) {
            mensaje = "Error al conectar con el servicio de categorías.";
            e.printStackTrace();
            return ERROR;
        }
    }

    // Getters y Setters
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
*/