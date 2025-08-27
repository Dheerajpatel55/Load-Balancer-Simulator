package main.strategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import main.core.Server;
public class RoundRobinStrategy implements RoutingStrategy {

    private AtomicInteger index = new AtomicInteger(0);
    @Override
    public Server selectServer(List<Server> servers){
        int i = Math.abs(index.getAndIncrement() % servers.size());
        return servers.get(i);
    }


    
}
