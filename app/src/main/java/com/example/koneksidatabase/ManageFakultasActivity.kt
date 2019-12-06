package com.example.koneksidatabase

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_manage_fakultas.*
import org.json.JSONObject



class ManageFakultasActivity : AppCompatActivity() {
    lateinit var  i : Intent
    lateinit var  add:Button
    lateinit var edit:Button
    lateinit var delete:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_fakultas)

        add = findViewById(R.id.btnCreate)
        edit = findViewById(R.id.btnUpdate)
        delete = findViewById(R.id.btnDelete)

        i = intent
        if (i.hasExtra("editMode")){
            if (i.getStringExtra("editMode").equals("1")){
                onEditMode()
            }
        }
        add.setOnClickListener {
            onCreate()
        }
        edit.setOnClickListener {
            onUpdate()
        }
        delete.setOnClickListener {
            onDelete()
        }
    }
    private fun onEditMode(){

        txt_idfakultas.setText(i.getStringExtra("txt_idfakultas"))
        txt_kodefakultas.setText(i.getStringExtra("txt_kodefakultas"))
        txt_namafakultas.setText(i.getStringExtra("txt_namafakultas"))
        txt_idfakultas.isEnabled = false


        btnCreate.visibility = View.GONE
        btnUpdate.visibility = View.VISIBLE
        btnDelete.visibility = View.VISIBLE

    }

    private fun onCreate(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan Data .....")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.CREATE)
            .addBodyParameter("kode_fakultas",txt_kodefakultas.toString())
            .addBodyParameter("nama_fakultas",txt_namafakultas.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()
                    if (response?.getString("message")?.contains("succesfully")!!){
                        this@ManageFakultasActivity.finish()
                    }
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure",Toast.LENGTH_SHORT).show()
                }
            })

    }
    private fun onUpdate(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan Data .....")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.UPDATE)
            .addBodyParameter("id_fakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("kode_fakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("nama_fakultas",txt_namafakultas.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()
                    if (response?.getString("message")?.contains("succesfully")!!){
                        this@ManageFakultasActivity.finish()
                    }
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure",Toast.LENGTH_SHORT).show()
                }
            })

    }

    private fun onDelete(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan Data .....")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.DELETE)
            .addBodyParameter("id_fakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("kode_fakultas",txt_kodefakultas.text.toString())
            .addBodyParameter("nama_fakultas",txt_namafakultas.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()
                    if (response?.getString("message")?.contains("succesfully")!!){
                        this@ManageFakultasActivity.finish()
                    }
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure",Toast.LENGTH_SHORT).show()
                }
            })

    }
}
