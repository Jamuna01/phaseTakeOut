import java.util.Scanner;
public class Menu 
{
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.printf("How many people are ordering: ");
		int people = console.nextInt();
		
		if(people >= 10 && people <= 100)
		{
			System.out.printf("\nWhat type of food will be ordered: \n");
			displayMainMenu();
			//System.out.printf("Choose what type of food you'd like to order: \n");
			int menu = console.nextInt();
			
			while(menu != '0')
			{
				if(menu == 1)
				{
					displayItalianFoodMenu();
					System.out.printf("Enter the number of trays do you want: ");
					int trays = console.nextInt();
					System.out.printf("How many feed per tray: ");
					int feeds = console.nextInt();
					System.out.printf("Cost of each tray: ");
					double cost = console.nextDouble();
					System.out.printf("\n********************************\n");
					System.out.printf("You need %d trays.\n", trays);
					determineTrays(people, feeds);
					System.out.printf("Feed: %d\n", feeds);
					double price = getSubtotal(cost, trays);
					System.out.printf("Price for %d people: $%.2f\n", people, price);
					double tax = getTax(price, 0.07);
					System.out.printf("Tax : $%.2f\n", tax);
					double tip = getTip(price, 0.15);
					System.out.printf("Tip : $%.2f\n", tip);
					double total = getGrandTotal(price, tax, tip);
					System.out.printf("Total(food, tax, tip) : $%.2f\n", total);
					double perPerson = pricePerPerson(total, people);
					System.out.printf("Price per person: $%.2f\n", perPerson);
					int leftOver = determineLeftOvers(feeds, trays, people);
					System.out.printf("Leftover servings for the delivery person: %d\n", leftOver);
					System.out.printf("\n********************************\n");
				}
				else if (menu == 2)
				{
					displayChineseFoodMenu();
				}
				else if (menu == 3)
				{
					displayAmericanFoodMenu();
				}
				else
				{
					System.out.printf("Sorry Wrong Input!! Please re-try again\n");
				}
				break;
			}
		}
		else
		{
			System.out.printf("Sorry! invalid number of people!\n");
		}
		
		
	}
	public static void displayMainMenu()
	{
		System.out.printf("CHOOSE TYPE OF MEAL\n");
		System.out.printf("______________________\n");
		System.out.printf("1. Italian\n");
		System.out.printf("2. Chinese\n");
		System.out.printf("3. American\n");
		
	}
	public static void displayItalianFoodMenu()
	{
		System.out.printf("CHOOSE ONE\n");
		System.out.printf("______________________\n");
		System.out.printf("1. Lasagna Tray - Feeds 5 - $17.99\n");
		System.out.printf("2. Pizza Pack - Feeds 7 - $15.99\n");
		System.out.printf("3. Gazpacho Soup, salad and bread sticks pack - Feeds 4 - $12.99\n");
		System.out.printf("Enter Choice\n");
		int choice = console.nextInt();
		/*
		if(choice == 1)
		{
			System.out.printf("Lasagna Tray - Feeds 5 - $17.99\n");
		}
		else if(choice == 2)
		{
		System.out.printf("Pizza Pack - Feeds 7 - $15.99\n");
		}
		else if(choice == 3)
		{
		System.out.printf("Gazpacho Soup, salad and bread sticks pack - Feeds 4 - $12.99\n");
		}
		*/
		
	}
	public static void displayChineseFoodMenu()
	{
		System.out.printf("CHOOSE ONE\n");
		System.out.printf("______________________\n");
		System.out.printf("1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds 7 - $18.99\n");
		System.out.printf("2. Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 - $18.99\n");
		System.out.printf("3. Shrimp Fried Rice Tray (includes 10 egg rolls) - Feeds 5 - $10.99\n");
		System.out.printf("Enter Choice\n");
		
	}
	public static void displayAmericanFoodMenu()
	{
		System.out.printf("CHOOSE ONE\n");
		System.out.printf("______________________\n");
		System.out.printf("1. Hamburger and Hot Dog Tray - includes buns and condiments - feeds 8 - $21.99\n");
		System.out.printf("2. Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces -Feeds 5 -\n" + 
				"$22.99\n");
		System.out.printf("3. Barbeque Tray - includes buns and peach cobbler - Feeds 10 - $26.99\n");
		System.out.printf("Enter Choice\n");
	}
	public static int determineTrays(int trays, int feeds)
	{
			int determinet = trays * feeds;
		
		return determinet;
	}
	public static double getSubtotal(double price, int trays)
	{
		double foodPrice = price * trays;
		
		return foodPrice;
	}
	public static double getTax(double subtotal, double taxrate)
	{
		taxrate = 0.07;
		double tax = subtotal * taxrate;
		
		return tax;
	}
	public static double getTip(double subtotal, double tipRate)
	{
		double tip = subtotal * 0.15;
		return tip;
	}
	public static double getGrandTotal(double subtotal, double tax, double tip)
	{
		double total = subtotal + tax  + tip;
		
		return total;
	}
	public static double pricePerPerson(double grandTotal, int people)
	{
		double pricePerPerson = grandTotal/people;
		
		return pricePerPerson;
	}
	public static int determineLeftOvers(int feeds, int trays, int people)
	{
		int determineOverFood = (feeds * trays) - people ;
		return determineOverFood;
	}
}
