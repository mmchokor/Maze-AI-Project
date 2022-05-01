

public class table {
	protected int[][] a = new int[3][3];
	protected int i;
	protected int j;

	public table() {
	}

	public table(int[][] b) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	public void insertMatrix(int[][] b) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	public void insertTable(table b) {
		if (b != null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
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
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				str += a[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}

	public void findentry(int w) {
		for (int k = 0; k < 3; k++) {
			for (int m = 0; m < 3; m++) {
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
		for (int ii = 0; ii < 3; ii++) {
			for (int jj = 0; jj < 3; jj++) {
				if (a[ii][jj] != t.a[ii][jj]) {
					return false;
				}
			}
		}
		return true;
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
}
