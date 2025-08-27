package main.strategy;

import java.util.List;

import main.core.Server;

public class LeastConnectionsStrategy implements RoutingStrategy{
    @Override
    public Server selectServer(List<Server> servers){
    
        if(servers==null || servers.isEmpty()){
            throw new IllegalArgumentException("No server available!");
        }
        //pick server with minimum  active connections
        Server leastLoaded = servers.get(0);
        for(Server s: servers){
            if(s.getActiveConnections()<leastLoaded.getActiveConnections()){
                leastLoaded=s;
            }
        }
        return leastLoaded;
    }
}
