package com.tamhac;

public class GameState {
	private int turn = 1;
	private final int MAX_MONK = 3;
	private final int MAX_DEVIL = 3;
	private int monkNum = MAX_MONK;
	private int devilNum = MAX_DEVIL;
	private int monkNumOtherSide = 0;
	private int devilNumOtherSide = 0;
	private boolean boatPosition = true; // true: Bo A ; false: Bo B
	private boolean end = false;
	
	public int getTurn() {
		return turn;
	}


	public int getMonkNum() {
		return monkNum;
	}

	public void setMonkNum(int monkNum) {
		this.monkNum = monkNum;
	}

	public int getDevilNum() {
		return devilNum;
	}

	public void setDevilNum(int devilNum) {
		this.devilNum = devilNum;
	}

	public int getMonkNumOtherSide() {
		return monkNumOtherSide;
	}

	public void setMonkNumOtherSide(int monkNumOtherSide) {
		this.monkNumOtherSide = monkNumOtherSide;
	}

	public int getDevilNumOtherSide() {
		return devilNumOtherSide;
	}

	public void setDevilNumOtherSide(int devilNumOtherSide) {
		this.devilNumOtherSide = devilNumOtherSide;
	}

	public boolean getBoatPosition() {
		return boatPosition;
	}

	public boolean isEnd() {
		return end;
	}

	public void update() {
		this.monkNumOtherSide = this.MAX_MONK - this.monkNum;
		this.devilNumOtherSide = this.MAX_DEVIL - this.devilNum;
		this.boatPosition = !this.boatPosition;
		//this.turn++;
		if ( (this.monkNum > 0 && this.monkNum < this.devilNum) 
				|| (this.monkNumOtherSide > 0 && this.monkNumOtherSide < this.devilNumOtherSide)
				|| (this.monkNumOtherSide == 3 && this.devilNumOtherSide == 3)) {
			this.end = true;
		}
		
	}

	public void display() {
		System.out.println();
		System.out.println("Bo A co " + this.monkNum + " tu si va " + this.devilNum + " quy");
		System.out.println(
				"Bo B co " + (this.getMonkNumOtherSide()) + " tu si va " + (this.getDevilNumOtherSide()) + " quy");
		System.out.println("Thuyen o " + (this.boatPosition ? "bo A" : "bo B"));
	}

}
