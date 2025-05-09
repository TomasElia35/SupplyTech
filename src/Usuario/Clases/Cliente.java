package Usuario.Clases;

import Usuario.Enum.Rol;
import Usuario.Enum.Sector;

import java.util.Scanner;

public class Cliente extends Usuario{
    public Cliente(int id, String nombre, Rol rol, String mail, String contrasenia, Sector sector, boolean activo) {
        super(id, nombre, rol, mail, contrasenia, sector, activo);
    }

    @Override
    public void mostrarMenu(Scanner sc) {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        boolean salir = false;

        do {
            System.out.println("Bienvenido: " + super.getNombre() + " - " + getRol());
            System.out.println("""
                1- Usuarios
                2- Insumos
                3- Salir
                Elija una opcion:
                """);

            int opcion = Integer.parseInt( sc.nextLine());

            switch (opcion){
                case 1 -> {
                    boolean salirSubmenu = false;
                    do {
                        System.out.println("""
                        1- Listado Cliente
                        2- Buscar por nombre
                        3- Volver al menú principal
                    """);
                        int opcion1 = Integer.parseInt(sc.nextLine());
                        switch (opcion1) {
                            case 1 -> gestionUsuarios.listadoCliente(sc);
                            case 2 -> gestionUsuarios.buscarPorNombre(sc);
                            case 3 -> salirSubmenu = true;
                            default -> System.out.println("Opcion inválida.");
                        }
                    } while (!salirSubmenu);
                }
                case 2 -> {
                    System.out.println("Gestión de Insumos aún no implementada.");

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
