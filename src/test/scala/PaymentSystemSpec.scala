
package com.knoldus.paymentsystem
import org.scalatest.flatspec.AnyFlatSpec

class PaymentSystemSpec extends AnyFlatSpec {

  "addPaymentMethods" should "add payment methods correctly" in {
    val paymentSystem = new PaymentSystem()
    val payPal = PayPal("1234567890", "password")
    paymentSystem.addPaymentMethods(payPal)
    assert(paymentSystem.allPayments() == List(payPal))
  }

  "processPayment" should "Credit payment successfully" in {
    val paymentSystem = new PaymentSystem()
    val amount = 100
    assert(paymentSystem.processPayment(amount, "Credit") == s"The payment of $amount has been Credited Successfully")
  }

  "processPayment" should "Debit payment successfully" in {
    val paymentSystem = new PaymentSystem()
    val amount = 100
    assert(paymentSystem.processPayment(amount, "Debit") == s"The payment of $amount has been Transferred Successfully")
  }

  "processPayment" should "return IllegalArgumentException if transactionType is wrong" in {
    val paymentSystem = new PaymentSystem()
    val amount = 100
    assertThrows[IllegalArgumentException](paymentSystem.processPayment(amount, "anythingElse"))
  }
}


