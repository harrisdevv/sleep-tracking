package com.app.server;

public class JettyRun {
    public static void main(String[] args) {
        JettyServer js = new JettyServer();
        try {
            js.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
