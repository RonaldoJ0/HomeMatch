package br.com.pdm.unemat.homematch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText nome, email, pwd;

    Button registerButton;

    public static final String MYPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nome = findViewById(R.id.nomeEditText);
        email = findViewById(R.id.emailEditText);
        pwd = findViewById(R.id.senhaEditText);

        registerButton = findViewById(R.id.registerButton);

        SharedPreferences sharedPreferences = getSharedPreferences(MYPREFERENCES, 0);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeLocal = nome.getText().toString();
                String emailLocal = email.getText().toString();
                String senhaLocal = pwd.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("nome", nomeLocal);
                editor.putString("email", emailLocal);
                editor.putString("senha", senhaLocal);

                editor.commit();

                Toast.makeText(RegisterActivity.this, "Dados Cadastrados no arquivo .xml com sucesso!!!", Toast.LENGTH_LONG).show();

                onBackPressed();
            }
        });
    }
}