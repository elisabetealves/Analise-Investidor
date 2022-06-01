package br.com.asilva.investoranalizer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.RadioButton
import br.com.asilva.investoranalizer.R
import br.com.asilva.investoranalizer.models.Question
import kotlinx.android.synthetic.main.radio_button_fragment.*

class RadioButtonFragment : Fragment() {

    private var currentQuestionIndex = 0
    private lateinit var radioButtonsList: List<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.radio_button_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radioButtonsList = listOf(radioButtonAlternative_a.id,
                                    radioButtonAlternative_b.id,
                                    radioButtonAlternative_c.id,
                                    radioButtonAlternative_d.id,
                                    radioButtonAlternative_e.id)
        configQuestion()
    }

    fun configQuestion(){
        val arguments = arguments
        if (arguments != null){
            textViewQuestion.text = arguments.getString(STATEMENT_KEY)
            val options = arguments.getStringArray(OPTIONS_KEY)
            for (i in options.indices){
                if (options.size == 3){
                    radioButtonAlternative_d.visibility = GONE
                    radioButtonAlternative_e.visibility = GONE
                    activity?.findViewById<RadioButton>(radioButtonsList[i])?.text = options[i]
                }else if (options.size == 4){
                    radioButtonAlternative_e.visibility = GONE
                    activity?.findViewById<RadioButton>(radioButtonsList[i])?.text = options[i]
                }else{

                    activity?.findViewById<RadioButton>(radioButtonsList[i])?.text = options[i]
                }
            }
        }
    }

    companion object {
        val STATEMENT_KEY = "statement"
        val OPTIONS_KEY = "options"

        fun newInstance(question:Question):RadioButtonFragment{
            val radioButtonFrag = RadioButtonFragment()
            radioButtonFrag.arguments = Bundle().apply {
                putString(STATEMENT_KEY, question.statement)
                putStringArray(OPTIONS_KEY, question.options.toTypedArray())
            }
            return radioButtonFrag
        }
    }

}
