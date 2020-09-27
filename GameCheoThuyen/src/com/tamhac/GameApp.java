package com.tamhac;

import java.util.Scanner;

public class GameApp {

	GameState currentState;
	/* StackGameState stack; */
	boolean result = false; // true: win ; false: lose

	public GameApp() {
		currentState = new GameState();
		/*
		 * stack = new StackGameState(); stack.push(currentState);
		 */
		System.out.println("Có 3 tu sĩ và 3 con quỷ đang ở bờ sông và cả 6 đều muốn qua bờ bên kia."
				+ "Dưới sông có một chiếc thuyền.\nThuyền không thể tự mình di chuyển được mà phải có người chèo."
				+ "Thuyền chỉ có thể chở tối đa 2 hành khách.");
		System.out.println("Trên mỗi bờ sông, nếu số lượng quỷ nhiều hơn số tu sĩ, thì các tu sĩ sẽ bị ăn thịt");
	}

	public void displayChoice(boolean boatPosition) {
		System.out.println("\nCho cac lua chon sau:");
		if (boatPosition) {
			/*
			 * if(currentState.getTurn()!=0) { System.out.println("0.Di lai nuoc vua roi.");
			 * }
			 */
			System.out.println("1.Thuyen cho di 1 tu si.");
			System.out.println("2.Thuyen cho di 2 tu si.");
			System.out.println("3.Thuyen cho di 1 tu si va 1 quy.");
			System.out.println("4.Thuyen cho di 2 quy.");
			System.out.println("5.Thuyen cho di 1 quy.");
		} else {
			System.out.println("1.Thuyen cho ve 1 tu si.");
			System.out.println("2.Thuyen cho ve 2 tu si.");
			System.out.println("3.Thuyen cho ve 1 tu si va 1 quy.");
			System.out.println("4.Thuyen cho ve 2 quy.");
			System.out.println("5.Thuyen cho ve 1 quy.");
		}
	}

	public static char getUserInput() {
		Scanner sc = new Scanner(System.in);
		String userInput;
		do {
			System.out.print("Nhap vao lua chon:");
			userInput = sc.nextLine();
		} while (userInput.contentEquals(""));
		/*
		 * while (!Character.isDigit(userInput)) {
		 * System.out.println("Khong hop le! Phai nhap vao 1 so!");
		 * System.out.print("Nhap vao lua chon:"); userInput = sc.nextLine().charAt(0);
		 * }
		 */
		// sc.close();
		return userInput.charAt(0);
	}

	public void departBoat(char userInput) {
		switch (userInput) {
		/*
		 * case '0': { moveBack(); } break;
		 */
		case '1': {
			if (currentState.getMonkNum() > 0) {
				currentState.setMonkNum(currentState.getMonkNum() - 1);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getMonkNum() + " tu si");
				departBoat(getUserInput());
			}
		}
			break;
		case '2': {
			if (currentState.getMonkNum() >= 2) {
				currentState.setMonkNum(currentState.getMonkNum() - 2);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getMonkNum() + " tu si");
				departBoat(getUserInput());
			}
		}
			break;
		case '3': {
			if (currentState.getMonkNum() > 0 && currentState.getDevilNum() > 0) {
				currentState.setMonkNum(currentState.getMonkNum() - 1);
				currentState.setDevilNum(currentState.getDevilNum() - 1);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getMonkNum() + " tu si");
				System.out.println("Khong hop le! Hien co " + currentState.getDevilNum() + " quy");
				departBoat(getUserInput());
			}
		}
			break;
		case '4': {
			if (currentState.getDevilNum() >= 2) {
				currentState.setDevilNum(currentState.getDevilNum() - 2);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getDevilNum() + " quy");
				departBoat(getUserInput());
			}
		}
			break;
		case '5': {
			if (currentState.getDevilNum() > 0) {
				currentState.setDevilNum(currentState.getDevilNum() - 1);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getDevilNum() + " quy");
				departBoat(getUserInput());
			}
		}
			break;
		default:
			System.out.println("Khong hop le! Lua chon khong ton tai!");
			departBoat(getUserInput());
		}// end of switch
		//currentState.update();
		// stack.push(currentState);
	}

	public void arriveBoat(char userInput) {
		switch (userInput) {
		/*
		 * case '0': { moveBack(); } break;
		 */
		case '1': {
			if (currentState.getMonkNumOtherSide() > 0) {
				currentState.setMonkNum(currentState.getMonkNum() + 1);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getMonkNumOtherSide() + " tu si");
				arriveBoat(getUserInput());
			}
		}
			break;
		case '2': {
			if (currentState.getMonkNumOtherSide() >= 2) {
				currentState.setMonkNum(currentState.getMonkNum() + 2);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getMonkNumOtherSide() + " tu si");
				arriveBoat(getUserInput());
			}
		}
			break;
		case '3': {
			if (currentState.getMonkNumOtherSide() > 0 && currentState.getDevilNumOtherSide() > 0) {
				currentState.setMonkNum(currentState.getMonkNum() + 1);
				currentState.setDevilNum(currentState.getDevilNum() + 1);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getMonkNumOtherSide() + " tu si");
				System.out.println("Khong hop le! Hien co " + currentState.getDevilNumOtherSide() + " quy");
				arriveBoat(getUserInput());
			}
		}
			break;
		case '4': {
			if (currentState.getDevilNumOtherSide() >= 2) {
				currentState.setDevilNum(currentState.getDevilNum() + 2);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getDevilNumOtherSide() + " quy");
				arriveBoat(getUserInput());
			}
		}
			break;
		case '5': {
			if (currentState.getDevilNumOtherSide() > 0) {
				currentState.setDevilNum(currentState.getDevilNum() + 1);
			} else {
				System.out.println("Khong hop le! Hien co " + currentState.getDevilNumOtherSide() + " quy");
				arriveBoat(getUserInput());
			}
		}
			break;
		default: {
			System.out.println("Khong hop le! Lua chon khong ton tai!");
			arriveBoat(getUserInput());
		}
		}// end of switch
	
		// stack.push(currentState);
	}// end of method

	/*
	 * public void moveBack() { currentState = stack.pop(); }
	 */

	public void processResult() {
		if (currentState.getMonkNumOtherSide() == 3 && currentState.getDevilNumOtherSide() == 3) {
			result = true;
		}
	}

	public void displayResult(boolean result) {
		if (result) {
			System.out.println("Chuc mung ban da chien thang!!!");
		} else {
			System.out.println("Rat tiec ban da thua!!!");
		}
	}

	public boolean playAgain() {
		System.out.println("Choi lai khong? (c/k)");
		char userInput = getUserInput();
		switch(userInput) {
		case 'c':{
			return true;
		}
		case 'k':{
			return false;
		}
		default: playAgain();
		}
		return true;
	}

	public static void main(String[] args) {
		boolean ans = false;
		do {
			GameApp game = new GameApp();
			while (!game.currentState.isEnd()) {
				game.currentState.display();
				game.displayChoice(game.currentState.getBoatPosition());
				if (game.currentState.getBoatPosition()) {
					game.departBoat(game.getUserInput());
					game.currentState.update();
				} else {
					game.arriveBoat(game.getUserInput());
					game.currentState.update();
				}
			}
			game.currentState.display();
			game.processResult();
			game.displayResult(game.result);
			ans=game.playAgain();
		} while (ans);
	}

}
