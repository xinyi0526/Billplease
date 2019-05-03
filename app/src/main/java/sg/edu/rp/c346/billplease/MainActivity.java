package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView total;
    TextView pax;
    TextView GST;
    ToggleButton GST1;
    TextView SVC;
    ToggleButton SVC1;
    Button calculate;
    TextView payment;
    TextView payperperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.billAmtInput);
        pax = findViewById(R.id.noOfPaxInput);
        GST = findViewById(R.id.gst);
        GST1 = findViewById(R.id.toggleButtonGST);
        SVC = findViewById(R.id.svc);
        SVC1 = findViewById(R.id.toggleButtonSVC);
        payment = findViewById(R.id.pay);
        payperperson = findViewById(R.id.payment);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ave;
                total.getText().toString();
                pax.getText().toString();
                int npax = Integer.parseInt(pax.getText().toString());
                double amt = Double.parseDouble(total.getText().toString());

                if(SVC1.isChecked()==true){
                    amt = amt * 1.10;
                }
                if(GST1.isChecked()==true){
                    amt = amt * 1.07;
                }

                ave = amt/npax;
                String payment = ave +"";
                payperperson.setText(payment);



            }
        });

    }
}
