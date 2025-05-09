package Insumo.Clases;

import Insumo.Enum.Categoria;
import Insumo.Enum.Estado;
import Insumo.Enum.Sector;

import java.time.LocalDate;

public class Celular extends Insumo {
    private String imei;

    public Celular(int id, Categoria categoria, String nombre, String descripcion, String responsable, boolean activo, int cantidad, double precio, LocalDate fechaAdquisicion, Estado estado, Sector sector, String imei) {
        super(id, categoria, nombre, descripcion, responsable, activo, cantidad, precio, fechaAdquisicion, estado, sector);
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public void detalleInsumo() {

    }
}
