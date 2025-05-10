import Excepciones.CredencialesIncorrectasExcepcion;
import Validacion.ValidacionUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CredencialesIncorrectasExcepcion {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a Tech Supply TEG");
        ValidacionUsuario validar = new ValidacionUsuario();
        validar.validarCredenciales(sc);
    }
}