package com.inhatc.juha.android_gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView objGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objGridView = (GridView)findViewById(R.id.gridView1);
        objGridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
                R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,
                R.drawable.img_7, R.drawable.img_8, R.drawable.img_9
        };

        public ImageAdapter(Context objC) { mContext = objC; }
        public int getCount() { return mThumbIds.length; }
        public Object getItem(int position) { return null; }
        public long getItemId(int position) { return 0; }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView objImgView;

            if (convertView == null) {
                objImgView = new ImageView(mContext);
                objImgView.setLayoutParams(new GridView.LayoutParams(300, 300));
                objImgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                objImgView.setPadding(8,8,8,8);
            }else{
                objImgView = (ImageView)convertView;
            }
            objImgView.setImageResource(mThumbIds[position]);
            return objImgView;
        }
    }
}
