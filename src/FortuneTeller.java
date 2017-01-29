import java.util.Scanner;

public class FortuneTeller {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] colors = {"red","orange","yellow","green","blue","indigo","violet"};
		String[] vehicles = {"skate board","bicycle","motorcycle","RV","sports car","convertable","private jet"};
		String vehicle = "roller skates";
		String[] months = {"january","february","march","april","may","june","july","august","september","october",
				"november","december"};
		String place;
		String money = "$0.00";
		boolean quitter = false;
		
		while (!quitter) {
			System.out.println("What is your First Name?:");
			String first = scanner.next();
			String firstLow = first.toLowerCase();
			if (firstLow.equals("quit")) {
				System.out.println("Nobody likes a quitter!  Goodbye.");
				quitter = true;
				break;
			} else if (firstLow.equals("restart")) {
				continue;
			}
			System.out.println("What is your Last Name?:");
			String last = scanner.next();
			String lastLow = last.toLowerCase();
			if (lastLow.equals("quit")) {
				System.out.println("Nobody likes a quitter!  Goodbye.");
				quitter = true;
				break;
			} else if (lastLow.equals("restart")) {
				continue;
			}
			System.out.println("What is your Age in years?:");
			String age = scanner.next();
			String ageLow = age.toLowerCase();
			if (ageLow.equals("quit")) {
				System.out.println("Nobody likes a quitter!  Goodbye.");
				quitter = true;
				break;
			} else if (ageLow.equals("restart")) {
				continue;
			}
			int retire;
			int ageLength = age.length();
			String lastDigit = age.substring(ageLength-1,ageLength);
			switch (lastDigit) {
				case ("0"): retire = 20; break;
				case ("2"): retire = 20; break;
				case ("4"): retire = 20; break;
				case ("6"): retire = 20; break;
				case ("8"): retire = 20; break;
				default: retire = 30; break;
			} 
			System.out.println("What month were you born?:");
			String month = scanner.next();
			String monthLow = month.toLowerCase();
			if (monthLow.equals("quit")) {
				System.out.println("Nobody likes a quitter!  Goodbye.");
				quitter = true;
				break;
			} else if (monthLow.equals("restart")) {
				continue;
			}
			boolean found = false;
			for (int index = 0; index < 12; index++) {
				if (monthLow.equals(months[index])) {
					found = true;
					index = 13;
				}		
			}
			// EXTRA CREDIT!!
			if (!found) {
				System.out.println("I think you said you were born in June.");
				monthLow = "june";
			}
			String fullName = firstLow + lastLow;
			String nameLetter;
			String monthLetter;
			found = false;
			money = "$0.00";
			for (int monthIndex = 0; monthIndex < monthLow.length(); monthIndex++) {
				for (int nameIndex = 0; nameIndex < fullName.length(); nameIndex++) {
					nameLetter = fullName.substring(nameIndex, nameIndex+1);
					monthLetter = monthLow.substring(monthIndex, monthIndex+1);
					if (nameLetter.equals(monthLetter)) {
						found = true;
						switch (monthIndex) {
						case 0: money = "$1,000,000.00"; break;
						case 1: money = "$2,000,000.00"; break;
						case 2: money = "$3,000,000.00"; break;
						case 3: money = "$4,000,000.00"; break;
						case 4: money = "$5,000,000.00"; break;
						case 5: money = "$6,000,000.00"; break;
						case 6: money = "$7,000,000.00"; break;
						case 7: money = "$8,000,000.00"; break;
						case 8: money = "$9,000,000.00"; break;
						}
					}
				}
			if (found) break;
			}
		
			System.out.println("What is your favorite color of the rainbow? If you need help, type 'help':");
			String color = scanner.next();
			String colorLow = color.toLowerCase();
			if (colorLow.equals("quit")) {
				System.out.println("Nobody likes a quitter!  Goodbye.");
				quitter = true;
				break;
			} else if (colorLow.equals("restart")) {
				continue;
			}
			if (colorLow.equals("help")) {
				System.out.println("The colors in the rainbow are: red, orange, yellow, green, blue, indigo, and violet:");
				color = scanner.next();
				colorLow = color.toLowerCase();
				if (colorLow.equals("quit")) {
					System.out.println("Nobody likes a quitter!  Goodbye.");
					quitter = true;
					break;
				} else if (colorLow.equals("restart")) {
					continue;
				}
				vehicle = getColor(colorLow, colors, vehicles, vehicle);
			} else vehicle = getColor(colorLow, colors, vehicles, vehicle);
		
			System.out.println("How many siblings, (that's total number of brothers and sisters), do you have?:");
			String sibs = scanner.next();
			String sibsLow = sibs.toLowerCase();
			if (sibsLow.equals("quit")) {
				System.out.println("Nobody likes a quitter!  Goodbye.");
				quitter = true;
				break;
			} else if (sibsLow.equals("restart")) {
				continue;
			}
			switch (sibs) {
				case "0": place = "about a block from your mothers house"; break;
				case "1": place = "Florida"; break;
				case "3": place = "Bali"; break;
				case "2": place = "Hawaii";	break;
				default: place = "Detroit";
				}
		
			System.out.println(first + " " + last + " will retire in " + retire + " years with " + money +
				" in the bank and have a vacation home in " + place + " and spend your time playing around with your "
				+ vehicle + ".");
			System.out.println("Would you like me to tell your fortune again?:");
			String again = scanner.next();
			String againLow = again.toLowerCase();
			if (!againLow.equals("yes")) {
				quitter = true;
				System.out.println("That was fun!  Lets do it again sometime!");
			}
		}
		scanner.close();
				
		}

	private static String getColor(String colorLow, String[] colors, String[] vehicles, String vehicle) {
		boolean found = false;
		for (int index = 0; index < 7 && !found; index++) {
			if (colorLow.equals(colors[index])) {
				found = true;
				vehicle = vehicles[index];
				break;
			}
		}
		//EXTRA CREDIT!!
		if (!found) {
			System.out.println("I think you said you're favorite color is blue.");
			vehicle = "unicycle";
		}
		return vehicle;
	}
		
	}
