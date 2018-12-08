package co.wayne.CamelTest;

import org.apache.camel.main.Main;

import co.wayne.CamelTest.route.HelloRoute;


/**
 * Hello Project for Camel Server
 * @author han
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
		Main main = new Main();
		
		// Add Route to the server
		main.addRouteBuilder(new HelloRoute());
		main.run();

    }
}
