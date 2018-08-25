import javax.sound.sampled.Line;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Client {

    Socket sClient;
    DataInputStream dIn;
    DataOutputStream dOut;
     public Client(){
         try{
             sClient = new Socket("localHost", 1234);
             dIn = new DataInputStream(sClient.getInputStream());
             dOut = new DataOutputStream(sClient.getOutputStream());

             listerForInput();
         } catch (UnknownHostException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }

    public void listerForInput() throws IOException {
         Scanner console = new Scanner(System.in);

         while(true) {
             while (!console.hasNextLine()) {
                 try {
                     sleep(1);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             String input = console.nextLine();

             if (input.toLowerCase().equals("quit")) {
                 break;
             }
             try {
                 dOut.writeUTF(input);
                 dOut.flush();
                 while(dIn.available() == 0){
                     try{
                         Thread.sleep(1);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 String reply = dIn.readUTF();
                 System.out.println(reply);
             }catch (IOException e){
                 e.printStackTrace();
                 break;
             }
         }
         try{
             dIn.close();
             dOut.close();
             sClient.close();
         }catch (IOException e){
             e.printStackTrace();
         }
    }
}