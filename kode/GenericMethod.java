import java.util.*;
public class GenericMethod {
   // Inspired by Tutorialspoint
   
   public static < E > void printArrayList( ArrayList<E> inputArrayList){
      // Print arraylist of generic elements
      for (E element : inputArrayList){
         System.out.printf("%s ", element);
      }
   }

   public static void main(String args[]) {
      
      // Initialize ArrayLists
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
      
      System.out.println("\nArrayList of Integer objects");
      printArrayList(intArrayList);
      
      System.out.println("\nArrayList of String objects");
      printArrayList(stringArrayList);
      
   }
}