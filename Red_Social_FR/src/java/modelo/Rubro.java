package modelo;

public class Rubro {

    private int id_rubro;
    private String descripcion_rubro;
    private boolean vigente_rubro;

    public Rubro(int id_rubro, String descripcion_rubro, boolean vigente_rubro) {
        this.id_rubro = id_rubro;
        this.descripcion_rubro = descripcion_rubro;
        this.vigente_rubro = vigente_rubro;
    }

    public Rubro(String descripcion_rubro, boolean vigente_rubro) {
        this.descripcion_rubro = descripcion_rubro;
        this.vigente_rubro = vigente_rubro;
    }

    public Rubro() {
    }

    public int getId_rubro() {
        return id_rubro;
    }

    public void setId_rubro(int id_rubro) {
        this.id_rubro = id_rubro;
    }

    public String getDescripcion_rubro() {
        return descripcion_rubro;
    }

    public void setDescripcion_rubro(String descripcion_rubro) {
        this.descripcion_rubro = descripcion_rubro;
    }

    public boolean isVigente_rubro() {
        return vigente_rubro;
    }

    public void setVigente_rubro(boolean vigente_rubro) {
        this.vigente_rubro = vigente_rubro;
    }

    public String getMostrarVigente() {
        String mensaje = "";
        if (this.vigente_rubro) {
            mensaje = "vigente";

        } else {
            mensaje = "no vigente";
        }
        return mensaje;
    }

    @Override
    public String toString() {
        return "Rubro{" + "id_rubro=" + id_rubro + ", descripcion_rubro=" + descripcion_rubro + ", vigente_rubro=" + vigente_rubro + '}';
    }

}
