
public class PasswordCombinations {

	public static void main(String[] args) {
		allCombinations("", 4);

	}

	private static void allCombinations(String password, int length) {
		if (password.length() == length)
		{
			System.out.println(password);
			return;
		}
		for (char character = 'a'; character <= 'z'; character++){
			//password.concat(character+""); //+=character;
			allCombinations(password.concat(character+""), length);
		}
		
	}

}
