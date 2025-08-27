package main;

import main.core.Server;


import java.util.Arrays;

import main.core.LoadBalancer;
import main.core.Request;
import main.core.Response;
//import main.strategy.LeastConnectionsStrategy;
//import main.strategy.RoundRobinStrategy;
import main.strategy.Weightedstrategy;

public class App {
    public static void main(String args[]) {
        Server sA = new Server("A", 110, 1, 300); // Server(id, capacity, weight, latency)
        Server sB = new Server("B", 100, 2, 200);
        Server sC = new Server("C", 100, 3, 300);

       

        LoadBalancer ib = new LoadBalancer(Arrays.asList(sA,sB,sC), new Weightedstrategy());

        for (int i = 1; i <= 100; i++) {
            final int requestId = i;
            new Thread(()->{
            Request req = new Request(requestId); // client creates request
            Response res = ib.handleRequest(req); // server process
            System.out.println(res.getMessage());
            }).start();
        }
    }
}
