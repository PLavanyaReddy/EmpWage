import java.util.*;
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
    int[] dailywage_array;
    public CompanyEmpWage(String companyName,int wage_per_hour,int max_working_days,int max_working_hours)
    {
    	this.companyName=companyName;
		this.wage_per_hour=wage_per_hour;
		this.max_working_days=max_working_days;
		this.max_working_hours=max_working_hours;
		dailywage_array=new int[max_working_days+1];
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
	//CompanyEmpWage[] companyEmpWageArray;
	ArrayList<CompanyEmpWage> companyEmpWageAL;
	HashMap<String,CompanyEmpWage> getWage;
	/**
	 * @param args
	 */
	public EmployeeWage()
	{
		companyEmpWageAL=new ArrayList<CompanyEmpWage>();
		getWage=new HashMap<String,CompanyEmpWage>();
	}
	public void addCompanyEmpWage(String companyName,int wage_per_hour,int max_working_days,int max_working_hours)
	{
		CompanyEmpWage companyEmpWage=new CompanyEmpWage(companyName,wage_per_hour,max_working_days,max_working_hours);
		//companyEmpWageArray[numOfCompany++]=new CompanyEmpWage(companyName,wage_per_hour,max_working_days,max_working_hours);
		companyEmpWageAL.add(companyEmpWage);
		getWage.put(companyName,companyEmpWage);
		numOfCompany++;
	}
	public void computeEmpWage()
	{
		for(int i=0;i<numOfCompany;i++)
		{
			companyEmpWageAL.get(i).setEmpWage(wageComputation(companyEmpWageAL.get(i)));
			
			System.out.println(companyEmpWageAL.get(i));
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
		  companyEmpWage.dailywage_array[days]=salary;
		  System.out.println(days+"\t"+companyEmpWage.dailywage_array[days]+"\t\t"+hours);
		}
		return (hours*companyEmpWage.wage_per_hour);
	}
	public int getTotalWage(String companyName)
	{
		return getWage.get(companyName).totalSalary;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation program");
		EmployeeWage empwage=new EmployeeWage();
		empwage.addCompanyEmpWage("DMART",20,20,100);
		empwage.addCompanyEmpWage("Reliance",30,25,95);
		empwage.computeEmpWage();
		System.out.println("Total wage for DMART company:"+empwage.getTotalWage("DMART"));
		System.out.println("Total wage for Reliance company:"+empwage.getTotalWage("Reliance"));
	}

}
