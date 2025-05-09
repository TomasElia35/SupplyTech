package Insumo.Clases;

import Insumo.Enum.Categoria;
import Insumo.Enum.Estado;
import Insumo.Enum.Sector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestionInsumos {
    List<Insumo> insumos = new ArrayList<>();

    public void altaInsumo(Scanner sc) {
        Insumo nuevoInsumo = null;
        System.out.println("Ingresar Id del producto");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Ingresar categoria (CELULARES,NOTEBOOK)");
        String entrada1 = sc.nextLine().toUpperCase();
        Categoria categoria = Categoria.valueOf(entrada1);
        System.out.println("Ingresar nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingresar descripcion");
        String descripcion = sc.nextLine();
        System.out.println("Ingresar Responsable");
        String responsable = sc.nextLine();
        System.out.println("Activo o inactivo");
        String entrada2 = sc.nextLine().toUpperCase();
        boolean activo = true;
        if (entrada2.equalsIgnoreCase("ACTIVO")) {
            activo = true;
        } else if (entrada2.equalsIgnoreCase("INACTIVO")) {
            activo = false;
        } else {
            System.out.println("Valor invalido");
        }
        System.out.println("Ingresar cantidad incorporada");
        int cantidad = Integer.parseInt(sc.nextLine());
        System.out.println("Ingresar precio por unidad");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Ingresar fecha incoporado dd/mm/aaaa");
        String entrada3 = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaIncorporacion = LocalDate.parse(entrada3, formatter);

        System.out.println("Ingresar Estado (ASIGNADO,REPARACION,SINASIGNAR)");
        String entrada4 = sc.nextLine().toUpperCase();
        Estado estado = Estado.valueOf(entrada4);

        System.out.println("Ingresar Sector (ADMINISTRACION,MAYORISTA,PREVENTA)");
        String entrada5 = sc.nextLine().toUpperCase();
        Sector sector = Sector.valueOf(entrada5);

        if (categoria == Categoria.CELULARES) {
            System.out.println("Ingresar IMEI");
            String imei = sc.nextLine();
            nuevoInsumo = new Celular(id, categoria, nombre, descripcion, responsable, activo, cantidad, precio, fechaIncorporacion, estado, sector, imei);
        } else if (categoria == Categoria.NOTEBOOK) {
            System.out.println("Ingresar Codigo");
            String codigo = sc.nextLine();
            nuevoInsumo = new Notebook(id, categoria, nombre, descripcion, responsable, activo, cantidad, precio, fechaIncorporacion, estado, sector, codigo);
        } else {
            System.out.println("Error");
        }
        if (nuevoInsumo != null) {
            insumos.add(nuevoInsumo);
            System.out.println(nuevoInsumo);
        } else {
            System.out.println("No se puedo ingresar el nuevo insumo");
        }
    }

    public void bajaInsumo(Scanner sc) {
        System.out.println("Ingresar ID del insumo a dar de baja");
        int id = Integer.parseInt(sc.nextLine());
        for (Insumo insumo : insumos) {
            if (insumo.getId() == id) {
                insumo.setActivo(false);
                System.out.println("Producto " + insumo.getNombre() + " dado de baja");
            }
        }
    }

    public void listadoInsumo(Scanner sc) {
        System.out.println("""
                1- Todos
                2- Asignados
                3- Reparacion
                4- Sin Asignar
                5- Salir
                Elija una opcion:
                """);
        int opcion = Integer.parseInt(sc.nextLine());
        boolean salir = false;
        do {
            switch (opcion) {
                case 1 -> {
                    for (Insumo insumo : insumos) {
                        System.out.println(insumo);
                    }
                }
                case 2 -> {
                    for (Insumo insumo : insumos) {
                        System.out.println("Productos asignados: ");
                        if (insumo.getEstado().equals("ASIGNADO")) {
                            System.out.println(insumo);
                        }
                    }
                }
                case 3 -> {
                    for (Insumo insumo : insumos) {
                        System.out.println("Productos en reparacion: ");
                        if (insumo.getEstado().equals("REPARACION")) {
                            System.out.println(insumo);
                        }
                    }
                }
                case 4 -> {
                    for (Insumo insumo : insumos) {
                        System.out.println("Productos sin asignar: ");
                        if (insumo.getEstado().equals("SINASIGNAR")) {
                            System.out.println(insumo);
                        }
                    }
                }
                case 5->{
                    salir = true;
                }
                default -> System.out.println("Opcion invalida");
            }

        } while (salir != false) ;
    }

    public void busquedaInsumo(Scanner sc){
        boolean salir = false;
        System.out.println("""
                Busqueda por:
                1- Imei
                2- Nombre
                3- Salir
                """);
        int opcion = Integer.parseInt(sc.nextLine());
        do {
            switch (opcion){
                case 1->{
                    System.out.println("Ingresar ID");
                    int id = Integer.parseInt(sc.nextLine());
                    for(Insumo insumo : insumos){
                        if (insumo.getId() == id){
                            System.out.println(insumo);
                        }
                    }
                }
                case 2->{
                    System.out.println("Ingresar nombre");
                    String nombre = sc.nextLine();
                    for(Insumo insumo : insumos){
                        if(insumo.getNombre().equalsIgnoreCase(nombre)){
                            System.out.println(insumo);
                        }
                    }
                }
                case 3-> salir = true;
                default -> System.out.println("Opcion invalida");
            }
        }while(salir != false);
    }

    public void ordenamientoInsumo(Scanner sc){
        boolean salir = false;

        System.out.println("""
                Ordenar por:
                1- Precio
                2- Estado
                3- Fecha
                4- Categoria
                5- Salir
                Elija una opcion
                """);
        int opcion = Integer.parseInt(sc.nextLine());

        do {
            switch (opcion){
                case 1->{
                    List<Insumo> insumosOrdenados = new ArrayList<>(insumos);
                    insumosOrdenados.sort(Comparator.comparing(insumo -> insumo.getPrecio()));
                    System.out.println("Insumos ordenados por precio");
                    for(Insumo insumo : insumosOrdenados){
                        insumo.detalleInsumo();
                    }
                }
                case 2->{
                    List<Insumo> insumosOrdenados = new ArrayList<>(insumos);
                    insumosOrdenados.sort(Comparator.comparing(insumo -> insumo.getEstado()));
                    System.out.println("Insumos ordenados por Estado");
                    for(Insumo insumo : insumosOrdenados){
                        insumo.detalleInsumo();
                    }
                }
                case 3-> {
                    List<Insumo> insumosOrdenados = new ArrayList<>(insumos);
                    insumosOrdenados.sort(Comparator.comparing(insumo -> insumo.getFechaAdquisicion()));
                    System.out.println("Insumos ordenados por Fecha");
                    for(Insumo insumo : insumosOrdenados){
                        insumo.detalleInsumo();
                    }
                }
                case 4-> {
                    List<Insumo> insumosOrdenados = new ArrayList<>(insumos);
                    insumosOrdenados.sort(Comparator.comparing(insumo -> insumo.getCategoria()));
                    System.out.println("Insumos ordenados por Categoria");
                    for(Insumo insumo : insumosOrdenados){
                        insumo.detalleInsumo();
                    }
                }
                case 5-> salir = true;
                default -> System.out.println("Opcion invalida");
            }
        }while(salir != false);
    }

    public void filtrarInsumo(Scanner sc){
        boolean salir = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("""
                Filtrar por:
                1- Fecha
                2- Categoria
                3- Sector
                4- Salir
                Elija una opcion
                """);
        int opcion = Integer.parseInt(sc.nextLine());

        do {
            switch (opcion){
                case 1-> {
                    System.out.println("Fecha desde (dd/mm/aaaa):");
                    LocalDate desde = LocalDate.parse(sc.nextLine(), formatter);

                    System.out.println("Fecha hasta (dd/mm/aaaa):");
                    LocalDate hasta = LocalDate.parse(sc.nextLine(), formatter);

                    List<Insumo> filtrados = filtrarPorRango(desde, hasta);
                    if (filtrados.isEmpty()) {
                        System.out.println("No se encontraron insumos en ese rango.");
                    } else {
                        filtrados.forEach(System.out::println);
                    }

                }
                case 2->{
                    System.out.println("Ingresar Categoria");
                    String entrada = sc.nextLine().toUpperCase();
                    Categoria categoria = Categoria.valueOf(entrada);
                    System.out.println("Filtrado por Tipo: " + categoria);
                    for(Insumo insumo : insumos){
                        if(insumo.getCategoria().equals(categoria)){
                            insumo.detalleInsumo();
                        }
                    }

                }
                case 3->{
                    System.out.println("Ingresar Sector");
                    String entrada = sc.nextLine().toUpperCase();
                    Sector sector = Sector.valueOf(entrada);
                    System.out.println("Filtrado por Tipo: " + sector);
                    for(Insumo insumo : insumos){
                        if(insumo.getSector().equals(sector)){
                            insumo.detalleInsumo();
                        }
                    }
                }
                case 4-> salir = true;
                default -> System.out.println("Opcion invalida");

            }
        }while(salir != false);
    }

    public List<Insumo> filtrarPorRango(LocalDate desde, LocalDate hasta) {
        List<Insumo> resultado = new ArrayList<>();
        for (Insumo insumo : insumos) {
            LocalDate fecha = insumo.getFechaAdquisicion();
            if ((fecha.isEqual(desde) || fecha.isAfter(desde)) &&
                    (fecha.isEqual(hasta) || fecha.isBefore(hasta))) {
                resultado.add(insumo);
            }
        }
        return resultado;
    }

    public void modificarInsumo(Scanner sc) {
        System.out.println("Ingresar ID del insumo:");
        int id = Integer.parseInt(sc.nextLine());
        boolean encontrado = false;

        for (Insumo insumo : insumos) {
            if (insumo.getId() == id) {
                encontrado = true;
                boolean salir = false;

                do {
                    System.out.println("""
                        Campo a modificar:
                        1- Categoria
                        2- Nombre
                        3- Descripcion
                        4- Responsable
                        5- Cantidad
                        6- Estado
                        7- Sector
                        8- Salir
                        Elija una opcion:
                        """);

                    int opcion = Integer.parseInt(sc.nextLine());

                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Ingresar nueva categoría:");
                            String entrada = sc.nextLine().toUpperCase();
                            Categoria categoria = Categoria.valueOf(entrada);
                            insumo.setCategoria(categoria);
                        }
                        case 2 -> {
                            System.out.println("Ingresar nuevo nombre:");
                            insumo.setNombre(sc.nextLine());
                        }
                        case 3 -> {
                            System.out.println("Ingresar nueva descripción:");
                            insumo.setDescripcion(sc.nextLine());
                        }
                        case 4 -> {
                            System.out.println("Ingresar nuevo responsable:");
                            insumo.setResponsable(sc.nextLine());
                        }
                        case 5 -> {
                            System.out.println("Ingresar nueva cantidad:");
                            insumo.setCantidad(Integer.parseInt(sc.nextLine()));
                        }
                        case 6 -> {
                            System.out.println("Ingresar nuevo estado (ASIGNADO,REPARACION,SINASIGNAR):");
                            String entrada = sc.nextLine().toUpperCase();
                            Estado estado = Estado.valueOf(entrada);
                            insumo.setEstado(estado);
                        }
                        case 7 -> {
                            System.out.println("Ingresar nuevo sector:");
                            String entrada = sc.nextLine().toUpperCase();
                            Sector sector = Sector.valueOf(entrada);
                            insumo.setSector(sector);
                        }
                        case 8 -> {
                            System.out.println("Saliendo de modificación...");
                            salir = true;
                        }
                        default -> System.out.println("Opción inválida.");
                    }
                } while (!salir);
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún insumo con ese ID.");
        }
    }

    public void calculosInsumo(Scanner sc) {
        boolean salir = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("""
                Calculos disponibles:
                1- Total stock por categoría
                2- Total gastado en un período
                3- Total stock por sector
                4- Salir
                Elija una opción:
                """);

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la categoría (CELULARES, NOTEBOOK):");

                        String entrada = sc.nextLine().toUpperCase();
                        Categoria categoria = Categoria.valueOf(entrada);
                        int totalStock = 0;
                        for (Insumo insumo : insumos) {
                            if (insumo.getCategoria().equals(categoria)) {
                                totalStock += insumo.getCantidad();
                            }
                        }
                        System.out.println("Total de stock para " + categoria + ": " + totalStock);
                }

                case 2 -> {
                        System.out.println("Ingrese fecha DESDE (dd/mm/aaaa):");
                        LocalDate desde = LocalDate.parse(sc.nextLine(), formatter);

                        System.out.println("Ingrese fecha HASTA (dd/mm/aaaa):");
                        LocalDate hasta = LocalDate.parse(sc.nextLine(), formatter);

                        double totalGastado = 0;

                        for (Insumo insumo : insumos) {
                            LocalDate fecha = insumo.getFechaAdquisicion();
                            if ((fecha.isEqual(desde) || fecha.isAfter(desde)) &&
                                    (fecha.isEqual(hasta) || fecha.isBefore(hasta))) {
                                totalGastado += insumo.getCantidad() * insumo.getPrecio();
                            }
                        }
                        System.out.printf("Total gastado entre %s y %s: $%.2f\n", desde, hasta, totalGastado);
                }

                case 3 -> {
                    System.out.println("Ingrese el sector (ADMINISTRACION, MAYORISTA, PREVENTA):");

                        String entrada = sc.nextLine().toUpperCase();
                        Sector sector = Sector.valueOf(entrada);
                        int total = 0;

                        for (Insumo insumo : insumos) {
                            if (insumo.getSector().equals(sector)) {
                                total += insumo.getCantidad();
                            }
                        }
                        System.out.println("Total de stock en el sector " + sector + ": " + total);
                }

                case 4 -> {
                    salir = true;
                    System.out.println("Saliendo de cálculos.");
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (!salir);
    }


}

