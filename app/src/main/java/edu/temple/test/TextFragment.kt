package edu.temple.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TextFragment : Fragment() {

    private lateinit var textView: TextView
    private lateinit var sizeViewModel : SizeViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false).apply {
            textView = findViewById(R.id.textView)
            sizeViewModel = ViewModelProvider(requireActivity())[SizeViewModel::class.java]
           sizeViewModel.getSize().observe()
        }
    }

    fun changeTextSize (size: Float) {

        sizeViewModel.getSize().observe(requireActivity()) {
            changeTextSize(it)
        }
    }

}