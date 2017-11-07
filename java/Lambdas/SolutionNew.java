import java.io.*;
import java.util.*;
import java.time.*;
//import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

class SolutionNew {
  public static void main(String[] args) {
    
		ArrayList <Person> list = new ArrayList <Person>();
		Person person = new Person();
		person.name = "Helga";
		person.emailAddress = "hegla@guoyuanx.com";
		list.add(person);
		person = new Person();
		person.name = "Ting Zhu";
		person.emailAddress = "tingzhu@guoyuanx.com";
		list.add(person);
		printPersons(list);

  }
  
  public static void printPersons(List<Person> roster) {
		roster.forEach(n -> {n.printPerson();
												System.out.println("I love these girls!");});
  }
}

class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name = "Joe Doe";
		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
    LocalDate birthday = LocalDate.parse("24.12.1998", germanFormatter);;
    Sex gender = Sex.FEMALE;
    String emailAddress = "TBD";

    public int getAge() {
        // ...
				return 20;
    }
		
		
    public void printPerson(){
        // ...
				
				System.out.println("Name: " + name);
				System.out.println("BDay: " + birthday);
				System.out.println("Gender: " + gender);
				System.out.println("Email: " + emailAddress);
				
    }
}

