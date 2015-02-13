package net.funol.multiphotopicker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.funol.multiphotopicker.R;


public class MainActivity extends CustomTitleBarActivity implements View.OnClickListener{

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mTitleBarFunction.setVisibility(View.GONE);
        mTitleBarBack.setVisibility(View.GONE);
        mTitleBarTitle.setText("照片选择");

        mButton = (Button) findViewById(R.id.main_pick_photo_button);
        mButton.setOnClickListener(this);
    }

    @Override
    protected void onBackClicked(View view) {

    }

    @Override
    protected void onTitleClicked(View view) {

    }

    @Override
    protected void onFunctionClicked(View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_pick_photo_button:
                Intent intent = new Intent();
                intent.setClass(this,MultiPhotoPicker.class);
                startActivity(intent);
                break;
        }
    }
}
