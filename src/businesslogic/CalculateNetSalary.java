package businesslogic;

public class CalculateNetSalary {

	private double basicsalary, HRA, DA, GS, incometax, netsalary, pf, plp;

	public double calculate(double ctc) // calculating all the parameters
	{
		basicsalary = (ctc * 50) / 100;
		HRA = ((ctc - basicsalary) * 10) / 100;
		incometax = ((ctc - basicsalary - HRA) * 5) / 100;
		plp = ((ctc - basicsalary - HRA - incometax) * 10) / 100;
		pf = ((ctc - basicsalary - HRA - incometax - plp) * 10) / 100;
		double monthsalary = (basicsalary + HRA - incometax - plp - pf) / 12;
		System.out.println("Basic Salary :" + basicsalary + "\t" + "HRA:" + HRA + "\t" + "Tax Deduction:" + incometax
				+ "\t" + "PLP :" + plp + "PF Deduction :" + pf);
		return monthsalary;

	}
}
