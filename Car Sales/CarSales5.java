/* 
GUI for Car Class - Eithen O'Neil
L00162818

//Creates a GUI using the Car class. Has a multitude of functions.
*/





import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import java.util.Scanner;
public class CarSales5 extends Application
{
   //Create Car ArrayList
   ArrayList<Car> carList = new ArrayList<>();
  
   //Instanciate GUI Fields/Labels/Buttons
   TextField txtRegno;
   TextField txtMake;
   TextField txtModel;
   TextField txtEmissions;
   TextField txtEsize;
   TextField txtYear;
   TextField txtPrice;
   TextArea txtOutput;
   Button btnAddcar;
   Button btnViewcar;
   Button btnEditcar;
   Button btnCarsold;
   Button btnSearchreg;
   Button btnSearchmake;
   Button btnSearchprice;
   Button btnCalcloan;
   TextField txtregNo2;
   TextField txtfMonths;
   Button btnReturn;
   TextArea txtOutput2;
   Button btnEnterDetails;
   private int Months;
   private String Registration;
   TextField txtregno3;
   TextField txtmake3;
   TextField txtmodel3;
   TextField txtemissions3;
   TextField txtenginesize3;
   TextField txtyear3;
   TextField txtprice3;
   Button btnupdate;
   Button btncancel;
   Button btnsearch3;
   
   
public void start(Stage stage)
   {   
      //Create all the Textfields + Sizes Necessary
      txtRegno = new TextField();
      txtRegno.setMaxWidth(100);
      txtMake = new TextField();
      txtMake.setMaxWidth(100);
      txtModel = new TextField();
      txtModel.setMaxWidth(100);
      txtEmissions = new TextField();
      txtEmissions.setMaxWidth(50);
      txtEsize = new TextField();
      txtEsize.setMaxWidth(50);
      txtYear = new TextField();
      txtYear.setMaxWidth(50);
      txtPrice = new TextField();
      txtPrice.setMaxWidth(50);
      
      
      //Create all Labels
      Label lblRegno = new Label("Reg No");
      Label lblMake = new Label("Make");
      Label lblModel = new Label("Model");
      Label lblEmissions = new Label("Emissions");
      Label lblEsize = new Label("Engine Size");
      Label lblYear = new Label("Year");
      Label lblPrice = new Label("Price");
      Label lblStars1 = new Label("********************Car Details********************");
      Label lblStars2 = new Label("***************************************************");
      
      //Create all Buttons
      btnAddcar = new Button("Add Car");
      btnAddcar.setOnAction(e -> addCar(e));
      btnViewcar = new Button("View All Cars");
      btnViewcar.setOnAction(e -> viewCar(e));
      btnEditcar = new Button("Edit Car Details");
      //btnEditcar.setOnAction(e -> editCar(e));
      btnCarsold = new Button("Car Sold");
      btnCarsold.setOnAction(e -> carSold(e));
      btnSearchreg = new Button("Search by RegNo");
      btnSearchreg.setOnAction(e -> searchReg(e));
      btnSearchmake = new Button("Search by Make");
      btnSearchmake.setOnAction(e -> searchMake(e));
      btnSearchprice = new Button("Search by Price Range");
      btnSearchprice.setOnAction(e -> searchPrice(e));
      btnCalcloan = new Button("Calculate Loan Repayments");
      //Don't need this here I dont think???******** btnCalcloan.setOnAction(e -> repayment(e));
      
      
      
      //Create TextArea for Output
      txtOutput = new TextArea();
      txtOutput.setMaxSize(500,400);
      txtOutput.setEditable(false);
      
      
      //Create Hboxes
      HBox Stars1 = new HBox(10);
      Stars1.getChildren().addAll(lblStars1);
      Stars1.setAlignment(Pos.CENTER);
      HBox Line1 = new HBox(10);
      Line1.getChildren().addAll(lblRegno, txtRegno, lblMake, txtMake, lblModel, txtModel);
      Line1.setAlignment(Pos.CENTER);
      HBox Line2 = new HBox(10);
      Line2.getChildren().addAll(lblEmissions, txtEmissions, lblEsize, txtEsize, lblYear, txtYear, lblPrice, txtPrice);
      Line2.setAlignment(Pos.CENTER);
      HBox Stars2 = new HBox(10);
      Stars2.getChildren().addAll(lblStars2);
      Stars2.setAlignment(Pos.CENTER);
      HBox Line3 = new HBox(10);
      Line3.getChildren().addAll(btnAddcar, btnViewcar, btnEditcar, btnCarsold);
      Line3.setAlignment(Pos.CENTER);
      HBox Line4 = new HBox(10);
      Line4.getChildren().addAll(btnSearchreg, btnSearchmake, btnSearchprice, btnCalcloan);
      Line4.setAlignment(Pos.CENTER);
       
      //Create VBox to store Hbox's
      VBox root = new VBox(20);
      root.getChildren().addAll(Stars1, Line1, Line2, Stars2, Line3, Line4, txtOutput);
      root.setAlignment(Pos.CENTER);
         
      //Create Scene and add VBox to the Scene(Which contains HBoxes)
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("LYIT Car Sales");
      stage.show();
 
      //Create Controls for Scene 2 (Calculate Loan Repayments)
      Label regNo2 = new Label("Enter Reg Number");
      regNo2.setMaxWidth(200);
      Label fMonths = new Label("Enter how many months you want your repayment to be over");
      txtregNo2 = new TextField();
      txtregNo2.setMaxWidth(100);
      txtfMonths = new TextField();
      txtfMonths.setMaxWidth(100);
      txtOutput2 = new TextArea();
      txtOutput2.setMaxWidth(500);
      btnEnterDetails = new Button("Enter Car Details");
      btnReturn = new Button("Return");
      HBox input = new HBox(8);
      input.getChildren().addAll(regNo2, txtregNo2);
      HBox input2 = new HBox(8);
      input2.getChildren().addAll(fMonths, txtfMonths);
      VBox root2 = new VBox(10);
      root2.getChildren().addAll(input,input2, btnEnterDetails, txtOutput2, btnReturn);
      Scene scene2 = new Scene(root2, 530, 600);
      
      btnCalcloan.setOnAction(e -> stage.setScene(scene2));
      btnReturn.setOnAction(e -> stage.setScene(scene));
      //btnEnterDetails.setOnAction(e -> enterDetails(e)); ***Commented out for program to continue working***
      
      //Create controls for Scene 3 (Edit Car Details)
      //Scene 3 Labels
      Label regno3 = new Label("Enter Reg Number to Edit");
      regno3.setMaxWidth(200);
      Label make3 = new Label("Make");
      make3.setMaxWidth(200);
      Label model3 = new Label("Model");
      model3.setMaxWidth(200);
      Label emissions3 = new Label("Emissions");
      emissions3.setMaxWidth(200);
      Label enginesize3 = new Label("Engine Size");
      enginesize3.setMaxWidth(200);
      Label year3 = new Label("Year");
      year3.setMaxWidth(200);
      Label price3 = new Label("Value");
      price3.setMaxWidth(200);
      //Scene 3 Textfields
      txtregno3 = new TextField();
      txtregno3.setMaxWidth(100);
      txtmake3 = new TextField();
      txtmake3.setMaxWidth(100);
      txtmodel3 = new TextField();
      txtmodel3.setMaxWidth(100);
      txtemissions3 = new TextField();
      txtemissions3.setMaxWidth(100);
      txtenginesize3 = new TextField();
      txtenginesize3.setMaxWidth(100);
      txtyear3 = new TextField();
      txtyear3.setMaxWidth(100);
      txtprice3 = new TextField();
      txtprice3.setMaxWidth(100);
      //Scene 3 Buttons
      btnsearch3 = new Button("Search Registration");
      //btnsearch3.setOnAction(e -> searchCar(e));
      btncancel = new Button("Cancel");
      btnupdate = new Button("Update");
      //VBoxes and HBoxes
      HBox input3 = new HBox(8);
      input3.getChildren().addAll(regno3,txtregno3, btnsearch3);
      HBox input4 = new HBox(8);
      input4.getChildren().addAll(make3, txtmake3, model3, txtmodel3, emissions3, txtemissions3, enginesize3, txtenginesize3, year3, txtyear3, price3, txtprice3);
      VBox root3 = new VBox(10);
      root3.getChildren().addAll(input3,input4, btnupdate, btncancel);
      Scene scene3 = new Scene(root3, 1000, 200);
        
      //Set buttons to change scenes  
      btnEditcar.setOnAction(e -> stage.setScene(scene3));
      btncancel.setOnAction(e -> stage.setScene(scene));
   
   }  //Close the start method
   
//Methods
//Method to add Car 
public void addCar(ActionEvent e)
   {
      //Check if ALL TextFields are empty
      if(txtRegno.getText().isEmpty() || txtMake.getText().isEmpty() || txtModel.getText().isEmpty() || txtEmissions.getText().isEmpty() || txtEsize.getText().isEmpty() || txtYear.getText().isEmpty() || txtPrice.getText().isEmpty())
      {
         txtOutput.setText("You must enter values for all fields");
      }
      else
      {
         String regNo = txtRegno.getText();
         String make = txtMake.getText();
         String model = txtModel.getText();
         int engineSize = Integer.parseInt(txtEsize.getText());
         int emissions = Integer.parseInt(txtEmissions.getText());
         int year = Integer.parseInt(txtYear.getText());
         double value = Double.parseDouble(txtPrice.getText());
         
         //Create object and add it to ArrayList - carList
         carList.add(new Car(regNo, make, model, engineSize, emissions, year, value));
         txtOutput.setText("Car has been successfully added");
         
         Car car1 = new Car(regNo, make, model, engineSize, emissions, year, value);
      }
      
         //Clear Textfields after Input
         txtRegno.clear();
         txtMake.clear();
         txtModel.clear();
         txtEsize.clear();
         txtEmissions.clear();
         txtYear.clear();
         txtPrice.clear();
   }//Close method1
   
   
   
//Method to View Cars
public void viewCar(ActionEvent e)
   {
      txtOutput.clear();
      boolean isFound = false;
      for(Car a: carList)
      {
         txtOutput.appendText(a +"\n"); //puts it on a seperate line
         isFound = true;
      }
      if(isFound == false)
      {
         txtOutput.setText("No Cars Found");
      }
   }//Close Method 2
      
      
      
//Method to sell a car
public void carSold(ActionEvent e)
   {
      txtOutput.clear();
      //Check if regNo has been entered
      String regNo = txtRegno.getText();
      boolean isFound = false;
      for(int i = 0; i < carList.size(); i++)
      {
         if(regNo.equals(carList.get(i).getRegNo()))
         {
            carList.remove(i);
            txtOutput.setText("The Car has been sold successfully and removed from the system");
            isFound = true;
         }
      }
      if(isFound == false)
      {
         txtOutput.setText("No Car with this registration has been found on the system");
      }
   }//Close Method 3
   
//Method to Search by Registration Number
public void searchReg(ActionEvent e)
   {
      String SearchReg = txtRegno.getText();
      boolean isFound = false;
      for(int i = 0; i < carList.size(); i++)
      {
         if(SearchReg.equals(carList.get(i).getRegNo()))
         {
            txtOutput.appendText(carList.get(i).toString() + "\n");
            isFound = true;
         }
      }
      if(isFound == false)
      {
         txtOutput.setText("No Car could be found with that registration number");
      }
   } // Close Method 4
   
//Method to Search by Make
public void searchMake(ActionEvent e)
   {
      String SearchMake = txtMake.getText();
      boolean isFound = false;
      for(int i = 0; i < carList.size(); i++)
      {
         if(SearchMake.equals(carList.get(i).getMake()))
         {
            txtOutput.appendText(carList.get(i).toString() + "\n");
            isFound = true;
         }
      }
      if(isFound == false)
      {
         txtOutput.setText("No Cars could be found for that Make");
      }
   }//Close Method 5
   
//Method to Search by Price Range
public void searchPrice(ActionEvent e)
   {
  double value = Double.parseDouble(txtPrice.getText());
  boolean isFound = false;
   
  for(int i = 0; i < carList.size(); i++)
  {
     if(carList.get(i).getValue() <= value)
     {
        txtOutput.appendText(carList.get(i).toString() + "\n");
        isFound = true;
     }
  }
  if(isFound == false)
     {
        txtOutput.appendText("No Cars could be found inside that maximum price range");
     }
   }//Close Method 6
   
   
//Method to get Loan Repayment Reg/Months (Not working. Attempts shown. Line 90 & 153 commented out for use also)

/* public void enterDetails(ActionEvent e)
   {
      if(txtregNo2.getText().isEmpty()) || (txtfMonths.getText().isEmpty())
      {
         txtOutput2.setText("You must enter the Registration Number and The Length of the Loan Term (No more than 60 months)");
      }
      else
      {
         String Registration = txtregNo2.getText();
         int Months = Integer.parseInt(txtfMonths.getText());
         
         for(int i = 0; i < carList.size(); i++)
  
         if(Registration.equals(carList.get(i).getRegNo()))
         {
            Car.loanRepayments(Months);
         }
            
           //Car.loanRepayments(Months);
           //(Months == Car.loanRepayments(int noMonths));
           //(Months = Car.loanRepayments(int noMonths));
           //Months = int Car.noMonths 
           // txtOutput2.appendtext("\nYour monthly repayment with an interest of 4% on the loan amount inputted is: "+Car.loanRepayments(noMonths));;
            
      }
         
  }
*/

//Method to Edit Car Details - ***Not working. I created a GUI that functions and coded the following for getting the values in but no luck***
//Compiler shows no errors, but still not functional. Commenting out code.

/*
public void searchCar(ActionEvent e)
{
   String Registration = txtregno3.getText();
   for(int i = 0; i < carList.size(); i++)
      {
         if(carList.get(i).getRegNo() == Registration)
         {  
            String make4 = carList.get(i).getMake();
            String model4 = carList.get(i).getModel();
            int esize4 = carList.get(i).getEngineSize();
            int emiss4 = carList.get(i).getEmissions();
            int year4 = carList.get(i).getYear();
            txtregno3.setText(Registration);
            txtmake3.setText(make4);
            txtmodel3.setText(model4);
            txtenginesize3.setText(String.valueOf(esize4));
            txtemissions3.setText(String.valueOf(emiss4));
            txtyear3.setText(String.valueOf(year4));
         }
      }
}
*/






   
   
  

   public static void main(String []args)
   {
      launch(args);
   }
}

      
      
         
     