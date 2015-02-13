package net.funol.multiphotopicker.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import net.funol.multiphotopicker.R;

public abstract class CustomTitleBarActivity extends Activity {

    protected TextView mTitleBarBack;
    protected TextView mTitleBarTitle;
    protected Button mTitleBarFunction;

    private OnTitleBarViewClickListener titleBarOnClickListener = new OnTitleBarViewClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_custom_title_bar);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);

        mTitleBarBack = (TextView) findViewById(R.id.title_bar_back);
        mTitleBarBack.setOnClickListener(titleBarOnClickListener);
        mTitleBarTitle = (TextView) findViewById(R.id.title_bar_title);
        mTitleBarTitle.setOnClickListener(titleBarOnClickListener);
        mTitleBarFunction = (Button) findViewById(R.id.title_bar_function);
        mTitleBarFunction.setOnClickListener(titleBarOnClickListener);
    }

    private class OnTitleBarViewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.title_bar_back:
                    onBackClicked(v);
                    break;
                case R.id.title_bar_title:
                    onTitleClicked(v);
                    break;
                case R.id.title_bar_function:
                    onFunctionClicked(v);
                    break;
            }
        }
    }

    protected abstract void onBackClicked(View view);

    protected abstract void onTitleClicked(View view);

    protected abstract void onFunctionClicked(View view);

}