package de.kallifabio.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText nameRegister;
    EditText usernameRegister;
    EditText passwordRegister;
    Button register;

    EditText usernameLogin;
    EditText passwordLogin;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nameRegister = findViewById(R.id.editText1);
        usernameRegister = findViewById(R.id.editText2);
        passwordRegister = findViewById(R.id.editText3);
        register = findViewById(R.id.button1);

        usernameLogin = findViewById(R.id.editText4);
        passwordLogin = findViewById(R.id.editText5);
        login = findViewById(R.id.button2);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameRegister.getText().toString();
                String username = usernameRegister.getText().toString();
                String password = passwordRegister.getText().toString();
                String url = "https://familienfotoswebsite.de/Home/insertAccountData.php";
                String type = "register";
                SaveDataBackground backgroundWorker = new SaveDataBackground(LoginActivity.this);
                backgroundWorker.execute(url, type, name, username, password);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameRegister.getText().toString();
                String username = usernameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                String url = "https://familienfotoswebsite.de/Home/readAccountData.php";
                String type = "login";
                SaveDataBackground backgroundWorker = new SaveDataBackground(LoginActivity.this);
                backgroundWorker.execute(url, type, name, username, password);

                switch (v.getId()) {
                    case R.id.button2:
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                        break;
                }
            }
        });

    }
}