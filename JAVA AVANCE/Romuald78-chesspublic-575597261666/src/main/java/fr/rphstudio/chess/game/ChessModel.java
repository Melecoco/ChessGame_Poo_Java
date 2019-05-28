/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jisseaudamien
 */
public class ChessModel implements IChess{
    
    private ChessBoard board;
    
    private ChessModel(){
        
    }
    
    public static ChessModel instance = null;
    
    public static ChessModel getInstance(){
        if(instance == null){
            instance = new ChessModel();
        }
        return instance;
    }

    @Override
    public void reinit() {
        // initialisation du plateau de jeu
        this.board = new ChessBoard();
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        // obtenir le type de pièce à une position donnée
        Piece piece = this.board.getPiece(p);
        if(piece != null){
            return piece.getType();
        }
        else{
            throw new EmptyCellException();
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        // obtenir la couleur de la pièce à une position donnée
        Piece piece = this.board.getPiece(p);
        if(piece != null){
            return piece.getColor();
        }
        else{
            throw new EmptyCellException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return 0;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        return new ArrayList<>();
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<>();    
    }

    @Override
    public boolean undoLastMove() {
        return true;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 26;
    }
    
}
