package main.core;

import java.util.concurrent.atomic.AtomicInteger;
public class Server {
    private String id;
    private int capacity; //max concuurent capacity
    private int weight;
    private int latency;  // for processing delay 

    private AtomicInteger activeConnections = new AtomicInteger(0);

    public Server(String id, int capacity, int weight, int latency){
        this.id = id;
        this.capacity=capacity;
        this.weight= weight;
        this.latency= latency;
    }

    public String getId(){
        return id;
    }

    public int getActiveConnections(){
        return activeConnections.get();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getWeight(){
        return weight;
    }

    public Response handleRequest(Request request){
        activeConnections.incrementAndGet();
        try{
            Thread.sleep(latency);
            return new Response("Server "+ id +" processing request "+ request.getId());
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return new Response("Server "+ id +" interrupted while processing.");
        }finally{
            activeConnections.decrementAndGet();
        }
    }
    
}
