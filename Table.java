import java.util.Random;

public abstract class Table{
    //atributes
    public Box[] boxes;//cajas de mi tablero.
    protected int quantityBox , dimensionTable , selectedBox; // caja seleccionada aleatoriamente para que sea la que se encontrara vacia.;
    
    public Table(int size){
      Random rnd = new Random();
      //asigno valores a mis atributos.
        dimensionTable = size;
        quantityBox = size*size;
        boxes = new Box[quantityBox];
        selectedBox = rnd.nextInt(quantityBox);

        System.out.println("selectedBox: " + selectedBox);

        //creo mis casillas o mis cajas:
        for (int travelBoxes = 0; travelBoxes < quantityBox ; travelBoxes ++){
          if (selectedBox == travelBoxes) boxes[travelBoxes] = new Box(travelBoxes , quantityBox , "selectedBox");
          else boxes[travelBoxes] = new Box(travelBoxes , quantityBox , "thisIsNotTheSelectedBox");
        }
        /*NOTA: lo que es asignarle los valores a las cajas, se puede considerar colocarlos dentro de la clase iterador*/
        //asigno valores a cada caja
        int verifyBox = 0;
        int compareBoxes = 0;
        int valueBox;
        //...arreglar codigo, ordenar!!!!;
        while(verifyBox < quantityBox){
          valueBox = rnd.nextInt(quantityBox - 1);
            if (verifyBox != selectedBox) {
              if (verifyBox == 0){
                boxes[verifyBox].setStatusOfTheBox("FULL");
                boxes[verifyBox].setValueOfTheBox(valueBox);
              }
              else{
                  if (boxes[verifyBox].getStatusBox() == "EMPTY"){
                    while(compareBoxes < verifyBox){
                      if (compareBoxes == selectedBox) compareBoxes ++;
                      if(boxes[compareBoxes].getValueInTheBox() == valueBox) {
                        valueBox = rnd.nextInt(quantityBox -1);
                        compareBoxes = 0;
                      }
                      else compareBoxes ++;
                    }
                    compareBoxes = 0;
                    boxes[verifyBox].setValueOfTheBox(valueBox);
                    boxes[verifyBox].setStatusOfTheBox("FULL");
                  }
              }
          }
          verifyBox ++;
        }
    }
    //end of constructor.

    //metodo de prueba que me muestra el valor de cada caja
    public void showTable(){
      int travelBoxes = 0;
      int jumpVar = 0;

        while (travelBoxes < quantityBox){

          if (jumpVar == dimensionTable){
            System.out.println("");
            jumpVar = 0;
          }else{
            if (travelBoxes == selectedBox) {
              System.out.print("|   |");
              jumpVar ++;
            }
            else{
              System.out.print("| " + boxes[travelBoxes].getValueInTheBox() + " |");
              jumpVar ++;
            }
          travelBoxes ++;
          }
        }

        System.out.println("");
    }
    //Gets and Sets.
    public int getDimensionTable(){return dimensionTable;}
    public int getQuantityBox(){return quantityBox;}
    public void setSelectedBox(int newSelectedBox){ selectedBox = newSelectedBox;}

    //Metodos.
    public abstract boolean verifyNearEmptyBox(int boxToMove);



  }
