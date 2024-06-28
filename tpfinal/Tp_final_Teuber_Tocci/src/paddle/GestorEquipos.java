package paddle;

import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GestorEquipos {
    private LinkedList<Equipo> equipos;
    private LinkedList<Partido> partidos;
    private static String fotoEquipo;

    public GestorEquipos() {
        this.equipos = new LinkedList<>();
        this.partidos = new LinkedList<>();
    }

   
    
    
    public LinkedList<Partido> getPartidos() {
		return partidos;
	}




	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}




	public static String getFotoEquipo() {
        return fotoEquipo;
    }

    public void setFotoEquipo(String fotoEquipo) {
        this.fotoEquipo = fotoEquipo;
    }

    public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    

    public void jugarTorneo() {
        if (equipos.size() < 8) {
            JOptionPane.showMessageDialog(null, "No hay suficientes equipos para el torneo.");
            return;
        }

       JOptionPane.showMessageDialog(null, "¡FASES ELIMINATORIAS DEL TORNEO DE PADEL","Comienzo",JOptionPane.DEFAULT_OPTION , 
        		new ImageIcon(Main.class.getResource("/escudos/torneopadel.png")));
        
        
        LinkedList<Equipo> cuartos = new LinkedList<>(equipos.subList(0, 8));
        LinkedList<Equipo> semifinales = new LinkedList<>();
        LinkedList<Equipo> finalistas = new LinkedList<>();

        Collections.shuffle(cuartos);
        JOptionPane.showMessageDialog(null, "¡Comienzan los cuartos de final!","Comienzo",JOptionPane.DEFAULT_OPTION , 
        		new ImageIcon(Main.class.getResource("/escudos/copapadel.jpg")));     
        for (int i = 0; i < cuartos.size(); i += 2) {
            Equipo equipo1 = cuartos.get(i);
            Equipo equipo2 = cuartos.get(i + 1);
            JOptionPane.showMessageDialog(null, "Partido de cuartos " +  equipo1.getNombre() + " vs " + equipo2.getNombre(),
                    "Partido", JOptionPane.DEFAULT_OPTION, new ImageIcon(getClass().getResource("/escudos/canchapadel.jpg" )));
            Equipo ganador = jugarPartidoYObtenerGanador(equipo1, equipo2);
            semifinales.add(ganador);
        }

        Collections.shuffle(semifinales);
        JOptionPane.showMessageDialog(null, "¡Comienzan las semifinales!","Comienzo",JOptionPane.DEFAULT_OPTION , 
        		new ImageIcon(Main.class.getResource("/escudos/copapadel.jpg")));  
        for (int i = 0; i < semifinales.size(); i += 2) {
            Equipo equipo1 = semifinales.get(i);
            Equipo equipo2 = semifinales.get(i + 1);
            JOptionPane.showMessageDialog(null, "Partido de semifinales " +  equipo1.getNombre() + " vs " + equipo2.getNombre(),
                    "Partido", JOptionPane.DEFAULT_OPTION, new ImageIcon(getClass().getResource("/escudos/canchapadel.jpg" )));
            Equipo ganador = jugarPartidoYObtenerGanador(equipo1, equipo2);
            finalistas.add(ganador);
        }

        JOptionPane.showMessageDialog(null, "¡Comienza la final!","Comienzo",JOptionPane.DEFAULT_OPTION , 
        		new ImageIcon(Main.class.getResource("/escudos/copapadel.jpg")));  
        Equipo equipo1 = finalistas.get(0);
        Equipo equipo2 = finalistas.get(1);
        JOptionPane.showMessageDialog(null, "Partido de final " +  equipo1.getNombre() + " vs " + equipo2.getNombre(),
                "Partido", JOptionPane.DEFAULT_OPTION, new ImageIcon(getClass().getResource("/escudos/canchapadel.jpg" )));
        JOptionPane.showMessageDialog(null, "Partido de final:" + equipo1.getNombre() + " vs " + equipo2.getNombre());
        Equipo ganador = jugarPartidoYObtenerGanador(equipo1, equipo2);

        
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(ganador.getNombre())) {
                this.fotoEquipo = equipo.getNombreArchivoEscudo();
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "El ganador del torneo es: " + ganador.getNombre(),
                "Ganador del Torneo", JOptionPane.DEFAULT_OPTION, new ImageIcon(getClass().getResource("/escudos/" + GestorEquipos.getFotoEquipo())));
    }

    
    private Equipo jugarPartidoYObtenerGanador(Equipo equipo1, Equipo equipo2) {
        int setsEquipo1 = 0;
        int setsEquipo2 = 0;

        
        
        String resultado = "Partido entre " + equipo1.getNombre() + " y " + equipo2.getNombre() + "\n";

        while (setsEquipo1 < 3 && setsEquipo2 < 3) {
            int juegosEquipo1 = 0;
            int juegosEquipo2 = 0;

            while (juegosEquipo1 < 6 && juegosEquipo2 < 6) {
                int puntoEquipo1 = (int) (Math.random() * 5);
                int puntoEquipo2 = (int) (Math.random() * 5);

                if (puntoEquipo1 > puntoEquipo2) {
                    juegosEquipo1++;
                } else {
                    juegosEquipo2++;
                }
            }

            if (juegosEquipo1 > juegosEquipo2) {
                setsEquipo1++;
            } else {
                setsEquipo2++;
            }

            resultado += "Set: " + equipo1.getNombre() + " " + juegosEquipo1 + " - " + juegosEquipo2 + " " + equipo2.getNombre() + "\n";
        }

        resultado += "Ganador: " + (setsEquipo1 > setsEquipo2 ? equipo1.getNombre() : equipo2.getNombre()) + "\n";
        JOptionPane.showMessageDialog(null, resultado);
        return setsEquipo1 > setsEquipo2 ? equipo1 : equipo2;
    }
}
