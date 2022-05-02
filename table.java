

public class table {
	protected int[][] a = new int[6][6];
	protected int i;
	protected int j;
	protected String action = "None";

	public table() {
	}

	public table(int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	public void insertMatrix(int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	public void insertTable(table b) {
		if (b != null) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					this.a[i][j] = b.a[i][j];
				}
			}
		} else {
			this.a = null;
		}
	}

	@Override
	public String toString() {
		String str = "";
		str += "0 action: " + action + "\n";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				str += a[i][j] + "  ";
			}
			str += "\n";
		}
		return str;
	}

	public void findentry(int w) {
		for (int k = 0; k < a.length; k++) {
			for (int m = 0; m < a.length; m++) {
				if (this.a[k][m] == w) {
					i = k;
					j = m;
				}
			}
		}
	}

	public boolean isequal(table t) {
		if (t == null)
			return false;
		for (int ii = 0; ii < a.length; ii++) {
			for (int jj = 0; jj < a.length; jj++) {
				if (a[ii][jj] != t.a[ii][jj]) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isEqual(table t) {
		if (t == null)
			return false;
			
		t.findentry(0);
		if (i == t.i && j == t.j) {
			return true;
		}
		return false;
	}

	public int[][] getA() {
		return a;
	}

	public void setA(int[][] a) {
		this.a = a;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	// getters and setters for action
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
