package com.multimedia2018.ubaya.adv160818031week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.math.log

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments!= null)
        {
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        var point:Int = 0
        txtScoreCurrent.text = point.toString()

        var random1: Int = (0..30).random()
        var random2: Int = (0..30).random()
        txtNumOne.text = random1.toString()
        txtNumTwo.text = random2.toString()
        var total = random1 + random2

        btnAnswer.setOnClickListener {
            if (txtAnswer.text.toString() == total.toString())
            {
                point+=1
                print("Betul, +1")
                txtScoreCurrent.text = point.toString()

                random1 = (0..30).random()
                random2 = (0..30).random()
                txtNumOne.text = random1.toString()
                txtNumTwo.text = random2.toString()
                total = random1 + random2
            }
            else
            {
                val playerScore = point
                val action = GameFragmentDirections.actionResultFragment(playerScore)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}