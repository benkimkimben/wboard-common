package com.wboard.rmi;
/**
 * RMI uses the Java object serialization mechanism to transport objects by value between Java virtual machines. 
 * For an object to be considered serializable, its class must implement the java.io.Serializable marker interface. 
 * 
 * Therefore, *** classes that implement the Task interface must also implement Serializable,*** 
 * as must the classes of objects used for task results.
 * 
 * This interface enables clients of the compute engine to define new kinds of tasks to be run on the server machine 
 * without needing the code to be explicitly installed on that machine. (useful for distributed computing)
 * Simply implement this interface from the client side and pass it as parameter to the executeTask method
 * 
 * http://download.oracle.com/javase/tutorial/rmi/designing.html
 * 
 * @author SKCCADMIN
 *
 * @param <T>
 */
public interface Task<T> {
	 T execute();
}
