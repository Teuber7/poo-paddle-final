package paddle;

import javax.swing.JOptionPane;

public class Main {
    private static GestorEquipos gestorEquipos = new GestorEquipos();

    public static void main(String[] args) {
        String[] opciones = {"Buscar Jugador", "Buscar Equipo", "Mostrar Equipos", "Jugar Torneo", "Salir"};
        boolean correrAplicacion = true;

       
        String[][] equipos = {
            {"Boca Juniors", "Buenos Aires", "Juan Pérez", "María Gutiérrez","Boca Juniors.png"},
            {"River Plate", "Buenos Aires", "Carlos López", "Ana Martínez","River Plate.png"},
            {"Independiente", "Avellaneda", "Diego Fernández", "Laura Rodríguez","Independiente.png"},
            {"Racing Club", "Avellaneda", "Luis García", "Silvia Pérez","Racing Club.png"},
            {"San Lorenzo", "Buenos Aires", "Pablo Martínez", "Lucía González","San Lorenzo.png"},
            {"Velez Sarsfield", "Buenos Aires", "Javier Sánchez", "Elena López","Velez Sarsfield.png"},
            {"Estudiantes", "La Plata", "Roberto Torres", "Natalia Fernández","Estudiantes.png"},
            {"Gimnasia y Esgrima", "La Plata", "Gabriel Ruiz", "Carmen Sánchez","Gimnasia y Esgrima.png"}
        };

        
        for (String[] equipoInfo : equipos) {
            Equipo equipo = new Equipo(equipoInfo[0], equipoInfo[1], equipoInfo[4]);  
            equipo.agregarJugador(new Jugador(equipoInfo[2], (int) (Math.random() * 45)));
            equipo.agregarJugador(new Jugador(equipoInfo[3], (int) (Math.random() * 45)));
            gestorEquipos.agregarEquipo(equipo);
        }

        while (correrAplicacion) {
            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú Principal", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (eleccion == null) {
                eleccion = "Salir";
            }

            switch (eleccion) {
                case "Buscar Jugador":
                    String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
                    for (Equipo equipo : gestorEquipos.getEquipos()) {
                        Jugador jugador = equipo.buscarJugadorPorNombre(nombreJugador);
                        if (jugador != null) {
                            JOptionPane.showMessageDialog(null, "Jugador encontrado: " + jugador.toString());
                            break;
                        }
                    }
                    break;

                case "Buscar Equipo":
                    String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo:");
                    for (Equipo equipo : gestorEquipos.getEquipos()) {
                        if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                            JOptionPane.showMessageDialog(null, "Equipo encontrado: " + equipo.toString());
                            break;
                        }
                    }
                    break;

                case "Mostrar Equipos":
                    StringBuilder equiposInfo = new StringBuilder("Equipos:\n");
                    for (Equipo equipo : gestorEquipos.getEquipos()) {
                        equiposInfo.append(equipo.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, equiposInfo.toString());
                    break;

                case "Jugar Torneo":
                    gestorEquipos.jugarTorneo();
                    break;

                case "Salir":
                    correrAplicacion = false;
                    break;
            }
        }
    }
}
