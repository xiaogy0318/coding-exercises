import java.io.*;
import java.util.*;
import java.time.*;
//import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

class Solution {
  public static void main(String[] args) {
    
		ArrayList <Person> list = new ArrayList <Person>();
		final String tempString = "temp";
		/*
		Person person = new Person();
		//person.name = "Hegla";
		//person.emailAddress = "hegla@guoyuanx.com";
		list.add(person);
		person = new Person();
		//person.name = "Ting Zhu";
		//person.emailAddress = "tingzhu@guoyuanx.com";
		list.add(person);
		*/
		Person person = (String name, String emailAddress) -> {
				System.out.println("Name Lambda: " + name);
				System.out.println("BDay: ");// + birthday);
				System.out.println("Gender:");// " + gender);
				System.out.println("Email: " + emailAddress);
				System.out.println(tempString);
		};
		list.add(person);
		printPersons(list);
		
  }
  
  public static void printPersons(
    List<Person> roster) {
    for (Person p : roster) {
			/*
        if (p.isValid()) {
            p.getGender();
            p.isAdmin();
            p.getEmailAddress();
            p.printPerson();
        }
				*/
				p.printPerson("Ting Zhu", "tingzhu@guoyuanx.com");
    }
  }
}

interface Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name = "Joe Doe";
		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
    LocalDate birthday = LocalDate.parse("24.12.1998", germanFormatter);;
    Sex gender = Sex.FEMALE;
    String emailAddress = "TBD";

		/* Only allow one method for lambda
		
    public int getAge() {
        // ...
    }
		*/
		
    public void printPerson(String name, String emailAddress);// {
        // ...
				/*
				System.out.println("Name: " + name);
				System.out.println("BDay: " + birthday);
				System.out.println("Gender: " + gender);
				System.out.println("Email: " + emailAddress);
				*/
    //}
}

