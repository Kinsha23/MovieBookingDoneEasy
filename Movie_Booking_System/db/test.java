package com.kinsha.db;

public class test {
public static void main(String[] args) {
	//parent p = new parent();
	//parent p1 = new parent();	
	//child c = new child();
	 //narrowing - explicitly
	//parent p2 = c; //widening - implicitly
	parent p1 = new child();
	parent p2 = new child2();
	child c = (child)p2;
	c.v1();
	
}
}

// parent ref can hold child object, but vice versa is not possible
//super() is used to call parent constructor
//method of object is called(if method is non-static)
//method of ref is called(if method is static)