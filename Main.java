import java.io.BufferedReader; // Importing BufferedReader class
import java.io.FileReader; // Import the FileReader class
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Arrays; // Import Array class to sort arrays
import java.util.ArrayList; // Import ArrayList class to create lists
import java.io.*; // Import File class to read files
import java.util.Scanner; // Import Scanner class to read user input
import javax.swing.JOptionPane; // Import JOptionPane class
import javax.swing.JFileChooser; // Import JFileChooser class
import javax.swing.*; // Import JOptionPane class
import java.lang.System; // Import System class to get the OS type
import java.net.URL;
import java.io.FileWriter;


class Main {
  /**
    * Gathers data from file and puts it into an array
   */
  public static ArrayList<HomeBuyer> addHomeBuyerData() throws IOException {
    // Create a FileReader object to read the file    
    FileReader homeBuyers = new FileReader("homebuyers.txt");
    // Create a BufferedReader object to read the file
    BufferedReader homeBuyersReader = new BufferedReader(homeBuyers); 
    // Declare a variable to store each line of the file
    String line; 
    // Declare an ArrayList to store the HomeBuyer objects
    ArrayList<HomeBuyer> buyers = new ArrayList<HomeBuyer>();
    
    // Loop through each line of the file
    while((line = homeBuyersReader.readLine()) != null) { 
      
      // Parse the ID from the line
      int ID = Integer.parseInt(line.substring(0, line.indexOf(",")));
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the grossMonthlyIncome from the line
      double grossMonthlyIncome = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the creditCardPayment from the line
      double creditCardPayment = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the carPayment from the line
      double carPayment = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the studentLoanPayments from the line
      double studentLoanPayments = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the appraisedValue from the line
      double appraisedValue = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the downPayment from the line
      double downPayment = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the loanAmount from the line
      double loanAmount = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the monthlyMortgagePayment from the line
      double monthlyMortgagePayment = Double.parseDouble(line.substring(0, line.indexOf(","))); 
      line = line.substring(line.indexOf(",") + 1);
      
      // Parse the creditScore from the line
      int creditScore = Integer.parseInt(line);  

      // Assign info to a person object
      HomeBuyer person = new HomeBuyer(ID, grossMonthlyIncome, creditCardPayment, carPayment, studentLoanPayments, appraisedValue, downPayment, loanAmount, monthlyMortgagePayment,creditScore);
      
      // Add a new HomeBuyer object to the buyers ArrayList
      buyers.add(person); 
  }
    homeBuyersReader.close(); // Close the BufferedReader object
    homeBuyers.close(); // Close the FileReader object
    return buyers; // Return the ArrayList of HomeBuyer objects
}
  
