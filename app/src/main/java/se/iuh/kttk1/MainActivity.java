package se.iuh.kttk1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB, txtC, txtKq;
    Button btnGiai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);
        txtKq = findViewById(R.id.txtKq);
        btnGiai = findViewById(R.id.btnGiai);
    }

    private void addEvents() {
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                double c = Double.parseDouble(txtC.getText().toString());
                double kq, x1, x2, delta;
                DecimalFormat df = new DecimalFormat("0.#");
                if(a==0)
                    if(b==0)
                        if(c==0)
                            txtKq.setText("Phương trình vô số nghiệm");
                        else
                            txtKq.setText("Phương trình vô nghiệm");
                    else{
                        kq = -c*1.0/b;
                        txtKq.setText(Double.toString(kq));
                    }
                else{
                    delta = b*b-4*a*c;
                    if(delta<0)
                        txtKq.setText("Phương trình vô nghiệm");
                    else if(delta==0){
                        x1 = x2 = -b*1.0/2*a;
                        txtKq.setText("x1 = x2 = "+Double.toString(x1));
                    }
                    else{
                        x1 = -b*1.0+Math.sqrt(delta)/(2*a);
                        x2 = -b*1.0-Math.sqrt(delta)/(2*a);
                        txtKq.setText("x1 = "+Double.toString(Double.parseDouble(df.format(x1))) + "\n x2 = "+Double.toString(Double.parseDouble(df.format(x2))));
                    }
                }
            }
        });
    }
}
