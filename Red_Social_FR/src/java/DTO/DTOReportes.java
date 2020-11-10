package DTO;

public class DTOReportes {

    private int id_comercio;
    private String nombre_comercio;
    private int cantidad_comentarios;
    private String vecino_comentario;
    private String descripcion_comentario;
    private double promedio_valoracion;
    private int valoracion_comercio_comentario;
    private int cantidad_valoraciones;
    private String descripcion_consulta_oferta;
    private String descripcion_oferta;

    public DTOReportes(int id_comercio, String nombre_comercio, int cantidad_comentarios, String vecino_comentario, String descripcion_comentario, double promedio_valoracion, int valoracion_comercio_comentario, int cantidad_valoraciones, String descripcion_consulta_oferta, String descripcion_oferta) {
        this.id_comercio = id_comercio;
        this.nombre_comercio = nombre_comercio;
        this.cantidad_comentarios = cantidad_comentarios;
        this.vecino_comentario = vecino_comentario;
        this.descripcion_comentario = descripcion_comentario;
        this.promedio_valoracion = promedio_valoracion;
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
        this.cantidad_valoraciones = cantidad_valoraciones;
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;
        this.descripcion_oferta = descripcion_oferta;
    }
    
      public DTOReportes() {
    }

    public int getId_comercio() {
        return id_comercio;
    }

    public void setId_comercio(int id_comercio) {
        this.id_comercio = id_comercio;
    }

    public String getNombre_comercio() {
        return nombre_comercio;
    }

    public void setNombre_comercio(String nombre_comercio) {
        this.nombre_comercio = nombre_comercio;
    }

    public int getCantidad_comentarios() {
        return cantidad_comentarios;
    }

    public void setCantidad_comentarios(int cantidad_comentarios) {
        this.cantidad_comentarios = cantidad_comentarios;
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

    public double getPromedio_valoracion() {
        return promedio_valoracion;
    }

    public void setPromedio_valoracion(double promedio_valoracion) {
        this.promedio_valoracion = promedio_valoracion;
    }

    public int getValoracion_comercio_comentario() {
        return valoracion_comercio_comentario;
    }

    public void setValoracion_comercio_comentario(int valoracion_comercio_comentario) {
        this.valoracion_comercio_comentario = valoracion_comercio_comentario;
    }

    public int getCantidad_valoraciones() {
        return cantidad_valoraciones;
    }

    public void setCantidad_valoraciones(int cantidad_valoraciones) {
        this.cantidad_valoraciones = cantidad_valoraciones;
    }

    public String getDescripcion_consulta_oferta() {
        return descripcion_consulta_oferta;
    }

    public void setDescripcion_consulta_oferta(String descripcion_consulta_oferta) {
        this.descripcion_consulta_oferta = descripcion_consulta_oferta;
    }

    public String getDescripcion_oferta() {
        return descripcion_oferta;
    }

    public void setDescripcion_oferta(String descripcion_oferta) {
        this.descripcion_oferta = descripcion_oferta;
    }

    @Override
    public String toString() {
        return "DTOReportes{" + "id_comercio=" + id_comercio + ", nombre_comercio=" + nombre_comercio + ", cantidad_comentarios=" + cantidad_comentarios + ", vecino_comentario=" + vecino_comentario + ", descripcion_comentario=" + descripcion_comentario + ", promedio_valoracion=" + promedio_valoracion + ", valoracion_comercio_comentario=" + valoracion_comercio_comentario + ", cantidad_valoraciones=" + cantidad_valoraciones + ", descripcion_consulta_oferta=" + descripcion_consulta_oferta + ", descripcion_oferta=" + descripcion_oferta + '}';
    }

    

 

}
