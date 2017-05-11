package com.example.india.sharedpreferences;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity implements OnClickListener
{
    private SharedPreferences sp;
    Intent i;
    Button SButton,EButton;
    EditText editUserName,editPass,editCPass,editDob,editContact,editEmail;
    String user,pass,cpass,chk,dob,cont,email;
    CheckBox checkBox;
    String stat="a";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        editUserName=(EditText)findViewById(R.id.editUserName);
        editDob=(EditText)findViewById(R.id.editDob);
        editContact=(EditText)findViewById(R.id.editContact);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editPass=(EditText)findViewById(R.id.editPass);
        editCPass=(EditText)findViewById(R.id.editCPass);
        SButton=(Button)findViewById(R.id.sgBtn);
        EButton=(Button)findViewById(R.id.exBtn);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        SButton.setOnClickListener(this);
        EButton.setOnClickListener(this);
        sp=this.getSharedPreferences("Login", MODE_WORLD_READABLE);
        chk=sp.getString("USERNAME", "");
        if(chk.length()!=0){
            sp=getSharedPreferences("Login",MODE_WORLD_WRITEABLE);
            Editor myEditor=sp.edit();
            myEditor.putString("Status", stat);
            myEditor.commit();

            i=new Intent(this,Login.class);
            startActivity(i);
        }
    }
    public void onClick(View arg0) {
        user=editUserName.getText().toString();
        pass=editPass.getText().toString();
        cpass=editCPass.getText().toString();
        dob=editDob.getText().toString();
        cont=editContact.getText().toString();
        email=editEmail.getText().toString();
        if(arg0==SButton){

            if(checkBox.isChecked()){

                if((user.length()!=0))
                {
                    if(dob.length()!=0)
                    {
                        if(cont.length()!=0) {
                            if (email.length() != 0) {
                                if ((pass.length() != 0)) {
                                    if (pass.compareTo(cpass) == 0) {
                                        sp = getSharedPreferences("Login", MODE_WORLD_WRITEABLE);
                                        Editor myEditor = sp.edit();
                                        myEditor.putString("USERNAME", user);
                                        myEditor.putString("PASSWORD", pass);
                                        myEditor.putString("DOB", dob);
                                        myEditor.putString("CONTACT", cont);
                                        myEditor.putString("EMAIL", email);
                                        myEditor.commit();
                                        Toast.makeText(this, "Registration is successfull", Toast.LENGTH_LONG).show();
                                        i = new Intent(this, Login.class);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(this, "Password Mismatch", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(this, "Please Enter password", Toast.LENGTH_LONG).show();

                                }
                            } else {
                                Toast.makeText(this, "Please Enter Email ID", Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(this, "Please Enter Contact Number", Toast.LENGTH_LONG).show();
                        }
                    }

                    else {
                        Toast.makeText(this, "Please Enter DOB", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(this,"Please Enter Username",Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this, "Please Accept all our terms and conditions", Toast.LENGTH_LONG).show();
            }
        }
        else if(arg0==EButton){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Exit");
            builder.setMessage("Do you want to exit");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

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
            AlertDialog alert=builder.create();
            alert.show();

        }
    }
}
