package br.com.asilva.investoranalizer.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.asilva.investoranalizer.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fullName: String
    //private lateinit var rbvm: RadioButtonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListeners()

    }

    private fun setUpListeners(){

        btnInitial.setOnClickListener {

            fullName = textInputEdit.text.toString()
            val questionActivity = Intent(this, QuestionActivity::class.java)
            questionActivity.putExtra("name", fullName)
            startActivity(questionActivity)
        }
    }

}
