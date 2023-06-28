package com.phonebook.fw;

import com.phonebook.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
  @DataProvider
  public Iterator<Object[]> addContact() {

    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"Mihail", "Las", "1234567890", "asas@gmail", "Berlin", "discription"});
    list.add(new Object[]{"Sofi", "NNNN", "2323678900", "asas@gmail", "Berlin", "discription"});
    list.add(new Object[]{"Sergey", "DDDD", "1230000890", "asas@gmail", "Berlin", "discription"});
    return list.iterator();
  }
  @DataProvider
    public Iterator<Object[]> addContactFromCsvFilePositive() throws IOException {
    Iterator<Object[]> list = readDataFromFile("src/test/resources/addNewContactPositive.csv");
    return  list;
  }

  @DataProvider
  public Iterator<Object[]> addContactFromCsvFileNegativePhone() throws IOException {
    Iterator<Object[]> list = readDataFromFile("src/test/resources/addNewContactNegativePhone.csv");
    return  list;
  }


    public   Iterator<Object[]> readDataFromFile (String urlFile) throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File(urlFile)));
    String line = reader.readLine();
    while (line!=null) {
      String[] split = line.split(",");
      list.add(new Object[]{new Contact()
          .setName(split[0])
          .setLastName(split[1])
          .setPhone(split[2])
          .setEmal(split[3])
          .setAddress(split[4])
          .setDescription(split[5])});
      line = reader.readLine();
    }
    return list.iterator();
  }
}
