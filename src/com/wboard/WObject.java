package com.wboard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WObject implements Serializable {
	
	private static final long serialVersionUID = 6889670905706233887L;

	private static int oidCounter = 0; // current object id
	protected final int oid;			// object id; can't be changed
	
	public WObject() {
		super();
		this.oid = oidCounter++;
	}

	public int getOid() {
		return oid;
	}

	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		// always perform the default de-serialization first
		in.defaultReadObject();

	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		// perform the default serialization for all non-transient, non-static fields
		out.defaultWriteObject();
	}
}
