package net.slipp.common.domain;

public class Result {
	private boolean valid;
	
	private String errorMessage;
	
	private Result() {}
	
	private Result(boolean valid) {
		this(true, null);
	}
	
	private Result(boolean valid, String errorMessage) {
		this.valid = valid;
		this.errorMessage = errorMessage;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public static Result ok() {
		return new Result(true);
	}
	
	public static Result fail(String errorMessgae) {
		return new Result(false, errorMessgae);
	}
}
