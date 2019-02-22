
// LINK TO TCP SOCKET TUTORIAL
// https://www.geeksforgeeks.org/socket-programming-in-java/

/*
 * In order to run both applications at once, both the class files can be run
 * from the command line.
 */

// A Java program for a Client 
import java.net.*; 
import java.io.*; 
 
public class TrackSimulatorClient 
{ 
    // initialize socket and input output streams 
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null; 
  

    /**
     * Constructor that takes in an ip address and a port number
     * 
     * @param address
     * @param port
     */
	public TrackSimulatorClient(String address, int port) 
    { 
		
		///////////////////////////////////////////////
		// CONNECT TO DISPLAY CLIENT
		///////////////////////////////////////////////
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            //input  = new DataInputStream(System.in);
            input = new BufferedReader(new InputStreamReader(System.in));
  
            // sends output to the socket 
            out = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        /////////////////////////////////////////////////
        // OUTPUT DATA TO DISPLAY CLIENT
        /////////////////////////////////////////////////
        
        // String to store message from input 
        String line = ""; 
  
        // Keep reading until "Over" is input 
        while (!line.equals("Over")) 
        { 
        	
            try
            { 
            	// Get the next line of user input
                line = input.readLine(); 
                
                // Write that line out to the output stream (The socket)
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            }

        } 
  
        /////////////////////////////////////////////////
        // CLOSE CONNECTION
        /////////////////////////////////////////////////
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
	/**
	 * Main Method
	 * @param args
	 */
    public static void main(String args[]) 
    { 
    	TrackSimulatorClient client = new TrackSimulatorClient("127.0.0.1", 5000); 
    } 
    
} 