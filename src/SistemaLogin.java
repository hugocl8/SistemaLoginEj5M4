import java.util.ArrayList;
import java.util.Scanner;

class Persona {
    private String usuario;
    private String contrasena;

    public Persona(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public String getUsuario() {
        return usuario;
    }
    public boolean validarContrasena(String contrasena){
        return this.contrasena.equals(contrasena);
    }
}

public class SistemaLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("Alex15", "EmpanadadeQueso"));
        listaPersonas.add(new Persona("Juanito2024", "JuanitoPerez"));
        listaPersonas.add(new Persona("Luis90", "Lucho1990"));

        System.out.print("Ingrese su nombre de usuario: ");
        String usuarioIngresado = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contrasenaIngresada = scanner.nextLine();

        boolean accesoPermitido = false;
        for (Persona persona : listaPersonas) {
            if (persona.getUsuario().equals(usuarioIngresado) && persona.validarContrasena(contrasenaIngresada)) {
                System.out.println("Bienvenido: " + usuarioIngresado);
                accesoPermitido = true;
                mostrarMenu(scanner);
                break;
            }
        }

        if (!accesoPermitido) {
            System.out.println("Usuario o contraseña incorrectas.");
        }
    }

    public static void mostrarMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n¿Qué desea realizar?");
            System.out.println("1 - Calcular la raíz cuadrada de un número");
            System.out.println("2 - Ver el valor de pi");
            System.out.println("3 - Calcular la potencia de un número");
            System.out.println("4 - Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número: ");
                    double numeroRaiz = scanner.nextDouble();
                    System.out.printf("La raíz cuadrada de %2f es %5f%n", numeroRaiz, Math.sqrt(numeroRaiz));
                    break;
                case 2:
                    System.out.printf("El valor de pi es %.5f%n", Math.PI);
                    break;
                case 3:
                    System.out.print("Ingrese la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese el exponente: ");
                    double exponente = scanner.nextDouble();
                    System.out.printf("%.2f elevado a  %.2f es %.5f%n", base, exponente, Math.pow(base, exponente));
                    break;
                case 4:
                    System.out.println("Saliendo del sistema");
                    return;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }
}
