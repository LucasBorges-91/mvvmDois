package br.com.borges.lucas.mvvmcursokotlin

class PersonRepository {

  fun login ( email: String, password: String ) : Boolean {
    return ( email != "" && password != "" )
  }
}