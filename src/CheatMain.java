import java.util.Scanner;

public class CheatMain {
	public static void main(String[] args){
		
		Cheater cheat1 = new Cheater();
		String theList = null;
		Scanner printScan = new Scanner(System.in);
		int loop = 0;
		
		
		while(loop == 0){
			System.out.println("1) to creat a list type: enterList" + System.lineSeparator() + "2) to add to the used list type: enterUsed" + System.lineSeparator() + "3) for possible solutions type: getpossable" + System.lineSeparator() + "4) to create new list type: clear" + System.lineSeparator() + "5) quit");
			theList = printScan.nextLine();
			String[] makeSwitch = theList.split(" ");

			switch(makeSwitch[0].toLowerCase()){
			case "enterlist" :
				String[] list = makeSwitch[1].split(",");
				
				for(int i = 0; i < list.length; i++){
					cheat1.add(list[i]);
				}
				break;
			case "enterused" :
				String[] usedList = makeSwitch[1].split(",");
				
				for(int i = 0; i < usedList.length; i++){
					String[] usedElement = usedList[i].split(":");
					cheat1.add(usedElement[0], Integer.valueOf(usedElement[1]));
				}
				break;
			case "clear" :
				cheat1 = new Cheater();
				break;
			case "getpossable" :
				for(String s : cheat1.solution()){
					System.out.println(s);
				}
				break;
			case "quit" :
				loop = 1;
				System.out.println("GoodBye");
				break;
			}
		}
		
		printScan.close();
	}
}
