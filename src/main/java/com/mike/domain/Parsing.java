package com.mike.domain;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mike on 07.03.2017.
 */
public class Parsing {

    public static void main(String[] args) throws ValidationException {
        ArrayList<String> list = readFile("C:\\Users\\mike\\IdeaProjects\\Library", "BookList.txt");
        parseArrayList(list);
    }


    public static void parseArrayList(ArrayList<String> list) throws ValidationException {
        for (int i = 0; i < list.size(); i++) {
            String e = list.get(i);
            String[] mass = e.split(",");
            //mass[2] =

            try {
                String s = mass[0];
                String[] id = s.split("-");
                while (id[0].length() == 3 && id[1].length() == 1 && id[2].length() == 4 && id[3].length() == 4 && id[4].length() == 1) {
                    id = s.split("-"); // долго думал, что сюда вставить. !на проверку
                }
            } catch (ArrayIndexOutOfBoundsException e1) {
                throw new ValidationException("Format is not valid", e1);
            }

            Date date = null;

            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(mass[2].trim());
            } catch (ParseException e1) {
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(mass[2].trim());
                } catch (ParseException e2) {
                    throw new ValidationException("Data is not valid", e2);
                }
            }

            try {
                BookType bookType = BookType.getEnum(mass[6].trim());
            } catch (IllegalArgumentException e1) {
                throw new ValidationException("BookType is not valid", e1);
            }

        }


    }

    public static ArrayList<String> readFile(String filePath, String fileName) {
        ArrayList<String> resultList = new ArrayList<String>();
        File file = new File(filePath, fileName);
        //создаем объект FileReader для объекта File
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного cчитывания
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            // считаем сначала первую строку
            line = reader.readLine();
            resultList.add(line);
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
                resultList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
