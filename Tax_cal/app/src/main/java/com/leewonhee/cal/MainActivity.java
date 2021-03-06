package com.leewonhee.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    int v_all_day;
    String v_resultText;
    int all_famliy_addition;
    float result_price;
    float v_all_price;
    int v_input_201;
    int v_input_101;
    int v_input_102;
    int v_input_B01;
    int v_input_B02;
    int v_input_B03;
    int v_input_B04;
    
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner_Family);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.day_family, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        Button btn1 = (Button)findViewById(R.id.all_cal);
        Button btn2 = (Button)findViewById(R.id.day_cal);


        EditText all_price = (EditText)findViewById(R.id.all_price);
        EditText all_day = (EditText)findViewById(R.id.all_Day);
        EditText input_201 = (EditText)findViewById(R.id.input_21);
        EditText input_101 = (EditText)findViewById(R.id.input_11);
        EditText input_102 = (EditText)findViewById(R.id.input_12);
        EditText input_B01 = (EditText)findViewById(R.id.input_b1);
        EditText input_B02 = (EditText)findViewById(R.id.input_b2);
        EditText input_B03 = (EditText)findViewById(R.id.input_b3);
        EditText input_B04 = (EditText)findViewById(R.id.input_b4);
        EditText day_Input = (EditText)findViewById(R.id.day_Input);
        TextView resultText = (TextView)findViewById(R.id.resultText);











        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // resultText.setText(v_resultText);
                v_all_price = Float.parseFloat(all_price.getText().toString());
                v_all_day = Integer.parseInt(all_day.getText().toString());
                 v_input_201 = Integer.parseInt(input_201.getText().toString());
                 v_input_101 = Integer.parseInt(input_101.getText().toString());
                 v_input_102 = Integer.parseInt(input_102.getText().toString());
                 v_input_B01 = Integer.parseInt(input_B01.getText().toString());
                 v_input_B02 = Integer.parseInt(input_B02.getText().toString());
                 v_input_B03 = Integer.parseInt(input_B03.getText().toString());
                 v_input_B04 = Integer.parseInt(input_B04.getText().toString());

                all_famliy_addition = v_input_201 + v_input_101 + v_input_102 + v_input_B01 + v_input_B02 + v_input_B03 + v_input_B04;
                result_price = v_all_price/all_famliy_addition;
                float f_input_201 = result_price*v_input_201;
                float f_input_101 = result_price*v_input_101;
                float f_input_102 = result_price*v_input_102;
                float f_input_B01 = result_price*v_input_B01;
                float f_input_B02 = result_price*v_input_B02;
                float f_input_B03 = result_price*v_input_B03;
                float f_input_B04 = result_price*v_input_B04;

                v_resultText = "1?????? ????????? ??? : " + (int)result_price + "???, ?????? : ???"+(result_price/v_all_day)+"?????????\n????????? ?????????\n201??? : "+ (int)f_input_201+"???" +
                        "\t, 101??? :"+(int)f_input_101+"???" + "\n102??? : "+(int)f_input_102+"???" + "" + "\t, b01??? : " +(int)f_input_B01+"???"+
                        "\nb02??? : "+(int)f_input_B02+"???"+"\t, b03??? : "+(int)f_input_B03+"???"+"\nb04??? : "+(int)f_input_B04+"???"+" ?????????.";

                resultText.setText(v_resultText);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v_day_Input = Integer.parseInt(day_Input.getText().toString());
                v_all_day = Integer.parseInt(all_day.getText().toString());
                result_price = v_all_price/all_famliy_addition;
                v_input_201 = Integer.parseInt(input_201.getText().toString());
                v_input_101 = Integer.parseInt(input_101.getText().toString());
                v_input_102 = Integer.parseInt(input_102.getText().toString());
                v_input_B01 = Integer.parseInt(input_B01.getText().toString());
                v_input_B02 = Integer.parseInt(input_B02.getText().toString());
                v_input_B03 = Integer.parseInt(input_B03.getText().toString());
                v_input_B04 = Integer.parseInt(input_B04.getText().toString());


                float val = (result_price/v_all_day);
                float val2 = 0;
                float val3=0;
                switch (spinner.getSelectedItem().toString()){
                    case "201":
                        val2=(val*v_day_Input)*v_input_201;
                        break;
                    case "101":
                        val2=(val*v_day_Input)*v_input_101;
                        break;
                    case "102":
                        val2=(val*v_day_Input)*v_input_102;
                        break;
                    case "B01":
                        val2=(val*v_day_Input)*v_input_B01;
                        break;
                    case "B02":
                        val2=(val*v_day_Input)*v_input_B02;
                        break;
                    case "B03":
                        val2=(val*v_day_Input)*v_input_B03;
                        break;
                    case "B04":
                        val2=(val*v_day_Input)*v_input_B04;
                        break;
                    default:
                        break;
                }
                val3 =(v_all_price-val2);
                v_resultText = "?????? : ??? "+val+"??? ????????? "+spinner.getSelectedItem()+"?????? "+v_day_Input+"?????? ????????? \n"+val2+"??? ?????????. ????????? ????????? "+val3+"??? ?????????.\n"
                +spinner.getSelectedItem()+"?????? 0?????? ???????????? ???????????? ???????????? ??????????????????.";

                resultText.setText(v_resultText);

            }
        });

    }
}