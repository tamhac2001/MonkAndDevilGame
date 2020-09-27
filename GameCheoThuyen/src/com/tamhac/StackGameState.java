package com.tamhac;

public class StackGameState {
	private GameState stack[] = new GameState[20];
	private int top = -1;
	
	public void push(GameState currentState) {
		this.stack[++top] = currentState;
	}
	
	public GameState pop() {
		return stack[top--];
	}
	
	public boolean isEmpty() {
		return (top==-1)? true : false;
	}
	
	public boolean isFull() {
		return (top == 19)? true : false;
	}
}
