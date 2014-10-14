package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){

		if(text.contains("\n") && (text.contains(","))){
			return sum(splitCommaNewline(text));
		}
		else if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("\n")){
			return sum(splitNewline(text));
		}
		else if((!text.contains(",")) && (!text.equals(""))){
			return toInt(text);
		}
	
		return 666;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}

	private static String[] splitNewline(String numbers){
		return numbers.split("\n");
	}

	private static String[] splitCommaNewline(String numbers){
		return numbers.split("\n|\\,");
	}

	private static int sum(String[] numbers){
		int total = 0;
		ArrayList<String> minus = new ArrayList<String>();

		for(String number : numbers){
			if(toInt(number) < 0){
				minus.add(number);
			}
			else if((toInt(number) < 1001) && (toInt(number) > 0)){
				total += toInt(number);
			}
		}
		if(!minus.isEmpty()){
			String negs = "";
			for(String neg : minus) {
				negs += neg + ",";
			}
			throw new RuntimeException("Negatives: " + negs);
		}
		return total;
	}
}
