package com.company;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParseException{
        List<Netflix> movieLists=new ArrayList<>();
        Scanner sc =new Scanner(System.in);
        List<Netflix> q1List=new ArrayList<>();
        System.out.println(args[0]);
        int n= Integer.parseInt(args[0]);
        long start=0;
        long end=0;
        String filePath="./src/netflix_titles.csv" ;

        try {
            BufferedReader br=new BufferedReader(new FileReader(filePath));

            System.out.println(Arrays.stream(br.readLine().split(","))+"  "+br.readLine().split(",").length);

            while(br.readLine()!=null && !br.readLine().equalsIgnoreCase("")){
                String line=br.readLine();
                if(line!=null) {
                    String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//                    System.out.println(values.length);
                    if (values.length == 12) {
                        Netflix movie = new Netflix(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11]);
                        movieLists.add(movie);
                    }
                }
            }


//            System.out.println(movieLists);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Hi Welcome to Assignment 1!!");

            System.out.println("Please choose the query");
            System.out.println("For List of records based on TYPE field              ---PRESS '1' ");
            System.out.println("For List of records based on LISTED_IN field         ---PRESS '2' ");
            System.out.println("For List of records based on TYPE and COUNTRY field  ---PRESS '3' ");
            System.out.println("For List of records based on ADDED_DATE RANGE        ---PRESS '4' ");
            System.out.println("Wanna QUIT?                                          ---PRESS '5' ");
            int query = sc.nextInt();
            sc.nextLine();
            switch (query) {
                //Case statements
                case 1:
                    start = System.nanoTime();

                    System.out.println("1 is selected");

                    System.out.println("Please enter Type here: ");
                    String type = sc.nextLine();
                    System.out.println("Listing " + n + " records of Query1---------- for type : " + type);
                    q1List = movieLists.stream().filter(movie -> movie.getType().equalsIgnoreCase(type)).limit(n).collect(Collectors.toList());
//                    System.out.println("NO OF RECORDS"+ q1List.size());
                    q1List.forEach(movie -> System.out.println(movie.toString()));
                    end = System.nanoTime();
                    System.out.println("Time taken for execution in nanoseconds  "+(end-start));

                    break;
                case 2:
                    start = System.nanoTime();
                    System.out.println("2 is selected");


                    System.out.println("Please enter Listed_In here: ");
                    String listed_In = sc.nextLine();
                    System.out.println("Listing " + n + " records of Query2---------- for Listed_In : " + listed_In);
                    q1List = movieLists.stream().filter(movie -> movie.getListed_in().contains(listed_In)).limit(n).collect(Collectors.toList());
//                    System.out.println("NO OF RECORDS"+ q1List.size());
                    q1List.forEach(movie -> System.out.println(movie.toString()));
                    end = System.nanoTime();
                    System.out.println("Time taken for execution in nanoseconds  "+(end-start));

                    break;
                case 3:
                    start = System.nanoTime();
                    System.out.println("3 is selected");
                    System.out.println("Please enter the country here: ");
                    String country = sc.nextLine();
                    System.out.println("Please enter the Type here: ");
                    String mType = sc.nextLine();
                    System.out.println("Listing " + n + " records of Query3---------- for Country : " + country + " and Type " + mType);
                    q1List = movieLists.stream().filter(movie -> movie.getType().equalsIgnoreCase(mType) && movie.getCountry().equalsIgnoreCase(country)).limit(n).collect(Collectors.toList());
//                    System.out.println("NO OF RECORDS"+ q1List.size());
                    q1List.forEach(movie -> System.out.println(movie.toString()));
                    end = System.nanoTime();
                    System.out.println("Time taken for execution in nanoseconds "+(end-start));

                    break;
                case 4:
                    start=System.nanoTime();
                    System.out.println("4 is selected");

                    System.out.println("Please enter the Type here: ");
                    String mtype = sc.nextLine();
                    System.out.println("Please enter the Country here: ");
                    String mcountry = sc.nextLine();
                    System.out.println("Please enter the Listed_in here: ");
                    String mListed_In = sc.nextLine();
                    System.out.println("Please enter the start date here: ");
                    Date sDate = new SimpleDateFormat("dd-MMM-yy").parse(sc.nextLine());
                    System.out.println("Please enter the end date here: ");
                    Date eDate = new SimpleDateFormat("dd-MMM-yy").parse(sc.nextLine());
                    System.out.println("Listing " + n + " records of Query4---------- for the range between start date: " + sDate + " and end date " + eDate);
//                    q1List= movieLists.stream().filter(movie->
//                       movie.getCountry().equalsIgnoreCase(mcountry)&& movie.getType().equalsIgnoreCase(mtype) && movie.getListed_in().contains(mListed_In) && new SimpleDateFormat("dd/MM/YYYY").parse(movie.getDate_added()).compareTo(sDate) >= 0 && new SimpleDateFormat("dd/MM/YYYY").parse(movie.getDate_added()).compareTo(eDate) <= 0;
//
//
//
//
//
//                    ).limit(n).collect(Collectors.toList());
                    for (Netflix data : movieLists) {
                        String cDate = "";


                        Date date = data.getDate_added();

//                        SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
//                        String datec = d.format(new Date(data.getDate_added()));

                        //System.out.println(date);
                        if (data.getCountry().equalsIgnoreCase(mcountry) && data.getType().equalsIgnoreCase(mtype) &&
                                data.getListed_in().contains(mListed_In) &&
                                (date.compareTo(sDate) >= 0 && date.compareTo(eDate) <= 0)) {
                            q1List.add(data);
                        }
                    }


                    q1List.forEach(movie -> System.out.println(movie.toString()));
                    end = System.nanoTime();
                    System.out.println("Time taken for execution in nanoseconds  "+(end-start));

                    break;
                case 5:

                    System.out.println("Quitting");
                    System.exit(0);

                    //Default case statement
//                default:System.out.println("Not in 10, 20 or 30");
            }
//            if(query==5){
//                System.out.println("Quitting");
//
//            }
//        }
        }



    }
}
