package co.interleap.samples.functions.employeepayroll;

public class Payroll {

  public Money calculatePay(Employee e) throws InvalidEmployeeType {
    switch (e.type) {
      case Employee.COMMISSIONED:
        return calculateCommissionedPay(e);
      case Employee.HOURLY:
        return calculateHourlyPay(e);
      case Employee.SALARIED:
        return calculateSalariedPay(e);
      default:
        throw new InvalidEmployeeType(e.type);
    }
  }

  private Money calculateSalariedPay(Employee employee) {
    return null;
  }

  private Money calculateHourlyPay(Employee employee) {
    return null;
  }

  private Money calculateCommissionedPay(Employee employee) {
    return null;
  }
}
