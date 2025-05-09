package Insumo.Clases;

import Insumo.Enum.Categoria;
import Insumo.Enum.Estado;
import Insumo.Enum.Sector;

import java.time.LocalDate;

public class Notebook extends Insumo{
    private String codigo;

    public Notebook(int id, Categoria categoria, String nombre, String descripcion, String responsable, boolean activo, int cantidad, double precio, LocalDate fechaAdquisicion, Estado estado, Sector sector, String codigo) {
        super(id, categoria, nombre, descripcion, responsable, activo, cantidad, precio, fechaAdquisicion, estado, sector);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void detalleInsumo() {

    }
}
