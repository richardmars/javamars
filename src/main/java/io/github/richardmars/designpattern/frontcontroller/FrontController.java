package io.github.richardmars.designpattern.frontcontroller;

public class FrontController {
	private Dispatcher dispatcher;
	
	public FrontController() {
		dispatcher = new Dispatcher();
	}
	
	/**
	 * 内部逻辑被简化了
	 * @return
	 */
	public boolean isAuthenticUser() {
		System.out.println("User is authenticated successfully.");
		return true;
	}
	
	private void traceRequest(String request) {
		System.out.println("Page requested: " + request);
	}
	
	public void dispatchRequest(String request) {
		traceRequest(request);
		
		if (isAuthenticUser()) {
			dispatcher.dispatch(request);
		}
	}
}
