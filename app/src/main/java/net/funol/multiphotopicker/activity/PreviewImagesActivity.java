package net.funol.multiphotopicker.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.funol.multiphotopicker.R;
import net.funol.multiphotopicker.adapter.PreviewImagesAdapter;

public class PreviewImagesActivity extends CustomTitleBarActivity {

    private ViewPager mImagesPager;

    private PreviewImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_images);
        
        initViews();
    }

    private void initViews() {
        mTitleBarTitle.setText("");

        mImagesPager = (ViewPager) findViewById(R.id.preview_images_pager);
        adapter = new PreviewImagesAdapter();
        mImagesPager.setAdapter(adapter);

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

}
