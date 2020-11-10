package modelo;

import DTO.DTOArticulo;

public class Oferta {

    private int id_oferta;
    private Comercio comercio;
    private DTOArticulo articulo;
    private String fecha_inicio_oferta;
    private String fecha_finalizacion_oferta;
    private String descripcion_oferta;
    private float precio_oferta;
    private boolean vigente_oferta;

    public Oferta(int id_oferta, Comercio comercio, DTOArticulo articulo, String fecha_inicio_oferta, String fecha_finalizacion_oferta, String descripcion_oferta, float precio_oferta, boolean vigente_oferta) {
        this.id_oferta = id_oferta;
        this.comercio = comercio;
        this.articulo = articulo;
        this.fecha_inicio_oferta = fecha_inicio_oferta;
        this.fecha_finalizacion_oferta = fecha_finalizacion_oferta;
        this.descripcion_oferta = descripcion_oferta;
        this.precio_oferta = precio_oferta;
        this.vigente_oferta = vigente_oferta;
    }

    public Oferta(Comercio comercio, DTOArticulo articulo, String fecha_inicio_oferta, String fecha_finalizacion_oferta, String descripcion_oferta, float precio_oferta, boolean vigente_oferta) {
        this.comercio = comercio;
        this.articulo = articulo;
        this.fecha_inicio_oferta = fecha_inicio_oferta;
        this.fecha_finalizacion_oferta = fecha_finalizacion_oferta;
        this.descripcion_oferta = descripcion_oferta;
        this.precio_oferta = precio_oferta;
        this.vigente_oferta = vigente_oferta;
    }

    public Oferta(int id_oferta, Comercio comercio, DTOArticulo articulo, String fecha_inicio_oferta, String fecha_finalizacion_oferta, String descripcion_oferta, float precio_oferta) {
        this.id_oferta = id_oferta;
        this.comercio = comercio;
        this.articulo = articulo;
        this.fecha_inicio_oferta = fecha_inicio_oferta;
        this.fecha_finalizacion_oferta = fecha_finalizacion_oferta;
        this.descripcion_oferta = descripcion_oferta;
        this.precio_oferta = precio_oferta;
    }

    public Oferta(int id_oferta, Comercio comercio, DTOArticulo articulo, String fecha_finalizacion_oferta, String descripcion_oferta, float precio_oferta) {
        this.id_oferta = id_oferta;
        this.comercio = comercio;
        this.articulo = articulo;
        this.fecha_finalizacion_oferta = fecha_finalizacion_oferta;
        this.descripcion_oferta = descripcion_oferta;
        this.precio_oferta = precio_oferta;
    }
    

 
    
    public Oferta(){}
    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public DTOArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(DTOArticulo articulo) {
        this.articulo = articulo;
    }

    public String getFecha_inicio_oferta() {
        return fecha_inicio_oferta;
    }

    public void setFecha_inicio_oferta(String fecha_inicio_oferta) {
        this.fecha_inicio_oferta = fecha_inicio_oferta;
    }

    public String getFecha_finalizacion_oferta() {
        return fecha_finalizacion_oferta;
    }

    public void setFecha_finalizacion_oferta(String fecha_finalizacion_oferta) {
        this.fecha_finalizacion_oferta = fecha_finalizacion_oferta;
    }

    public String getDescripcion_oferta() {
        return descripcion_oferta;
    }

    public void setDescripcion_oferta(String descripcion_oferta) {
        this.descripcion_oferta = descripcion_oferta;
    }

    public double getPrecio_oferta() {
        return precio_oferta;
    }

    public void setPrecio_oferta(float precio_oferta) {
        this.precio_oferta = precio_oferta;
    }

    public boolean isVigente_oferta() {
        return vigente_oferta;
    }

    public void setVigente_oferta(boolean vigente_oferta) {
        this.vigente_oferta = vigente_oferta;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id_oferta=" + id_oferta + ", comercio=" + comercio + ", articulo=" + articulo + ", fecha_inicio_oferta=" + fecha_inicio_oferta + ", fecha_finalizacion_oferta=" + fecha_finalizacion_oferta + ", descripcion_oferta=" + descripcion_oferta + ", precio_oferta=" + precio_oferta + ", vigente_oferta=" + vigente_oferta + '}';
    }

        
    
}
