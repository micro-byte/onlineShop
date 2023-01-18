package co.ke.onlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.rpc.context.AttributeContext;

import java.io.DataOutputStream;

public class LoginActivity extends AppCompatActivity {
private EditText email_login, password_login;
private Button button_login;
private TextView textView_forgot_login_password;
private FirebaseAuth mAuth;
private ProgressBar progressBar_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //casting
        email_login = findViewById(R.id.editTextText_Email_Login);
        password_login = findViewById(R.id.editTextText_Password_Login);
        button_login = findViewById(R.id.Button_Login);
        progressBar_login = findViewById(R.id.ProgressBar_Login);
        textView_forgot_login_password = findViewById(R.id.textView_ForgotPassword_Login);
        mAuth = FirebaseAuth.getInstance();
        button_login.setOnClickListener(View -> {
            loginUser();
        });
    }
    public  void loginUser() {
        String email = email_login.getText().toString().trim();
        String password = password_login.getText().toString().trim();
        if (TextUtils.isEmpty(email) && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_login.setError("Please prrovide a valid email");
            email_login.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            password_login.setError("Please prrovide a valid email");
            password_login.requestFocus();
            return;
        } else{

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(), "Logged in successfuly!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, CategoryActivity.class));
                        progressBar_login.setVisibility(View.VISIBLE);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Log in failed, please try again later", Toast.LENGTH_LONG).show();
                        progressBar_login.setVisibility(View.INVISIBLE);
                    }
                }
            });
        //TODO enter mAuth login auth
    }
}
}
    /*public void reset_password(){
        String email = email_login.getText().toString().trim();
        String password = password_login.getText().toString().trim();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(this, OnCompleteListener{
            task ->
                    if(task.isSuccesful)
                    {
                        Toast.makeText(this, "Password reset link sent to your email address", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "Failed to send password reset link", Toast.LENGTH_SHORT).show();
                    }
        });
    }
}
}*/
/*else {
            progressBar_register.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        //send email to send verification
                        Toast.makeText(getApplicationContext(),"Registration succesful!",Toast.LENGTH_LONG).show();
                        progressBar_register.setVisibility(View.INVISIBLE);


                    } else {
                        progressBar_register.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Registration failed, please try next time",Toast.LENGTH_LONG).show();
                    }
                    if (task.isSuccessful()){
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                }
            });
        }*/