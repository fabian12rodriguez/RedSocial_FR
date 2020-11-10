
package DTO;


public class DTOArticulo {

    private int codigo_articulo;
    private String nombre_articulo;
    private double precio_articulo;
    private int stock_articulo;

    public DTOArticulo(int codigo_articulo, String nombre_articulo, double precio_articulo, int stock_articulo) {
        this.codigo_articulo = codigo_articulo;
        this.nombre_articulo = nombre_articulo;
        this.precio_articulo = precio_articulo;
        this.stock_articulo = stock_articulo;
    }

    public DTOArticulo() {
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public double getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(double precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    public int getStock_articulo() {
        return stock_articulo;
    }

    public void setStock_articulo(int stock_articulo) {
        this.stock_articulo = stock_articulo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo_articulo=" + codigo_articulo + ", nombre_articulo=" + nombre_articulo + ", precio_articulo=" + precio_articulo + ", stock_articulo=" + stock_articulo + '}';
    }

}
