
import java.util.*;
public class FourQueens
{

    public static void main(int size)
    {  
        //if(size>3||size==1)
        //{
            Board chessBoard=new Board(size);
            FourQueens ai=new FourQueens();
            ai.find(chessBoard,0,0,0,0);
        //}
        System.out.println("Not solvable");

    }

    public void find(Board chessBoard,int row,int column,int lastRow,int lastColumn)
    {
        System.out.println('\f');
        chessBoard.print();
        System.out.println(row);
        try
        {
            Thread.sleep(50); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        //System.out.println(row+" "+column+" "+lastRow+" "+lastColumn);
        if(row>=chessBoard.boardSize())
        {
            System.out.println("Solved!");
            System.exit(0);
        }
        if(chessBoard.canPlace(row,column))
        {
            chessBoard.putQueen(row,column);

            find(chessBoard,row+1,0,row,column);
        }
        else
        {
            if(column!=chessBoard.boardSize()-1)
            {
                find(chessBoard,row,column+1,lastRow,lastColumn);
            }
            else
            {
                chessBoard.removeQueen(lastRow,lastColumn);
                int addColumn=0;
                int findRow=lastRow-1;
                if(lastRow-1<0)
                {
                    findRow=0;
                }
                for(int i=0;i<chessBoard.boardSize();i++)
                {

                    if(chessBoard.hasQueen(findRow,i))
                    {
                        addColumn=i;
                    }
                }
                if(lastColumn==chessBoard.boardSize()-1)
                {
                    findRow=lastRow-1;
                    if(lastRow-1<0)
                    {
                        findRow=0;
                    }
                    for(int i=0;i<chessBoard.boardSize();i++)
                    {
                        System.out.println(i);
                        if(chessBoard.hasQueen(findRow,i))
                        {
                            addColumn=i;
                        }
                    }
                    chessBoard.removeQueen(row-2,addColumn);
                    find(chessBoard,row-2,addColumn+1,row-2,addColumn);
                }
                if(row-1<0)
                {
                    row++;
                }
                find(chessBoard,row-1,lastColumn+1,lastRow-1,addColumn);
            }
        }
    }

}
