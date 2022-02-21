package com.app.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

class JettyServer {

    private Server server;

    void start() throws Exception {
        QueuedThreadPool threadPool = new QueuedThreadPool(80,10,100);
        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9000);
        server.setConnectors(new Connector[] { connector });
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
        //servletHandler.addServletWithMapping(TestServlet.class, "/index");
        server.start();
    }

    void stop() throws Exception {
        server.stop();
    }
}
