package paddle;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int goles1;
    private int goles2;
    private String fase;

    public Partido(Equipo equipo1, Equipo equipo2, String fase) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.goles1 = (int) (Math.random() * 3);
        this.goles2 = (int) (Math.random() * 3);
        this.fase = fase;
    }

   

    public Equipo getEquipo1() {
		return equipo1;
	}



	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}



	public Equipo getEquipo2() {
		return equipo2;
	}



	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}



	public int getGoles1() {
		return goles1;
	}



	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}



	public int getGoles2() {
		return goles2;
	}



	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}



	public String getFase() {
		return fase;
	}



	public void setFase(String fase) {
		this.fase = fase;
	}



	@Override
    public String toString() {
        return "Partido{" +
                "equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                ", goles1=" + goles1 +
                ", goles2=" + goles2 +
                ", fase='" + fase + '\'' +
                '}';
    }
}
