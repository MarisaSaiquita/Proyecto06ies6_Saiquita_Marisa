package ar.edu.ies.model;

import org.springframework.stereotype.Component;

@Component

public class Calculadora {
 private int numA;
 private int numB;
 public Calculadora() {
	// TODO Auto-generated constructor stub
}
public int getNumA() {
	return numA;
}
public void setNumA(int numA) {
	this.numA = numA;
}
public int getNumB() {
	return numB;
}
public void setNumB(int numB) {
	this.numB = numB;
}
 
}
