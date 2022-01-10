package uk.co.itmms.demohilt.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uk.co.itmms.demohilt.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.state.observe(this) {
            when (it) {
                is MainViewModel.State.Error -> showError(it.message)
            }
        }

        val button = findViewById<Button>(R.id.mainButton)
        button.setOnClickListener {
            mainViewModel.doSomething()
        }
    }

    private fun showError(message: String) {
        val textView = findViewById<TextView>(R.id.mainError)
        textView.text = message
    }
}