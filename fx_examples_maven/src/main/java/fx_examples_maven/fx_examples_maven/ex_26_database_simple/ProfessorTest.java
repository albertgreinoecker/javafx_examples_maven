package fx_examples_maven.fx_examples_maven.ex_26_database_simple;

import java.sql.SQLException;

/**
 * Diese Klasse zeigt an wie Die Datenbankabfrage für die Professoren verwendet werden kann.
 */
public class ProfessorTest {
	public static void main(String[] args) throws SQLException {
		DBManager db = new DBManager();
		try {
			System.out.println(">>>> Ein Professor:");
			Professor p = db.get("2125");
			System.out.println(p);
			

			Professor p2 = new Professor("1234", "Hans Müller", "C1", "101");
			System.out.println(">>>> Professor einfügen:"+ p2);
			db.insert(p2);
			
			System.out.println(">>>> Alle Professoren:");
			for (Professor prof : db.getAll()) {
				System.out.println(prof);
			}
			
			System.out.println(">>>> Professor aendern:");
			p.setRang("C2");
			db.update(p);
			
			System.out.println(">>>> Alle Professoren nach der Änderung:");
			for (Professor prof : db.getAll()) {
				System.out.println(prof);
			}
			
			System.out.println(">>>> Professor löschen:");
			db.delete("1234");
			
			System.out.println(">>>> Alle Professoren nach dem Löschen:");
			for (Professor prof : db.getAll()) {
				System.out.println(prof);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}
}
