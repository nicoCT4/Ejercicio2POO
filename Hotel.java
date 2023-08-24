//Universidad del valle de Guatemala
//Carne:23197
//Fecha: 21/08/2023
//Arrgelos de objetos
import java.util.Scanner;
public class Hotel {

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

            switch (opcion){
                case 1:
                    System.out.println("==========================================================");
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = sc.next();
                    System.out.println("Ingrese el numero de veces que ha visitado el hotel");
                    int visitas = sc.nextInt();
                    System.out.println("Ingrese el numero de personas");
                    int personas = sc.nextInt();
                    System.out.println("==========================================================");
                    cliente cliente = new cliente(nombre,visitas,personas);
                    boolean clienteEnLista = false;
                    cliente clienteNuevo = new cliente(nombre, visitas, personas);
                    boolean clienteAsignado = false;
                
                    for (habitacion h : habitaciones) {
                        if (h.getEstado() && h.getTipo().equalsIgnoreCase(cliente) && h.getCapacidad() >= clienteNuevo.getAcompañantes() + 1) {
                            h.setEstado(false);
                            clienteAsignado = true;
                            System.out.println("Habitación asignada correctamente al cliente: " + clienteNuevo.getNombre());
                            break;
                        }
                    }
                
                    if (!clienteAsignado) {
                        for (int i = 0; i < clientesEnEspera.length; i++) {
                            if (clientesEnEspera[i] == null) {
                                clientesEnEspera[i] = clienteNuevo;
                                System.out.println("Cliente en espera: " + clienteNuevo.getNombre());
                                break;
                            }
                        }
                    }               
                    clientesEnEspera[clientesEnEspera.length - 1] = clienteNuevo;
                    break;
                case 2:
                    System.out.println("==========================================================");
                    System.out.println("Ingrese el nombre del cliente");
                    String nombreCliente = sc.next();
                    System.out.println("==========================================================");
                    
                    cliente clienteEncontrado = null;
                    for (cliente c : clientesEnEspera) {
                        if (c != null && c.getNombre().toLowerCase().equals(nombreCliente.toLowerCase())) {
                            clienteEncontrado = c;
                            break;
                        }
                    }
                    
                    if (clienteEncontrado != null) {
                        String tipoCliente = "Regular";
                        if (clienteEncontrado.getVisitasHotel() >= 5 && clienteEncontrado.getVisitasHotel() < 10) {
                            tipoCliente = "Frecuente";
                        } else if (clienteEncontrado.getVisitasHotel() >= 10) {
                            tipoCliente = "VIP";
                        }
                        
                        habitacion habitacionDisponible = null;
                        for (habitacion h : habitaciones) {
                            if (h.getEstado() && h.getTipo().equalsIgnoreCase(tipoCliente) && h.getCapacidad() >= clienteEncontrado.getAcompañantes() + 1) {
                                habitacionDisponible = h;
                                break;
                            }
                        }
                        
                    if (clienteEncontrado != null) {
                            for (habitacion h : habitaciones) {
                                if (!h.getEstado() && h.getTipo().equalsIgnoreCase(tipoCliente) && h.getCapacidad() >= clienteEncontrado.getAcompañantes() + 1) {
                                    System.out.println("Cliente ya ha sido asignado a una habitación.");
                                    break;
                                }
                            }
                    
                        boolean enclientesEnEspera = false;
                        for (cliente c : clientesEnEspera) {
                                if (c != null && c.equals(clienteEncontrado)) {
                                    enclientesEnEspera = true;
                                    break;
                                }
                            }
                    
                        if (!enclientesEnEspera) {
                            for (int i = 0; i < clientesEnEspera.length; i++) {
                                    if (clientesEnEspera[i] == null) {
                                        clientesEnEspera[i] = clienteEncontrado;
                                        System.out.println("Cliente en espera: " + clienteEncontrado.getNombre());
                                        break;
                                    }
                                }
                        } else {
                                System.out.println("Cliente ya está en la lista de espera.");
                            }
                        } else {
                            System.out.println("Cliente no encontrado en la lista.");
                        }
                break;
                    }
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


