
public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
    String companyName;
	int wage_per_hour;
	int working_days;
    int working_hours;
    int totalSalary=0;
	/**
	 * @param args
	 */
	public EmployeeWage(String companyName,int wage_per_hour,int working_days,int working_hours)
	{
		this.companyName=companyName;
		this.wage_per_hour=wage_per_hour;
		this.working_days=working_days;
		this.working_hours=working_hours;
	}
	void wageComputation()
	{
		int days=0;
		int full_day_hour=8;
		int part_time_hour=4;
		int hours=0;
		int salary=0;
		System.out.println("For "+companyName+":");
		System.out.println("Day\tDailyWage\tTotalEmployeeHours");
		while(hours<working_hours && days<working_days)
		{
		  days++;
		  int empCheck=(int)Math.floor(Math.random()*10)%3;
		  switch(empCheck)
		  {
		    case IS_FULL_TIME:salary=wage_per_hour*full_day_hour; 
		    	              hours+=full_day_hour;
		                      break;
		    case IS_PART_TIME:salary=wage_per_hour*part_time_hour;
		                      hours+=part_time_hour;
			                  break;
			default:salary=0;
		  }
		  totalSalary+=salary;
		  System.out.println(days+"\t"+salary+"\t\t"+hours);
		}
	}
	public String toString()
	{
		return "Total emp wage for "+companyName+" is "+totalSalary;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation program");
		EmployeeWage dmart=new EmployeeWage("DMART",20,20,100);
		EmployeeWage reliance=new EmployeeWage("Reliance",30,25,95);
		dmart.wageComputation();
		System.out.println(dmart);
		reliance.wageComputation();
		System.out.println(reliance);
	}

}
