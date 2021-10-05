/*
Car Class - Eithen O'Neil
L00162818
*/

//  Represents following details about a Car
//  RegNo, Make, Model, Engine Size, Emissions, Year and Value
  



public class Car
{

   //Instance variables
   private String regNo;
   private String make;
   private String model;
   private int engineSize;
   private int emissions;
   private int year;
   private double value;
   public int noMonths;
   private String Registration;
   
   //1st Constructor - Set instance variables to default values
   public Car()
   {
      regNo = "";
      make = "";
      model = "";
      engineSize = 0;
      emissions = 0;
      year = 0;
      value = 0.00;
   }
   //2nd Constructor - Set instance variables to values input by user
   public Car(String reg, String mk , String mod, int size, int em, int yr, double val)
   {
      regNo = reg;
      make = mk;
      model = mod;
      engineSize = size;
      emissions = em;
      year = yr;
      value = val;
   }  
  
   //Set Methods - Mutator- Sets all values for instance variables
   public void setRegNo(String reg)
   {
      regNo = reg;
   }
   public void setMake(String mk)
   {
      make = mk;
   }
   public void setModel(String mod)
   {
      model = mod;
   }
   public void setEngineSize(int size)
   {
      engineSize = size;
   }
   public void setEmissions(int em)
   {
      emissions = em;
   }
   public void setYear (int yr)
   {
      year = yr;
   }
   public void setValue(double val)
   {
      value = val;
   }
   
   //Get methods - Accessor methods - Returns Values for instance variables
   public String getRegNo()
   {
      return regNo;
   }
   public String getMake()
   {
      return make;
   }
   public String getModel()
   {
      return model;
   }
   public int getEngineSize()
   {
      return engineSize;
   }
   public int getEmissions()
   {
      return emissions;
   }
   public int getYear()
   {
      return year;
   }
   public double getValue()
   {
      return value;
   }

   //Method to calculate loan repayments
   public double loanRepayments(int noMonths)
   {
      double repayment = 0, loanCarValue;
      loanCarValue = value + value * 0.04;
      repayment = loanCarValue / noMonths;
      return repayment;
   }   
   
   //toString Method to return all car details
   public String toString()
   {
      return " Car Registration:"+ regNo+ "\t Make: "+make+" \t Model: "+model+ "\t Engine Size: "+engineSize+ "\t Emissions: "+emissions+ "\t Year: "+year+ "\t Value: "+value;
   }
      
}//Close class
   
      
    