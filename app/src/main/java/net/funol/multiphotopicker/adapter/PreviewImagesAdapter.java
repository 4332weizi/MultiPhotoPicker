package net.funol.multiphotopicker.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.davemorrissey.labs.subscaleview.ScaleImageView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.polites.android.GestureImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by DZY-ZWW on 03-4.
 */
public class PreviewImagesAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Uri> datas;

    public PreviewImagesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Uri> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<Uri> datas) {
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
    public View instantiateItem(ViewGroup container, int position) {
        //GestureImageView photoView = new GestureImageView(container.getContext());
        //photoView.setImageURI(datas.get(position));
        //ImageLoader.getInstance().loadImage(datas.get(position).toString(),photoView);

        // Now just add PhotoView to ViewPager and return it
        //container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

//        WebView webView = new WebView(context);
//        String html = "<img src=\"" + datas.get(position).toString() + "\" width=\"100%\"/>";
//        webView.loadDataWithBaseURL("file:///", html, "text/html", "utf-8", null);
//        webView.getSettings().setSupportZoom(true);
//        webView.setHorizontalScrollBarEnabled(false);
//        webView.setVerticalScrollBarEnabled(false);
//        webView.setPadding(0,0,0,0);
        SubsamplingScaleImageView imageView = new SubsamplingScaleImageView(context);
        imageView.setImageUri("file://" + datas.get(position));
        container.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        ((ViewPager) container).removeView(view);
        view = null;
        System.gc();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
