package Garage;

public class OwnerControl {
	public void validateChoice() {
		OwnerForm form = new OwnerForm();
		int choice = form.desplayMenuList();
		if (choice==1) {
			addNewSlot();
		} else if (choice==2) {
			generateReport();
		} else if (choice==3) {
			addNewOperator();
		} else if (choice==4) {
			return;
		}
		validateChoice();
	}
	
	public void generateReport() {
		Report report = new Report();
		report.getReport();
		Report.ReportForm reportForm = report.new ReportForm();
		reportForm.displayReport(report);
	}
	
	public void addNewSlot() {
		Garage.addSlot(new OwnerForm().enterSlotInfo());
	}
	
	public void addNewOperator() {
		new GarageOperator(new OwnerForm().enterOperatorInfo());
	}
}
