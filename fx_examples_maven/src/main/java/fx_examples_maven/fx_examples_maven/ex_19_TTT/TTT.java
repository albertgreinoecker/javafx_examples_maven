package fx_examples_maven.fx_examples_maven.ex_19_TTT;

/*
 * 0 1 2
 * 3 4 5
 * 6 7 8
 */
public class TTT {

	private char[] sf = new char[9]; // {'0', '1'};
	private char werAmZug = 'X';

	public TTT() {
		init();
	}

	void init() {
		for (int i = 0; i < sf.length; i++) {
			sf[i] = ' ';
		}
	}

	public char getWerAmZug() {
		return werAmZug;
	}

	void ausgabe() {
		System.out.printf("%s|%s|%s%n", sf[0], sf[1], sf[2]);
		System.out.printf("%s|%s|%s%n", sf[3], sf[4], sf[5]);
		System.out.printf("%s|%s|%s%n%n", sf[6], sf[7], sf[8]);
	}

	boolean gewonnen() {
		String erg = "" + sf[0] + sf[1] + sf[2] + "|" + sf[3] + sf[4] + sf[5] + "|" + sf[6] + sf[7] + sf[8] + "|"
				+ sf[6] + sf[3] + sf[0] + "|" + sf[7] + sf[4] + sf[1] + "|" + sf[8] + sf[5] + sf[2] + "|" + sf[6]
				+ sf[4] + sf[2] + "|" + sf[8] + sf[4] + sf[0];
		return erg.contains("OOO") || erg.contains("XXX");

	}

	boolean spielZug(int pos) {
		// ist das Spielfeld besetzt? => return false;
		if (sf[pos] != ' ')
			return false;

		// setze aktuellen Spieler auf pos
		sf[pos] = werAmZug;
		// Spielerwechsel
		return true;
	}

	void spielerWechsel() {
		if (werAmZug == 'X')
			werAmZug = 'O';
		else
			werAmZug = 'X';
	}

	boolean voll() {
		for (int i = 0; i < sf.length; i++) {
			if (sf[i] == ' ')
				return false;
		}
		return true;
	}
}