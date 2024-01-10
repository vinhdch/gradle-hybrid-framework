package util;

import com.github.javafaker.Faker;

public class DataHelpers {

	// private Locale local = new Locale("vi");
	private Faker faker = new Faker();

	public static DataHelpers getDataHelpers() {
		return new DataHelpers();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getPassword() {
		return faker.internet().password(8, 10, true, true);
	}

}
