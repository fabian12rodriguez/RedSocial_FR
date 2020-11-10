
package modelo;

public class Comercio {

    private int id_comercio;
    private String nombre_comercio;
    private String telefono_comercio;
    private String direccion_comercio;
    private String email_comercio;
    private Rubro rubro;
    private boolean vigente_comercio;

    public Comercio(int id_comercio, String nombre_comercio, String telefono_comercio, String direccion_comercio, String email_comercio, Rubro rubro, boolean vigente_comercio) {
        this.id_comercio = id_comercio;
        this.nombre_comercio = nombre_comercio;
        this.telefono_comercio = telefono_comercio;
        this.direccion_comercio = direccion_comercio;
        this.email_comercio = email_comercio;
        this.rubro = rubro;
        this.vigente_comercio = vigente_comercio;
    }

    public Comercio(String nombre_comercio, String telefono_comercio, String direccion_comercio, String email_comercio, Rubro rubro, boolean vigente_comercio) {
        this.nombre_comercio = nombre_comercio;
        this.telefono_comercio = telefono_comercio;
        this.direccion_comercio = direccion_comercio;
        this.email_comercio = email_comercio;
        this.rubro = rubro;
        this.vigente_comercio = vigente_comercio;
    }
    public Comercio(){}
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

    public String getTelefono_comercio() {
        return telefono_comercio;
    }

    public void setTelefono_comercio(String telefono_comercio) {
        this.telefono_comercio = telefono_comercio;
    }

    public String getDireccion_comercio() {
        return direccion_comercio;
    }

    public void setDireccion_comercio(String direccion_comercio) {
        this.direccion_comercio = direccion_comercio;
    }

    public String getEmail_comercio() {
        return email_comercio;
    }

    public void setEmail_comercio(String email_comercio) {
        this.email_comercio = email_comercio;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public boolean isVigente_comercio() {
        return vigente_comercio;
    }

    public void setVigente_comercio(boolean vigente_comercio) {
        this.vigente_comercio = vigente_comercio;
    }

    @Override
    public String toString() {
        return "Comercio{" + "id_comercio=" + id_comercio + ", nombre_comercio=" + nombre_comercio + ", telefono_comercio=" + telefono_comercio + ", direccion_comercio=" + direccion_comercio + ", email_comercio=" + email_comercio + ", rubro=" + rubro + ", vigente_comercio=" + vigente_comercio + '}';
    }

}
