import java.io.*;
import java.net.Socket;

public class TaskServerEcho implements Runnable {
    private Socket socket;
    private BufferedWriter out ;
    private BufferedReader in ;
    public TaskServerEcho(Socket socket) throws IOException {
        this.socket = socket;
    }
    @Override
    public void run()  {

        String message ;
        System.out.println(socket.getInetAddress());
        try {
            out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            message = in.readLine();
            while (message != null && !message.equals("quit"))
            {
                message = message.toUpperCase();
                out.write(message);
                out.newLine();
                out.flush();
                message = in.readLine();
            }
            in.close();
            out.close();
            socket.close();
            System.out.println("déconnexion de " + socket.getInetAddress());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

