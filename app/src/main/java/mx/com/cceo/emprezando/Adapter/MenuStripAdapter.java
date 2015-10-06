package mx.com.cceo.emprezando.Adapter;

import android.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Hugo on 10/6/2015.
 */
public class MenuStripAdapter extends PagerAdapter {
    private List<Fragment> mTabs;


    public MenuStripAdapter(FragmentManager supportFragmentManager) {
    }

    public void setDatasource(List<Fragment> datasource){
       // mTabs = datasource;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(1);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        return instantiateItem((View) container, position);
    }
}
