package com.sanchi.tutorial.algorithms;

import java.util.Arrays;

/**
 * Queue with array as data structure.
 * 
 * @author Sanchi
 *
 * @param <E>
 */
public class Queue<E> {
 
	E[] arr;
	int head = -1;
	int tail = -1;
	int size;
 
	public Queue(Class<E> c, int size) {
		E[] newInstance = (E[]) new Object[size];
		this.arr = newInstance;
		this.size = 0;
	}
 
	public boolean push(E e) {
		if (size == arr.length)
			return false;
 
		head = (head + 1) % arr.length;
		arr[head] = e;
		size++;
 
		if(tail == -1){
			tail = head;
		}
 
		return true;
	}
 
	public boolean pop() {
		if (size == 0) {
			return false;
		}
 
		E result = arr[tail];
		arr[tail] = null;
		size--;
		tail = (tail+1)%arr.length;
 
		if (size == 0) {
			head = -1;
			tail = -1;
		}
 
		return true;
	}
 
	public E peek(){
		if(size==0)
			return null;
 
		return arr[tail];
	}
 
	public int size() {
		return this.size;
	}
 
	public String toString() {
		return Arrays.toString(this.arr);
	}
}
