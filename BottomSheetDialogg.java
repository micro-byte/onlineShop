package co.ke.onlineshop;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetDialogg extends BottomSheetDialogFragment {
    //create member variable for the listener

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.bottom_sheetdialogg_layout,
                container, false);
        Button button1 = v.findViewById(androidx.core.R.id.dialog_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "BUY", Toast.LENGTH_SHORT).show();
                dismiss();
                //call our button clicked interface
            }
        });
        return v;
    }
}

    /*
    //creating interface called bottomsheet listener
 public interface BottomSheetListener{
        //putting a method to call both buttons
        void onButtonClicked(String text);
        //sendin strin with which button was clicked
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {

        //We have to implement this interface in our main activity
        mlistener = (BottomSheetListener) context;
    }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement BottomSheetListener");
        }
        }
}
*/