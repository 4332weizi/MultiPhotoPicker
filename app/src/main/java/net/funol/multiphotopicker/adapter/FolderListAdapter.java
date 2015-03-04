package net.funol.multiphotopicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.funol.bean.ImageFloder;
import net.funol.multiphotopicker.R;
import net.funol.utils.ImageLoader;

import java.util.List;

/**
 * Created by DZY-ZWW on 03-3.
 */
public class FolderListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private ViewHolder holder;

    private List<ImageFloder> datas;

    public FolderListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<ImageFloder> datas) {
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
    public ImageFloder getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_folder_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mFolderName.setText(getItem(position).getName());
        holder.mFolderImageCount.setText(getItem(position).getCount() + "张");
        ImageLoader.getInstance().loadImage(getItem(position).getFirstImagePath(),holder.mFolderCover);

        return convertView;
    }

    private class ViewHolder{

        ImageView mFolderCover;
        TextView mFolderName;
        TextView mFolderImageCount;

        public ViewHolder(View view){
            mFolderCover = (ImageView) view.findViewById(R.id.folder_list_cover);
            mFolderName = (TextView) view.findViewById(R.id.folder_list_name);
            mFolderImageCount = (TextView) view.findViewById(R.id.folder_list_count);
        }
    }

}