  public static void potentialQuote()
  {
    boolean done = true;
      while (done) // Loop 
      {
      done = false;
      // Create JoptionPane variable
      JOptionPane optionPane = new JOptionPane();
      String output; // Declare Variable
      String output2; // Declare Variable
      String output3; // Declare Variable
      String output4; // Declare Variable
    
      // Ask user for HomeBuyer ID
      String id = JOptionPane.showInputDialog("What is your ID?"); 
    // Ask user for HomeBuyer monhtly car payment
        String input20 = JOptionPane.showInputDialog("How much are your student loans?");
        
        double studentLoans = Double.parseDouble(input20);
        String input = JOptionPane.showInputDialog("What is your monthly car payment?");
        double monthCarPayment = Double.parseDouble(input);
        String input2 = JOptionPane.showInputDialog("What is your monthly credit card payment?");
        double creditCardPayments = Double.parseDouble(input2);
        String input3 = JOptionPane.showInputDialog("What is your monthly mortgage?");
        double mortagage = Double.parseDouble(input3);
        String input4 = JOptionPane.showInputDialog("What is your monthly gross income?");
        double grossIncome = Double.parseDouble(input4);
        double debt = monthCarPayment + creditCardPayments + mortagage;
        double dti = (debt / grossIncome)* 100; 
        if (dti < 43)
        {
          output = "Your debt to income ratio is " + dti + ", which is below the 43% threshold.";
        }
        else 
        {
          output = "Your debt to income ratio is " + dti + ", which is above the 43% threshold.";
        } 
        String input5 = JOptionPane.showInputDialog("What is your credit score?");
        int creditScore = Integer.parseInt(input5);
        if (creditScore > 640)
        {
          output2 = "Your credit score is good enough to qualify for a loan";
        }
        else 
        {
          output2 = "Your credit score is not good enough.";
        }
        String input6 = JOptionPane.showInputDialog("What is your home appraised value?");
        double homeAppraisedValue = Double.parseDouble(input6);
        String input7 = JOptionPane.showInputDialog("How much is your down payment?");
        double downPayment = Double.parseDouble(input7);
        double loanValue = homeAppraisedValue - (downPayment);
        double ltv = (loanValue / homeAppraisedValue) * 100;
        if (ltv < 80)
        {
          output3 = "Your loan value to home appraised value is " + 
          ltv + ", which is below the 80% threshold.";
        }
        else
        {
          output3 = "Your loan to value to home appraised value is " + ltv + ", which is above the 80% threshold." + "\n" + "To lower LTV, increase your downpayment." + "\n" + "Additionally, you can continue renting while saving for your down payment." + "\n" + "You might still qualify for the home by buying private mortgage insurance which will" + "\n" + "add to the amount you have to pay for the house.";
        }
        double fedti = (mortagage / grossIncome) * 100;
        if (fedti <= 28)
        {
          output4 = "Your front-end debt to income ratio is " + fedti + ",  which" + "\n" + "is less than or equal to 28%. This puts you one step closer to being a potential buyer.";
        }
        else 
        {
          output4 = "Your front-end debt to income ratio is " + fedti + ", which" + "\n" + "is greater than 28%. Try to lower this ratio.";
        }
        JOptionPane.showMessageDialog(null, output);
        JOptionPane.showMessageDialog(null, output2);
        JOptionPane.showMessageDialog(null, output3);
        JOptionPane.showMessageDialog(null, output4);
        /*FileWriter fos = new FileWriter("homebuyers.txt", true);
        fos.write(id + "," + grossIncome + "," + creditCardPayments + "," + monthCarPayment + "," + studentLoans + "," + homeAppraisedValue + "," + downPayment + "," + loanValue + "," + mortagage + "," + creditScore + "\n");
        */
        
        String input8 = JOptionPane.showInputDialog("Would you like to enter another set" + "\n" + "of information or leave? Press Y to continue or N to exit.");
        if (input8 == "Y" || input8 == "y")
        {
          done = true;
        }
        if(input8 == "N" || input8 == "n")
        {
          done = false;
        }
  }
  }
  
/**
  * Using JOptionPane to display data from the homebuyers.txt file
*/
/*
static void displayHomeBuyers(ArrayList<HomeBuyer> buyers) {
  {
    // Create a JOptionPane object to display the HomeBuyer objects
    JOptionPane optionPane = new JOptionPane();

     boolean done = false; // Declare a boolean variable to control the loop
     while(!done) // Loop until user selects "Exit"
     {
         String menu = "1 - Potential Buyer Quote" + "\n" + "2 - Links to helpful information" + "\n" + "3 - Sort Buyer by info" + "\n" + "4 - Exit program";
     String inputValue = JOptionPane.showInputDialog(menu);
     int n = Integer.parseInt(inputValue);
     switch(n)
     {
        case 1 :
         potentialQuote();
         break; // add function
        case 2 : 
         // link();
         break; // add function
        case 3 : 
         //sortHomeBuyers(buyers);
         break; // add function
        case 4 : 
         done = true;
         break; // add function
        default : done = true;
         break;
     }
     }
  }
}
*/
  
  /**
  Sorts the HomeBuyer objects in the ArrayList 
  */
  /*
  static void sortHomeBuyers(ArrayList<HomeBuyer> buyerList)
  {

    for (int i = 0; i < buyerList.size(); i++)
      {
        
      
    // Menu Options to sort the HomeBuyer objects
    JOptionPane sortHomeBuyersOptionPane = new JOptionPane();

     boolean done = false; // Declare a boolean variable to control the loop
     while(!done) // Loop until user selects "Exit"
     {
         String menu = "\t\tSort By\n1 - ID" + "\n" + "2 - gross monthly income" + "\n" + "3 - credit card payment" + "\n" + "4 - car payments" + "\n" + "5 - student loan payments" + "\n" + "6 - appraised value" + "\n" + "7 - down payment" + "\n" + "8 - loan amount" + "\n" + "9 - monthly mortgage payment" + "\n" + "10 - credit score";
     String sortHomeBuyersInputValue = JOptionPane.showInputDialog(menu);
     int choice = Integer.parseInt(sortHomeBuyersInputValue);
      

     switch(choice)
     {
        case 1 :
         buyerList.get(i).sortID(buyerList);
         break; // add function
        case 2 :
         buyerList.get(i).sortGrossIncome(buyerList);
         break; // add function
        case 3 : 
         buyerList.get(i).sortCreditCardPayment(buyerList);
         break; // add function
        case 4 :
         buyerList.get(i).sortMonthCarPayment(buyerList);
         break; // add function
        case 5 :
         buyerList.get(i).sortStudentLoans(buyerList);
         break; // add function
        case 6 :
         buyerList.get(i).sortHomeAppraisedValue(buyerList);
         break; // add function
        case 7 :
         buyerList.get(i).sortDownPayment(buyerList);
         break; // add function
        case 8 :
         buyerList.get(i).sortLoanAmount(buyerList);
         break; // add function
        case 9 :
         buyerList.get(i).sortMonthlyMortgagePayment(buyerList);
         break; // add function
        case 10 :
         buyerList.get(i).sortCreditScore(buyerList);
         break; // add function
        default : 
         done = true;
         break;
     }
     }
      }
  } */




  

