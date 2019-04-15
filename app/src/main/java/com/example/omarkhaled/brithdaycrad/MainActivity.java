package com.example.omarkhaled.brithdaycrad;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quanity =2;
    public void incrment( View view) {
        if (quanity == 100) {
            Toast.makeText(this, "the number can't be more than 100", Toast.LENGTH_SHORT).show();
        } else {
            quanity++;
            display(quanity);
        }
    }
    public void decrment(View view) {
        if (quanity == 1) {
            Toast.makeText(this, "the number can't be nagtive", Toast.LENGTH_SHORT).show();
        } else {
            quanity--;
            display(quanity);
        }
    }
    public void submit(View view){
        int m= quanity*5;
        CheckBox vanlia = (CheckBox)findViewById(R.id.vanlia);
        boolean van = vanlia.isChecked();
        if (van){
            m+=quanity*1;
        }
        CheckBox chocla = (CheckBox)findViewById(R.id.chocla);
        boolean choc = chocla.isChecked();
        if (choc){
            m+=quanity*2;
        }
        EditText namefield = (EditText) findViewById(R.id.name_filed);
        String name = namefield.getText().toString();
        String massage =  displaymassage(m,name,van,choc);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT,massage );
        intent.putExtra(Intent.EXTRA_SUBJECT,"just for anything");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
    public  void display(int num){
        TextView textView = findViewById(R.id.text1);
        textView.setText(""+num);
    }
    public String displaymassage (int num , String name ,boolean vainla , boolean choc ){
        String mass = "welcome  "+name;
        mass+="\n the vanlia option is "+vainla;
        mass+="\n the choclate is "+choc;
        mass+="\n the total price is "+num +"$";
        mass+=" \n thank you";
       return mass;
    }
}
