
public class EmployeeWage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation program");
		int IS_FULL_TIME=1;
		int IS_PART_TIME=2;
		int Wage_per_hour=20;
		int full_day_hour=8;
		int part_time_hour=4;
		int salary=0;
		int days_in_month=20;
		int working_hours=0;
		int working_days=0;
		while(working_hours<100 && working_days<20)
		{
		  working_days++;
		  int empCheck=(int)Math.floor(Math.random()*10)%3;
		  switch(empCheck)
		  {
		    case 1:salary+=Wage_per_hour*full_day_hour; 
		    	   working_hours+=full_day_hour;
		           break;
		    case 2:salary+=Wage_per_hour*part_time_hour;
		           working_hours+=part_time_hour;
			       break;
			default:salary+=0;
		  }
		}
		System.out.println("No.of working days:"+working_days);
		System.out.println("No.of working hours:"+working_hours);
		System.out.println("Salary for month is:"+salary);
	}

}
