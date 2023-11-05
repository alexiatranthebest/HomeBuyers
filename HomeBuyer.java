/*
HomeBuyer class holds data for the homebuyers.txt file. 
@param int ID
@param double grossMonthlyIncome
@param double creditCardPayment
@param double carPayment
@param double studentLoanPayments
@param double appraisedValue
@param double downPayment
@param double loanAmount
@param double monthlyMortgagePayment
@param double monthlyMortgagePayment
@param int creditScore
*/
class HomeBuyer {
  private int ID;
  private double grossMonthlyIncome;
  private double creditCardPayment;
  private double carPayment;
  private double studentLoanPayments;
  private double appraisedValue;
  private double downPayment;
  private double loanAmount;
  private double monthlyMortgagePayment;
  private int creditScore;

  public HomeBuyer(){
    ID = 0;
    grossMonthlyIncome = 0;
    creditCardPayment = 0;
    carPayment = 0;
    studentLoanPayments = 0;
    appraisedValue = 0;
    downPayment = 0;
    loanAmount = 0;
    monthlyMortgagePayment = 0;
    creditScore = 0;
  }

  public HomeBuyer(int ID, double grossMonthlyIncome, double creditCardPayment, double carPayment, double studentLoanPayments, double appraisedValue, double downPayment, double loanAmount, double monthlyMortgagePayment, int creditScore){
    this.ID = ID;
    this.grossMonthlyIncome = grossMonthlyIncome;
    this.creditCardPayment = creditCardPayment;
    this.carPayment = carPayment;
    this.studentLoanPayments = studentLoanPayments;
    this.appraisedValue = appraisedValue;
    this.downPayment = downPayment;
    this.loanAmount = loanAmount;
    this.monthlyMortgagePayment = monthlyMortgagePayment;
    this.creditScore = creditScore;
  }

  public int getID() {
    return ID;
  }

  public double getGrossMonthlyIncome() {
    return grossMonthlyIncome;
  }

  public double getCreditCardPayment() {
    return creditCardPayment;
  }

  public double getCarPayment() {
    return carPayment;
  }

  public double getStudentLoanPayments() {
    return studentLoanPayments;
  }

  public double getAppraisedValue() {
    return appraisedValue;
  }

  public double getDownPayment() {
    return downPayment;
  }

  public double getLoanAmount() {
    return loanAmount;
  }

  public double getMonthlyMortgagePayment() {
    return monthlyMortgagePayment;
  }

  public int getCreditScore() {
    return creditScore;
  }

  public void setID(int newID){
    this.ID = newID;
  }

  public void setGrossMonthlyIncome(double grossMonthlyIncome) {
    this.grossMonthlyIncome = grossMonthlyIncome;
  }

  public void setCreditCardPayment(double creditCardPayment) {
    this.creditCardPayment = creditCardPayment;
  }

  public void setCarPayment(double carPayment) {
    this.carPayment = carPayment;
  }

  public void setStudentLoanPayments(double studentLoanPayments) {
    this.studentLoanPayments = studentLoanPayments;
  }

  public void setAppraisedValue(double appraisedValue) {
    this.appraisedValue = appraisedValue;
  }

  public void setDownPayment(double downPayment) {
    this.downPayment = downPayment;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  public void setMonthlyMortgagePayment(double monthlyMortgagePayment){
    this.monthlyMortgagePayment = monthlyMortgagePayment;
  }

  public void setCreditScore(int creditScore) {
    this.creditScore = creditScore;
  }

  public boolean checkCreditScore(){
    if(creditScore > 639)
      return true;
    return false;
  }

  public int loanToValue(){
    return (int)(loanAmount / appraisedValue * 100);
  }

  public int debtToIncome(){
    return (int)((carPayment + creditCardPayment + monthlyMortgagePayment) / grossMonthlyIncome * 100);
  }
  
  public int frontEndDebtToIncome(){
    return (int) (monthlyMortgagePayment / grossMonthlyIncome * 100);
  }

  
  public String toString(){
    return ID + " " + grossMonthlyIncome + " " + creditCardPayment + " " + carPayment + " " + studentLoanPayments + " " + appraisedValue + " " + downPayment + " " + loanAmount + " " + monthlyMortgagePayment + " " + creditScore;
  }
/*
  public void sortID(HomeBuyer[] homeBuyers)
  {
    int min;
    int temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getID() < homeBuyers[min].getID())
          min = scan;
      }
      temp = homeBuyers[min].getID();
      homeBuyers[min].setID(homeBuyers[i].getID());
  }
}

  public void sortGrossMonthlyIncome(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getGrossMonthlyIncome() < homeBuyers[min].getGrossMonthlyIncome())
          min = scan;
        temp = homeBuyers[min].getGrossMonthlyIncome();
        homeBuyers[min].setGrossMonthlyIncome(homeBuyers[i].getGrossMonthlyIncome());
      }
    }1
  }

  public void sortCreditCardPayment(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getCreditCardPayment() < homeBuyers[min].getCreditCardPayment())
          min = scan;
      }
      temp = homeBuyers[min].getCreditCardPayment();
      homeBuyers[min].setCreditCardPayment(homeBuyers[i].getCreditCardPayment());
  }
  }

  public void sortCarPayment(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getCarPayment() < homeBuyers[min].getCarPayment())
          min = scan;
      }
      temp = homeBuyers[min].getCarPayment();
      homeBuyers[min].setCarPayment(homeBuyers[i].getCarPayment());
  }
  }

  public void sortStudentLoanPayments(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getStudentLoanPayments() < homeBuyers[min].getStudentLoanPayments())
          min = scan;
      }
      temp = homeBuyers[min].getStudentLoanPayments();
      homeBuyers[min].setStudentLoanPayments(homeBuyers[i].getStudentLoanPayments());
  }
  }
  
  public void sortAppraisedValue(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getAppraisedValue() < homeBuyers[min].getAppraisedValue())
          min = scan;
      }
      temp = homeBuyers[min].getAppraisedValue();
      homeBuyers[min].setAppraisedValue(homeBuyers[i].getAppraisedValue());
  }
  }
  
  public void sortDownPayment(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getDownPayment() < homeBuyers[min].getDownPayment())
          min = scan;
      }
      temp = homeBuyers[min].getDownPayment();
      homeBuyers[min].setDownPayment(homeBuyers[i].getDownPayment());
  }
  }

  public void sortLoanAmount(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getLoanAmount() < homeBuyers[min].getLoanAmount())
          min = scan;
      }
      temp = homeBuyers[min].getLoanAmount();
      homeBuyers[min].setLoanAmount(homeBuyers[i].getLoanAmount());
  }
  }

  public void sortMonthlyMortgagePayment(HomeBuyer[] homeBuyers)
  {
    int min;
    double temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getMonthlyMortgagePayment() < homeBuyers[min].getMonthlyMortgagePayment())
          min = scan;
      }
      temp = homeBuyers[min].getMonthlyMortgagePayment();
  }
  }
  
  public void sortCreditScore(HomeBuyer[] homeBuyers)
  {
    int min;
    int temp;
    for(int i = 0; i < homeBuyers.length - 1; i++)
    {
      min = i;
      for(int scan = i + 1; scan < homeBuyers.length; scan++)
      {
        if(homeBuyers[scan].getCreditScore() < homeBuyers[min].getCreditScore())
          min = scan;
      }
      temp = homeBuyers[min].getCreditScore();
      homeBuyers[min].setCreditScore(homeBuyers[i].getCreditScore());
  }
  }
  */
}