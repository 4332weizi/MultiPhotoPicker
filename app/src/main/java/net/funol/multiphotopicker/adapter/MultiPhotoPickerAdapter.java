package net.funol.multiphotopicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import net.funol.multiphotopicker.R;
import net.funol.utils.Dimension;
import net.funol.utils.Screen;

import java.util.List;

/**
 * Created by DZY-ZWW on 02-11.
 */
public class MultiPhotoPickerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private ViewHolder holder;

    private List<String> datas;

    private int width = 0;

    public MultiPhotoPickerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        width = (Screen.getWidthPixels(context) - Dimension.dp2px(context, 10)) / 3;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        if (datas == null) {
            return 0;
        }
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_multi_photo_picker_grid, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
            convertView.setLayoutParams(new GridView.LayoutParams(width, width));
            holder.mSelector.setFocusable(false);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mSelector.setChecked(!holder.mSelector.isChecked());
            }
        });

        return convertView;
    }

    private class ViewHolder {

        ImageView mPhoto;
        CheckBox mSelector;

        public ViewHolder(View view) {
            mPhoto = (ImageView) view.findViewById(R.id.multi_photo_picker_photo);
            mSelector = (CheckBox) view.findViewById(R.id.multi_photo_picker_selector);
        }

    }

}
