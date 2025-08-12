package org.easyws.standard; 
 
public class DefaultServiceImpl implements DefaultService { 
    @Override 
    public String processRequest(String request) { 
        return "Processed: " + request; 
    } 
} 
