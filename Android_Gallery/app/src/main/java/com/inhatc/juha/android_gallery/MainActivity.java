package com.inhatc.juha.android_gallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Gallery objGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objGallery = (Gallery)findViewById(R.id.gallery1);
        objGallery.setAdapter(new ImageAdapter(this));
        objGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int postion, long id){
                    Toast.makeText(MainActivity.this, ""+ postion, Toast.LENGTH_LONG).show();
                }
        });
    }

    public class ImageAdapter extends BaseAdapter{
        int mGalleryItemBackground;
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
                R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,
                R.drawable.img_7, R.drawable.img_8, R.drawable.img_9,
        };

        public ImageAdapter(Context objContxt) {
            mContext = objContxt;
            TypedArray objArray = obtainStyledAttributes(R.styleable.gallery1);
            mGalleryItemBackground = objArray.getResourceId(
                    R.styleable.gallery1_android_galleryItemBackground, 0);
            objArray.recycle();
        }
        public int getCount() { return mThumbIds.length; }
        public Object getItem(int postion) { return postion; }
        public long getItemId(int postion) { return postion; }

        public View getView(int postion, View convertView, ViewGroup parent){
            ImageView objImgView;

            objImgView = new ImageView(mContext);
            objImgView.setImageResource(mThumbIds[postion]);
            objImgView.setLayoutParams(new Gallery.LayoutParams(300, 200));
            objImgView.setScaleType(ImageView.ScaleType.FIT_XY);
            objImgView.setBackgroundResource(mGalleryItemBackground);
            return objImgView;
        }
    }
}
