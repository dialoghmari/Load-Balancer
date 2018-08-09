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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Serveur {

    private Socket clientSocket;
    ServerSocket listenSocket = null;

    public Serveur(int port) {
        try {
            listenSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        }
        execution();

    }

    void execution() {
        while (true) {
            Socket clientSocket = null;
            BufferedReader in = null;
            PrintStream out = null;
            String theLine = null;

            while (clientSocket == null) {
                try {
                    clientSocket = listenSocket.accept();
                } catch (IOException ex) {
                    Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException ex) {
                Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                out = new PrintStream(clientSocket.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (true) {
                try {
                    theLine = in.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("J'ai récu : " + theLine + " de " + clientSocket.getPort());
                if (theLine.equals("fin.")) {
                    break;
                }
                out.println(theLine + " = " + Probleme.calculateEq(theLine) + "   " + clientSocket.getPort());

            }
            try {
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Serveur lancé sur le port : "+args[0]);
        new Serveur(Integer.parseInt(args[0]));
    }

}
