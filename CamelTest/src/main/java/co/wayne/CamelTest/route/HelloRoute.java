package co.wayne.CamelTest.route;

import org.apache.camel.builder.RouteBuilder;

import co.wayne.CamelTest.process.HelloConv;
import co.wayne.CamelTest.process.HelloProcessor;

public class HelloRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
//		this.from("timer:test-hello").to("log:test-log");
		
//		from("stream:in?promptMessage=Enter: ")
//		.process(new HelloProcessor())
//		.to("stream:out");
		
		onException(Exception.class).handled(true)
		.setBody().constant("Error Occured")
		.to("stream:out");
		
		from("stream:in?promptMessage=Enter: ").routeId("HelloRoute")
		.process(new HelloProcessor())
		.bean(HelloConv.class,"addHello(${body})")
		.to("stream:out");

	}

}
