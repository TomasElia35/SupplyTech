package Insumo.Clases;

import Insumo.Enum.*;

import java.time.LocalDate;

public abstract class Insumo {
    private int id;
    private Categoria categoria; //
    private String nombre;
    private String descripcion;
    private String responsable;
    private boolean activo;
    private int cantidad;
    private double precio;
    private LocalDate fechaAdquisicion;
    private Estado estado; //
    private Sector sector; //

    public Insumo(int id, Categoria categoria, String nombre, String descripcion, String responsable, boolean activo, int cantidad, double precio, LocalDate fechaAdquisicion, Estado estado, Sector sector) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.activo = activo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaAdquisicion = fechaAdquisicion;
        this.estado = estado;
        this.sector = sector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "id='" + id + '\'' +
                ", categoria=" + categoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", responsable='" + responsable + '\'' +
                ", activo=" + activo +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", fechaAdquisicion=" + fechaAdquisicion +
                ", estado=" + estado +
                ", sector=" + sector +
                '}';
    }

    public abstract void detalleInsumo();
}
