package portscanner;

import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> portsClosed = new ArrayList<String>();
		String host = "127.0.0.1";
		
		System.out.println("Starting...");

		for (int port = 1; port <= 65535; port++) {
            try (Socket socket = new Socket()) {
                
                socket.connect(new InetSocketAddress(host, port), 200);

                System.out.println("Port offen: " + port);

            } catch (Exception e) {
                portsClosed.add(String.valueOf(port));
            }
        }//End for
		
		/*
		System.out.println("Closed ports: ");
		
		for(int k = 0; k < portsClosed.size(); k++) {
			System.out.println("[" + portsClosed.get(k) + "] ");
		}//End for
		*/
		
		System.out.println("Done...");
	}

}
