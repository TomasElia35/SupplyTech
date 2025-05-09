package Usuario.Clases;

import Insumo.Clases.GestionInsumos;
import Usuario.Enum.Rol;
import Usuario.Enum.Sector;

import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador(int id, String nombre, Rol rol, String mail, String contrasenia, Sector sector, boolean activo) {
        super(id, nombre, rol, mail, contrasenia, sector,activo);
    }

    @Override
    public void mostrarMenu(Scanner sc) {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        GestionInsumos gestionInsumos = new GestionInsumos();
        boolean salir = false;

        do {
            System.out.println("Bienvenido: " + super.getNombre() + " - " + getRol());
            System.out.println("""
                1- Usuarios
                2- Insumos
                3- Salir
                Elija una opcion:
                """);

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1 -> {
                    boolean salirSubmenu = false;
                    do {
                        System.out.println("""
                        1- Alta Cliente
                        2- Baja Cliente
                        3- Modificacion cliente
                        4- Listado Cliente
                        5- Buscar por nombre
                        6- Volver al menú principal
                    """);
                        int opcion1 = Integer.parseInt(sc.nextLine());
                        switch (opcion1) {
                            case 1 -> gestionUsuarios.altaCliente(sc);
                            case 2 -> gestionUsuarios.bajaCliente(sc);
                            case 3 -> gestionUsuarios.modificarCliente(sc);
                            case 4 -> gestionUsuarios.listadoCliente(sc);
                            case 5 -> gestionUsuarios.buscarPorNombre(sc);
                            case 6 -> salirSubmenu = true;
                            default -> System.out.println("Opcion inválida.");
                        }
                    } while (!salirSubmenu);
                }
                case 2 -> {
                    System.out.println("Gestión de Insumos aún no implementada.");
                    boolean salirSubmenu = false;
                    do {
                        System.out.println("""
                        1- Alta Insumo
                        2- Baja Insumo
                        3- Modificacion Insumo
                        4- Listado Insumo
                        5- Buscar Insumo
                        6- Ordenar insumos
                        7. Filtrar Insumo
                        8- Calcular Insumo
                        9- Volver al menú principal
                    """);
                        int opcion1 = Integer.parseInt(sc.nextLine());
                        switch (opcion1) {
                            case 1 -> gestionInsumos.altaInsumo(sc);
                            case 2 -> gestionInsumos.bajaInsumo(sc);
                            case 3 -> gestionInsumos.modificarInsumo(sc);
                            case 4 -> gestionInsumos.listadoInsumo(sc);
                            case 5 -> gestionInsumos.busquedaInsumo(sc);
                            case 6 -> gestionInsumos.ordenamientoInsumo(sc);
                            case 7 -> gestionInsumos.filtrarInsumo(sc);
                            case 8 -> gestionInsumos.calculosInsumo(sc);
                            case 9 -> salirSubmenu = true;
                            default -> System.out.println("Opcion inválida.");
                        }
                    } while (!salirSubmenu);
                                }
                case 3 -> {
                    System.out.println("Saliendo del sistema.");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.");
            }

        } while (!salir);
    }

}
