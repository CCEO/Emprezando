package mx.com.cceo.emprezando.Util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.util.AttributeSet;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/23/2015.
 */
public class CustomPagerTabStrip extends PagerTabStrip
{
    public CustomPagerTabStrip(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyPagerTabStrip);
        setTabIndicatorColor(a.getColor(
                R.styleable.MyPagerTabStrip_indicatorColor, Color.WHITE));
        setTextColor(Color.WHITE);
        a.recycle();
    }

}