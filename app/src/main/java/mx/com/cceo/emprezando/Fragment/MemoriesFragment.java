package mx.com.cceo.emprezando.Fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/5/2015.
 */
public class MemoriesFragment extends Fragment {

    private RelativeLayout banner_2013;
    private RelativeLayout banner_2014;
    private ScrollView scroll;

    private boolean bannerVisible2013 = false;
    private boolean afterBannerVisible2013 = false;

    private boolean bannerVisible2014 = false;
    private boolean afterBannerVisible2014 = false;

    private TextView bannerText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_memories, container, false);

        GridView gridview = (GridView) rootView.findViewById(R.id.fragment_memories_gridview);
        gridview.setAdapter(new ImageAdapter(this.getActivity()));



//        final LinearLayout lv2012 = (LinearLayout) rootView.findViewById(R.id.memories_rl_2012);
//        final LinearLayout lv2013 = (LinearLayout) rootView.findViewById(R.id.memories_rl_2013);
//        LinearLayout lv2014 = (LinearLayout) rootView.findViewById(R.id.memories_rl_2014);
//
//        scroll = (ScrollView) rootView.findViewById(R.id.memories_scroll);
//        banner_2013 = (RelativeLayout) rootView.findViewById(R.id.memories_banner_2013);
//        banner_2014 = (RelativeLayout) rootView.findViewById(R.id.memories_banner_2014);
//        bannerText = (TextView) rootView.findViewById(R.id.memories_banner_text);


//        scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
////                if(scroll.getScrollY() < lv2012.getLayoutParams().height)
////                    bannerText.setText("2012");
////                if(scroll.getScrollY() > lv2012.getLayoutParams().height && scroll.getScrollY() < lv2013.getLayoutParams().height)
////                    bannerText.setText("2013");
////                if(scroll.getScrollY() > lv2013.getLayoutParams().height)
////                    bannerText.setText("2014");
//            }
//        });

        return rootView;
    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;

        }

        public int dpToPixels(int dp)
        {
            final float scale = mContext.getResources().getDisplayMetrics().density;
            int pixels = (int) (dp * scale + 0.5f);

            return pixels;
        }
        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(dpToPixels(102), dpToPixels(128)));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                //2012
                R.drawable.header_2012,
                R.drawable.memories_2012_1, R.drawable.memories_2012_2,
                R.drawable.memories_2012_3, R.drawable.memories_2012_4,
                R.drawable.memories_2012_5, R.drawable.memories_2012_6,
                R.drawable.memories_2012_7, R.drawable.memories_2012_8,
                R.drawable.memories_2012_9, R.drawable.memories_2012_10,
                R.drawable.memories_2012_11, R.drawable.memories_2012_12,
                R.drawable.memories_2012_13, R.drawable.memories_2012_14,
                R.drawable.memories_2012_15, R.drawable.memories_2012_16,
                //2013
                R.drawable.header_2013,
                R.drawable.memories_2013_1, R.drawable.memories_2013_2,
                R.drawable.memories_2013_3, R.drawable.memories_2013_4,
                R.drawable.memories_2013_5, R.drawable.memories_2013_6,
                R.drawable.memories_2013_7, R.drawable.memories_2013_8,
                R.drawable.memories_2013_9, R.drawable.memories_2013_10,
                R.drawable.memories_2013_11, R.drawable.memories_2013_12,
                R.drawable.memories_2013_13,
                //2013
                R.drawable.header_2014,
                R.drawable.memories_2014_1, R.drawable.memories_2014_2,
                R.drawable.memories_2014_3, R.drawable.memories_2014_4,
                R.drawable.memories_2014_5, R.drawable.memories_2014_6,
                R.drawable.memories_2014_7, R.drawable.memories_2014_8,
                R.drawable.memories_2014_9, R.drawable.memories_2014_10,
                R.drawable.memories_2014_11,

        };
    }
}
