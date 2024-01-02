package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;
	
	// Dizendo que o tabuleiro vai ser 8 por 8
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	// Retornar a matriz de peças de xadrez correspodente a essa partida 
	public ChessPiece[] [] getPieces(){
		ChessPiece[] [] mat = new ChessPiece[board.getRows()] [board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
}
