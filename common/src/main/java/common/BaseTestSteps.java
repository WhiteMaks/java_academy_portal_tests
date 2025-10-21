package common;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public abstract class BaseTestSteps {

	@Step("Сравнение ожидающего тела ответа с актуальным")
	public void responsesMustBeEqually(Object expected, Object actual) {
		objectsMustBeEqually(expected, actual, "Тело ответа не соответствует ожидаемому");
	}

	@Step("Сравнение ожидаемой записи в базе с актуальной")
	public void recordsMustBeEqually(Object expected, Object actual) {
		objectsMustBeEqually(expected, actual, "Запись в базе не соответствует ожидаемой");
	}

	@Step("Сравнение ожидаемого объекта с актуальным")
	public void objectsMustBeEqually(Object expected, Object actual, String message) {
		Assertions.assertEquals(expected, actual, message);
	}

}
