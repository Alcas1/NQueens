
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    boolean[][] board;
    public Board(int size)
    {
        board=new boolean[size][size];    
    }

    public boolean canPlace(int row,int column)
    {
        if(checkRows(row,column)&&checkColumns(row,column)&&checkDiagonals(row,column))
        {
            return true;
        }
        return false;
    }

    public boolean checkColumns(int row,int column)
    {
        for(int i=column;i>-1;i--)
        {
            if(board[row][i])
            {
                return false;
            }
        }
        for(int i=column;i<board.length;i++)
        {
            if(board[row][i])
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkRows(int row,int column)
    {
        for(int i=row;i>-1;i--)
        {
            if(board[i][column])
            {
                return false;
            }
        }
        for(int i=row;i<board.length;i++)
        {
            if(board[i][column])
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals(int row,int column)
    {
        int checkRow=row;
        int checkColumn=column;
        while(checkRow>-1&&checkColumn<board.length)
        {
            if(board[checkRow][checkColumn])
            {
                return false;
            }
            else
            {
                checkRow--;
                checkColumn++;
            }
        }
        checkRow=row;
        checkColumn=column;
        while(checkRow<board.length&&checkColumn>-1)
        {
            if(board[checkRow][checkColumn])
            {
                return false;
            }
            else
            {
                checkRow++;
                checkColumn--;
            }
        }
        checkRow=row;
        checkColumn=column;
        while(checkRow>-1&&checkColumn>-1)
        {
            if(board[checkRow][checkColumn])
            {
                return false;
            }
            else
            {
                checkRow--;
                checkColumn--;
            }
        }
        checkRow=row;
        checkColumn=column;
        while(checkRow<board.length&&checkColumn<board.length)
        {
            if(board[checkRow][checkColumn])
            {
                return false;
            }
            else
            {
                checkRow++;
                checkColumn++;
            }
        }
        return true;
    }

    public void putQueen(int row,int column)
    {
        board[row][column]=true;
    }

    public void removeQueen(int row,int column)
    {
        board[row][column]=false;
    }

    public boolean hasQueen(int row,int column)
    {
        if(board[row][column])
        {
            return true;
        }
        return false;
    }
    
    
    public void removeAllQueens()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                board[i][j]=false;
            }
        }
    }
    
    
    public int boardSize()
    { 
        return board.length;
    }

    public void print()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j])
                {
                    System.out.print("Q ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
