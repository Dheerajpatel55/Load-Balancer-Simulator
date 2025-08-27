package main.strategy;

import java.util.List;
import main.core.Server;

public class Weightedstrategy implements RoutingStrategy {
    private int currIndex = -1;
    private int currWeight = 0;

    private int gcdWeight(List<Server> servers) {
        int gcd = servers.get(0).getWeight();
        for (int i = 1; i < servers.size(); i++) {
            gcd = gcd(gcd, servers.get(i).getWeight());
        }
        return gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int maxWeight(List<Server> servers) {
        int max = 0;
        for (Server s : servers) {
            if (s.getWeight() > max) max = s.getWeight();
        }
        return max;
    }

    @Override
    public Server selectServer(List<Server> servers) {
        if (servers == null || servers.isEmpty()) {
            throw new IllegalArgumentException("No server available!");
        }

        int serverCount = servers.size();
        while (true) {
            currIndex = (currIndex + 1) % serverCount;
            if (currIndex == 0) {
                currWeight -= gcdWeight(servers);
                if (currWeight <= 0) {
                    currWeight = maxWeight(servers);
                    if (currWeight == 0)
                        return null;
                }
            }
            if (servers.get(currIndex).getWeight() >= currWeight) {
                return servers.get(currIndex);
            }
        }
    }
}
