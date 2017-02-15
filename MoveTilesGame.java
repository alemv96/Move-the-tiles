import java.util.Scanner;

public class MoveTilesGame{
    public static void main(String[] args){

      Iterator iterator = new Iterator(3);
      Scanner scn = new Scanner(System.in);
      int answer;

      do {   

        iterator.playTheGame(); 
        
        System.out.println("desea salir del juego ? /pulse 0");
        answer = scn.nextInt();
             

      }while(answer != 0);
    }
}
