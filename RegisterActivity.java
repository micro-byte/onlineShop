package co.ke.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText Email, Phone, Password;
    private TextView login, reset;
    private Button register;
    ProgressBar progressBar_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //CASTING
        Email = findViewById(R.id.EditText_Email);
        Phone = findViewById(R.id.EditText_Phone);

        Password = findViewById(R.id.EditText_Password);
        login = findViewById(R.id.TextView_Login);
        reset = findViewById(R.id.TextView_Reset);
        progressBar_register = findViewById(R.id.ProgressBar_Register);
        register = findViewById(R.id.Button_Register);
        mAuth = FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, CategoryActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        register.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser() {
        String email = Email.getText().toString().trim();
        String phone = Phone.getText().toString().trim();
        String password = Password.getText().toString().trim();
        if (TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please prrovide a valid email");
            Email.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Password.setError("Password cannot be less than 6 characters!");
            Password.requestFocus();
            return;
        }
        if (Password.length() < 6) {
            Password.setError("Password should not be less than 6 characters");
            Password.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            Phone.setError("A Valid Phone number is required");
            Phone.requestFocus();
            return;
        }
        if (Phone.length() < 10) {
            Phone.setError("Phone number should not be less than 10 characters");
            Phone.requestFocus();
            return;
        } else {
            progressBar_register.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        //send email to send verification
                        Toast.makeText(getApplicationContext(), "Registration succesful!", Toast.LENGTH_LONG).show();
                        progressBar_register.setVisibility(View.INVISIBLE);


                    } else {
                        progressBar_register.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "Registration failed, please try next time", Toast.LENGTH_LONG).show();
                    }
                    if (task.isSuccessful()) {
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                }
            });
        }
    }
}
    /*private void loginuser() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }*/

//TODO add Users object to store
