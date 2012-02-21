package com.wboard.common.protocol;

import java.net.ConnectException;

public class ServerConnectException extends ConnectException {
	public ServerConnectException (String msg){
		super(msg);
	}
}
