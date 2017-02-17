public class EmptyStatus implements Status{
  private String statusBox;

  public EmptyStatus(String statusBox){this.statusBox = statusBox;}
  public String getStatusBox(){return this.statusBox;}
}
