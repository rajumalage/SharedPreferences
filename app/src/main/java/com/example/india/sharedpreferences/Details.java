package com.example.india.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Details extends Activity implements OnClickListener {
    private SharedPreferences sp;
    String us,ps,dob,cont,email;
    EditText editUserName,editPass,editDob,editCont,editEmail;
    Button sgBtn;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        sp=this.getSharedPreferences("Login", MODE_WORLD_READABLE);
        us=sp.getString("USERNAME", "");
        ps=sp.getString("PASSWORD", "");
        dob=sp.getString("DOB", "");
        cont=sp.getString("CONTACT", "");
        email=sp.getString("EMAIL", "");
        editUserName=(EditText)findViewById(R.id.editUserName);
        editPass=(EditText)findViewById(R.id.editPass);
        editDob=(EditText)findViewById(R.id.editDob);
        editCont=(EditText)findViewById(R.id.editCont);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editUserName.setText(us);
        editPass.setText(ps);
        editDob.setText(dob);
        editCont.setText(cont);
        editEmail.setText(email);
        sgBtn=(Button)findViewById(R.id.sgBtn);
        sgBtn.setOnClickListener(this);

    }


    public void onClick(View arg0) {

        Intent i;
        i=new Intent(this,Login.class);
        startActivity(i);


    }


}