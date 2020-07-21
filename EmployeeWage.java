interface EmpWage
{
	void addCompanyEmpWage(String companyName,int wage_per_hour,int max_working_days,int max_working_hours);
	void computeEmpWage();
	public int wageComputation(CompanyEmpWage companyEmpWage);
}
class CompanyEmpWage
{
	String companyName;
	int wage_per_hour;
	int max_working_days;
    int max_working_hours;
    int totalSalary=0;
    public CompanyEmpWage(String companyName,int wage_per_hour,int max_working_days,int max_working_hours)
    {
    	this.companyName=companyName;
		this.wage_per_hour=wage_per_hour;
		this.max_working_days=max_working_days;
		this.max_working_hours=max_working_hours;
    }
    public void setEmpWage(int totalEmpWage)
    {
    	totalSalary=totalEmpWage;
    }
    public String toString()
	{
		return "Total emp wage for "+companyName+" is "+totalSalary;
	}
}
public class EmployeeWage implements EmpWage{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	int numOfCompany=0;
	CompanyEmpWage[] companyEmpWageArray;
	/**
	 * @param args
	 */
	public EmployeeWage()
	{
		companyEmpWageArray=new CompanyEmpWage[5];
	}
	public void addCompanyEmpWage(String companyName,int wage_per_hour,int max_working_days,int max_working_hours)
	{
		companyEmpWageArray[numOfCompany++]=new CompanyEmpWage(companyName,wage_per_hour,max_working_days,max_working_hours);
	}
	public void computeEmpWage()
	{
		for(int i=0;i<numOfCompany;i++)
		{
			companyEmpWageArray[i].setEmpWage(wageComputation(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	public int wageComputation(CompanyEmpWage companyEmpWage)
	{
		int days=0;
		int full_day_hour=8;
		int part_time_hour=4;
		int hours=0;
		int salary=0;
		System.out.println("For "+companyEmpWage.companyName+":");
		System.out.println("Day\tDailyWage\tTotalEmployeeHours");
		while(hours<companyEmpWage.max_working_hours && days<companyEmpWage.max_working_days)
		{
		  days++;
		  int empCheck=(int)Math.floor(Math.random()*10)%3;
		  switch(empCheck)
		  {
		    case IS_FULL_TIME:salary=companyEmpWage.wage_per_hour*full_day_hour; 
		    	              hours+=full_day_hour;
		                      break;
		    case IS_PART_TIME:salary=companyEmpWage.wage_per_hour*part_time_hour;
		                      hours+=part_time_hour;
			                  break;
			default:salary=0;
		  }
		  System.out.println(days+"\t"+salary+"\t\t"+hours);
		}
		return (hours*companyEmpWage.wage_per_hour);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation program");
		EmployeeWage empwage=new EmployeeWage();
		empwage.addCompanyEmpWage("DMART",20,20,100);
		empwage.addCompanyEmpWage("Reliance",30,25,95);
		empwage.computeEmpWage();
	}

}
