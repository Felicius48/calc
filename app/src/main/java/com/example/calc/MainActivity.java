package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    TextView resfield;
    String oper;
    public Button rass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        bt1 = findViewById(R.id.oneBt1);
        bt2 = findViewById(R.id.oneBt2);
        bt3 = findViewById(R.id.oneBt3);
        bt4 = findViewById(R.id.oneBt4);
        resfield = findViewById(R.id.resField);
        rass = findViewById(R.id.btRasschet);

        rass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());
                int res;

                if (oper.equals("+")){

                    res = a + b;
                    String r = Integer.toString(res);
                    String a1 = Integer.toString(a);
                    String a2 = Integer.toString(b);
                    resfield.setText(a +" + " + b + " = " + r);
                }
                if (oper.equals("-")){
                    res = a - b;
                    String r = Integer.toString(res);
                    String a1 = Integer.toString(a);
                    String a2 = Integer.toString(b);
                    resfield.setText(a +"-" + b + " = " + r);
                }
                if (oper.equals("*")){
                    res = a * b;
                    String r = Integer.toString(res);
                    String a1 = Integer.toString(a);
                    String a2 = Integer.toString(b);
                    resfield.setText(a +"*" + b + " = " + r);
                }
                if (oper.equals("/")){
                    res = a / b;
                    String r = Integer.toString(res);
                    String a1 = Integer.toString(a);
                    String a2 = Integer.toString(b);
                    resfield.setText(a +"/" + b + " = " + r);
                }
                if (num1 == null){
                }
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
           getMenuInflater().inflate(R.menu.main_menu, menu);
           return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
           int id = item.getItemId();
           if (id == R.id.action_show){
               Toast toast = Toast.makeText(this, "Message Error", Toast.LENGTH_LONG);
               toast.show();
               return true;
           }
           if (id == R.id.action_close){
               Snackbar snackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Вы точно хотите выйти?", Snackbar.LENGTH_LONG);

               snackbar.setAction("Да...", new View.OnClickListener (){
                   @Override
                   public void onClick(View v) {
                       finish();
                   }
               });
               snackbar.show();


           }
           return super.onOptionsItemSelected(item);
    }

    public void click(View view){
        Button button = (Button) view;
        String op = button.getText().toString();
            if (op.equals("+")){
                Toast toast = Toast.makeText(this, "Вы выбрали сложение!", Toast.LENGTH_SHORT);
                toast.show();
            }
            if (op.equals("-")){
                Toast toast = Toast.makeText(this, "Вы выбрали вычитание!", Toast.LENGTH_SHORT);
                toast.show();
            }
            if (op.equals("*")){
                Toast toast = Toast.makeText(this, "Вы выбрали умножение!", Toast.LENGTH_SHORT);
                toast.show();
            }
            if (op.equals("/")){
                Toast toast = Toast.makeText(this, "Вы выбрали деление!", Toast.LENGTH_SHORT);
                toast.show();
            }

        oper = op;

    }


    public void btClear(View view){
           resfield.setText("");
           num1.setText("");
           num2.setText("");
    }


}