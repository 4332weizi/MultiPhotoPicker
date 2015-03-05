package net.funol.multiphotopicker.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import net.funol.utils.ImageLoader;

import java.util.List;

import uk.co.senab.photoview.PhotoView;


/**
 * Created by DZY-ZWW on 03-4.
 */
public class PreviewImagesAdapter extends PagerAdapter {

    private Context context;
    private List<Uri> datas;

    public PreviewImagesAdapter(Context context) {
        this.context = context;
    }

    public List<Uri> getDatas() {
        return datas;
    }

    public void setDatas(List<Uri> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        if(datas == null){
            return 0;
        }
        return datas.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(container.getContext());
        photoView.setImageURI(datas.get(position));
        //ImageLoader.getInstance().loadImage(datas.get(position).toString(),photoView);

        // Now just add PhotoView to ViewPager and return it
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
