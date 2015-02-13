package net.funol.multiphotopicker.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import net.funol.multiphotopicker.R;
import net.funol.multiphotopicker.adapter.MultiPhotoPickerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultiPhotoPicker extends CustomTitleBarActivity {

    private MultiPhotoPickerAdapter adapter;
    private GridView mPhotoGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_photo_picker);
        
        initViews();
    }

    private void initViews() {
        mTitleBarTitle.setText("所有照片");
        //mTitleBarFunction.setEnabled(false);

        mPhotoGrid = (GridView) findViewById(R.id.multi_photo_picker_photo_grid);

        adapter = new MultiPhotoPickerAdapter(this);
        List<String> datas = new ArrayList<String>();
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        adapter.setDatas(datas);
        mPhotoGrid.setAdapter(adapter);
    }

    @Override
    protected void onBackClicked(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onTitleClicked(View view) {

    }

    @Override
    protected void onFunctionClicked(View view) {
        setResult(RESULT_OK);
        finish();
    }

}
