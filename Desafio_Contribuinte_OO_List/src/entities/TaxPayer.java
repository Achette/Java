package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double tax = 0;

		if (this.salaryIncome / 12 < 3000) {
			tax = 0;
		} else if (this.salaryIncome / 12 >= 3000 && this.salaryIncome / 12 < 5000) {
			tax = 0.10;
		} else {
			tax = 0.20;
		}
		return tax;
	}

	public double serviceTax() {
		double serviceTax = 0;
		if (this.servicesIncome > 0) {
			serviceTax = 0.15;
		}
		return serviceTax;
	}

	public double capitalTax() {
		double capitalTax = 0;
		if (this.capitalIncome > 0) {
			capitalTax = 0.20;
		}
		return capitalTax;
	}

	public double grossTax() {
		double grossTax = 0;

		if (salaryTax() == 0) {
			grossTax = (this.servicesIncome * this.serviceTax()) + (this.capitalIncome * this.capitalTax());
		} else {
			grossTax = (this.salaryIncome * this.salaryTax()) + (this.servicesIncome * this.serviceTax())
					+ (this.capitalIncome * this.capitalTax());
		}

		return grossTax;
	}

	public double taxRebate() {
		double rebate = 0;

		if (this.healthSpending + this.educationSpending > grossTax() * 0.3) {
			rebate = grossTax() * 0.3;
		} else {
			rebate = this.healthSpending + this.educationSpending;
		}

		return rebate;
	}

	public double netTax() {
		double netTax = grossTax() - taxRebate();
		return netTax;
	}

}
