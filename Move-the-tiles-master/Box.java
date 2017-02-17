import java.util.Random;
public class Box{
//atributes
    private int Id;
    public int valueBox;
    public Status stateBox;

    public Box(int Id , int size , String key){
			
		this.Id = Id;

          if(key == "selectedBox")  stateBox = new EmptyStatus("SELECTEDEMPTYBOX");
          else stateBox = new  EmptyStatus("EMPTY");

    }
    //necesito un metodo get que me diga cual es el id de la caja que se encuentra vacia.
    public int getValueInTheBox(){return valueBox;}
    public int getIdOFTheBox(){return Id;}
    public String getStatusBox(){return stateBox.getStatusBox();}
    public void setValueOfTheBox(int valueBox){this.valueBox = valueBox;}

    public void setStatusOfTheBox(String status){
      if (status == "EMPTY") this.stateBox = new EmptyStatus(status);
      else this.stateBox = new FullStatus(status);
    }
}
