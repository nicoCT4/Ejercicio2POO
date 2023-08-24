//Universidad del valle de Guatemala
//Carne:23197
//Fecha: 21/08/2023
//Arrgelos de objetos
import java.util.Scanner;
/**
 * Clase principal que simula la gestión de reservas de habitaciones en un hotel.
 */
public class Hotel {
        /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[]args)
    {
        //Creacion de las habitaciones
        Scanner sc = new Scanner(System.in);
        habitacion habitacion1 = new habitacion(1,100,"Estandar",true,4);
        habitacion habitacion2= new habitacion(2,300,"Deluxe",true,6);
        habitacion habitacion3 = new habitacion(3,800,"Suites",true,8);

        //Arreglo de los clientes para lista de espera
        cliente [] clientesEnEspera = new cliente[5];
        //Arreglo de las habitaciones
        habitacion[] habitaciones = new habitacion[3];
        habitaciones[0] = habitacion1;
        habitaciones[1] = habitacion2;
        habitaciones[2] = habitacion3;
        boolean habitacionesOcupadas=false;

        //Menu
        while (true){
            System.out.println("==========================================================");
            System.out.println("Bienvenido al hotel Motagua");
            System.out.println("==========================================================");
            System.out.println("1. Recibir cliente");
            System.out.println("2. Asignar habitacion");
            System.out.println("3. Limpiar habitacion");
            System.out.println("4. Salir");
            System.out.println("==========================================================");
            System.out.print("Ingrese una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("==========================================================");
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = sc.next();
                    System.out.println("Ingrese el numero de veces que ha visitado el hotel");
                    int visitas = sc.nextInt();
                    System.out.println("Ingrese el numero de personas");
                    int personas = sc.nextInt();
                    System.out.println("==========================================================");
                    // Crear un nuevo cliente
                    cliente clienteNuevo = new cliente(nombre, visitas, personas);
                    // Colocar al cliente en la lista de espera si no hay habitaciones disponibles
                    boolean clienteEnListaEspera = true;
                    for (int i = 0; i < clientesEnEspera.length; i++) {
                        if (clientesEnEspera[i] == null) {
                            clientesEnEspera[i] = clienteNuevo;
                            clienteEnListaEspera = false;
                            System.out.println("El cliente ha sido añadido a la lista de espera.");
                            break;
                        }
                    }
                    if (clienteEnListaEspera) {
                        System.out.println("La lista de espera está llena, no se puede agregar más clientes.");
                    }
                    habitacionesOcupadas=true;
                    for (habitacion h : habitaciones) {
                        if (!h.getEstado()) {
                            habitacionesOcupadas=false;
                            break;
                        }
                    }
                    if (habitacionesOcupadas) {
                        System.out.println("Todas las habitaciones están ocupadas, el cliente ha sido añadido a la lista de espera.");
                    }
                    break;
                case 2:
                    System.out.println("==========================================================");
                    System.out.println("Ingrese el nombre del cliente");
                    String nombreCliente = sc.next();
                    System.out.println("==========================================================");
                    // Buscar al cliente en la lista de espera
                    cliente clienteAsignado = null;
                    for (int i = 0; i < clientesEnEspera.length; i++) {
                        if (clientesEnEspera[i] != null && clientesEnEspera[i].getNombre().equalsIgnoreCase(nombreCliente)) {
                            clienteAsignado = clientesEnEspera[i];
                            clientesEnEspera[i] = null;
                            break;
                        }
                    }
                    if (clienteAsignado != null) {
                        // Asignar una habitación según la categoría del cliente
                        for (habitacion h : habitaciones) {
                            if (h.getEstado()) {
                                if (h.getTipo().equals("Estandar")&& clienteAsignado.getVisitasHotel() < 5) {
                                    h.setEstado(false);
                                    System.out.println("Habitación estándar asignada al cliente " + clienteAsignado.getNombre()+" con un precio de: "+h.getPrecio()+"$");
                                } else if (h.getTipo().equals("Deluxe") && clienteAsignado.getVisitasHotel() >= 5) {
                                    h.setEstado(false);
                                    System.out.println("Habitación Deluxe asignada al cliente " + clienteAsignado.getNombre()+" con un precio de: "+h.getPrecio()+"$");
                                } else if (h.getTipo().equals("Suites") && clienteAsignado.getVisitasHotel() >= 10) {
                                    h.setEstado(false);
                                    System.out.println("Suite asignada al cliente VIP " + clienteAsignado.getNombre()+" con un precio de: "+h.getPrecio()+"$");
                                }
                                break;
                            }
                        }
                    } else {
                        System.out.println("El cliente no está en la lista de espera o no se encuentra.");
                    }
                    break;
                case 3:
                //Limpiar todos los datos y regresar a 0 datos
                for (habitacion h : habitaciones) {
                    h.setEstado(true);
                }
                System.out.println("Todas las habitaciones han sido limpiadas y marcadas como disponibles.");
                break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}




