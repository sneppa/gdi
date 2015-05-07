package uebung08;



public class Position {

	private int row;
	private int col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public String toString() {
		return row + ", " + col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
