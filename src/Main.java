import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final int MAX_OPERACIONES = 30;
    static String[] historial = new String[MAX_OPERACIONES];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("MENÚ PRINCIPAL");
                System.out.println("1. Cálculo de figuras geométricas");
                System.out.println("2. Calcular potencia");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        calcularFigura(scanner);
                        break;
                    case 2:
                        calcularPotencia(scanner);
                        break;
                    case 3:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();
            }
        }

        mostrarHistorial();
        System.out.println("Programa finalizado.");
    }

    static void mostrarHistorial() {
        System.out.println("\n*** HISTORIAL DE OPERACIONES ***");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + historial[i]);
        }
    }

    static void calcularFigura(Scanner scanner) {
        try {
            System.out.println("\nFiguras disponibles:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.print("Seleccione una figura: ");
            int figura = scanner.nextInt();

            if (figura < 1 || figura > 5) {
                System.out.println("Opción inválida.");
                return;
            }

            System.out.println("\nOperaciones:");
            System.out.println("1. Calcular Área");
            System.out.println("2. Calcular Perímetro");
            System.out.print("Seleccione una operación: ");
            int operacion = scanner.nextInt();

            if (operacion != 1 && operacion != 2) {
                System.out.println("Opción inválida.");
                return;
            }

            String resultado = "";

            switch (figura) {
                case 1:
                    resultado = operacion == 1 ? areaCirculo(scanner) : perimetroCirculo(scanner);
                    break;
                case 2:
                    resultado = operacion == 1 ? areaCuadrado(scanner) : perimetroCuadrado(scanner);
                    break;
                case 3:
                    resultado = operacion == 1 ? areaTriangulo(scanner) : perimetroTriangulo(scanner);
                    break;
                case 4:
                    resultado = operacion == 1 ? areaRectangulo(scanner) : perimetroRectangulo(scanner);
                    break;
                case 5:
                    resultado = operacion == 1 ? areaPentagono(scanner) : perimetroPentagono(scanner);
                    break;
            }

            guardarEnHistorial(resultado);
            System.out.println("Resultado: " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
        }
    }

    static void calcularPotencia(Scanner scanner) {
        try {
            System.out.print("Ingrese la base: ");
            double base = scanner.nextDouble();
            System.out.print("Ingrese el exponente: ");
            int exponente = scanner.nextInt();

            double resultado = potenciaRecursiva(base, exponente);
            String operacion = String.format("%.2f elevado a %d es: %.4f", base, exponente, resultado);
            guardarEnHistorial(operacion);
            System.out.println("Resultado: " + operacion);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
        }
    }

    static double potenciaRecursiva(double base, int exponente) {
        if (exponente == 0) return 1;
        if (exponente < 0) return 1 / potenciaRecursiva(base, -exponente);
        return base * potenciaRecursiva(base, exponente - 1);
    }

    static String areaCirculo(Scanner scanner) {
        System.out.print("Radio: ");
        double radio = scanner.nextDouble();
        double area = Math.PI * radio * radio;
        return String.format("Área de Círculo (radio=%.2f): %.2f", radio, area);
    }

    static String perimetroCirculo(Scanner scanner) {
        System.out.print("Radio: ");
        double radio = scanner.nextDouble();
        double perimetro = 2 * Math.PI * radio;
        return String.format("Perímetro de Círculo (radio=%.2f): %.2f", radio, perimetro);
    }

    static String areaCuadrado(Scanner scanner) {
        System.out.print("Lado: ");
        double lado = scanner.nextDouble();
        double area = lado * lado;
        return String.format("Área de Cuadrado (lado=%.2f): %.2f", lado, area);
    }

    static String perimetroCuadrado(Scanner scanner) {
        System.out.print("Lado: ");
        double lado = scanner.nextDouble();
        double perimetro = 4 * lado;
        return String.format("Perímetro de Cuadrado (lado=%.2f): %.2f", lado, perimetro);
    }

    static String areaTriangulo(Scanner scanner) {
        System.out.print("Base: ");
        double base = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        double area = 0.5 * base * altura;
        return String.format("Área de Triángulo (base=%.2f, altura=%.2f): %.2f", base, altura, area);
    }

    static String perimetroTriangulo(Scanner scanner) {
        System.out.print("Lado 1: ");
        double l1 = scanner.nextDouble();
        System.out.print("Lado 2: ");
        double l2 = scanner.nextDouble();
        System.out.print("Lado 3: ");
        double l3 = scanner.nextDouble();
        double perimetro = l1 + l2 + l3;
        return String.format("Perímetro de Triángulo (lados=%.2f, %.2f, %.2f): %.2f", l1, l2, l3, perimetro);
    }

    static String areaRectangulo(Scanner scanner) {
        System.out.print("Base: ");
        double base = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        double area = base * altura;
        return String.format("Área de Rectángulo (base=%.2f, altura=%.2f): %.2f", base, altura, area);
    }

    static String perimetroRectangulo(Scanner scanner) {
        System.out.print("Base: ");
        double base = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        double perimetro = 2 * (base + altura);
        return String.format("Perímetro de Rectángulo (base=%.2f, altura=%.2f): %.2f", base, altura, perimetro);
    }

    static String areaPentagono(Scanner scanner) {
        System.out.print("Lado: ");
        double lado = scanner.nextDouble();
        double area = (5 * lado * lado) / (4 * Math.tan(Math.PI / 5));
        return String.format("Área de Pentágono (lado=%.2f): %.2f", lado, area);
    }

    static String perimetroPentagono(Scanner scanner) {
        System.out.print("Lado: ");
        double lado = scanner.nextDouble();
        double perimetro = 5 * lado;
        return String.format("Perímetro de Pentágono (lado=%.2f): %.2f", lado, perimetro);
    }

    static void guardarEnHistorial(String operacion) {
        if (contador < MAX_OPERACIONES) {
            historial[contador] = operacion;
            contador++;
        } else {
            System.out.println("Historial lleno.");
        }
    }
}
