
public class EmployeeWage {
	static final int IS_FULL_TIME=1;
	static final int IS_PART_TIME=2;
	/**
	 * @param args
	 */
	void wageComputation()
	{
		int Wage_per_hour=20;
		int full_day_hour=8;
		int part_time_hour=4;
		int salary=0;
		int totalSalary=0;
		int days_in_month=20;
		int working_hours=0;
		int working_days=0;
		System.out.println("Day\tDailyWage\tTotalEmployeeHours");
		while(working_hours<100 && working_days<days_in_month)
		{
		  working_days++;
		  int empCheck=(int)Math.floor(Math.random()*10)%3;
		  switch(empCheck)
		  {
		    case IS_FULL_TIME:salary=Wage_per_hour*full_day_hour; 
		    	              working_hours+=full_day_hour;
		                      break;
		    case IS_PART_TIME:salary=Wage_per_hour*part_time_hour;
		                      working_hours+=part_time_hour;
			                  break;
			default:salary=0;
		  }
		  totalSalary+=salary;
		  System.out.println(working_days+"\t"+salary+"\t\t"+working_hours);
		}
		System.out.println("Total salary of employee is:"+totalSalary);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation program");
		EmployeeWage e1=new EmployeeWage();
		e1.wageComputation();
	}

}
