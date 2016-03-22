import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MinesweeperTest {

	@Test
	public void initializeWith_should_return_field_initialized_given_a_line_field() {

		Minesweeper minesweeper = new Minesweeper(1, 2);
		minesweeper.initializeFieldWith(new String[][] { { "*", "." } });

		assertThat(minesweeper.getFieldValue(0, 0)).isEqualTo("*");
		assertThat(minesweeper.getFieldValue(0, 1)).isEqualTo(".");
	}

	@Test
	public void initializeWith_should_return_field_initialized_given_a_2_x_2_field() {

		//Given
		Minesweeper minesweeper = new Minesweeper(2, 2);

		//When
		minesweeper.initializeFieldWith(new String[][] { { "*", "." }, { ".", "*" } });

		// Then
		assertThat(minesweeper.getFieldValue(0, 0)).isEqualTo("*");
		assertThat(minesweeper.getFieldValue(0, 1)).isEqualTo(".");

		assertThat(minesweeper.getFieldValue(1, 0)).isEqualTo(".");
		assertThat(minesweeper.getFieldValue(1, 1)).isEqualTo("*");
	}

	@Test
	public void getCountedMines_should_return_star_one_given_a_line_field_with_star_dot() {

		//Given
		Minesweeper minesweeper = new Minesweeper(1, 2);
		minesweeper.initializeFieldWith(new String[][] { { "*", "." } });

		// Test
		String[][] countedMines = minesweeper.getCountedMines();

		// Then
		assertThat(Minesweeper.display(countedMines)).isEqualTo("*1");
	}

	@Test
	public void getCountedMines_should_return_star_two_given_a_line_field_with_star_dot_star() {

		//Given
		Minesweeper minesweeper = new Minesweeper(1, 3);
		minesweeper.initializeFieldWith(new String[][] { { "*", ".", "*" } });

		// Test
		String[][] countedMines = minesweeper.getCountedMines();

		// Then
		assertThat(Minesweeper.display(countedMines)).isEqualTo("*2*");
	}

	@Test
	public void getCountedMines_should_return_ok() {

		//Given
		Minesweeper minesweeper = new Minesweeper(2, 3);
		minesweeper.initializeFieldWith(new String[][] { { "*", ".", "*" }, { "*", ".", "*" } });

		// Test
		String[][] countedMines = minesweeper.getCountedMines();

		// Then
		assertThat(Minesweeper.display(countedMines)).isEqualTo("*4*\n*4*");
	}

	@Test
	public void getCountedMines_should_return_ok_given_initial_output() {

		//Given
		Minesweeper minesweeper = new Minesweeper(4, 4);
		minesweeper.initializeFieldWith(new String[][] { { "*", ".", ".", "." }, { ".", ".", ".", "." }, { ".", "*", ".", "." },
				{ ".", ".", ".", "." } });

		// Test
		String[][] countedMines = minesweeper.getCountedMines();

		// Then
		assertThat(Minesweeper.display(countedMines)).isEqualTo("*100\n2210\n1*10\n1110");

	}
}
