package net.funol.multiphotopicker.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import net.funol.multiphotopicker.R;
import net.funol.multiphotopicker.adapter.PhotosGridAdapter;
import net.funol.utils.Screen;

import java.util.List;


public class MainActivity extends CustomTitleBarActivity implements View.OnClickListener {

    private Button mButton;
    private GridView mPhotosGrid;

    private PhotosGridAdapter adapter;

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

        mPhotosGrid = (GridView) findViewById(R.id.main_photos);
        mPhotosGrid.setColumnWidth(Screen.getWidthPixels(this) / 3);

        adapter = new PhotosGridAdapter(this);
        mPhotosGrid.setAdapter(adapter);
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
        switch (v.getId()) {
            case R.id.main_pick_photo_button:
                Intent intent = new Intent();
//                intent.setClass(this,MultiPhotoPicker.class);
                //intent.setAction("funol.intent.action.PICK_PHOTO");
                intent.setData(Uri.parse("pick://images.funol.net/number/20"));
                startActivityForResult(intent,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.setDatas(data.getParcelableArrayListExtra("photos"));
        adapter.notifyDataSetChanged();
    }
}
