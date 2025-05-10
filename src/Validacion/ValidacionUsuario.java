package Validacion;

import Excepciones.CredencialesIncorrectasExcepcion;
import Usuario.Clases.Administrador;
import Usuario.Clases.Cliente;
import Usuario.Clases.Usuario;
import Usuario.Enum.Rol;
import Usuario.Enum.Sector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidacionUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public ValidacionUsuario(){
        usuarios.add(new Administrador(
                1,
                "Administrador",
                Rol.ADMINISTRADOR,
                "admin@gmail.com",
                "admin1234",
                Sector.SISTEMAS,
                true
        ));

        usuarios.add(new Cliente(
                2,
                "Cliente",
                Rol.CLIENTE,
                "cliente@gmail.com",
                "cliente1234",
                Sector.DESARROLLO,
                true
        ));
    }


    public void validarCredenciales (Scanner sc) throws CredencialesIncorrectasExcepcion {
        System.out.println("Ingresar mail");
        String mail = sc.nextLine();

        System.out.println("Ingresar contraseña");
        String contrasenia = sc.nextLine();

        boolean encontrado = false;


        for(Usuario usuario : usuarios){
            if(usuario.getMail().equalsIgnoreCase(mail) && usuario.getContrasenia().equals(contrasenia)) {
                    encontrado = true;
                if (usuario instanceof Administrador admin) {
                    admin.mostrarMenu(sc);
                } else if (usuario instanceof Cliente cliente) {
                    cliente.mostrarMenu(sc);
                }
            }
        }
        if (!encontrado) {
            throw new CredencialesIncorrectasExcepcion("Credenciales inválidas o usuario no encontrado.");
        }
    }
}
