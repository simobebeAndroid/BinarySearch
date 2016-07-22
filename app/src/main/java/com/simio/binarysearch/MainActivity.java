package com.simio.binarysearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] number;
    int i, j, k;

    EditText edtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = new int[]{1, 5, 10, 23, 31, 49, 62, 78, 99, 120};
        i = 0;
        j = number.length - 1;
        k = (i + j) / 2;

        edtInput = (EditText) findViewById(R.id.edtInput);
    }

    private int bs(int num) {
        i = 0;
        j = number.length - 1;
        k = (i + j) / 2;
        if (number[k] == num) return k;
        while (number[k] != num) {
            if (k == i && k == j) {
                return -1;
            } else if(i>k){
                return -1;
            }

            if (number[k] > num) {
                j = k - 1;
            } else {
                i = k + 1;
            }
            k = (i + j) / 2;
        }
        return k;
    }

    public void onSearch(View view) {
        int index = bs(Integer.parseInt(edtInput.getText().toString()));
        Toast.makeText(this, "" + index, Toast.LENGTH_SHORT).show();
    }
}
