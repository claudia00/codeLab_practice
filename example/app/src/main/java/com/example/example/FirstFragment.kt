package com.example.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

//    var count = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.button_toast.setOnClickListener {
           Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT).show()
        }

        view.button_count.setOnClickListener {
            countMe(view)
        }
        view.button_random.setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textView1)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }


        view.button_next.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            //R.id.action_FirstFragment_to_SecondFragment
        }

    }
        private fun countMe(view: View) {
            // Get the text view
            val showCountTextView = view.findViewById<TextView>(R.id.textView1)

            // Get the value of the text view.
            val countString = showCountTextView.text.toString()

            // Convert value to a number and increment it
            var count = countString.toInt()
            count++

            // Display the new value in the text view.
            showCountTextView.text = count.toString()
//        count++
//        val textView = textView1
//        textView.text = "Click times = $count "
    }

}
