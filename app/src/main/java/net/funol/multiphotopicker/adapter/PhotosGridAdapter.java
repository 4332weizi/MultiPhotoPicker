package net.funol.multiphotopicker.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;

import net.funol.bean.ImageFloder;
import net.funol.multiphotopicker.R;
import net.funol.utils.Dimension;
import net.funol.utils.ImageLoader;
import net.funol.utils.Screen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DZY-ZWW on 02-11.
 */
public class PhotosGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private List<Parcelable> datas;

    private int width = 0;

    public PhotosGridAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        width = Screen.getWidthPixels(context) / 3;
    }

    public void setDatas(List<Parcelable> datas) {
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
    public Uri getItem(int position) {
        return (Uri)datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_photos_grid, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
            convertView.setLayoutParams(new GridView.LayoutParams(width, width));
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mPhoto.setImageResource(R.mipmap.icon_picture);
        ImageLoader.getInstance().loadImage(getItem(position).toString(), holder.mPhoto);

        return convertView;
    }

    private class ViewHolder {

        ImageView mPhoto;

        public ViewHolder(View view) {
            mPhoto = (ImageView) view.findViewById(R.id.photos_grid_photo);
        }

    }

}
