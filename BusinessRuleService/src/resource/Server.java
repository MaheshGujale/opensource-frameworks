package resource;

import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Server
{
  static Logger logger = Logger.getLogger("server");

  public static void main(String[] args) { 
	URI baseuri = UriBuilder.fromUri("http://127.0.0.1/").port(8095).build(new Object[0]);
    ResourceConfig config = new ResourceConfig(new Class[] {RuleTester.class });
    config.register(new LoggingFeature(logger, LoggingFeature.Verbosity.PAYLOAD_ANY));
    JdkHttpServerFactory.createHttpServer(baseuri, config);
  }
}