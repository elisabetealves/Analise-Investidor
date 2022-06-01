package br.com.asilva.investoranalizer.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.asilva.investoranalizer.R
import br.com.asilva.investoranalizer.viewmodels.DirectQuestionViewModel

class DirectQuestionFragment : Fragment() {

    companion object {
        fun newInstance() = DirectQuestionFragment()
    }

    private lateinit var viewModel: DirectQuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DirectQuestionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
