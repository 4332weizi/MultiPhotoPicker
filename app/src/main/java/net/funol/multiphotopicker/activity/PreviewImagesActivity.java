package net.funol.multiphotopicker.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import net.funol.multiphotopicker.R;
import net.funol.multiphotopicker.adapter.PreviewImagesAdapter;

import java.util.ArrayList;
import java.util.List;

public class PreviewImagesActivity extends CustomTitleBarActivity implements CompoundButton.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private PreviewImagesAdapter adapter;

    private CheckBox mImageSeletor;

    private ArrayList<Uri> datas;
    private boolean[] isImageSelected;
    private int selectedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_images);

        datas = (ArrayList) getIntent().getParcelableArrayListExtra("photos");
        selectedCount = datas.size();
        isImageSelected = new boolean[datas.size()];
        for (int i = 0; i < isImageSelected.length; i++) {
            isImageSelected[i] = true;
        }

        initViews();
    }

    private void initViews() {
        mTitleBarTitle.setText("");

        mImageSeletor = (CheckBox) findViewById(R.id.preview_images_selector);
        mImageSeletor.setOnCheckedChangeListener(this);

        mViewPager = (ViewPager) findViewById(R.id.preview_images_pager);
        adapter = new PreviewImagesAdapter(this);
        adapter.setDatas(datas);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(this);
        updateFunctionButton();
    }

    private void updateFunctionButton() {
        mTitleBarFunction.setText("发送(" + selectedCount + "/" + datas.size() + ")");
    }

    @Override
    public void onBackPressed() {
        onBackClicked(null);
    }

    @Override
    protected void onBackClicked(View view) {
        setResult(RESULT_CANCELED, getResultIntent());
        finish();
    }

    @Override
    protected void onTitleClicked(View view) {

    }

    @Override
    protected void onFunctionClicked(View view) {
        setResult(RESULT_OK, getResultIntent());
        finish();
    }

    private Intent getResultIntent() {

        ArrayList<Uri> datas = adapter.getDatas();

        for (int i = isImageSelected.length - 1; i >= 0; i--) {
            if (!isImageSelected[i]) {
                datas.remove(i);
            }
        }

        return new Intent().putParcelableArrayListExtra("photos", datas);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    private boolean byUser = true;

    @Override
    public void onPageSelected(int position) {
        byUser = false;
        mImageSeletor.setChecked(isImageSelected[position]);
        byUser = true;
//        updateFunctionButton();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (byUser) {
            isImageSelected[mViewPager.getCurrentItem()] = isChecked;
            if (isChecked) {
                selectedCount++;
            } else {
                selectedCount--;
            }
            updateFunctionButton();
        }
        byUser = true;
    }
}
