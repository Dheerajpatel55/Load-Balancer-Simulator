package main.core;

import java.util.List;

//import main.strategy.LeastConnectionsStrategy;
//import main.strategy.RoundRobinStrategy;
import main.strategy.RoutingStrategy;
import main.strategy.Weightedstrategy;

public class LoadBalancer {
    private List<Server> servers;
    private RoutingStrategy strategy;

    public LoadBalancer(List<Server> servers, Weightedstrategy strategy){
        this.servers= servers;
        this.strategy = (RoutingStrategy) strategy;
    }

    public Response handleRequest(Request request){

        Server chosen = strategy.selectServer(servers);
        return chosen.handleRequest(request);
    }
}
