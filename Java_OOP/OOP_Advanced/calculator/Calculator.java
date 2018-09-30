package oop.advanced.calculator;

public class Calculator implements CalculatorInterface {
	
	private double answer;
	private double one;
	private double two;
	private String operation;
	
	public Calculator() {
	}
	
	public void setOperandOne(double num) {
		this.one = num;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setOperandTwo(double num) {
		this.two = num;
	}
	public void performOperation() {
		if(operation == "+") {
			this.answer = one + two;
		} else if(operation == "-") {
			this.answer = one - two;
		} else {
			System.out.println("Operand not valid, must be plus or minus.");
		}
	}
	public void getResults() {
		System.out.println(this.answer);
	}
}
