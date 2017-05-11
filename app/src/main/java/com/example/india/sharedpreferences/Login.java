package com.example.india.sharedpreferences;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
    private SharedPreferences sp;
    String user, pass, cont;
    Button sgBtn, exBtn, edtReg;
    EditText editUserName, editPass;
//    String PREFS_NAME = "com.example.india.sharedpreferences.Login";
    int flag = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        sgBtn = (Button) findViewById(R.id.sgBtn);
        exBtn = (Button) findViewById(R.id.exBtn);
        edtReg = (Button) findViewById(R.id.edtReg);

        editUserName = (EditText) findViewById(R.id.editUserName);
        editPass = (EditText) findViewById(R.id.editPass);
        sgBtn.setOnClickListener(this);
        edtReg.setOnClickListener(this);
    }
//        sp = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
//        if (sp.getString("logged", "").toString().equals("logged")) {
//            Intent i = new Intent(Login.this, BoardingActivity.class);
//            i.putExtra("USERNAME", sp.getString("username", "").toString());
//            i.putExtra("PASSWORD", sp.getString("password", "").toString());
//            i.putExtra("CHECK", true);
//            startActivity(i);
//
//        }
//        sgBtn.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                if (!editUserName.getText().toString().equals("") && (!editPass.getText().equals(""))) {
//
//                        SharedPreferences.Editor editor = sp.edit();
//                        editor.putString("username", editUserName.getText().toString());
//                        editor.putString("password", editPass.getText().toString());
//                        editor.putString("logged", "logged");
//                        editor.commit();
//
//                    Intent i = new Intent(Login.this, BoardingActivity.class);
//                    i.putExtra("USERNAME", editUserName.getText().toString());
//                    i.putExtra("PASSWORD", editPass.getText().toString());
//
//                    startActivity(i);
//                } else {
//                    Toast.makeText(Login.this, "Please enter both the fields.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }

    public void onClick(View arg0) {

        sp = this.getSharedPreferences("Login", MODE_WORLD_READABLE);
        user = sp.getString("EMAIL", "");
        cont = sp.getString("CONTACT", "");
        pass = sp.getString("PASSWORD", "");
        if (sgBtn == arg0) {
            if ((editUserName.getText().toString().compareTo(user) == 0) || (editUserName.getText().toString().compareTo(cont) == 0)  &&
                    (editPass.getText().toString().compareTo(pass) == 0))
            {
                Toast.makeText(this, "You are Logged In", Toast.LENGTH_LONG).show();
                flag = 1;
                Intent i = new Intent(Login.this, BoardingPassActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "Wrong Username or Password/Create Your Account First", Toast.LENGTH_LONG).show();
                flag = 0;
            }

        } else if (edtReg==arg0) {
            Intent i = new Intent(Login.this, Registration.class);
            startActivity(i);
        }
        else if (exBtn == arg0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit");
            builder.setMessage("Do you want to exit");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
