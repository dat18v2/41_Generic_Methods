import java.util.*;
import java.io.*;

public class GenericMethod {
   // Inspired by Tutorialspoint
   
   public static < E > void printArrayList( ArrayList<E> inputArrayList){
      // Print arraylist of generic elements
      for (E element : inputArrayList){
         System.out.printf("%s ", element);
      }
   }
   
   public static < E > void writeArrayList ( ArrayList<E> inputArrayList) throws IOException {
      // write arraylist to disk
      // åbn inputstreams på al.ser
      FileOutputStream fo = new FileOutputStream("al.ser");
      ObjectOutputStream oo = new ObjectOutputStream(fo);
      // serialiser arraylist af generisk type til fil
      oo.writeObject(inputArrayList);
      // luk inputstreams
      oo.close();
      fo.close();
   }
   
   public static < E > ArrayList<E> readArrayList () throws IOException, ClassNotFoundException{
      // read arraylist from disk
      // ArrayList til at returnere
      ArrayList<E> outputArrayList = new ArrayList<E>();
      // åbn inputstreams på al.ser
      FileInputStream fi = new FileInputStream("al.ser");
      ObjectInputStream oi = new ObjectInputStream(fi);
      // cast til arraylist af generisk type
      outputArrayList = (ArrayList<E>) oi.readObject();
      // luk inputstreams og returner
      oi.close();
      fi.close();
      return outputArrayList;
   }

   public static void main(String args[]) throws IOException, ClassNotFoundException {
      
      // Initialize ArrayLists - must be of reference type objects - not primitive types
      ArrayList<Integer> intArrayList = new ArrayList<Integer>();
      ArrayList<String> stringArrayList = new ArrayList<String>();
      
      // Add numbers to intArrayList
      for (int i=0;i<10;i++){
         intArrayList.add(i);
      }
      
      // Add strings to stringArrayList
      for (Integer i : intArrayList){
         stringArrayList.add("Nummer " + i);
      }
      
      System.out.println("ArrayList of Integer objects");
      printArrayList(intArrayList);
      System.out.println();
      
      System.out.println("ArrayList of String objects");
      printArrayList(stringArrayList);
      System.out.println();
      
      writeArrayList(intArrayList);
      System.out.println(readArrayList());
   }
}