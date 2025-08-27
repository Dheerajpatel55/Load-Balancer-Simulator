package main.strategy;

import java.util.List;

import main.core.Server;

public interface RoutingStrategy {
    Server selectServer(List<Server> servers);
}
