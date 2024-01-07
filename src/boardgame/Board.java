package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: é necessário que haja 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];

	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	// Retonar a peça dada linha e coluna
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("A Posição não está no tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("A Posição não está no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	// Colocar uma peça em uma dada posição
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça na posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	// Movendo a peça
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("A Posição não está no tabuleiro");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()] [position.getColumn()] = null;
		return aux;
	}
	
	// Testando se a posição existe
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não no tabuleiro");
		}
		return piece(position) != null;
	}
}
