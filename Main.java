package modelo;

import java.util.Scanner;

/**
 * Clase principal del sistema de inventarios.
 * Punto de entrada de la aplicación.
 * Demuestra el funcionamiento de todos los requerimientos.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        Reporte reporteVentas = new Reporte();

        // Usuarios del sistema (demostración de herencia y polimorfismo)
        Persona admin = new Administrador("Jose Carranza", "admin01", "pass123");
        Persona cajero = new Cajero("Walter Negreiros", "cajero01", "pass456");
        Persona encargado = new EncargadoAlmacen("Harley Jara", "almacen01", "pass789");

        int opcion;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE INVENTARIO - UPN 2025-1   ");
            System.out.println("========================================");
            System.out.println("1. Registrar producto (HU-01)");
            System.out.println("2. Actualizar stock (HU-02)");
            System.out.println("3. Buscar producto (HU-03)");
            System.out.println("4. Registrar venta (HU-04)");
            System.out.println("5. Generar reporte de inventario (HU-05)");
            System.out.println("6. Generar reporte de ventas");
            System.out.println("7. Mostrar usuarios del sistema");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR PRODUCTO ---");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    Producto nuevo = new Producto(nombre, stock, precio);
                    if (inventario.agregarProducto(nuevo)) {
                        System.out.println("✅ Producto registrado correctamente");
                    } else {
                        System.out.println("❌ Error: Ya existe un producto con ese nombre");
                    }
                    break;

                case 2:
                    System.out.println("\n--- ACTUALIZAR STOCK ---");
                    System.out.print("Nombre del producto: ");
                    String nomBuscar = sc.nextLine();
                    System.out.print("Nuevo stock: ");
                    int nuevoStock = sc.nextInt();
                    sc.nextLine();

                    if (inventario.actualizarStock(nomBuscar, nuevoStock)) {
                        System.out.println("✅ Stock actualizado correctamente");
                    } else {
                        System.out.println("❌ Producto no encontrado");
                    }
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR PRODUCTO ---");
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    Producto encontrado = inventario.buscarProducto(buscar);
                    if (encontrado != null) {
                        System.out.println("✅ Producto encontrado: " + encontrado);
                    } else {
                        System.out.println("❌ Producto no encontrado");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REGISTRAR VENTA ---");
                    System.out.print("Producto a vender: ");
                    String prodVenta = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha (DD/MM/YYYY): ");
                    String fecha = sc.nextLine();

                    Producto pVenta = inventario.buscarProducto(prodVenta);
                    if (pVenta != null) {
                        if (pVenta.reducirStock(cantidad)) {
                            Venta v = new Venta(pVenta, cantidad, fecha);
                            reporteVentas.agregarVenta(v);
                            System.out.println("✅ Venta realizada: " + v);
                        } else {
                            System.out.println("❌ Stock insuficiente o cantidad inválida");
                        }
                    } else {
                        System.out.println("❌ Producto no encontrado");
                    }
                    break;

                case 5:
                    System.out.println("\n--- REPORTE DE INVENTARIO ---");
                    System.out.println(inventario.generarReporte());
                    break;

                case 6:
                    System.out.println("\n--- REPORTE DE VENTAS ---");
                    System.out.println(reporteVentas.generarReporte());
                    break;

                case 7:
                    System.out.println("\n--- USUARIOS DEL SISTEMA ---");
                    System.out.println(admin);
                    System.out.println(cajero);
                    System.out.println(encargado);
                    break;

                case 0:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        sc.close();
    }
}
// Main: Menu interactivo para demostracion del sistema
