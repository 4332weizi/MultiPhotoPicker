package net.funol.multiphotopicker.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.funol.multiphotopicker.R;
import net.funol.multiphotopicker.adapter.PreviewImagesAdapter;

import java.util.List;

public class PreviewImagesActivity extends CustomTitleBarActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private PreviewImagesAdapter adapter;

    private List<Uri> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_images);

        datas = getIntent().getParcelableArrayListExtra("photos");

        initViews();
    }

    private void initViews() {
        mTitleBarTitle.setText("");

        mViewPager = (ViewPager) findViewById(R.id.preview_images_pager);
        adapter = new PreviewImagesAdapter(this);
        adapter.setDatas(datas);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(this);
        updateFunctionButton();
    }

    private void updateFunctionButton() {
        mTitleBarFunction.setText("发送(" + (mViewPager.getCurrentItem() + 1) + "/" + datas.size() + ")");
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        updateFunctionButton();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
