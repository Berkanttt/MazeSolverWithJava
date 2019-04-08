package maze_solver;

import java.util.Random;
import java.util.Scanner;

public class maze_solver {
	Scanner input = new Scanner(System.in);
	Random random = new Random();
	char f, r, l;
	int randomnum, currentplaceX = 0, currentplaceY = 0, previousX = 0, previousY = 0, gecici = 2, IsThisFinalFRf = 0,
			IsThisFinalFRr = 0, IsThisFinalFLf = 0, IsThisFinalFLl = 0, finalX = 0, finalY = 0, difference = 0,
			catalX = 0, catalY = 0,  Xtochange = -1, Ytochange = -1, previouscatalY = 0, previouscatalX = 0, ilkcatalX =-1, ilkcatalY = -1,
			anothergecici = 0, gecici2 = 0;
	boolean varmiyokmi = false; 
	boolean kavsak = true;
	String directionofrob = "North", whichdirect = "";
	int[][] matris = new int[16][16];

	void turnright(int z) {
		if (directionofrob.equals("North")) {
			directionofrob = "East";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX++;
		} else if (directionofrob.equals("East")) {
			directionofrob = "South";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY--;
		} else if (directionofrob.equals("South")) {
			directionofrob = "West";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX--;
		} else {
			directionofrob = "North";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY++;
		}
		if( z == 1) {
			setthenumber();
		}
		else {
			setthenumberturningback();
		}
		System.out.println();
		System.out.println("Turn right\nMove one step\nDirection: " + directionofrob + "\nPlace: " + currentplaceX
				+ ", " + currentplaceY);
		System.out.println("Number: " + matris[15 - currentplaceY][currentplaceX]);
	}

	void turnleft(int y) {
		if (directionofrob.equals("North")) {
			directionofrob = "West";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX--;
		} else if (directionofrob.equals("East")) {
			directionofrob = "North";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY++;
		} else if (directionofrob.equals("South")) {
			directionofrob = "East";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX++;
		} else {
			directionofrob = "South";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY--;
		}
		if ( y == 1) {
			setthenumber();
		}
		else {
			setthenumberturningback();
		}
		System.out.println();
		System.out.println("Turn left\nMove one step\nDirection: " + directionofrob + "\nPlace: " + currentplaceX + ", "
				+ currentplaceY);
		System.out.println("Number: " + matris[15 - currentplaceY][currentplaceX]);
	}


	void gostraight(int x) {
		if (directionofrob.equals("North")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY++;
		} else if (directionofrob.equals("East")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX++;
		} else if (directionofrob.equals("South")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY--;
		} else {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX--;
		}
		if( x == 1 ) {
			setthenumber();
		} else {
			setthenumberturningback();
		}
		System.out.println();
		System.out.println(
				"Move one step\nDirection: " + directionofrob + "\nPlace: " + currentplaceX + ", " + currentplaceY);
		System.out.println("Number: " + matris[15 - currentplaceY][currentplaceX]);
	}

	public void turnback () {
		if (directionofrob.equals("North")) {
			directionofrob = "South";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY--;
		} else if (directionofrob.equals("East")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			directionofrob = "West";
			currentplaceX--;
		} else if (directionofrob.equals("South")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			directionofrob = "North";
			currentplaceY++;
		} else {
			directionofrob = "East";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX++;
		}
		varmiyokmi = false;
		setthenumber();
		System.out.println();
		System.out.println("Turn back\nMove one step\nDirection: " + directionofrob + "\nPlace: " + currentplaceX + ", "
				+ currentplaceY);
		System.out.println("Number: " + matris[15 - currentplaceY][currentplaceX]);
	}

