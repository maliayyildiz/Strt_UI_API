package utilities;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteReadToTxt {
      public static void writeDataInTxt(String jobId,String deliveryId){
          try {
              FileWriter writer = new FileWriter("MyFile.txt", true);
              BufferedWriter bufferedWriter = new BufferedWriter(writer);

              bufferedWriter.write(jobId);
              bufferedWriter.newLine();
              bufferedWriter.write(deliveryId);

              bufferedWriter.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      public static List<String> readDataFromTxt(){
          List<String> ids = new ArrayList<>();
          try {
              FileReader reader = new FileReader("MyFile.txt");
              BufferedReader bufferedReader = new BufferedReader(reader);

              String line;

              while ((line = bufferedReader.readLine()) != null) {
                  ids.add(line);
              }
              reader.close();

          } catch (IOException e) {
              e.printStackTrace();
          }
          return ids;
      }


}
