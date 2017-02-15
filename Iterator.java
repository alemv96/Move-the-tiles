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
    			
    		}
    		else {
    			System.out.println("No se puede mover esta casilla");
    			//System("cls");
    		}    	
  }
}
