public class SquareTable extends Table{
//atributes
  public boolean[][] neighbour;//me va a enlazar cada caja de mi tablero para saber si la que se encuentra vacia esta a mis alrededores

  public SquareTable(int size){
      super(size);
      this.neighbour = new boolean[super.quantityBox][super.quantityBox];
      //empiezo a enlazar mis cajas del tablero.
      int travelBoxes = 0; // para las cajas
      int guideBoxes = 0;// solo una guia...

      while (travelBoxes < super.quantityBox){

          if (guideBoxes == size) guideBoxes = 0;
          if (travelBoxes >= size) neighbour[travelBoxes][travelBoxes - size] = true;
          if (travelBoxes < quantityBox - size) neighbour[travelBoxes][travelBoxes + size] = true;
          if (travelBoxes - 1 >= 0){
              if ((guideBoxes < size) && (guideBoxes != 0)) neighbour[travelBoxes][travelBoxes - 1] = true;
              else neighbour[travelBoxes][travelBoxes - 1] = false;
          }
          if (travelBoxes + 1 < quantityBox){
            if (guideBoxes + 1 < size) neighbour[travelBoxes][travelBoxes + 1] = true;
            else neighbour[travelBoxes][travelBoxes + 1] = false;
          }

          travelBoxes ++;
          guideBoxes ++;
      }
      System.out.println("he enlazado todas las cajas");
  }
  //..Metodos.
  public void moveTheTile(int positionBox , int newPositionBox){
    super.setSelectedBox(super.boxes[positionBox].getIdOFTheBox());
    super.boxes[newPositionBox].setValueOfTheBox(super.boxes[positionBox].getValueInTheBox());
    super.boxes[positionBox].setStatusOfTheBox("SELECTEDEMPTYBOX");
    super.boxes[newPositionBox].setStatusOfTheBox("FULL");
  }

  public String whereDoIMoveTheTile(int boxToMove){
    if (boxToMove + 1 == selectedBox) return "RIGHT";
    else if (boxToMove - 1 == selectedBox ) return "LEFT";
    else if (boxToMove + super.dimensionTable == selectedBox) return "DOWN";
    else return "UP";
  }

  /*metodo que indica si ala casilla que se encuentra vacia se encuentra a los alrededores de la casilla que el usuario escogio*/
  public boolean verifyNearEmptyBox(int boxToMove){
    //esta muy cableado, pensar en otra cosa.
    if (((boxToMove + 1 == super.selectedBox) && (neighbour[boxToMove][boxToMove + 1]) || (boxToMove - 1 == super.selectedBox) && (neighbour[boxToMove][boxToMove - 1])
    || (boxToMove - super.dimensionTable == super.selectedBox) && (boxToMove - super.dimensionTable >= 0) || (boxToMove + super.dimensionTable == super.selectedBox)
    && (boxToMove + super.dimensionTable <= super.quantityBox))) return true;
    else return false;
  }
  /*metodo que solo sirve para ver el enlace que se hizo de las cajas*/
  /*public void showLinks(){
      for (int rows = 0 ; rows < quantityBox ; rows ++){
        for (int columns = 0 ; columns < quantityBox ; columns ++){
          System.out.print("| " + neighbour[rows][columns] + " |");
        }
        System.out.println("");
      }
  }*/

}
