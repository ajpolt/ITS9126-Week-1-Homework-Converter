package com.adampolt.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity converts weights between pounds and kilograms
 */
public class MainActivity extends AppCompatActivity {
    //Constant variables for conversions:
    private static final double KGS_TO_LBS = 2.20462;
    private static final double LBS_TO_KGS = 0.453592;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //The first line in onCreate must be super.onCreate()
        super.onCreate(savedInstanceState);

        //The Activity should use the layout file we worked on
        setContentView(R.layout.activity_main);

        //Get references to all of our buttons and text views:
        Button calulate = findViewById(R.id.calculate);
        //(These ones are referenced in our onClickListener so they need to be final):
        final EditText kgsField = findViewById(R.id.kgField);
        final EditText lbsField = findViewById(R.id.lbField);
        final TextView lbsResult = findViewById(R.id.lbsResult);
        final TextView kgsResult = findViewById(R.id.kgResult);

        //Set up an onClickListener that does the conversions
        calulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If the fields are empty, put zeroes into them
                if(kgsField.getText().toString().equals("")) {
                    kgsField.setText("0");
                }

                if(lbsField.getText().toString().equals("")) {
                    lbsField.setText("0");
                }

                //Put everything in a try/catch block so we can display an error if something goes
                //wrong (for example, if the value isn't a number)
                try {
                    //Get the values from the EditText fields
                    double kgsInput = Double.parseDouble(kgsField.getText().toString());
                    double lbsInput = Double.parseDouble(lbsField.getText().toString());

                    //Convert the decimal numbers to KGS or LBS
                    double resultInLbs = kgsInput * KGS_TO_LBS;
                    double resultInKgs = lbsInput * LBS_TO_KGS;

                    //Display the results (converting back to Strings)
                    lbsResult.setText(String.valueOf(resultInKgs));
                    kgsResult.setText(String.valueOf(resultInLbs));
                } catch (Exception e) {
                    //If an exception gets caught, display a message using Toast
                    Toast.makeText(MainActivity.this, "Something went wrong. Make sure all fields are filled in with numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
