package com.matteopasotti.bdd_sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_transfer.*

class TransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        transfer_button.setOnClickListener {
            val amountToTransfer = amount_to_transfer.text.toString().toDouble()
            transferAmount(amountToTransfer)
        }
    }


    private fun transferAmount(amount: Double) {
        val amountAvailable = current_account.text.toString().removePrefix("£").toDouble()
        var savings = savings_account.text.toString().removePrefix("£").toDouble()

        if(amount > amountAvailable) {
            error_text.visibility = View.VISIBLE
        } else {
            error_text.visibility = View.GONE
            savings += amount
            savings_account.text = "£$savings"

            val newAmount = amountAvailable - amount

            current_account.text = "£$newAmount"
        }

    }
}