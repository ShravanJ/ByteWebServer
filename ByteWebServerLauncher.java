import java.io.*;
import java.net.*;
import java.util.*;

public class ByteWebServerLauncher
{

	public static void main(String[] args)
	{
		ByteWebServer webServer;
		final int DEFAULT_ADDRESS = 1214;
		Scanner scan = new Scanner(System.in);
		int socketPortNumber = 0;
		String reponseMessage = "";
		System.out.println("Welcome to ByteWebServer");
		System.out.print("Start server with default settings? <YES/NO>?: ");
		String useDefault = scan.nextLine();
		if(useDefault.equalsIgnoreCase("YES"))
		{
			System.out.println("Web server is now running at localhost:" + DEFAULT_ADDRESS);
			webServer = new ByteWebServer();
		}
		if(useDefault.equalsIgnoreCase("NO"))
		{
			System.out.print("Please enter in port number: ");
			socketPortNumber = scan.nextInt();
			System.out.print("Please enter in response message: ");
			reponseMessage = scan.next();
			webServer = new ByteWebServer(socketPortNumber, reponseMessage);
			System.out.println("Web server is now running at localhost:" + socketPortNumber);
			
		}

	}


}