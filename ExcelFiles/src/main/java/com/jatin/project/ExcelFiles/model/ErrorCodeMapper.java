package com.jatin.project.ExcelFiles.model;



public class ErrorCodeMapper {

	
	//@PK
	private String id;
	//@user_Key
	private String errorId;
    private String errorCode;
    private String errorMsg;
    private String orgErrorCode;
    private String orgErrorMsg;
    private String apiName;
    private String type;
    
    
    public ErrorCodeMapper() {
    	
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getOrgErrorCode() {
		return orgErrorCode;
	}
	public void setOrgErrorCode(String orgErrorCode) {
		this.orgErrorCode = orgErrorCode;
	}
	public String getOrgErrorMsg() {
		return orgErrorMsg;
	}
	public void setOrgErrorMsg(String orgErrorMsg) {
		this.orgErrorMsg = orgErrorMsg;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
    @Override 
    public String toString(){
		return "(\"" + this.id + "\",\"" + this.errorId + "\",\"" + this.errorCode + "\",\"" + this.errorMsg + "\",\""
				+ this.orgErrorCode + "\",\"" + this.orgErrorMsg + "\",\"" + this.apiName + "\",\"" + this.type
				+ "\")" + ";";
		}
	
}
