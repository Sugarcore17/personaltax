package personaltax;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class tax {
  @WebMethod
  public double calculateTax(double income) {
    double taxRate;
    if (income <= 36000) {
      taxRate = 0.03;
    } else if (income <= 144000) {
      taxRate = 0.1;
    } else if (income <= 300000) {
      taxRate = 0.2;
    } else if (income <= 420000) {
      taxRate = 0.25;
    } else if (income <= 660000) {
      taxRate = 0.3;
    } else if (income <= 960000) {
      taxRate = 0.35;
    } else {
      taxRate = 0.45;
    }

    double tax = income * taxRate - (income <= 36000 ? 0 : (income - 36000) * 0.03);
    return tax;
  }
  public static void main(String[] argv) {
    Object implementor = new tax();
    String address = "http://localhost:8080/personaltax";
    Endpoint.publish(address, implementor);
  }
}
