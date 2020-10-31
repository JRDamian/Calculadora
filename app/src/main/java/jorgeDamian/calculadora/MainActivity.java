package jorgeDamian.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nro1, nro2;
    RadioButton rBSuma, rBResta, rBMultiplicacion, rBDivision;
    Button btnCalcular;
    TextView tVRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nro1 = findViewById(R.id.eTN1);
        nro2 = findViewById(R.id.eTN2);
        rBSuma = findViewById(R.id.rBSuma);
        rBResta = findViewById(R.id.rBResta);
        rBMultiplicacion = findViewById(R.id.rBMultiplicacion);
        rBDivision = findViewById(R.id.rBDivision);
        btnCalcular = findViewById(R.id.btnCalcular);
        tVRespuesta = findViewById(R.id.tVRespuesta);

       btnCalcular.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (nro1.getText().toString().length() < 1) {
                   Toast.makeText(getApplicationContext(), "Ingrese un operador en el primer campo", Toast.LENGTH_LONG).show();

               } else if (nro2.getText().toString().length() < 1) {
                   Toast.makeText(getApplicationContext(), "Ingrese un operador en el segundo campo", Toast.LENGTH_LONG).show();
               } else {
                   if (rBSuma.isChecked()) {
                       tVRespuesta.setText(suma(Double.parseDouble(nro1.getText().toString()), Double.parseDouble(nro2.getText().toString())) + "");
                   }
                   if (rBResta.isChecked()) {
                       tVRespuesta.setText(resta(Double.parseDouble(nro1.getText().toString()), Double.parseDouble(nro2.getText().toString())) + "");
                   }
                   if (rBMultiplicacion.isChecked()) {
                       tVRespuesta.setText(multiplicacion(Double.parseDouble(nro1.getText().toString()), Double.parseDouble(nro2.getText().toString())) + "");
                   }
                   if (rBDivision.isChecked()) {
                       if (division(Double.parseDouble(nro1.getText().toString()), Double.parseDouble(nro2.getText().toString())) == 0.0) {
                           tVRespuesta.setText("ERROR. Imposible dividir por cero!");
                       } else {
                           tVRespuesta.setText(division(Double.parseDouble(nro1.getText().toString()), Double.parseDouble(nro2.getText().toString())) + "");

                       }
                   }


               }

           }

           ;


           public Double suma(Double a, Double b) {
               return a + b;
           }

           public Double resta(Double a, Double b) {
               return a - b;
           }

           public Double multiplicacion(Double a, Double b) {
               return a * b;
           }

           public Double division(Double a, Double b) {
               Double respuesta = 0.0;

               if (b != 0) {
                   respuesta = a / b;
               }

               return respuesta;
           }
       });
    }
}