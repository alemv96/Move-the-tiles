import java.util.Scanner;

public class Iterator {
  private SquareTable table;

  public Iterator(int tableDimension){
    table = new SquareTable(tableDimension);
  }

  public void playTheGame(){

    Scanner scn = new Scanner(System.in);
    int positionToMove;

	    table.showTable(); 
    	System.out.println("Introduzca posicion a mover");
    	positionToMove = scn.nextInt();
    	

    		if (table.verifyNearEmptyBox(positionToMove)){
    			if (table.whereDoIMoveTheTile(positionToMove) == "RIGHT") table.moveTheTile(positionToMove , positionToMove + 1);
    			else if(table.whereDoIMoveTheTile(positionToMove) == "LEFT") table.moveTheTile(positionToMove , positionToMove - 1);
	   			else if(table.whereDoIMoveTheTile(positionToMove) == "DOWN") table.moveTheTile(positionToMove , positionToMove + table.getDimensionTable());
    			else table.moveTheTile(positionToMove , positionToMove - table.getDimensionTable()); 
     		}
    		else System.out.println("No se puede mover esta casilla");
    		//System("cls");
    			
  }
}
