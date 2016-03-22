import java.util.List;

import org.assertj.core.util.Lists;

public class Minesweeper {

	private static final String BOMB = "*";
	private String[][] field;
	private String[][] countedMines;

	public Minesweeper(int nbLines, int nbColumns) {
		super();
		field = new String[nbLines][nbColumns];
		countedMines = new String[nbLines][nbColumns];

	}

	public String[][] getCountedMines() {
		for (int line = 0; line < field.length; line++) {
			for (int column = 0; column < field[line].length; column++) {
				this.countedMines[line][column] = getMineOrCountedNeighborsMinesForACell(line, column);
			}
		}

		return this.countedMines;
	}

	private String getMineOrCountedNeighborsMinesForACell(int line, int column) {
		if (BOMB.equals(field[line][column])) {
			return BOMB;
		}
		return getCountedNeighborMines(line, column);
	}

	private String getCountedNeighborMines(int line, int column) {

		List<String> neighborsValues = collectNeigbors(line, column);

		int countedNeighborsMines = 0;
		for (String neighborValue : neighborsValues) {
			if (BOMB.equals(neighborValue)) {
				countedNeighborsMines++;
			}
		}

		return String.valueOf(countedNeighborsMines);
	}

	private List<String> collectNeigbors(int line, int column) {

		List<String> neighbors = Lists.newArrayList();
		neighbors.add(getNeighborValue(line, column - 1));
		neighbors.add(getNeighborValue(line, column + 1));
		neighbors.add(getNeighborValue(line - 1, column));
		neighbors.add(getNeighborValue(line + 1, column));
		neighbors.add(getNeighborValue(line - 1, column + 1));
		neighbors.add(getNeighborValue(line + 1, column - 1));
		neighbors.add(getNeighborValue(line - 1, column - 1));
		neighbors.add(getNeighborValue(line + 1, column + 1));
		return neighbors;
	}

	private String getNeighborValue(int line, int column) {
		boolean neighborOutOfField = line < 0 || column < 0 || line > field.length - 1 || column > field[field.length - 1].length - 1;
		if (neighborOutOfField) {
			return null;
		}
		return field[line][column];
	}

	public static String display(String[][] field) {
		StringBuilder displayField = new StringBuilder();

		for (String[] line : field) {
			for (String element : line) {
				displayField.append(element);
			}
			displayField.append("\n");
		}
		displayField.deleteCharAt(displayField.length() - 1);
		return displayField.toString();

	}

	public void initializeFieldWith(String[][] outputField) {
		for (int line = 0; line < outputField.length; line++) {
			for (int column = 0; column < outputField[line].length; column++) {
				this.field[line][column] = outputField[line][column];
			}
		}
	}

	public Object getFieldValue(int line, int column) {
		return field[line][column];
	}
}
