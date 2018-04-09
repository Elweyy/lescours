import java.io.*;



public class Parser {

  private String filepath;


  public void parse() {
    try(BufferedReader br = new BufferedReader(new FileReader(this.filepath))){
      String line;
      while ((line = br.read.line()) !=null){

        }
      }
      catch(Exception e){
        e.printStrackTrace();
      }
    }
  }
