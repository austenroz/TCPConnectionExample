
// A Java program for a Server 

import java.net.*; 
import java.io.*; 
  
public class TrackDisplayServer 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
  
    // constructor with port 
    public TrackDisplayServer(int port) 
    { 
        ///////////////////////////////////////////
    	// START SERVER AND WAIT FOR CONNECTION
    	///////////////////////////////////////////
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            ///////////////////////////////////////////
        	// RECEIVE DATA FROM CLIENT
        	///////////////////////////////////////////
            
            // takes input from the client socket 
            in = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
  
            // reads message from client until "Over" is sent 
            while (!line.equals("Over")) 
            { 
                try
                { 
                    line = in.readUTF(); 
                    System.out.println(line); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            }
            
            ///////////////////////////////////////////
        	// CLOSE CONNECTION
        	///////////////////////////////////////////
            
            System.out.println("Closing connection"); 
  
            // close connection 
            socket.close(); 
            in.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String args[]) 
    { 
    	TrackDisplayServer server = new TrackDisplayServer(5000); 
    } 
} 