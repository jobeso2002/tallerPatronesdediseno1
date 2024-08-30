package taller1;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivo archivo = new Archivo();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" Sistema de cobros de envios");
            System.out.println("1. registrar nueva guia");
            System.out.println("2. consultar guias por estado");
            System.out.println("3. consultar guias por destinatario");
            System.out.println("4. finalizar una guia");
            System.out.println("5. salir");
            System.out.println("seleccione una opcion");
            int opcion = sc.nextInt();
            sc.nextLine();
            

            switch (opcion) {
                case 1:
                    registrarNuevaGuia(sc, archivo);
                    break;
                    case 2:
                        consultarGuiasPorEstado(sc, archivo);
                        break;
                        case 3:
                            consultarGuiasPorDestinatario(sc, archivo);
                        break;
                        case 4:
                            finalizarGuia(sc, archivo);
                        break;
                        case 5:
                            System.out.println("saliendo del menu...");
                            return;
                            default:
                                System.out.println("opcion invalida");
            }
        }
    }


    private static void registrarNuevaGuia(Scanner sc, Archivo archivo) {
        System.out.print("Ingrese el número de guía: ");
        int numeroGuia = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el destinatario: ");
        String destinatario = sc.nextLine();

        System.out.print("Ingrese el peso (en kg): ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese el valor declarado: ");
        double valorDeclarado = sc.nextDouble();

        System.out.print("¿Es un servicio internacional? (true/false): ");
        boolean esInternacional = sc.nextBoolean();

        System.out.println("Seleccione el tipo de servicio:");
        System.out.println("1. Sobre");
        System.out.println("2. Caja");
        System.out.println("3. Paquete");
        int tipoServicio = sc.nextInt();
        Servicio servicio = null;

        switch (tipoServicio) {
            case 1:
                servicio = new Sobre();
                break;
            case 2:
                servicio = new Caja();
                break;
            case 3:
                servicio = new Paquete();
                break;
            default:
                System.out.println("Tipo de servicio no válido.");
                return;
        }

        Guia guia = new Guia(numeroGuia, destinatario, peso, valorDeclarado, esInternacional, servicio);
        archivo.registrarGUia(guia);
        System.out.println("Guía registrada exitosamente.");
    }

    private static void consultarGuiasPorEstado(Scanner sc, Archivo archivo) {
        System.out.print("ingrese el estado a consultar (Despacho/Finalizado): ");
        String estado = sc.nextLine();
        List<Guia> guias = archivo.consultarGuiasPorEstado(estado);
        if(guias.isEmpty()) {
            System.out.println("no se encontraron guias con el estado " + estado);
        }else {
            for (Guia guia : guias) {
                System.out.println("numero de guia " + guia.getNumeroGuia() + " Destinatario" + " " + guia.getDestinatario());
            }
        }
    }

    private static void consultarGuiasPorDestinatario(Scanner sc, Archivo archivo) {
        System.out.print("ingrese el destinatario a consultar: ");
        String destinatario = sc.nextLine();
        List<Guia> guias = archivo.consultarGuiasPorDestinatario(destinatario);
        if(guias.isEmpty()) {
            System.out.println("no se encontro guias para el destinatario " + destinatario);
        }else {
            for (Guia guia : guias) {
                System.out.println("numero guia " + guia.getNumeroGuia() + " Destinatario " + guia.getDestinatario() + " estado " + guia.getEstado());
            }
        }
    }

    private static void finalizarGuia(Scanner sc, Archivo archivo) {
        System.out.print("ingrese el numero de guia a finalizar: ");
        int numeroGuia = sc.nextInt();
        String resultado = archivo.finalizarGuiaPorNumero(numeroGuia);
        System.out.println(resultado);
    }
}
