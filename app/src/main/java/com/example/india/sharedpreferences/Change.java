package com.example.india.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Change extends Activity implements OnClickListener {
    EditText editOldPass,editNewPass,editCPass;
    Button sgBtn,exBtn;
    private SharedPreferences sp;
    String pass;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        editOldPass=(EditText)findViewById(R.id.editOldPass);
        editNewPass=(EditText)findViewById(R.id.editNewPass);
        editCPass=(EditText)findViewById(R.id.editCPass);
        sp=this.getSharedPreferences("Login", MODE_WORLD_READABLE);
        pass=sp.getString("PASSWORD", "");
        editOldPass.setText(pass);
        sgBtn=(Button)findViewById(R.id.sgBtn);
        exBtn=(Button)findViewById(R.id.exBtn);
        sgBtn.setOnClickListener(this);
        exBtn.setOnClickListener(this);
    }

    public void onClick(View arg0) {
        String p=editNewPass.getText().toString();
        String c=editCPass.getText().toString();
        sp=getSharedPreferences("Login", MODE_WORLD_WRITEABLE);
        Editor myeditor=sp.edit();
        if(arg0==sgBtn){
            if(p.compareTo(c)==0){
                //myeditor.remove("PASSWORD");
                myeditor.putString("PASSWORD", p);
                myeditor.commit();
                Toast.makeText(this, "Password Changed", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this,Login.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Password Mismatch", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Intent i=new Intent(this,Login.class);
            startActivity(i);
        }
    }



}