	void turnbackwhenclosed() {
		if (directionofrob.equals("North")) {
			directionofrob = "South";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceY--;
		} else if (directionofrob.equals("East")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			directionofrob = "West";
			currentplaceX--;
		} else if (directionofrob.equals("South")) {
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			directionofrob = "North";
			currentplaceY++;
		} else {
			directionofrob = "East";
			previousX = currentplaceX;
			previousY = 15 - currentplaceY;
			currentplaceX++;
		}
		Xtochange = previousX;
		Ytochange = previousY;
		while (Xtochange != catalX || Ytochange != catalY) {
			gecici2 = matris[Ytochange][Xtochange];
			matris[Ytochange][Xtochange] = 88888;
			if (Ytochange < 15 && Ytochange > 0 && Xtochange < 15 && Xtochange > 0) {
				if (matris[Ytochange + 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange + 1;
				} else if (matris[Ytochange][Xtochange + 1] == gecici2 - 1) {
					Xtochange = Xtochange + 1;
				} else if (matris[Ytochange - 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange - 1;
				} else if (matris[Ytochange][Xtochange - 1] == gecici2 - 1) {
					Xtochange = Xtochange - 1;
				}
			} else if (Ytochange == 15 && Xtochange < 15 && Xtochange > 0) {
				if (matris[Ytochange][Xtochange + 1] == gecici2 - 1) {
					Xtochange = Xtochange + 1;
				} else if (matris[Ytochange - 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange - 1;
				} else if (matris[Ytochange][Xtochange - 1] == gecici2 - 1) {
					Xtochange = Xtochange - 1;
				}
			} else if (Ytochange == 0 && Xtochange < 15 && Xtochange > 0) {
				if (matris[Ytochange + 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange + 1;
				} else if (matris[Ytochange][Xtochange + 1] == gecici2 - 1) {
					Xtochange = Xtochange + 1;
				} else if (matris[Ytochange][Xtochange - 1] == gecici2 - 1) {
					Xtochange = Xtochange - 1;
				}
			} else if (Xtochange == 15 && Ytochange < 15 && Ytochange > 0) {
				if (matris[Ytochange + 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange + 1;
				} else if (matris[Ytochange - 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange - 1;
				} else if (matris[Ytochange][Xtochange - 1] == gecici2 - 1) {
					Xtochange = Xtochange - 1;
				}
			} else if (Xtochange == 0 && Ytochange < 15 && Ytochange > 0) {
				if (matris[Ytochange + 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange + 1;
				} else if (matris[Ytochange][Xtochange + 1] == gecici2 - 1) {
					Xtochange = Xtochange + 1;
				} else if (matris[Ytochange - 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange - 1;
				}
			} else if (Xtochange == 0 && Ytochange == 0) {
				if (matris[Ytochange + 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange + 1;
				} else if (matris[Ytochange][Xtochange + 1] == gecici2 - 1) {
					Xtochange = Xtochange + 1;
				}
			} else if (Xtochange == 15 && Ytochange == 0) {
				if (matris[Ytochange + 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange + 1;
				} else if (matris[Ytochange][Xtochange - 1] == gecici2 - 1) {
					Xtochange = Xtochange - 1;
				}
			} else if (Xtochange == 0 && Ytochange == 15) {
				if (matris[Ytochange - 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange - 1;
				} else if (matris[Ytochange][Xtochange + 1] == gecici2 - 1) {
					Xtochange = Xtochange + 1;
				}
			} else if (Xtochange == 15 && Ytochange == 15) {
				if (matris[Ytochange - 1][Xtochange] == gecici2 - 1) {
					Ytochange = Ytochange - 1;
				} else if (matris[Ytochange][Xtochange - 1] == gecici2 - 1) {
					Xtochange = Xtochange - 1;
				}
			}
		}
		setthenumber();
		System.out.println();
		System.out.println("Turn back\nReset something\nMove one step\nDirection: " + directionofrob + "\nPlace: " + currentplaceX + ", "
				+ currentplaceY);
		System.out.println("Number: " + matris[15 - currentplaceY][currentplaceX]); //
	}

	void setthenumber() {
		if (matris[15 - currentplaceY][currentplaceX] == 88888) {
		} else if (matris[15 - currentplaceY][currentplaceX] == 0) {
			matris[15 - currentplaceY][currentplaceX] = gecici;
			gecici++;
		} else if (matris[15 - currentplaceY][currentplaceX] > matris[previousY][previousX]) {
			matris[15 - currentplaceY][currentplaceX] = matris[previousY][previousX] + 1;
			gecici = matris[15 - currentplaceY][currentplaceX] + 1;
		} else {
			gecici = matris[15 - currentplaceY][currentplaceX] + 1;
		}

	}


	void setthenumberturningback() {
		matris[15 - currentplaceY][currentplaceX] = gecici;
		gecici = matris[15 - currentplaceY][currentplaceX] - 1;
	}

	void writethemaze() {
		System.out.println();
		for (int i = 0; i < matris.length; i++) {
			for (int j = 0; j < matris.length; j++) {
				System.out.print(matris[i][j] + "\t");
			}
			System.out.println();
		}
	}

	int rightsidevalue() {
		if (directionofrob.equals("North")) {
			return matris[15 - currentplaceY][currentplaceX + 1];
		} else if (directionofrob.equals("East")) {
			return matris[16 - currentplaceY][currentplaceX];
		} else if (directionofrob.equals("South")) {
			return matris[15 - currentplaceY][currentplaceX - 1];
		} else {
			return matris[14 - currentplaceY][currentplaceX];
		}
	}

	int leftsidevalue() {
		if (directionofrob.equals("North")) {
			return matris[15 - currentplaceY][currentplaceX - 1];
		} else if (directionofrob.equals("East")) {
			return matris[14 - currentplaceY][currentplaceX];
		} else if (directionofrob.equals("South")) {
			return matris[15 - currentplaceY][currentplaceX + 1];
		} else {
			return matris[16 - currentplaceY][currentplaceX];
		}
	}

	int frontsidevalue() {
		if (directionofrob.equals("North")) {
			return matris[14 - currentplaceY][currentplaceX];
		} else if (directionofrob.equals("East")) {
			return matris[15 - currentplaceY][currentplaceX + 1];
		} else if (directionofrob.equals("South")) {
			return matris[16 - currentplaceY][currentplaceX];
		} else {
			return matris[15 - currentplaceY][currentplaceX - 1];
		}
	}

	public void solutionwillwork() {
		matris[15][0] = 1;
		System.out.println("Write only C for Closed, O for Open");
		while (!(IsThisFinalFRf == 5 || IsThisFinalFRr == 5 || IsThisFinalFLf == 5 || IsThisFinalFLl == 5)) {
			System.out.println();
			System.out.print("Front side: ");
			f = input.next().charAt(0);
			System.out.print("Right side: ");
			r = input.next().charAt(0);
			System.out.print("Left side: ");
			l = input.next().charAt(0);
			if (f == 'C' && l == 'C' && r == 'O') {
				IsThisFinalFRr = 0;
				IsThisFinalFLf = 0;
				
					if (IsThisFinalFRf >= 2) {
						IsThisFinalFRf++;
					}
					if (IsThisFinalFLl >= 2) {
						IsThisFinalFLl++;
					}
					if(rightsidevalue() == 0 || !varmiyokmi) {
						turnright(1);
					}
					else if(varmiyokmi) {
						turnback();
					}
				
			} else if (f == 'C' && l == 'O' && r == 'C') {
				IsThisFinalFRf = 0;
				IsThisFinalFLl = 0;
				
					if (IsThisFinalFRr >= 2) {
						IsThisFinalFRr++;
					}
					if (IsThisFinalFLf >= 2) {
						IsThisFinalFLf++;
					}
					if(leftsidevalue() == 0 || !varmiyokmi ) {
						turnleft(1);
					}
					else if(varmiyokmi) {
						turnback();
					}
			} else if (f == 'O' && l == 'C' && r == 'C') {
				IsThisFinalFRf = 0;
				IsThisFinalFRr = 0;
				IsThisFinalFLf = 0;
				IsThisFinalFLl = 0;
				
					if(frontsidevalue() == 0 || !varmiyokmi) {
						gostraight(1);
					}
					else if(varmiyokmi) {
						turnback();
					}
			} else if (f == 'C' && l == 'C' && r == 'C') {
				IsThisFinalFRf = 0;
				IsThisFinalFRr = 0;
				IsThisFinalFLf = 0;
				IsThisFinalFLl = 0;
				turnbackwhenclosed();
				varmiyokmi = false;
			} else if (f == 'O' && l == 'C' && r == 'O') {
				if(kavsak) {
					ilkcatalX = currentplaceX;
					ilkcatalY = 15 - currentplaceY;
					kavsak = false;
				}
				previouscatalX = catalX;
				previouscatalY = catalY;		
				catalX = currentplaceX;
				catalY = 15 - currentplaceY;
				IsThisFinalFLf = 0;
				IsThisFinalFLl = 0;
				if(frontsidevalue() == 0 || rightsidevalue() == 0) {
					varmiyokmi = true;
					if (rightsidevalue() > frontsidevalue()) {
						IsThisFinalFRf = 2;
						IsThisFinalFRr = 0;
						gostraight(1);
					} else if (rightsidevalue() < frontsidevalue()) {
						IsThisFinalFRf = 0;
						IsThisFinalFRr = 2;
						turnright(1);
					} else if (frontsidevalue() == rightsidevalue()){
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							IsThisFinalFRf = 0;
							IsThisFinalFRr = 2;
							turnright(1);
							break;
						case 1:
							IsThisFinalFRf = 2;
							IsThisFinalFRr = 0;
							gostraight(1);
							break;
						default:
							break;
						}
					}
				}
				else {
					varmiyokmi = false;
					if ((currentplaceX == ilkcatalX) && (ilkcatalY == 15 - currentplaceY)) {
						turnback();
					} else if (rightsidevalue() > frontsidevalue()) {
						IsThisFinalFRf = 2;
						IsThisFinalFRr = 0;
						gostraight(1);
					} else if (rightsidevalue() < frontsidevalue()) {
						IsThisFinalFRf = 0;
						IsThisFinalFRr = 2;
						turnright(1);
					} else if (frontsidevalue() == rightsidevalue()){
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							IsThisFinalFRf = 0;
							IsThisFinalFRr = 2;
							turnright(1);
							break;
						case 1:
							IsThisFinalFRf = 2;
							IsThisFinalFRr = 0;
							gostraight(1);
							break;
						default:
							break;
						}
					}
				}
				if (rightsidevalue() > frontsidevalue()) {
					IsThisFinalFRf = 2;
					IsThisFinalFRr = 0;
					gostraight(1);
				} else if (rightsidevalue() < frontsidevalue()) {
					IsThisFinalFRf = 0;
					IsThisFinalFRr = 2;
					turnright(1);
				} else if (frontsidevalue() == rightsidevalue()){
					randomnum = random.nextInt(2);
					switch (randomnum) {
					case 0:
						IsThisFinalFRf = 0;
						IsThisFinalFRr = 2;
						turnright(1);
						break;
					case 1:
						IsThisFinalFRf = 2;
						IsThisFinalFRr = 0;
						gostraight(1);
						break;
					default:
						break;
					}
				}
			} else if (f == 'C' && l == 'O' && r == 'O') {
				if(kavsak) {
					ilkcatalX = currentplaceX;
					ilkcatalY = 15 - currentplaceY;
					kavsak = false;
				}
				previouscatalX = catalX;
				previouscatalY = catalY;
				catalX = currentplaceX;
				catalY = 15 - currentplaceY;
				IsThisFinalFRf = 0;
				IsThisFinalFRr = 0;
				IsThisFinalFLf = 0;
				IsThisFinalFLl = 0;
				if(rightsidevalue() == 0 || leftsidevalue() == 0) {
					varmiyokmi = true;
					if (rightsidevalue() > leftsidevalue()) {
						turnleft(1);
					} else if (rightsidevalue() < leftsidevalue()) {
						turnright(1);
					} else if (rightsidevalue() == leftsidevalue()) {
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							turnright(1);
							break;
						case 1:
							turnleft(1);
							break;
						default:
							break;
						}
					}
				}
				else {
					varmiyokmi = false;
					if(currentplaceX == ilkcatalX && ilkcatalY == 15 - currentplaceX) {
						turnback();
					}
					else if (rightsidevalue() > leftsidevalue()) {
							turnleft(1);
						
					} else if (rightsidevalue() < leftsidevalue()) {
							turnright(1);
					} else if (rightsidevalue() == leftsidevalue()) {
							randomnum = random.nextInt(2);
							switch (randomnum) {
							case 0:
								turnright(1);
								break;
							case 1:
								turnleft(1);
								break;
							default:
								break;
							}
					}
				}
			
			} else if (f == 'O' && l == 'O' && r == 'C') {
				if(kavsak) {
					ilkcatalX = currentplaceX;
					ilkcatalY = 15 - currentplaceY;
					kavsak = false;
				}
				previouscatalX = catalX;
				previouscatalY = catalY;
				catalX = currentplaceX;
				catalY = 15 - currentplaceY;
				IsThisFinalFRf = 0;
				IsThisFinalFRr = 0;
				if(frontsidevalue() == 0 || leftsidevalue() == 0 ) {
					varmiyokmi = true;
					if (frontsidevalue() > leftsidevalue()) {
						IsThisFinalFLf = 0;
						IsThisFinalFLl = 2;
						turnleft(1);
					} else if (frontsidevalue() < leftsidevalue()) {
						IsThisFinalFLf = 2;
						IsThisFinalFLl = 0;
						gostraight(1);
					} else if(frontsidevalue() == leftsidevalue()){
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							IsThisFinalFLf = 2;
							IsThisFinalFLl = 0;
							gostraight(1);
							break;
						case 1:
							IsThisFinalFLf = 0;
							IsThisFinalFLl = 2;
							turnleft(1);
							break;
						default:
							break;
						}
							
					}
				}
				else {
					varmiyokmi = false;
					if(currentplaceX == ilkcatalX && ilkcatalY == 15 - currentplaceY  ) {
						turnback();
					}
					else if (frontsidevalue() > leftsidevalue()) {
						IsThisFinalFLf = 0;
						IsThisFinalFLl = 2;
						turnleft(1);
					} else if (frontsidevalue() < leftsidevalue()) {
						IsThisFinalFLf = 2;
						IsThisFinalFLl = 0;
						gostraight(1);
					} else if(frontsidevalue() == leftsidevalue()){
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							IsThisFinalFLf = 2;
							IsThisFinalFLl = 0;
							gostraight(1);
							break;
						case 1:
							IsThisFinalFLf = 0;
							IsThisFinalFLl = 2;
							turnleft(1);
							break;
						default:
							break;
						}
							
					}
				}
			
			} else if (f == 'O' && l == 'O' && r == 'O') {
				if(kavsak) {
					ilkcatalX = currentplaceX;
					ilkcatalY = 15 - currentplaceY;
					kavsak = false;
				}
				previouscatalX = catalX;
				previouscatalY = catalY;
				catalX = currentplaceX;
				catalY = 15 - currentplaceY;
				IsThisFinalFRf = 0;
				IsThisFinalFRr = 0;
				IsThisFinalFLf = 0;
				IsThisFinalFLl = 0;
				if(frontsidevalue() == 0 || leftsidevalue() == 0 || rightsidevalue() == 0) {
					varmiyokmi = true;
					if (rightsidevalue() < leftsidevalue() && rightsidevalue() < frontsidevalue()) {
						
						turnright(1);
					
					} else if (leftsidevalue() < rightsidevalue() && leftsidevalue() < frontsidevalue()) {
					
						turnleft(1);
					
					} else if (frontsidevalue() < rightsidevalue() && frontsidevalue() < leftsidevalue()) {
					
					gostraight(1);
					} else if (frontsidevalue() < rightsidevalue() && frontsidevalue() == leftsidevalue()) {
					randomnum = random.nextInt(2);
						switch (randomnum) {
							case 0:
								gostraight(1);
								break;
							case 1:
								turnleft(1);
								break;
							default:
								break;
						}
					} else if (frontsidevalue() == rightsidevalue() && frontsidevalue() < leftsidevalue()) {
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							gostraight(1);
							break;
						case 1:
							turnright(1);
							break;
						default:
							break;
						}
					} else if (leftsidevalue() == rightsidevalue() && frontsidevalue() > leftsidevalue()) {
						randomnum = random.nextInt(2);
						switch (randomnum) {
						case 0:
							turnleft(1);
							break;
						case 1:
							turnright(1);
							break;
						default:
							break;
						}
					} else if (leftsidevalue() == frontsidevalue() && (rightsidevalue() == frontsidevalue())) {
						randomnum = random.nextInt(3);
						switch (randomnum) {
						case 0:
							turnleft(1);
							break;
						case 1:
							turnright(1);
							break;
						case 2:
							gostraight(1);
						default:
							break;
						}
					}
			}
				} else {
					varmiyokmi = false;
				 
			    if(currentplaceX == ilkcatalX && ilkcatalY == 15 - currentplaceY) {
			    	turnback();
			    	
			    }
			    else if (rightsidevalue() < leftsidevalue() && rightsidevalue() < frontsidevalue()) {
					
					turnright(1);
				
			} else if (leftsidevalue() < rightsidevalue() && leftsidevalue() < frontsidevalue()) {
				
					turnleft(1);
				
			} else if (frontsidevalue() < rightsidevalue() && frontsidevalue() < leftsidevalue()) {
				
				gostraight(1);
			} else if (frontsidevalue() < rightsidevalue() && frontsidevalue() == leftsidevalue()) {
				randomnum = random.nextInt(2);
				switch (randomnum) {
				case 0:
					gostraight(1);
					break;
				case 1:
					turnleft(1);
					break;
				default:
					break;
				}
			} else if (frontsidevalue() == rightsidevalue() && frontsidevalue() < leftsidevalue()) {
				randomnum = random.nextInt(2);
				switch (randomnum) {
				case 0:
					gostraight(1);
					break;
				case 1:
					turnright(1);
					break;
				default:
					break;
				}
			} else if (leftsidevalue() == rightsidevalue() && frontsidevalue() > leftsidevalue()) {
				randomnum = random.nextInt(2);
				switch (randomnum) {
				case 0:
					turnleft(1);
					break;
				case 1:
					turnright(1);
					break;
				default:
					break;
				}
			} else if (leftsidevalue() == frontsidevalue() && (rightsidevalue() == frontsidevalue())) {
				randomnum = random.nextInt(3);
				switch (randomnum) {
				case 0:
					turnleft(1);
					break;
				case 1:
					turnright(1);
					break;
				case 2:
					gostraight(1);
				default:
					break;
				}
			}
		}

			writethemaze();
		}
				
		finalX = currentplaceX;
		finalY = 15 - currentplaceY;
		for (int i = 0; i < matris.length; i++) {
			for (int j = 0; j < matris.length; j++) {
				if (matris[i][j] == 0 || matris[i][j] > matris[15 - currentplaceY][currentplaceX]) {
					matris[i][j] = 88888;
				}
			}
		}
		for (int k = matris[15 - currentplaceY][currentplaceX]; k > 1; k--) {
			for (int i = 1; i < matris.length - 1; i++) {
				if (matris[0][i] == k) {
					if (!(i == finalX && 0 == finalY) && matris[0][i + 1] != k + 1 && matris[0][i - 1] != k + 1
							&& matris[1][i] != k + 1) {
						matris[0][i] = 88888;
					}
				}
				if (matris[i][0] == k) {
					if (!(0 == finalX && i == finalY) && matris[i + 1][0] != k + 1 && matris[i - 1][0] != k + 1
							&& matris[i][1] != k + 1) {
						matris[i][0] = 88888;
					}
				}
				if (matris[15][i] == k) {
					if (!(i == finalX && 15 == finalY) && matris[15][i + 1] != k + 1 && matris[15][i - 1] != k + 1
							&& matris[10][i] != k + 1) {
						matris[15][i] = 88888;
					}
				}
				if (matris[i][15] == k) {
					if (!(15 == finalX && i == finalY) && matris[i + 1][15] != k + 1 && matris[i - 1][15] != k + 1
							&& matris[i][10] != k + 1) {
						matris[i][15] = 88888;
					}
				}
				for (int j = 1; j < matris.length - 1; j++) {
					if (matris[i][j] == k) {
						if (!(i == finalY && j == finalX) && matris[i][j + 1] != k + 1 && matris[i + 1][j] != k + 1
								&& matris[i - 1][j] != k + 1 && matris[i][j - 1] != k + 1) {
							matris[i][j] = 88888;
						}
					}
				}
			}
			if (matris[0][15] == k) {
				if (matris[0][10] != k + 1 && matris[1][15] != k + 1) {
					matris[0][15] = 88888;
				}
			}
			if (matris[0][0] == k) {
				if (matris[1][0] != k + 1 && matris[0][1] != k + 1) {
					matris[0][0] = 88888;
				}
			}
			if (matris[15][15] == k) {
				if (matris[10][15] != k + 1 && matris[15][10] != k + 1) {
					matris[15][15] = 88888;
				}
			}
		}
		System.out.println();
		System.out.println("FINAL");
		writethemaze();
	}

	public void turnbacktostart() {
		gecici = matris[15 - currentplaceY][currentplaceX] - 1;
		while (currentplaceX != 0 || currentplaceY != 0) {
			System.out.println();
			System.out.print("Front side: ");
			f = input.next().charAt(0);
			System.out.print("Right side: ");
			r = input.next().charAt(0);
			System.out.print("Left side: ");
			l = input.next().charAt(0);
			if (f == 'C' && r == 'O' && l == 'C') {
				turnright(2);
			} else if (f == 'C' && r == 'C' && l == 'O') {
				turnleft(2);
			} else if (f == 'O' && r == 'C' && l == 'C') {
				gostraight(2);
			} else if (f == 'O' && r == 'O' && l == 'C') {
				if (rightsidevalue() < frontsidevalue()) {
					turnright(2);
				} else {
					gostraight(2);
				}
			} else if (f == 'O' && r == 'C' && l == 'O') {
				if (leftsidevalue() < frontsidevalue()) {
					turnleft(2);
				} else {
					gostraight(2);
				}
			} else if (f == 'C' && l == 'O' && r == 'O') {
				if (rightsidevalue() < leftsidevalue()) {
					turnright(2);
				} else {
					turnleft(2);
				}
			} else if (f == 'O' && l == 'O' && r == 'O') {
				if (rightsidevalue() < leftsidevalue() && rightsidevalue() < frontsidevalue()) {
					turnright(2);
				} else if (leftsidevalue() < frontsidevalue() && leftsidevalue() < rightsidevalue()) {
					turnleft(2);
				} else if (frontsidevalue() < rightsidevalue() && frontsidevalue() < leftsidevalue()) {
					gostraight(2);
				}
			}
			writethemaze();
		}
		for (int k = matris[15][0] + 1; k < matris[finalY][finalX]; k++) {
			for (int i = 1; i < matris.length - 1; i++) {
				if (matris[0][i] == k) {
					if (matris[0][i + 1] != k - 1 && matris[0][i - 1] != k - 1 && matris[1][i] != k - 1) {
						matris[0][i] = 88888;
					}
				}
				if (matris[i][0] == k) {
					if (matris[i + 1][0] != k - 1 && matris[i - 1][0] != k - 1 && matris[i][1] != k - 1) {
						matris[i][0] = 88888;
					}
				}
				if (matris[15][i] == k) {
					if (matris[15][i + 1] != k - 1 && matris[15][i - 1] != k - 1 && matris[10][i] != k - 1) {
						matris[15][i] = 88888;
					}
				}
				if (matris[i][15] == k) {
					if (matris[i + 1][15] != k - 1 && matris[i - 1][15] != k - 1 && matris[i][10] != k - 1) {
						matris[i][15] = 88888;
					}
				}
				for (int j = 1; j < matris.length - 1; j++) {
					if (matris[i][j] == k) {
						if (matris[i][j + 1] != k - 1 && matris[i + 1][j] != k - 1 && matris[i - 1][j] != k - 1
								&& matris[i][j - 1] != k - 1) {
							matris[i][j] = 88888;
						}
					}
				}
			}
			if (matris[0][15] == k) {
				if (matris[0][10] != k - 1 && matris[1][15] != k - 1) {
					matris[0][15] = 88888;
				}
			}
			if (matris[0][0] == k) {
				if (matris[1][0] != k - 1 && matris[0][1] != k - 1) {
					matris[0][0] = 88888;
				}
			}
			if (matris[15][15] == k) {
				if (matris[10][15] != k - 1 && matris[15][10] != k - 1) {
					matris[15][15] = 88888;
				}
			}
		}
		difference = matris[15][0] - 1;
		for (int i = 0; i < matris.length; i++) {
			for (int j = 0; j < matris.length; j++) {
				if (matris[i][j] != 88888) {
					matris[i][j] -= difference;
				}
			}
		}
		System.out.println();
		System.out.println("FINAL");
		writethemaze();
	}
}
