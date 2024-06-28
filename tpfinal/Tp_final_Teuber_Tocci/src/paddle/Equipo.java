package paddle;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
    private String nombre;
    private String ciudad;
    private LinkedList<Jugador> jugadores;
    private String nombreArchivoEscudo;

    
    public Equipo(String nombre, String ciudad, String nombreArchivoEscudo) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.nombreArchivoEscudo = nombreArchivoEscudo;
        this.jugadores = new LinkedList<>();
    }

   
    

    public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCiudad() {
		return ciudad;
	}




	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}




	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}




	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}




	public String getNombreArchivoEscudo() {
		return nombreArchivoEscudo;
	}




	public void setNombreArchivoEscudo(String nombreArchivoEscudo) {
		this.nombreArchivoEscudo = nombreArchivoEscudo;
	}




	public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < 2) {
            jugadores.add(jugador);
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más de 2 jugadores a un equipo de pádel.");
        }
    }

    public Jugador buscarJugadorPorNombre(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nEquipo{" + "nombre='" + nombre + '\'' + ", ciudad='" + ciudad + '\'' + ", jugadores=" + jugadores + '}';
    }
}