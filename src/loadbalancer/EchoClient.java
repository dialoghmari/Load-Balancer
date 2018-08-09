/**
 *
 * @author Dia LOGHMARI & Wael LATIRI
 * github.com/dialoghmari
 */
package loadbalancer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        Socket theSocket = null;
        BufferedReader theInputStream = null;
        PrintStream theOutputStream = null;
        String mathProb = null;

        try {
            theSocket = new Socket("127.0.0.1", 6000);
            theOutputStream = new PrintStream(theSocket.getOutputStream());
            theInputStream = new BufferedReader(
                    new InputStreamReader(theSocket.getInputStream())
            );

            for (int i = 0; i < 50; i++) {
                mathProb = Probleme.generateEq();
                theOutputStream.println(mathProb);
                System.out.println(theInputStream.readLine());
            }
            theOutputStream.println("fin.");

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (theSocket != null) {
                    theSocket.close();
                }
                if (theInputStream != null) {
                    theInputStream.close();
                }

                if (theOutputStream != null) {
                    theOutputStream.close();
                }

            } catch (IOException e) {
            }
        }
        System.out.println("Ceci est un test...");
        Scanner scan=new Scanner(System.in);
        scan.next();
    }
}
