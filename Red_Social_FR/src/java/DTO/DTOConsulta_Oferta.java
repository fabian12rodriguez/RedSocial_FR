package DTO;

import modelo.*;

public class DTOConsulta_Oferta {

    private Oferta oferta;
    private int id_consulta_oferta;
    private String vecino_comentario;
    private String descripcion_consulta_oferta;
    private boolean aprobada_consulta_oferta;
    private String respuesta_consulta_vecino;

    public DTOConsulta_Oferta(Oferta oferta, int id_consulta_oferta, String vecino_comentario, String descripcion_consulta_oferta, boolean aprobada_consulta_oferta, String respuesta_consulta_vecino) {
        this.oferta = oferta;
        this.id_consulta_oferta = id_consulta_oferta;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;
        this.aprobada_consulta_oferta = aprobada_consulta_oferta;
        this.respuesta_consulta_vecino = respuesta_consulta_vecino;
    }

    public DTOConsulta_Oferta() {
    }

    public DTOConsulta_Oferta(Oferta oferta, String descripcion_consulta_oferta, boolean aprobada_consulta_oferta) {
        this.oferta = oferta;
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;
        this.aprobada_consulta_oferta = aprobada_consulta_oferta;
    }

    public DTOConsulta_Oferta(Oferta oferta, String descripcion_consulta_oferta) {
        this.oferta = oferta;
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;

    }

    public DTOConsulta_Oferta(Oferta oferta, String vecino_comentario, String descripcion_consulta_oferta) {
        this.oferta = oferta;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;
    }

    public DTOConsulta_Oferta(String respuesta_consulta_vecino) {
        this.respuesta_consulta_vecino = respuesta_consulta_vecino;
    }


    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public int getId_consulta_oferta() {
        return id_consulta_oferta;
    }

    public void setId_consulta_oferta(int id_consulta_oferta) {
        this.id_consulta_oferta = id_consulta_oferta;
    }

    public String getVecino_comentario() {
        return vecino_comentario;
    }

    public void setVecino_comentario(String vecino_comentario) {
        this.vecino_comentario = vecino_comentario;
    }

    public String getDescripcion_consulta_oferta() {
        return descripcion_consulta_oferta;
    }

    public void setDescripcion_consulta_oferta(String descripcion_consulta_oferta) {
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;
    }

    public boolean isAprobada_consulta_oferta() {
        return aprobada_consulta_oferta;
    }

    public void setAprobada_consulta_oferta(boolean aprobada_consulta_oferta) {
        this.aprobada_consulta_oferta = aprobada_consulta_oferta;
    }

    public String getRespuesta_consulta_vecino() {
        return respuesta_consulta_vecino;
    }

    public void setRespuesta_consulta_vecino(String respuesta_consulta_vecino) {
        this.respuesta_consulta_vecino = respuesta_consulta_vecino;
    }

    @Override
    public String toString() {
        return "DTOConsulta_Oferta{" + "oferta=" + oferta + ", id_consulta_oferta=" + id_consulta_oferta + ", vecino_comentario=" + vecino_comentario + ", descripcion_consulta_oferta=" + descripcion_consulta_oferta + ", aprobada_consulta_oferta=" + aprobada_consulta_oferta + ", respuesta_consulta_vecino=" + respuesta_consulta_vecino + '}';
    }

}
