package com.example.wcartvendor.ui.login

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.wcartvendor.R
import com.example.wcartvendor.ui.base.BaseActivity
import com.example.wcartvendor.ui.home.HomeActivity
import com.example.wcartvendor.ui.register.RegisterFirstStepActivity
import com.victor.loading.rotate.RotateLoading
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),View.OnClickListener{
    var cusRotateLoading: RotateLoading? = null
    var progressDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressDialog = Dialog(this@LoginActivity, android.R.style.Theme_Translucent_NoTitleBar)
        progressDialog?.setContentView(R.layout.custom_progress_dialog)
        cusRotateLoading = progressDialog?.findViewById<View>(R.id.rotateloading_register) as RotateLoading
        btn_facebook_login.setOnClickListener(this)
        btn_google_login.setOnClickListener(this)
        btn_normal_login.setOnClickListener(this)
        tv_create_account.setOnClickListener(this)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle(resources.getString(R.string.exit))
                .setMessage(resources.getString(R.string.alert_exit))
                .setNegativeButton(resources.getString(R.string.txt_cancel), null)
                .setPositiveButton(resources.getString(R.string.txt_ok)) { arg0, arg1 -> //  HomeActivity.super.onBackPressed();
                    val a = Intent(Intent.ACTION_MAIN)
                    a.addCategory(Intent.CATEGORY_HOME)
                    a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(a)
                }.create().show()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_facebook_login->{

            }
            R.id.btn_google_login->{

            }
            R.id.btn_normal_login->{
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.tv_create_account->{
                val intent = Intent(this@LoginActivity, RegisterFirstStepActivity::class.java)
                startActivity(intent)
            }
        }
    }
}