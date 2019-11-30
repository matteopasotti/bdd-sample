package com.matteopasotti.bdd_sample.steps

import androidx.test.rule.ActivityTestRule
import com.matteopasotti.bdd_sample.TransferActivity
import com.matteopasotti.bdd_sample.test.TransferRobot
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class TransferSteps {

    private val robot = TransferRobot()
    private val activityRule = ActivityTestRule(TransferActivity::class.java, false , false)


    @Before
    fun setup() {
        //not needed now, but you may needed to setup mock responses before your screen starts
    }

    @After
    fun tearDown() {

    }

    @Given("I start the application")
    fun i_start_application() {
        robot.launchTransferScreen(activityRule)
    }

    @And("My current account is {double}")
    fun init_my_current_account(amount: Double) {
        robot.initAmountCurrentAccount(amount)
    }

    @And("My savings are {double}")
    fun init_my_savings(amount: Double) {
        robot.initAmountSavings(amount)
    }

    @When("I click amount to transfer field")
    fun click_amount_to_transfer_field() {
        robot.selectAmountToTransferField()
    }

    @And("I enter an amount to transfer {double}")
    fun i_enter_an_amount_to_transfer(amount: Double) {
        robot.insertAmountToTransfer(amount)
    }

    @And("I close the keyboard")
    fun i_close_the_keyboard(){
        robot.closeKeyboard()
    }

    @And("I click Transfer button")
    fun i_click_transfer_button(){
        robot.clickTransferButton()
    }

    @Then("I expect to see my Savings increased of that amount")
    fun i_expect_to_see_my_savings_increased(){
        robot.successfullTransfer()
    }
}