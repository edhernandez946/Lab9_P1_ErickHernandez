package lab9_p1_erickhernandez;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;

public class Lab9_P1_ErickHernandez {

    public static Random random = new Random();

    public static void main(String[] args) {

        ArrayList<String> instrucciones = new ArrayList<>();

        String instruccion;

        int width;
        int height;

        int xGusanito;
        int yGusanito;

        int xManzana;
        int yManzana;

        int coordenadaMenor;
        int coordenadaMayor;
        int numeroObstaculos;

        int coordenadaObstaculoX;
        int coordenadaObstaculoY;

        int opcionEjecutar;

        width = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ancho del tablero"));
        while (width < 4 || width > 10) {
            JOptionPane.showMessageDialog(null, "Ancho invalido");
            width = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ancho del tablero"));
        }

        height = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la altura del tablero"));
        while (height < 4 || height > 10) {
            JOptionPane.showMessageDialog(null, "Altura invalida");
            height = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la altura del tablero"));
        }

        char[][] tablero = new char[height][width];

        xGusanito = random.nextInt(0, width);
        yGusanito = random.nextInt(0, height);

        tablero[yGusanito][xGusanito] = 'S';

        xManzana = random.nextInt(0, width);
        yManzana = random.nextInt(0, height);

        tablero[yManzana][xManzana] = 'O';

        if (width <= height) {
            coordenadaMenor = width;
            coordenadaMayor = height;
        } else {
            coordenadaMenor = height;
            coordenadaMayor = width;
        }

        numeroObstaculos = random.nextInt(coordenadaMenor, coordenadaMayor + 1);

        for (int i = 0; i <= numeroObstaculos; i++) {

            coordenadaObstaculoX = random.nextInt(0, width);
            while (coordenadaObstaculoX == xGusanito || coordenadaObstaculoX == xManzana) {
                coordenadaObstaculoX = random.nextInt(0, width);
            }

            coordenadaObstaculoY = random.nextInt(0, height);
            while (coordenadaObstaculoY == yGusanito || coordenadaObstaculoY == yManzana) {
                coordenadaObstaculoY = random.nextInt(0, height);
            }

            tablero[coordenadaObstaculoY][coordenadaObstaculoX] = '#';

        }

        JOptionPane.showMessageDialog(null, matriztoString(tablero));

        opcionEjecutar = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Ingresar Instruccion, 2. Ejecutar Instruccion"));

        while (opcionEjecutar == 1) {
            instruccion = JOptionPane.showInputDialog(null, "Ingrese la instruccion de forma magnitud");
            instrucciones.add(instruccion);
            opcionEjecutar = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Ingresar Instruccion, 2. Ejecutar Instruccion"));
        }

        instrucciones(instrucciones, tablero, yGusanito, xGusanito);

    }

    public static void instrucciones(ArrayList<String> instrucciones, char[][] tablero, int yGusanito, int xGusanito) {

        int numeroPuestos;
        String direccion;

        for (int i = 0; i < instrucciones.size(); i++) {
            numeroPuestos = Integer.parseInt(String.valueOf(instrucciones.get(i).charAt(0)));
            direccion = instrucciones.get(i).substring(1, 3);

            tablero[yGusanito][xGusanito] = ' ';

            if (direccion.equals("UP")) {
                yGusanito = yGusanito - numeroPuestos;
            } else if (direccion.equals("DN")) {
                yGusanito = yGusanito + numeroPuestos;
            } else if (direccion.equals("LT")) {
                xGusanito = xGusanito - numeroPuestos;
            } else if (direccion.equals("RT")) {
                xGusanito = xGusanito + numeroPuestos;
            }

            tablero[yGusanito][xGusanito] = 'S';

            
            JOptionPane.showMessageDialog(null, matriztoString(tablero));

        }
    }

    public static void imprimir(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == 'O' || matriz[i][j] == '#' || matriz[i][j] == 'S') {
                    System.out.print("[" + matriz[i][j] + "]");
                } else {
                    System.out.print("[ ]");
                }

            }
            System.out.println("");
        }

    }

    public static String matriztoString(char[][] matriz) {

        String mensaje = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                mensaje += "[" + matriz[i][j] + "]" + " " + "\t";
            }
            mensaje += "\n";
        }

        return mensaje;

    }

}
