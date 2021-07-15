package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataCreator {

    Faker faker = new Faker(new Locale("en-GB"));

    public String setRandomFirstName(){
        return faker.name().firstName();
    }

    public String setRandomLastName(){
        return faker.name().lastName();
    }

    public String setRandomEmail(){
        return faker.internet().emailAddress();
    }

    public String setRandomPhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }

    public String setRandomAdress(){
        return faker.address().streetAddress();
    }

    public String setRandomZipcode(){
        return faker.address().zipCode();
    }

    public String setRandomTown(){
        return faker.address().city();
    }
}
