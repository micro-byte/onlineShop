/*package co.ke.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BottomSheetExample extends AppCompatActivity implements BottomSheetDialogg.BottomSheetListener {
private TextView mtextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_bottom_sheet);
        mtextview = findViewById(R.id.TextView_Button_Clicked);
        Button buttoOpenBottomSheet = findViewById(R.id.Button_Open_ButtonSheet);
        buttoOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogg bottomsheet = new BottomSheetDialogg();
                bottomsheet.show(getSupportFragmentManager(), "Example BottomSheet");

            }
        });
    }
    @Override
    public void onButtonClicked(String text){
        mtextview.setText(text);
    }
}
//TODO implement the inquire option where you send a mail attached to the inquire button in the slide
// A long text box giving specs
//Save Option where you save your seletion
*/