package br.com.borges.lucas.mvvmcursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.borges.lucas.mvvmcursokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    setObserver()
    // binding.tvWelcome.text = "olá"
  }

  private fun setObserver() {
    viewModel.welcome().observe( this, Observer { text ->
      binding.tvWelcome.text = text
    })
  }
}