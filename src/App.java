import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        ResourceConfig config = new PackagesResourceConfig("controller");
        HttpServer server = HttpServerFactory.create("http://172.20.10.3:80/", config);
        server.start();
    }


}
