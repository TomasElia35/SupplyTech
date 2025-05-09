package Usuario.Clases;

import Usuario.Enum.Rol;
import Usuario.Enum.Sector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();


    public void altaCliente(Scanner sc) {
        System.out.println("Ingresar ID");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Ingresar nombre y apellido");
        String nombre = sc.nextLine();

        System.out.println("Ingresar el rol (ADMINISTRADOR/CLIENTE)");
        String entrada1 = sc.nextLine().toUpperCase();
        Rol rol = Rol.valueOf(entrada1);

        System.out.println("Ingresar mail");
        String mail = sc.nextLine();

        System.out.println("Ingresar contraseña");
        String contrasenia = sc.nextLine();

        System.out.println("Ingresar Sector");
        String entrada2 = sc.nextLine().toUpperCase();
        Sector sector = Sector.valueOf(entrada2);

        Usuario nuevoUsuario;

        if (rol == Rol.ADMINISTRADOR) {
            nuevoUsuario = new Administrador(id, nombre, rol, mail, contrasenia, sector, true);
        } else {
            nuevoUsuario = new Cliente(id, nombre, rol, mail, contrasenia, sector, true);
        }
        usuarios.add(nuevoUsuario);
    }

    public void bajaCliente(Scanner sc) {
        System.out.println("Ingresar ID del usuario a dar de baja");
        int id = Integer.parseInt(sc.nextLine());

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setActivo(false);
                System.out.println("Usuario: " + usuario.getMail() + " se encuentra dado de baja");
            }
        }
    }

    public void modificarCliente(Scanner sc) {
        System.out.println("Ingresar ID del usuario a modificar");
        int id = Integer.parseInt(sc.nextLine());
        int opcion;
        boolean salir = false;
        for (Usuario usuario : usuarios) {
            do {
                System.out.println("""
                        Dato a modificar:
                        1- Nombre
                        2- Rol
                        3- Mail
                        4- Contraseña
                        5- Sector
                        6- Activo
                        7- Salir
                        """);
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingresar nuevo Nombre");
                        String nombre = sc.nextLine();
                        usuario.setNombre(nombre);
                    }
                    case 2 -> {
                        System.out.println("Ingresar nuevo Rol");
                        String entrada = sc.nextLine().toUpperCase();
                        Rol rol = Rol.valueOf(entrada);
                        usuario.setRol(rol);
                    }
                    case 3 -> {
                        System.out.println("Ingresar nuevo Mail");
                        String mail = sc.nextLine();
                        usuario.setMail(mail);
                    }
                    case 4 -> {
                        System.out.println("Ingresar nueva Contraseña");
                        String contrasenia = sc.nextLine();
                        usuario.setContrasenia(contrasenia);
                    }
                    case 5 -> {
                        System.out.println("Ingresar nuevo Sector");
                        String entrada = sc.nextLine().toUpperCase();
                        Sector sector = Sector.valueOf(entrada);
                        usuario.setSector(sector);
                    }
                    case 6 -> {
                        System.out.println("Usuario ACTIVO o INACTIVO?");
                        String entrada = sc.nextLine().toUpperCase();
                        if (entrada.equalsIgnoreCase("ACTIVO")) {
                            usuario.setActivo(true);
                        } else if (entrada.equalsIgnoreCase("INACTIVO")) {
                            usuario.setActivo(false);
                        } else {
                            System.out.println("Valor no encontrado");
                        }
                    }
                    case 7 -> {
                        System.out.println("Saliendo");
                        salir = true;
                    }
                    default -> System.out.println("Opcion invalida");
                }
            } while (salir != true);
        }
    }

    public void listadoCliente(Scanner sc) {
        boolean salir = false;

        do {
            System.out.println("""
                Listado de clientes:
                1- Todos
                2- Altas
                3- Bajas
                4- Salir
                """);

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Todos los Usuarios:");
                    for (Usuario usuario : usuarios) {
                        System.out.println(usuario);
                    }
                }
                case 2 -> {
                    System.out.println("Usuarios Activos:");
                    for (Usuario usuario : usuarios) {
                        if (usuario.isActivo()) {
                            System.out.println(usuario);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Usuarios Inactivos:");
                    for (Usuario usuario : usuarios) {
                        if (!usuario.isActivo()) {
                            System.out.println(usuario);
                        }
                    }
                }
                case 4 -> {
                    salir = true;
                    System.out.println("Saliendo del listado.");
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (!salir);
    }


    public void buscarPorNombre(Scanner sc){
        System.out.println("Ingresar nombre a buscar");
        String nombre = sc.nextLine().toLowerCase();
        for (Usuario usuario : usuarios){
            if(usuario.getNombre().equalsIgnoreCase(nombre)){
                System.out.println(usuario);
            }
        }
    }

}





