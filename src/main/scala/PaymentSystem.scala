package com.knoldus.paymentsystem

import scala.collection.mutable.ListBuffer

// A trait representing a payment method, which can be used to pay for goods or services.
trait PaymentMethod

// Case classes for different type of payment methods which are inheriting the trait PaymentMethod
case class PayPal(phoneNumber: String, password: String) extends PaymentMethod
case class CreditCard(name: String, cardNumber: String, expirationDate: String, cvv: Int) extends PaymentMethod
case class BankTransfer(accountNumber: String, password: String) extends PaymentMethod

class PaymentSystem {

  private val paymentMethods = ListBuffer.empty[PaymentMethod]

  // Function to add the payment methods to the list
  def addPaymentMethods(paymentMethod: PaymentMethod): Unit = {
    paymentMethods += paymentMethod
  }

  // Function to perform the "Debit" and "Credit" of the amount
  def processPayment(amount: Int, transactionType: String): String = {

    transactionType match {
      case "Credit" => s"The payment of $amount has been Credited Successfully"
      case "Debit" => s"The payment of $amount has been Transferred Successfully"
      case _ => throw new IllegalArgumentException()
    }
  }

  // Function to fetch all the payments from the list.
  def allPayments(): ListBuffer[PaymentMethod] = {
    paymentMethods
  }
}