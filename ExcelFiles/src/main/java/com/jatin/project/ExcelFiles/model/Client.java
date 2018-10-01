package com.jatin.project.ExcelFiles.model;

public class Client {

	String clientId;
	String date;
	String symbol;
	
	public Client(String clientId, String date, String symbol) {
		this.clientId = clientId;
		this.date = date;
		this.symbol = symbol;
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	
	@Override
    public boolean equals(Object obj) {
		
        if (obj instanceof Client) {
        	Client client = (Client) obj;
            return client.getClientId().equals(this.getClientId());
        } else {
            return false;
        }
    }
	
    @Override
    public int hashCode() {
    	int result = 17;
        result = 31 * result + clientId.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
    	
		return "client id :" + clientId;
    	
    }
	
}
