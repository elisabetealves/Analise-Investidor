package br.com.asilva.investoranalizer.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.asilva.investoranalizer.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewName.text = intent.getStringExtra("name")
        textViewResult.text = intent.getStringExtra("result")

    }
}
