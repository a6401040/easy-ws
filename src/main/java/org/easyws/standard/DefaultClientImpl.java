package org.easyws.standard; 
 
public class DefaultClientImpl implements DefaultClient { 
    @Override 
    public String sendRequest(String request) { 
        return "Sent: " + request; 
    } 
} 
