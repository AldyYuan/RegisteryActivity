package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var edtName: EditText? = null
    var spnnerGender: Spinner? = null
    var edtEmail: EditText? = null
    var edtTelp: EditText? = null
    var edtAlamat: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.editName)
        spnnerGender = findViewById(R.id.spinnerGender)
        edtEmail = findViewById(R.id.editEmail)
        edtTelp = findViewById(R.id.editTelp)
        edtAlamat = findViewById(R.id.editAddress)

        buttonSave.setOnClickListener {
            validasiInput()
        }
        setDataSpinner()
    }

    fun setDataSpinner(){
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(  this,
        R.array.gender_list, android.R.layout.simple_spinner_item)

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGender?.adapter = adapter
}
fun validasiInput(){
    val namaInput : String = edtName?.text.toString()
    val emailInput : String = edtEmail?.text.toString()
    val telpInput : String = edtTelp?.text.toString()
    val alamatInput : String = edtAlamat?.text.toString()
    val genderInput : String = spnnerGender?.selectedItem.toString()
    when{

        genderInput.equals("Pilih Jenis Kelamin") ->
            Toast.makeText(    this, "Kelamin harus dipilih",Toast.LENGTH_SHORT).show()

        namaInput.isEmpty() -> edtName?.error = "Nama Tidak Boleh Kosong"
        emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"
        telpInput.isEmpty() -> edtTelp?.error = "Telp tidak boleh kosong"
        alamatInput.isEmpty() -> edtAlamat?.error = "Alamat tidak boleh kosong"
        else -> {
            Toast.makeText( this, "Data berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}
}

