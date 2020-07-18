
public class EmployeeWage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage Computation program");
		int IS_FULL_TIME=1;
		int Wage_per_hour=20;
		int full_day_hour=8;
		int salary=0;
		double empCheck=Math.floor(Math.random()*10)%2;
		if(empCheck == IS_FULL_TIME)
		{
			System.out.println("Employee is present");
			salary=Wage_per_hour*full_day_hour;
		}
		else
		{
			System.out.println("Employee is absent");
			salary=0;
		}
		System.out.println("Salary is:"+salary);
	}

}
