package Model;
import java.io.Serializable;


/**
 * This class represents the billing information authorized by checkout customer.
 * It implements the Serializable interface.
 */
public class Billing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nameOnCard;
	private String creditCardNumber;
	private String creditCardExpMonth;
	private String creditCardExpYear;
	private String CVV;
	
	
	/**
	 * Constructor: create an Billing object w/o specified parameters
	 */
	public Billing() {
		
	}

	/**
	 * This method is used to get nameOnCard
	 * @return name: nameOnCard
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * This method is used to set nameOnCard
	 * @param nameOnCard: name on credit card
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * This method is used to get creditCardNumber
	 * @return name: creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}


	/**
	 * This method is used to set creditCardNumber
	 * @param creditCardNumber: credit card number
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * This method is used to get creditCardExpMonth
	 * @return creditCardExpMonth: credit card expired month
	 */
	public String getCreditCardExpMonth() {
		return creditCardExpMonth;
	}
	

	/**
	 * This method is used to set creditCardExpMonth
	 * @param creditCardExpMonth: credit card expired month
	 */
	public void setCreditCardExpMonth(String creditCardExpMonth) {
		this.creditCardExpMonth = creditCardExpMonth;
	}

	/**
	 * This method is used to get creditCardExpYear
	 * @return creditCardExpYear: credit card expired year
	 */
	public String getCreditCardExpYear() {
		return creditCardExpYear;
	}


	/**
	 * This method is used to set creditCardExpYear
	 * @param creditCardExpYear: credit card expired year
	 */
	public void setCreditCardExpYear(String creditCardExpYear) {
		this.creditCardExpYear = creditCardExpYear;
	}

	/**
	 * This method is used to get CVV
	 * @return CVV: CVV on credit card
	 */
	public String getCVV() {
		return CVV;
	}


	/**
	 * This method is used to set CVV
	 * @param CVV: CVV on credit card
	 */
	public void setCVV(String CVV) {
		this.CVV = CVV;
	}
}

	