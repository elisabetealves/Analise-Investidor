package br.com.asilva.investoranalizer.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import br.com.asilva.investoranalizer.R
import br.com.asilva.investoranalizer.dataAccess.questions
import br.com.asilva.investoranalizer.fragments.RadioButtonFragment
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private lateinit var fullName: String
    private var currentQuestionIndex = 0
    private var sum: Int = 0
    private var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val fragTransaction = supportFragmentManager.beginTransaction()
        val radioButtonFrag = RadioButtonFragment.newInstance(questions[currentQuestionIndex])
        fragTransaction.add(R.id.frameLayoutQuestion, radioButtonFrag)
        fragTransaction.commit()
        setUpListener()
    }

    fun setUpListener(){
        btnProximo.setOnClickListener {
            val radioGroupfrag = findViewById<RadioGroup>(R.id.radioGroupFrag)
            val selectedOption = radioGroupfrag.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedOption)
            val selectedText = selectedRadioButton.text.toString()
            Toast.makeText(this,"Você selecionou a alternativa " + selectedText, Toast.LENGTH_LONG).show()

            if (i == 0 || i == 5 || i == 6){
                sum += when(selectedOption){
                    R.id.radioButtonAlternative_a -> 0
                    R.id.radioButtonAlternative_b -> 2
                    R.id.radioButtonAlternative_c -> 3
                    R.id.radioButtonAlternative_d -> 4
                    R.id.radioButtonAlternative_e -> 0
                    else -> 0
                }
            }else if (i == 1){
                sum += when(selectedOption){
                    R.id.radioButtonAlternative_a -> 0
                    R.id.radioButtonAlternative_b -> 2
                    R.id.radioButtonAlternative_c -> 4
                    R.id.radioButtonAlternative_d -> 5
                    R.id.radioButtonAlternative_e -> 0
                    else -> 0
                }
            }else if (i == 2 || i == 7){
                sum += when(selectedOption){
                    R.id.radioButtonAlternative_a -> 0
                    R.id.radioButtonAlternative_b -> 1
                    R.id.radioButtonAlternative_c -> 2
                    R.id.radioButtonAlternative_d -> 4
                    R.id.radioButtonAlternative_e -> 0
                    else -> 0
                }
            }else if (i == 3 || i == 4){
                sum += when(selectedOption){
                    R.id.radioButtonAlternative_a -> 0
                    R.id.radioButtonAlternative_b -> 2
                    R.id.radioButtonAlternative_c -> 4
                    R.id.radioButtonAlternative_d -> 0
                    R.id.radioButtonAlternative_e -> 0
                    else -> 0
                }
            }else{
                sum += when(selectedOption){
                    R.id.radioButtonAlternative_a -> 0
                    R.id.radioButtonAlternative_b -> 1
                    R.id.radioButtonAlternative_c -> 2
                    R.id.radioButtonAlternative_d -> 4
                    R.id.radioButtonAlternative_e -> 5
                    else -> 0
                }
            }

            showNextQuestion()
        }
    }

    fun showNextQuestion(){
        i += 1
        currentQuestionIndex += 1
        if (currentQuestionIndex < questions.size){

            val fragTransaction = supportFragmentManager.beginTransaction()
            val radioButtonFrag = RadioButtonFragment.newInstance(questions[currentQuestionIndex])
            fragTransaction.replace(R.id.frameLayoutQuestion, radioButtonFrag)
            fragTransaction.commit()

        }else{
            Toast.makeText(this,"Acabaram as perguntas", Toast.LENGTH_LONG).show()
            val resultActivity = Intent(this, ResultActivity::class.java)
            var fullName = intent.getStringExtra("name")
            resultActivity.putExtra("name", fullName)

            Log.i("QuestionActivity", "$sum - $i")

            if (sum >= 0 && sum <= 12){
                resultActivity.putExtra("result", "Investidor: Conservador")
            }else if (sum >= 13 && sum <= 29){
                resultActivity.putExtra("result", "Investidor: Moderado")
            }else{
                resultActivity.putExtra("result", "Investidor: Arrojado")
            }
            startActivity(resultActivity)
        }
    }

}
