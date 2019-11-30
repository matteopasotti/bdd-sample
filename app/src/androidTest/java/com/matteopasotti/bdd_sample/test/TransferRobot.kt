package com.matteopasotti.bdd_sample.test

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.matteopasotti.bdd_sample.R
import com.matteopasotti.bdd_sample.TransferActivity

class TransferRobot {

    fun launchTransferScreen(testRule: ActivityTestRule<TransferActivity>) {
        testRule.launchActivity(null)
    }

    fun selectAmountToTransferField() {
        Espresso.onView(ViewMatchers.withId(R.id.amount_to_transfer)).perform(ViewActions.click())
    }

    fun initAmountCurrentAccount(amount: Double) {
        Espresso.onView(ViewMatchers.withId(R.id.current_account))
            .perform(ViewActions.typeText(amount.toString()))
    }

    fun initAmountSavings(amount: Double) {
        Espresso.onView(ViewMatchers.withId(R.id.savings_account))
            .perform(ViewActions.typeText(amount.toString()))
    }

    fun insertAmountToTransfer(amount: Double){
        Espresso.onView(ViewMatchers.withId(R.id.amount_to_transfer))
            .perform(ViewActions.typeText(amount.toString()))
    }

    fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
        Thread.sleep(100)
    }

    fun clickTransferButton() {
        Espresso.onView(ViewMatchers.withText("TRANSFER")).perform(ViewActions.click())
    }

    fun successfullTransfer() {
        Espresso.onView(ViewMatchers.withId(R.id.savings_account))
            .check(ViewAssertions.matches(ViewMatchers.withText("£1000")))
        Espresso.onView(ViewMatchers.withId(R.id.current_account))
            .check(ViewAssertions.matches(ViewMatchers.withText("£500")))
    }
}