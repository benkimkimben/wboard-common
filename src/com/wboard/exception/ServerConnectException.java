package com.wboard.exception;

import java.net.ConnectException;

public class ServerConnectException extends ConnectException {
	public ServerConnectException (String msg){
		super(msg);
	}
}
