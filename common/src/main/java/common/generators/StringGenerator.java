package common.generators;

import java.util.Random;

public class StringGenerator {

	public static String generateRandomString(int length) {
		var result = new StringBuilder();

		var characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		for (int i = 0; i < length; i++) {
			var randomIndex = new Random().nextInt(characters.length());
			result.append(characters.charAt(randomIndex));
		}

		return result.toString();
	}

}
