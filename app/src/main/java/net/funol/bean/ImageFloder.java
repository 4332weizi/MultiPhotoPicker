package net.funol.bean;

import android.net.Uri;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageFloder {

    /**
     * folder path
     */
    private String dir;

    /**
     * list of all image paths in this folder
     */
    private List<Uri> images;

    /**
     * frist image in folder
     */
    private String firstImagePath;

    /**
     * the name of folder
     */
    private String name;

    /**
     * count of images in this folder
     */
    private int count;

    private Set<Integer> selectedImages;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
        int lastIndexOf = this.dir.lastIndexOf("/");
        this.name = this.dir.substring(lastIndexOf);
    }

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        if(images == null){
            return 0;
        }
        return images.size();
    }

    public List<Uri> getImages() {
        return images;
    }

    public void setImages(List<Uri> images) {
        this.images = images;
    }

    public void addImage(Uri uri) {
        if (images == null) {
            images = new ArrayList<Uri>();
        }
        images.add(uri);
    }

    public void addImage(String path) {
        //addImage(Uri.parse("file://" + path));
        addImage(Uri.parse(path));
    }

    public void selectImage(int position){
        if(selectedImages == null){
            selectedImages = new HashSet<Integer>();
        }
        selectedImages.add(position);
    }

    public void unSelectedImage(int position){
        if(selectedImages == null){
            return;
        }
        selectedImages.remove(position);
    }

    public void clearSelectedImages(){
        if(selectedImages==null){
            return;
        }
        selectedImages.clear();
    }

    public boolean isSelected(int position){
        if(selectedImages==null){
            return false;
        }
        return selectedImages.contains(position);
    }
}
