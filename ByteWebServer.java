import java.io.*;
import java.net.*;
import java.util.*;
import com.sun.net.httpserver.*;

/**
 * ByteWebServer - a java based http server
 * @author Shravan Jambukesan
 * https://github.com/ShravanJ/ByteWebServer/
 */

public class ByteWebServer
{
	HttpServer server;
	String response = "";
	int statusCode = 200;
	final int DEFAULT_SOCKET_ADDRESS = 1214;
	final String DEFAULT_RESPONSE = "Hello, world.";
	public ByteWebServer()
	{
		response = DEFAULT_RESPONSE;
		try
		{
			server = HttpServer.create(new InetSocketAddress(DEFAULT_SOCKET_ADDRESS), 0);
			server.createContext("/", new WebHandler());
			server.setExecutor(null);
			server.start();
		}
		catch(IOException e)
		{
			System.out.println("Could not start the server");
		}

	}

	public ByteWebServer(int socketAddress, String responseMessage)
	{
		response = responseMessage;
		try
		{
			server = HttpServer.create(new InetSocketAddress(socketAddress), 0);
			server.createContext("/", new WebHandler());
			server.setExecutor(null);
			server.start();
		}
		catch(IOException e)
		{
			System.out.println("Could not start the server");
		}

	}


	class WebHandler implements HttpHandler
	{
		public void handle(HttpExchange t)
		{
			try
			{
				t.sendResponseHeaders(statusCode, response.length());
				OutputStream out = t.getResponseBody();
				out.write(response.getBytes());
				out.close();
			}
			catch(Exception e)
			{
				System.out.println("An error occured.");
			}
		}
	}

	public void setResponseMessage(String newResponse)
	{
		response = newResponse;
	}

	public void setStatusCode(int newCode)
	{
		statusCode = newCode;
	}

	public void startServer()
	{
		server.start();
	}

	public void stopServer()
	{
		server.stop(10);
	}

	public void stopServer(int delay)
	{
		server.stop(delay);
	}
}