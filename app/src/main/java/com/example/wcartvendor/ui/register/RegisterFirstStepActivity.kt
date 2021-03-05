package com.example.wcartvendor.ui.register

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wcartvendor.R
import com.example.wcartvendor.ui.base.BaseActivity
import com.victor.loading.rotate.RotateLoading
import kotlinx.android.synthetic.main.activity_register.*

class RegisterFirstStepActivity : BaseActivity(), View.OnClickListener{

    val viewModel by lazy { ViewModelProvider(this).get(RegisterViewModel::class.java) }
    var countryCode=ArrayList<String?>()
    private lateinit var dialog:Dialog

    private val countryCodeAdapter by lazy{ CountryCodeAdapter(this,countryCode,object:
        CountryCodeAdapter.ItemClickInterfaces{
        override fun itemClick(id: String?) {
            newInstance(countryWithCode[id])
            dialog.dismiss()
        }
    })
    }
    private var countryWithCode:MutableMap<String,String>
        get() {
           return viewModel.getCountryCode()
        }
        set(value) {}
    var cusRotateLoading: RotateLoading? = null
    private var progressDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        progressDialog = Dialog(this@RegisterFirstStepActivity, android.R.style.Theme_Translucent_NoTitleBar)
        progressDialog?.setContentView(R.layout.custom_progress_dialog)
        cusRotateLoading = progressDialog?.findViewById<View>(R.id.rotateloading_register) as RotateLoading
        et_first_name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(edit: Editable?) {
                viewModel.firstName = edit.toString().trim()
            }
        })
        et_last_name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(edit: Editable?) {
                viewModel.lastName = edit.toString().trim()
            }
        })
        et_sign_up_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.eMail = s.toString().trim()
            }
        })
        et_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.password = s.toString().trim()
            }
        })
        et_confirm_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.confirmPassword = s.toString().trim()
            }
        })
        et_mobile_no.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.mobileNumber = s.toString().trim()
            }
        })
        et_address_one.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.address1 = s.toString().trim()
            }
        })
        et_address_two.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.address2 = s.toString().trim()
            }
        })
        et_city.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.city = s.toString().trim()
            }
        })
        et_state.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.state = s.toString().trim()
            }
        })
        et_country.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.country = s.toString().trim()
            }
        })
        tv_back.setOnClickListener(this)
        tv_already_user.setOnClickListener(this)
        btn_signup.setOnClickListener(this)
        tv_country_code.setOnClickListener(this)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
        viewModel.progressBar.observe(this, Observer {
            if (it) {
                progressDialog?.show()
            } else {
                progressDialog?.cancel()
                cusRotateLoading?.stop()
            }
        })
        viewModel.responseSuccess.observe(this, Observer {
            startActivity(Intent(this@RegisterFirstStepActivity, RegistrationSecondStepActivity::class.java))
        })
    }

    private fun goBackMethod() {
      this@RegisterFirstStepActivity.finish()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_signup -> {
                viewModel.validation()
            }
            R.id.tv_already_user -> {
                goBackMethod()
            }
            R.id.tv_back -> {
                goBackMethod()
            }
            R.id.tv_country_code->{
                val newList=ArrayList<String?>()
                for(i in countryWithCode){
                    newList.add(i.key)
                }
                countryCode.clear()
                countryCode.addAll(newList)
                val dialogBuilder = AlertDialog.Builder(this@RegisterFirstStepActivity)
                var rcvDialog = RecyclerView(this@RegisterFirstStepActivity)
                rcvDialog.adapter =countryCodeAdapter //DialogAdapter create by your self
                rcvDialog.layoutManager = LinearLayoutManager(this@RegisterFirstStepActivity)
                dialogBuilder.setView(rcvDialog)
                dialog= dialogBuilder.create()
                dialog.show()
            }
        }
    }

    fun newInstance(countryName:String?){
        val zipCode=getCountryZipCode(countryName)
        tv_country_code.text= "+$zipCode"
    }

    private fun getCountryZipCode(code:String?): String? {
        var CountryID = ""
        var CountryZipCode = ""


        CountryID = code.toString()
        val rl: Array<String> = this.resources.getStringArray(R.array.CountryCodes)
        for (i in rl.indices) {
            val g = rl[i].split(",").toTypedArray()
            if (g[1].trim { it <= ' ' } == CountryID.trim { it <= ' ' }) {
                CountryZipCode = g[0]
                break
            }
        }
        return CountryZipCode
    }
}