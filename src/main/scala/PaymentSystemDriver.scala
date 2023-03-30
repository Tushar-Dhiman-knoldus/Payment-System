
package com.knoldus.paymentsystem

object PaymentSystemDriver extends App {

  private val paymentSystemObject = new PaymentSystem

  // Creating different Payment Methods
  private val cvv = 377
  private val creditCard = CreditCard("Tushar", "1865 9658 4587 3652", "03/24", cvv)
  private val payPal = PayPal("9856852147", "password")
  private val bankTransfer = BankTransfer("47589623154", "password")

  // Adding different payment methods
  paymentSystemObject.addPaymentMethods(creditCard)
  paymentSystemObject.addPaymentMethods(payPal)
  paymentSystemObject.addPaymentMethods(bankTransfer)

  // Processing Payment
  println("Enter the amount to be transferred :-")
  private val amountToBeProcessed = scala.io.StdIn.readInt()
  println(paymentSystemObject.processPayment(amountToBeProcessed, "Credit"))

  // Displaying all the payment methods
  println("All payment Options are:-")
  val paymentMethods = paymentSystemObject.allPayments()
  paymentMethods.foreach(methods => println(methods))
}
