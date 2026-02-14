

import java.util.Scanner;

    public class Main{
        // Scanner global
        static Scanner sc = new Scanner(System.in);

        // Atributos
        static String[] estudiantes = new String[10];
        static double[] notas = new double[10];
        static int contador = 0;

        public static void main(String[] args) {
            int opcion;

            do {
                System.out.println("\n===== MENÚ PRINCIPAL =====");
                System.out.println("1. Agregar estudiante");
                System.out.println("2. Mostrar estudiantes");
                System.out.println("3. Promedio de notas");
                System.out.println("4. Nota más alta");
                System.out.println("5. Buscar estudiante");
                System.out.println("6. Contar notas pares");
                System.out.println("7. Salir");
                System.out.print("Seleccione opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1 -> agregar();
                    case 2 -> mostrar();
                    case 3 -> promedio();
                    case 4 -> notaAlta();
                    case 5 -> buscar();
                    case 6 -> System.out.println("Cantidad de notas pares: " + contarParesNotas());
                    case 7 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }

            } while (opcion != 7);
        }

        // Método para agregar estudiante
        static void agregar() {
            if (contador < estudiantes.length) {
                System.out.print("Nombre: ");
                estudiantes[contador] = sc.nextLine();

                System.out.print("Nota (número entero o decimal): ");
                notas[contador] = sc.nextDouble();
                sc.nextLine(); // Limpiar buffer

                contador++;
                System.out.println("Estudiante agregado correctamente.");
            } else {
                System.out.println("Arreglo lleno, no se pueden agregar más estudiantes.");
            }
        }

        // Mostrar todos los estudiantes
        static void mostrar() {
            if (contador == 0) {
                System.out.println("No hay estudiantes registrados.");
                return;
            }

            System.out.println("\n--- LISTA DE ESTUDIANTES ---");
            for (int i = 0; i < contador; i++) {
                System.out.println(estudiantes[i] + " - " + notas[i]);
            }
        }

        // Calcular promedio
        static void promedio() {
            if (contador == 0) {
                System.out.println("No hay datos.");
                return;
            }

            double suma = 0;
            for (int i = 0; i < contador; i++) {
                suma += notas[i];
            }

            System.out.println("Promedio: " + (suma / contador));
        }

        // Nota más alta
        static void notaAlta() {
            if (contador == 0) {
                System.out.println("No hay estudiantes.");
                return;
            }

            double mayor = notas[0];
            for (int i = 1; i < contador; i++) {
                if (notas[i] > mayor) {
                    mayor = notas[i];
                }
            }

            System.out.println("Nota más alta: " + mayor);
        }

        // Buscar estudiante
        static void buscar() {
            if (contador == 0) {
                System.out.println("No hay estudiantes registrados.");
                return;
            }

            System.out.print("Nombre a buscar: ");
            String nombre = sc.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < contador; i++) {
                if (estudiantes[i].equalsIgnoreCase(nombre)) {
                    System.out.println("Encontrado: " + estudiantes[i] + " - " + notas[i]);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No existe el estudiante.");
            }
        }

        // Contar cuántas notas son pares
        static int contarParesNotas() {
            int pares = 0;
            for (int i = 0; i < contador; i++) {
                // Convertir a entero para determinar paridad
                if ((int) notas[i] % 2 == 0) {
                    pares++;
                }
            }
            return pares;
        }
    }

