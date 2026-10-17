package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

public class DataProviderBoards {

    @DataProvider
    public Board[] boardDataProvider() {
        Board board1 = Board.builder().boardTitle("Avrora1").build();
        Board board2 = Board.builder().boardTitle("Avrora2").build();
        Board board3 = Board.builder().boardTitle("Avrora3").build();
        return new Board[]{board1, board2, board3};
    }
}
