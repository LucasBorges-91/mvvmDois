package br.com.borges.lucas.mvvmcursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    binding.btLogin.setOnClickListener{
      val email = binding.etEmail.text.toString()
      val password = binding.etPassword.text.toString()

      viewModel.doLogin(email, password)
    }

    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    setObserver()
    // binding.tvWelcome.text = "olá"
  }

  private fun setObserver() {
    viewModel.welcome().observe( this, Observer { text ->
      binding.tvWelcome.text = text
    })
    viewModel.login().observe(this, Observer { login ->
      if ( login ) {
        Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_LONG).show()
      } else {
        Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_LONG).show()
      }
    })
  }
}