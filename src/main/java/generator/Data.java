/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import com.google.gson.Gson;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Person
{
    public String firstName;
    public String lastName;
    public int age;
    public int id;

    public Person(String firstName, String lastName, int age, int id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }
    
    
}

/**
 *
 * @author Hasssuni
 */
public class Data
{
    Gson gson = new Gson();
    private final int amount;
    private final String[] firstNames =
    {
        "Nur", "Johnny", "Magnus", "Claudia"
    };
    private final String[] lastNames =
    {
        "Andersen", "Jensen", "Pedersen", "Møller", "Hansen"
    };
    private int id;

    public Data(int amount, int id)
    {
        if (id < 1)
        {
            throw new IllegalArgumentException("id must be bigger than 0");
        }
        this.amount = amount;
        this.id = id;
    }

    public String[] genJsonArr()
    {
        String firstName;
        String lastName;
        int age;
        String[] jsonArr = new String[amount];
        Random random = new Random();
        for (int i = 0; i < amount; i++)
        {
            String json = "";
            firstName = firstNames[random.nextInt(firstNames.length)];
            lastName = lastNames[random.nextInt(lastNames.length)];
            age = ThreadLocalRandom.current().nextInt(17, 70 + 1);
            Person p = new Person(firstName, lastName, age, id);
            
//            json += "{\"firstName\" : \"" + firstName + "\", \"lastName\" : \"" + lastName + "\", \"age\" : " + age + ", \"id\" : " + id + "}";
//            if (i < amount - 1)
//            {
//                json += ",";
//            }
            id++;
            jsonArr[i] = gson.toJson(p);
            //jsonArr[i] = json;
        }
        return jsonArr;
    }

    public static void main(String[] args)
    {
        Data data = new Data(100, 1000);
        String[] arr = data.genJsonArr();
        System.out.println(arr.toString());
    }
}
