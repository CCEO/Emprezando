package mx.com.cceo.emprezando.Fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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

        scroll = (ScrollView) rootView.findViewById(R.id.memories_scroll);
        banner_2013 = (RelativeLayout) rootView.findViewById(R.id.memories_banner_2013);
        banner_2014 = (RelativeLayout) rootView.findViewById(R.id.memories_banner_2014);
        bannerText = (TextView) rootView.findViewById(R.id.memories_banner_text);


        scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if(scroll.getScrollY() < 1251)
                    bannerText.setText("2012");
                if(scroll.getScrollY() > 1251 && scroll.getScrollY() < 2745)
                    bannerText.setText("2013");
                if(scroll.getScrollY() > 2745)
                    bannerText.setText("2014");
            }
        });

        return rootView;
    }
}
