package co.wayne.CamelTest.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Get input from the source
 * 
 * @author Han
 *
 */
public class HelloProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);

		try {
			double intBody = Double.parseDouble(body);
			intBody = intBody * 100;
			exchange.getIn().setBody(intBody + ". This is a number!!");
		} catch (NumberFormatException e) {
			if (body.equals("")) {
				exchange.getIn().setBody("This is empty value!!");
			} else {
				exchange.getIn().setBody(body + ". This is not a number!!");
			}
		}

	}

}
