package mx.com.cceo.emprezando;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import mx.com.cceo.emprezando.Fragment.InformationFragment;
import mx.com.cceo.emprezando.Fragment.MemoriesFragment;
import mx.com.cceo.emprezando.Fragment.ProgramFragment;
import mx.com.cceo.emprezando.Fragment.RegisterFragment;
import mx.com.cceo.emprezando.Fragment.ScheduleFragment;
import mx.com.cceo.emprezando.Fragment.VenueFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private DrawerLayout drawerLayout;
    private ImageView ivBackGround;

    private int pageWidth;

    private Toolbar toolbar;
    private TabLayout tabLayout;

    private FloatingActionButton fabRegister;


    private static final int NUM_PAGES = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.menu_small);

        mPager = (ViewPager) findViewById(R.id.main_pager);
        mPagerAdapter = new MainPagerAdapter(fragmentManager);
        mPager.setAdapter(mPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);


        getSupportActionBar().setTitle("");

        //toolbar.setDisplayHomeAsUpEnabled(true);
        //toolbar.setIcon(R.drawable.menu_small);


        //this.getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setIcon(R.drawable.icon_information);
        //getActionBar().setTitle("");

        ImageView ivLogo = (ImageView) findViewById(R.id.main_logo);
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.cceo.com.mx";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // ivBackGround = (ImageView) findViewById(R.id.main_ivBackground);

        initDrawer();


        //if we come from a Description's menu selection, set the pager to Description's selection
        Intent mIntent = getIntent();
        int selectedPosition = mIntent.getIntExtra("selection", 0);
        mPager.setCurrentItem(selectedPosition);

        fabRegister = (FloatingActionButton) findViewById(R.id.fab);
        fabRegister.setVisibility(View.GONE);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 5) {
                    fabRegister.setVisibility(View.VISIBLE);
                    fabRegister.animate().alpha(1.0f).translationY(-fabRegister.getHeight() * 0.2f);
                } else {

                    fabRegister.animate().alpha(0.0f).translationY(fabRegister.getHeight() * 2);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        fabRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://emprezando.com/2015/registrarme/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    /**
     * Enables drawer items to change the adapter current item
     */
    public void initDrawer() {
        RelativeLayout drawerInformation = (RelativeLayout) findViewById(R.id.drawer_information);
        drawerInformation.setOnClickListener(this);

        RelativeLayout drawerProgram = (RelativeLayout) findViewById(R.id.drawer_schedule);
        drawerProgram.setOnClickListener(this);

        RelativeLayout drawerMemories = (RelativeLayout) findViewById(R.id.drawer_memories);
        drawerMemories.setOnClickListener(this);

        RelativeLayout drawerVenue = (RelativeLayout) findViewById(R.id.drawer_venue);
        drawerVenue.setOnClickListener(this);

        RelativeLayout drawerRegister = (RelativeLayout) findViewById(R.id.drawer_register);
        drawerRegister.setOnClickListener(this);

        RelativeLayout drawer_schedule = (RelativeLayout) findViewById(R.id.drawer_speakers);
        drawer_schedule.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (drawerLayout.isDrawerOpen(Gravity.LEFT))
            drawerLayout.closeDrawer(Gravity.LEFT);
        else
            drawerLayout.openDrawer(Gravity.LEFT);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onClick(View v) {
        drawerLayout.closeDrawer(Gravity.LEFT);
        switch (v.getId()) {
            case R.id.drawer_information:

                mPager.setCurrentItem(0);
                break;
            case R.id.drawer_schedule:

                mPager.setCurrentItem(1);
                break;
            case R.id.drawer_speakers:

                mPager.setCurrentItem(2);
                break;
            case R.id.drawer_memories:

                mPager.setCurrentItem(3);
                break;
            case R.id.drawer_venue:

                mPager.setCurrentItem(4);
                break;
            case R.id.drawer_register:

                mPager.setCurrentItem(5);
                break;
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class MainPagerAdapter extends FragmentStatePagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    // ivBackGround.setTranslationX(pageWidth/5 * (1));
                    return new InformationFragment();
                case 1:
                    //           ivBackGround.setTranslationX(pageWidth/5 * (1));
                    return new ScheduleFragment();
                case 2:
                    //           ivBackGround.setTranslationX(pageWidth/5 * (1));
                    return new ProgramFragment();
                case 3:
                    //         ivBackGround.setTranslationX(pageWidth/5 * (2));
                    return new MemoriesFragment();
                case 4:
                    //       ivBackGround.setTranslationX(pageWidth/5 * (3));
                    return new VenueFragment();
                default:
                    return new RegisterFragment();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Información";
                case 1:
                    return "Programa";
                case 2:
                    return "Conferencistas";
                case 3:
                    return "Memorias";
                case 4:
                    return "Sede";
                case 5:
                    return "Registro";
            }
            return "";
        }

    }

}
