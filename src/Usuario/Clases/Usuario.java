package Usuario.Clases;

import Usuario.Enum.Rol;
import Usuario.Enum.Sector;

import java.util.Scanner;

public abstract class Usuario {
    private int id;
    private String nombre;
    private Rol rol;
    private String mail;
    private String contrasenia;
    private Sector sector;
    private boolean activo;

    public Usuario(int id, String nombre, Rol rol, String mail, String contrasenia, Sector sector, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.mail = mail;
        this.contrasenia = contrasenia;
        this.sector = sector;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rol=" + rol +
                ", mail='" + mail + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", sector=" + sector +
                ", activo=" + activo +
                '}';
    }

    public abstract void mostrarMenu(Scanner sc);

}
