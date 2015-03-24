package net.funol.multiphotopicker.adapter;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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
public class MultiPhotoPickerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private ImageFloder datas;

    private int width = 0;

    private Set<Uri> selectedImages;

    private ImageSelectChangeListener imageSelectChangeListener;

    private int MAX_IMAGES = 9;

    public MultiPhotoPickerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        width = Screen.getWidthPixels(context) / 3;
        selectedImages = new HashSet<Uri>();
    }

    public int getMaxImages() {
        return MAX_IMAGES;
    }

    public void setMaxImages(int num) {
        this.MAX_IMAGES = num;
    }

    public void setDatas(ImageFloder datas) {
        this.datas = datas;
    }

    public Set<Uri> getSelectedImages() {
        return selectedImages;
    }

    public void setSelectedImages(Set<Uri> selectedImages) {
        this.selectedImages = selectedImages;
    }

    public void unSelectedImage(Uri uri){
        selectedImages.remove(uri);
    }

    @Override
    public int getCount() {
        if (datas == null) {
            return 0;
        }
        return datas.getCount();
    }

    @Override
    public Uri getItem(int position) {
        return datas.getImages().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
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
                if (holder.mSelector.isChecked()) {
                    // 可选数量要小于指定最大数量
                    if (selectedImages.size() < MAX_IMAGES) {
                        datas.selectImage(position);
                        selectedImages.add(getItem(position));
                    } else {
                        holder.mSelector.setChecked(false);
                    }
                } else {
                    datas.unSelectedImage(position);
                    selectedImages.remove(getItem(position));
                }
                if (imageSelectChangeListener != null) {
                    imageSelectChangeListener.onSelectChanged(holder.mSelector, position);
                }
            }
        });

        if (selectedImages.contains(getItem(position))) {
            holder.mSelector.setChecked(true);
            selectedImages.add(getItem(position));
        } else {
            holder.mSelector.setChecked(false);
            selectedImages.remove(getItem(position));
        }

        holder.mPhoto.setImageResource(R.mipmap.icon_picture);
        holder.mSelector.setChecked(datas.isSelected(position));
        ImageLoader.getInstance().loadImage(getItem(position).toString(), holder.mPhoto);

        return convertView;
    }

    public void setOnImageSelectChangeListener(ImageSelectChangeListener imageSelectChangeListener) {
        this.imageSelectChangeListener = imageSelectChangeListener;
    }

    private class ViewHolder {

        ImageView mPhoto;
        CheckBox mSelector;

        public ViewHolder(View view) {
            mPhoto = (ImageView) view.findViewById(R.id.multi_photo_picker_photo);
            mSelector = (CheckBox) view.findViewById(R.id.multi_photo_picker_selector);
        }

    }

    public interface ImageSelectChangeListener {
        public void onSelectChanged(CheckBox cb, int position);
    }

}
