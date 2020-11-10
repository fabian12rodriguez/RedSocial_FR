package modelo;

public class Login {

    private String usr_codigo;
    private String usr_descripcion;
    private String usr_password;

    public Login(String usr_codigo, String usr_descripcion, String usr_password) {
        this.usr_codigo = usr_codigo;
        this.usr_descripcion = usr_descripcion;
        this.usr_password = usr_password;
    }

    public String getUsr_codigo() {
        return usr_codigo;
    }

    public void setUsr_codigo(String usr_codigo) {
        this.usr_codigo = usr_codigo;
    }

    public String getUsr_descripcion() {
        return usr_descripcion;
    }

    public void setUsr_descripcion(String usr_descripcion) {
        this.usr_descripcion = usr_descripcion;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    @Override
    public String toString() {
        return "Login{" + "usr_codigo=" + usr_codigo + ", usr_descripcion=" + usr_descripcion + ", usr_password=" + usr_password + '}';
    }

}
