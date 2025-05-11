package fx_examples_maven.fx_examples_maven.ex_26_database_simple;

public class Professor {
	String persNr;
	String name;
	String rang;
	String raum;
	
	public Professor(String persNr, String name, String rang, String raum) {
		this.persNr = persNr;
		this.name = name;
		this.rang = rang;
		this.raum = raum;
	}

	public String getPersNr() {
		return persNr;
	}

	public void setPersNr(String persNr) {
		this.persNr = persNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

	@Override
	public String toString() {
		return "Professor [persNr=" + persNr + ", name=" + name + ", rang=" + rang + ", raum=" + raum + "]";
	}
}
