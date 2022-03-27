package lab6;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



public class Account {
	public int id;
	public int balance;

	public Account(int id, int balance) {
		this.id = id;
		this.balance = balance;
	}

	// TODO: Task1
	// replace the null with a lambda expression
	public static Consumer<Account> add100 = a -> a.balance += 100; // lambda of adding balance by 100



	// TODO: Task2
	// define checkBound using lowerBound and upperBound
	// We want checkBound to check BOTH lowerBound AND upperBound.
	public static Predicate<Account> lowerBound = a -> a.balance >=0;
	public static Predicate<Account> upperBound = a -> a.balance <=10000;
	public static Predicate<Account> checkBound = a -> lowerBound.and(upperBound).test(a); // replace it
	// predicate chaining, use .and() to chain both condition predicate then use .test() to test a with prdicates for boolean

	interface AddMaker {
		Consumer<Account> make(int N);
	}

	// TODO: Task3
	// replace the null with a lambda expression
	public static AddMaker maker = (n)-> a -> a.balance += n;
	// lambda that take int n, return function (lambda expression) that take Account a and add a.balance by n


	// You can assume that all the Account in acconts have positive balances.
	public static int getMaxAccountID(List<Account> accounts) {
		// TODO: Task4
		// replace the null with a lambda expression
		Account maxOne = accounts.stream().reduce(new Account(0, -100), (a, b)-> a.balance > b.balance? a: b);
		// lambda expression: input 2 account a, b, if a.balance > a, return a, else return b
		// base value Account with id = 0 and -100 balance returned for empty stream
		// the stream input a list of account which do reduction of such stream to get only max balance account
		return maxOne.id;
	}


}
