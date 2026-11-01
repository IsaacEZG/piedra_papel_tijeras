import javax.swing.*;
/*
Recrea el Juego de Piedra, Papel y Tijera contra la maquina.
 */
public class Main {
    public static void main(String[] args) {
        int rondas,opcion, opcionIA,contadorUser=0,contadorMaquina=0;

        //Presentacion del user.
        String name = JOptionPane.showInputDialog(null,"Ingresa tu nombre: ");
        while (name == null || name.isBlank() || !name.matches("[\\p{L} ]+")){
            JOptionPane.showMessageDialog(null, "No ingresaste un nombre valido\nVuelve a intentar.");
            name = JOptionPane.showInputDialog(null,"Ingresa tu nombre: ");
        }

        //Definimos cuantas rondas se jugaran.
        JOptionPane.showMessageDialog(null, "Jugemos a piedra, papel y tijera");
        rondas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas rondas quieres jugar?"));

        while(rondas <= 0){
            JOptionPane.showMessageDialog(null,"No es un numero valido");
            rondas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas rondas quieres jugar?"));
        }

        JOptionPane.showMessageDialog(null,"Bien, el primero que gane " + rondas + " rondas, sera el ganador definitivo.");

        while(contadorUser < rondas && contadorMaquina < rondas) {

            //Le mostramos el menu al usuario
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige la opcion con la que jugaras\n1.Tijera\n2.Piedra\n3.Papel"));
            while (opcion >= 4 || opcion <= 0) {
                JOptionPane.showMessageDialog(null, "Opcion invalida.\nElige nuevamente.");
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opcion:"));
            }
            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Elegiste Tijera");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Elegiste Piedra.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Elegiste Papel.");
                    break;
                default:
                    break;
            }

            //Ahora la maquina elige una opcion
            opcionIA = (int) (Math.random() * 3 + 1);
            JOptionPane.showMessageDialog(null,"La maquina ha elegido una opcion");

            //Defenimos los posibles resultados con las 3 opciones
            if (opcion == 1 && opcionIA == 2) {
                JOptionPane.showMessageDialog(null, "Has elegido Tijera y yo elegi Piedra\nYo gano");
                contadorMaquina++;
            } else if (opcion == 1 && opcionIA == 3) {
                JOptionPane.showMessageDialog(null, "Has elegido Tijera y yo elegi Papel\nTu ganas");
                contadorUser++;
            } else if (opcion == 1 && opcionIA == 1) {
                JOptionPane.showMessageDialog(null, "Ambos hemos elegido tijeras\nEmpate");
            }else if (opcion == 2 && opcionIA == 3) {
                JOptionPane.showMessageDialog(null, "Has elegido Piedra y yo elegi Papel\nYo gano");
                contadorMaquina++;
            } else if (opcion == 2 && opcionIA == 1) {
                JOptionPane.showMessageDialog(null, "Has elegido Piedra y yo elegi Tijera\nTu ganas");
                contadorUser++;
            } else if (opcion == 2 && opcionIA == 2) {
                JOptionPane.showMessageDialog(null, "Ambos hemos elegido Piedra\nEmpate");
            } else if (opcion == 3 && opcionIA == 1) {
                JOptionPane.showMessageDialog(null, "Has elegido Papel y yo elegi Tijeras\nYo gano");
                contadorMaquina++;
            } else if (opcion == 3 && opcionIA == 2) {
                JOptionPane.showMessageDialog(null, "Has elegido Papel y yo elegi Piedra\nTu ganas");
                contadorUser++;
            } else if (opcion == 3 && opcionIA == 3) {
                JOptionPane.showMessageDialog(null, "Ambos hemos elegido Papel\nEmpate");
            }
        }

        //Marcador final
        JOptionPane.showMessageDialog(null,"Marcador final\n " + name + " " + contadorUser + "\n Maquina " + contadorMaquina);
        if (contadorUser > contadorMaquina){
            JOptionPane.showMessageDialog(null, name + " es el ganador!\nFin del juego.\nHasta la proxima!");
        }
        else {
            JOptionPane.showMessageDialog(null, "La maquina es la ganadora!\nFin del juego.\nHasta la proxima!");
        }
    }
}