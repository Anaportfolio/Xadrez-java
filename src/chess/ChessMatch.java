package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	// Dizendo que o tabuleiro vai ser 8 por 8
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
	// Iniciando a partida
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE),new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK),new Position(0, 4));
	}
}
