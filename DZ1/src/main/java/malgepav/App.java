package malgepav;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person("John","Smith",20);

        String jsonPerson = new Gson().toJson(person);
        System.out.println(jsonPerson);

        Person backFromJasonPerson = new Gson().fromJson(jsonPerson, Person.class);
        System.out.println(backFromJasonPerson);
    }
}
