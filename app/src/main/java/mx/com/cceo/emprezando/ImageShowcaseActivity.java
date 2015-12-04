package mx.com.cceo.emprezando;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import mx.com.cceo.emprezando.Fragment.DescriptionFragment;
import mx.com.cceo.emprezando.Fragment.ImageShowcaseFragment;
import mx.com.cceo.emprezando.Model.DescriptionItem;
import mx.com.cceo.emprezando.R;

public class ImageShowcaseActivity extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private int selectedPosition;
    private int NUM_PAGES = 5;

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_showcase);

        FragmentManager fragmentManager = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.arrow_left_white_small);

        getSupportActionBar().setTitle("Memorias");

        //  drawerLayout = (DrawerLayout) findViewById(R.id.description_drawer);

        //binds drawer items to pager's pages
        //  initDrawer();

        //retrieves the position of the card the user selected to also set the adapter initial position
        Intent mIntent = getIntent();
        selectedPosition = mIntent.getIntExtra("position", 0);



        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(R.drawable.header_2012,
                R.drawable.a1, R.drawable.a2,
                R.drawable.a3, R.drawable.a4,
                R.drawable.a5, R.drawable.a6,
                R.drawable.a7, R.drawable.a8,
                R.drawable.a9, R.drawable.a10,
                R.drawable.a11, R.drawable.a12,
                R.drawable.a13, R.drawable.a14,
                R.drawable.a15, R.drawable.a16,
                //2013

                R.drawable.a17, R.drawable.a18,
                R.drawable.header_2013,
                R.drawable.a19, R.drawable.a20,
                R.drawable.a21, R.drawable.a22,
                R.drawable.a23, R.drawable.a24,
                R.drawable.a25, R.drawable.a26,
                R.drawable.a27, R.drawable.a28,
                R.drawable.a29,
                //2013

                R.drawable.a30, R.drawable.a31,
                R.drawable.header_2014,
                R.drawable.a32, R.drawable.a33,
                R.drawable.a34, R.drawable.a35,
                R.drawable.a36, R.drawable.a37,
                R.drawable.a38, R.drawable.a39,
                R.drawable.a40, R.drawable.a41, R.drawable.a42));


        //looks up ViewPager and sets its adapter
        mPager = (ViewPager) findViewById(R.id.main_pager);
        mPagerAdapter = new DescriptionPagerAdapter(getSupportFragmentManager(),list);
        mPager.setAdapter(mPagerAdapter);

        mPager.setCurrentItem(selectedPosition);

//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        this.finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }


    private class DescriptionPagerAdapter extends FragmentStatePagerAdapter {

        public ArrayList<Integer> dataSet;

        public DescriptionPagerAdapter(FragmentManager fm, ArrayList<Integer> dataSet) {
            super(fm);
            this.dataSet = dataSet;
        }

        @Override
        public Fragment getItem(int position) {

            ImageShowcaseFragment descriptionFragment = new ImageShowcaseFragment();
            descriptionFragment.setImageId(dataSet.get(position));
            return descriptionFragment;

        }

        @Override
        public int getCount() {
            return dataSet.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.valueOf(dataSet.get(position));
        }
    }
}