  public static void main(String[] args) throws IOException {
    ArrayList<HomeBuyer> buyerList = new ArrayList<HomeBuyer>();
    potentialQuote();
    buyerList = addHomeBuyerData();
  
    ////////////////////////////////////////////////////////////////////////
    FileOutputStream fos = new FileOutputStream("HomeBuyersResults.txt");
      int eligibleBuyersCounter = 0;
      int nonEligibleBuyersCounter = 0;
      int lowCreditScoreCounter = 0;
      int highLoanToValueCounter = 0;
      int highDebtToIncomeCounter = 0;
      int highFrontEndDebtToIncomeCounter = 0;
      for(int i = 0; i < buyerList.size(); i++){
        int buyerRating = 5;
        fos.write((buyerList.get(i).getID() + " reccomendations:\n").getBytes());
        if(buyerList.get(i).checkCreditScore()&&  buyerList.get(i).debtToIncome()< 44 && buyerList.get(i).frontEndDebtToIncome() < 29){                                                  
          if(buyerList.get(i).loanToValue() < 80)
            fos.write(("Y - Eligible buyer!\n" + buyerRating + " star buyer!\n").getBytes());
          else if(buyerList.get(i).loanToValue() < 95)
            fos.write(("Y - Eligible buyer with higher interest rate and need to purchase mortgage insurance. Need to put down a higher down payment or look for a less expensive home.\n" + buyerRating + " star buyer!\n").getBytes());
          eligibleBuyersCounter++;
        }
        else
        {

          fos.write(("N - Not eligible buyer.\n").getBytes());
        if(!buyerList.get(i).checkCreditScore()){
          URL lowCreditScoreUrl = new URL("https://www.nerdwallet.com/article/finance/raise-credit-score-fast");
          fos.write(("Credit score is too low. Pay off debts to increase credit score.\nUse these resources: " + lowCreditScoreUrl + "\n").getBytes());
          lowCreditScoreCounter++;
          buyerRating--;
        }
        if(!(buyerList.get(i).loanToValue() < 95)){
          fos.write(("Loan to value ratio is too high.Need to put down a higher down payment or look for a less expensive home.\nUse these resources: https://www.carboncollective.co/sustainable-investing/loan-to-value-ratio\n").getBytes());
          highLoanToValueCounter++;
          buyerRating--;
        }
        if(!(buyerList.get(i).debtToIncome() < 44)){
          fos.write(("Debt to income ratio is too high. Decrease monthly mortgage payment, decrease car payment, decrease credit card payment, or increase gross income.\nUse these resources: https://money.usnews.com/loans/personal-loans/articles/what-is-debt-to-income-ratio\n").getBytes());
          highDebtToIncomeCounter++;
          buyerRating--;
        }
          if(!(buyerList.get(i).frontEndDebtToIncome() < 29)){
            fos.write(("Front end debt to income ratio is too high. Decrease monthly mortgage payment or increase gross income.\nUse these resources: https://www.investopedia.com/terms/f/front-end-debt-to-income-ratio\n").getBytes());
            highFrontEndDebtToIncomeCounter++;
            buyerRating--;
          }
            nonEligibleBuyersCounter++;
          fos.write(("Buyer rating: " + buyerRating + "\n").getBytes());

      }

      }
      fos.write(("\nNumber of eligible buyers: " + eligibleBuyersCounter).getBytes());
      fos.write(("\nNumber of noneligible buyers: " + nonEligibleBuyersCounter).getBytes());
      fos.write(("\nNumber of buyers with a low credit score: " + lowCreditScoreCounter).getBytes());
      fos.write(("\nNumber of buyers with a high loan to value ratio: " + highLoanToValueCounter).getBytes());
      fos.write(("\nNumber of buyers with a high debt to income ratio: " + highDebtToIncomeCounter).getBytes());
      fos.write(("\nNumber of buyers with a high front end debt to income ratio " + highFrontEndDebtToIncomeCounter).getBytes());
      fos.close();
  }



  
}