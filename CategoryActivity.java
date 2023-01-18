package co.ke.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {
private ImageView cruiser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        cruiser = findViewById(R.id.cruiser);
        cruiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogg bottomsheet = new BottomSheetDialogg();
                bottomsheet.show(getSupportFragmentManager(),
                        "INGUIRING");
            }
        });
    }
}