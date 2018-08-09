/**
 *
 * @author Dia LOGHMARI & Wael LATIRI
 * github.com/dialoghmari
 */
package loadbalancer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Tache implements Runnable {

    Socket clientSocket;
    int portServeur;

    public Tache(Socket clientSocket, int port) {
        this.clientSocket = clientSocket;
        this.portServeur = port;
    }

    public void run() {

        System.out.println("Tache a demarré.");

        String theLine = null;
        try {

            /* Buffers du client */
            BufferedReader inClient = null;
            PrintStream outClient = null;
            inClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outClient = new PrintStream(clientSocket.getOutputStream());

            /* Buffers du serveur claster*/
            BufferedReader inServeur = null;
            PrintStream outServeur = null;
            Socket socketServeur = new Socket("127.0.0.1", portServeur);
            outServeur = new PrintStream(socketServeur.getOutputStream());
            inServeur = new BufferedReader(new InputStreamReader(socketServeur.getInputStream()));

            while (true) {
                theLine = inClient.readLine();
                outServeur.println(theLine);
                theLine = inServeur.readLine();
                outClient.println(theLine);
                if (theLine.equals("fin.")) {
                    break;
                }

            }
            clientSocket.close();
            socketServeur.close();

        } catch (IOException ex) {
            Logger.getLogger(Tache.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
