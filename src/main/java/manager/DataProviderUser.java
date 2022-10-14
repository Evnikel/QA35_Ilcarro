package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> datalogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"evnikel@gmail.com", "Elena1234$@"});
        list.add(new Object[]{"lis2161@gmail.com", "Lis123@12"});
        list.add(new Object[]{"lis2165@gmail.com", "Lis123@12"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataModelUser() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("evnikel@gmail.com").withPassword("Elena1234$@")});
        list.add(new Object[]{new User().withEmail("lis2161@gmail.com").withPassword("Lis123@12")});
        list.add(new Object[]{new User().withEmail("lis2165@gmail.com").withPassword("Lis123@12")});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> regDataValid() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //list.add(new Object[]{new User().withName()})
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registrationSuccess.csv")));
        String line =reader.readLine();  // "Zoa,Dow,zoa@mail.com,Zz12345$"
        while (line!=null){
            String [] split =line.split(",");  //  ["Noa"] ["Snow"] ["kinoa@mail.com"] ["Nn12345$"]
            list.add(new Object[]{new User().withName(split[0]).withLastname(split[1]).withEmail(split[2]).withPassword(split[3])});
            line =reader.readLine();  // null
        }


        return list.iterator();
    }
}
