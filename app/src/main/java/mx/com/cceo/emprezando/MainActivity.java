package mx.com.cceo.emprezando;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
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

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import mx.com.cceo.emprezando.Fragment.InformationFragment;
import mx.com.cceo.emprezando.Fragment.MemoriesFragment;
import mx.com.cceo.emprezando.Fragment.ProgramFragment;
import mx.com.cceo.emprezando.Fragment.RegisterFragment;
import mx.com.cceo.emprezando.Fragment.VenueFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private DrawerLayout drawerLayout;
    private ImageView ivBackGround;
    private CrossfadePageTransformer pagerTransformer;

    private int pageWidth;

    private static final int NUM_PAGES = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("    " + "Foro Emprezando 2015");

        getSupportActionBar().setIcon(R.drawable.menu_small);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FragmentManager fragmentManager = getSupportFragmentManager();

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
        pagerTransformer = new CrossfadePageTransformer();

        //looks up ViewPager and sets its adapter
        mPager = (ViewPager) findViewById(R.id.main_pager);
        mPagerAdapter = new MainPagerAdapter(fragmentManager);
        mPager.setAdapter(mPagerAdapter);

        initDrawer();


        //if we come from a Description's menu selection, set the pager to Description's selection
        Intent mIntent = getIntent();
        int selectedPosition = mIntent.getIntExtra("selection", 0);
        mPager.setCurrentItem(selectedPosition);
    }

    /**
     * Enables drawer items to change the adapter current item
     */
    public void initDrawer()
    {
        RelativeLayout drawerInformation = (RelativeLayout) findViewById(R.id.drawer_information);
        drawerInformation.setOnClickListener(this);

        RelativeLayout drawerProgram = (RelativeLayout) findViewById(R.id.drawer_program);
        drawerProgram.setOnClickListener(this);

        RelativeLayout drawerMemories = (RelativeLayout) findViewById(R.id.drawer_memories);
        drawerMemories.setOnClickListener(this);

        RelativeLayout drawerVenue = (RelativeLayout) findViewById(R.id.drawer_venue);
        drawerVenue.setOnClickListener(this);

        RelativeLayout drawerRegister = (RelativeLayout) findViewById(R.id.drawer_register);
        drawerRegister.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
       // super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        switch (v.getId())
        {
            case R.id.drawer_information:

                mPager.setCurrentItem(0);
                break;
            case R.id.drawer_program:

                mPager.setCurrentItem(1);
                break;
            case R.id.drawer_memories:

                mPager.setCurrentItem(2);
                break;
            case R.id.drawer_venue:

                mPager.setCurrentItem(3);
                break;
            case R.id.drawer_register:

                mPager.setCurrentItem(4);
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
            switch (position)
            {
                case 0:
                    // ivBackGround.setTranslationX(pageWidth/5 * (1));
                    return new InformationFragment();
                case 1:
                    //           ivBackGround.setTranslationX(pageWidth/5 * (1));
                    return new ProgramFragment();
                case 2:
                    //         ivBackGround.setTranslationX(pageWidth/5 * (2));
                    return new MemoriesFragment();
                case 3:
                    //       ivBackGround.setTranslationX(pageWidth/5 * (3));
                    return new VenueFragment();
                default: return new RegisterFragment();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return "Información";
                case 1:
                    return "Programa";
                case 2:
                    return "Memorias";
                case 3:
                    return "Sede";
                case 4:
                    return "Registro";
            }
            return "";
        }
    }

    private class CrossfadePageTransformer implements ViewPager.PageTransformer {

        public int size = 0;

        public int getScreenSize()
        {
            return size;
        }

        @Override
        public void transformPage(View page, float position) {
            int pageWidth = page.getWidth();
            size = page.getWidth();

            ViewPager parent = (ViewPager) page.getParent();
            position -= parent.getPaddingRight() / (float) pageWidth;

            //ImageView ivObj1 = (ImageView) findViewById(R.id.obj1);
            ImageView ivObj2 = (ImageView) findViewById(R.id.obj2);
            ImageView ivObj3 = (ImageView) findViewById(R.id.obj3);
            ImageView ivObj4 = (ImageView) findViewById(R.id.obj4);
           // ImageView ivObj5 = (ImageView) findViewById(R.id.obj5);
            //  ImageView ivObj3 = (ImageView) page.findViewById(R.id.obj3);

            setTitle(String.valueOf(position));

            if(0 <= position && position < 1){
                // page.setTranslationX(pageWidth * -position);
            }
            if(-1 < position && position < 0){
                //page.setTranslationX(pageWidth * -position);
            }

            //ivBackGround.setTranslationX(ivBackGround.getTranslationX() + (pageWidth/5 * (position)));
            //((RelativeLayout.LayoutParams) ivBackGround.getLayoutParams()).setMargins(((int) (pageWidth/5 * (position))), 0, 0, 0);
            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.setAlpha(1);

            } else if (position <= 1) { // [-1,1]
              //  if(ivObj1 != null)
               //     ivObj1.setTranslationX((pageWidth/5 * (position)));
                //  ((RelativeLayout.LayoutParams) ivObj1.getLayoutParams()).setMargins(-((int) (pageWidth/5 * (position))), 0, 0, 0);
                if(ivObj2 != null)
                    ivObj2.setTranslationX((pageWidth/5 * (position)));
                // ((RelativeLayout.LayoutParams) ivObj2.getLayoutParams()).setMargins(-((int) (pageWidth * (position))), 0, 0, 0);
                if(ivObj3 != null)
                    ivObj3.setTranslationX((pageWidth/5 * (position)));

                if(ivObj4 != null)
                    ivObj4.setTranslationX((pageWidth/5 * (position)));

            //    if(ivObj5 != null)
            //        ivObj5.setTranslationX((pageWidth/5 * (position)));
                //  dummyImageView.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.setAlpha(1);
            }

//            if(position < -1.0f || position > 1.0f) {
//                page.setAlpha(0);
//            } else if( position == 0.0f ) {
//            } else {
//                if(ivObj1 != null)
//                    ivObj1.setTranslationX(-(pageWidth/5 * (position)));
//                  //  ((RelativeLayout.LayoutParams) ivObj1.getLayoutParams()).setMargins(-((int) (pageWidth/5 * (position))), 0, 0, 0);
//                if(ivObj2 != null)
//                ivObj2.setTranslationX((pageWidth/5 * (position)));
//                   // ((RelativeLayout.LayoutParams) ivObj2.getLayoutParams()).setMargins(-((int) (pageWidth * (position))), 0, 0, 0);
//                if(ivObj3 != null)
//                    ivObj3.setTranslationX(-(pageWidth/5 * (position)));
//
//                if(ivObj4 != null)
//                    ivObj4.setTranslationX(-(pageWidth/5 * (position)));
//
//                if(ivObj5 != null)
//                    ivObj5.setTranslationX(-(pageWidth/5 * (position)));
//
//            }
        }
    }
}
