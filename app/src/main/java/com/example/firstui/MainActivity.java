package com.example.firstui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup groupe;
    private EditText cout;
    private Button calculate;
    private TextView result;
    private Switch aSwitch;
    private double montant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cout=findViewById(R.id.cout_de_service);
        groupe=findViewById(R.id.options);
        calculate = findViewById(R.id.calculate_button);
        aSwitch = findViewById(R.id.round_up_switch);
        result = findViewById(R.id.result);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = groupe.getCheckedRadioButtonId();
                double percent = 0;
                if(option==R.id.option1){
                    percent = 0.20;
                } else if (option==R.id.option2) {
                    percent = 0.18;

                } else {
                    percent = 0.15;
                }


                montant = Double.parseDouble
                                (cout.getText().toString()) *
                        percent;
                if
                (aSwitch.isChecked()) {
                    montant = Math.round
                                    (montant * 100.0) / 100.0
                    ;
                }
                result.setText("");
                result.append
                        ("Montant pourboire : " + montant);
            }


        });
    }}