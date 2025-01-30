package fx_examples_maven.fx_examples_maven.ex_06_class_node;

public class AnyUserData {
	int cnt;
	String notes;

	public AnyUserData(int cnt, String notes) {
		this.cnt = cnt;
		this.notes = notes;
	}

	AnyUserData(String notes) {
		this(0, notes);
	}

	public void inc() {
		cnt++;
	}

	public int getCnt() {
		return cnt;
	}

	public String getNotes() {
		return notes;
	}

	@Override
	public String toString() {

		return String.format("%s cnt: %d", notes, cnt);
	}
}
