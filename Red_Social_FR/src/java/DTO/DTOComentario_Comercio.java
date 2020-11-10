package DTO;

import modelo.*;

public class DTOComentario_Comercio {

    private int id_comentario;
    private Comercio comercio;
    private String vecino_comentario;
    private String descripcion_comentario;
    private int valoracion_comercio_comentario;
    private String respuesta_comercio_comentario;

    public DTOComentario_Comercio(int id_comentario, Comercio comercio, String vecino_comentario, String descripcion_comentario, int valoracion_comercio_comentario, String respuesta_comercio_comentario) {
        this.id_comentario = id_comentario;
        this.comercio = comercio;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_comentario = descripcion_comentario;
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
        this.respuesta_comercio_comentario = respuesta_comercio_comentario;
    }

    public DTOComentario_Comercio(Comercio comercio, String vecino_comentario, String descripcion_comentario, int valoracion_comercio_comentario, String respuesta_comercio_comentario) {
        this.comercio = comercio;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_comentario = descripcion_comentario;
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
        this.respuesta_comercio_comentario = respuesta_comercio_comentario;
    }

    public DTOComentario_Comercio(Comercio comercio, String vecino_comentario, String descripcion_comentario, int valoracion_comercio_comentario) {
        this.comercio = comercio;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_comentario = descripcion_comentario;
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
    }

    public DTOComentario_Comercio(int id_comentario, Comercio comercio, String vecino_comentario, String descripcion_comentario, int valoracion_comercio_comentario) {
        this.id_comentario = id_comentario;
        this.comercio = comercio;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_comentario = descripcion_comentario;
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
    }
 
    

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public String getVecino_comentario() {
        return vecino_comentario;
    }

    public void setVecino_comentario(String vecino_comentario) {
        this.vecino_comentario = vecino_comentario;
    }

    public String getDescripcion_comentario() {
        return descripcion_comentario;
    }

    public void setDescripcion_comentario(String descripcion_comentario) {
        this.descripcion_comentario = descripcion_comentario;
    }

    public int getValoracion_comercio_comentario() {
        return valoracion_comercio_comentario;
    }

    public void setValoracion_comercio_comentario(int valoracion_comercio_comentario) {
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
    }

    public String getRespuesta_comercio_comentario() {
        return respuesta_comercio_comentario;
    }

    public void setRespuesta_comercio_comentario(String respuesta_comercio_comentario) {
        this.respuesta_comercio_comentario = respuesta_comercio_comentario;
    }

    @Override
    public String toString() {
        return "Comentario_Comercio{" + "id_comentario=" + id_comentario + ", comercio=" + comercio + ", vecino_comentario=" + vecino_comentario + ", descripcion_comentario=" + descripcion_comentario + ", valoracion_comercio_comentario=" + valoracion_comercio_comentario + ", respuesta_comercio_comentario=" + respuesta_comercio_comentario + '}';
    }

}
