import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcpEchoMulti {

        public Socket client;
        public BufferedWriter out;
        public BufferedReader in;
        public ServerSocket serveur;
        public int nbClients;

        public ServerTcpEchoMulti(int nbClients) throws IOException {
            this.serveur = new ServerSocket();
            this.nbClients = nbClients;
            serveur.bind(new InetSocketAddress("10.203.9.95",64000));
        }

        public void connexion() throws IOException {


            for (int i = 1; i <= nbClients; i++) {
                this.client = serveur.accept();
                Thread monThread = new Thread(new TaskServerEcho(this.client));
                monThread.start();


            }
            serveur.close();
        }
    }


