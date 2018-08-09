/**
 *
 * @author Dia LOGHMARI & Wael LATIRI
 * github.com/dialoghmari
 */
package loadbalancer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loadbalancer {

    private Socket clientSocket = null;
    ServerSocket listenSocket = null;

    public Loadbalancer() {
        RoundRobin RR = new RoundRobin(6001, 6004);

        try {
            listenSocket = new ServerSocket(6000);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println("LB : J'ai recu un client.");
                new Thread(new Tache(clientSocket, RR.next())).start();
            }
        } catch (Exception e) {
        } finally {
            try {
                listenSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(Loadbalancer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        Loadbalancer LB = new Loadbalancer();
    }

}
