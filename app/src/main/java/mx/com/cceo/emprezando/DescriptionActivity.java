package mx.com.cceo.emprezando;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Fragment.DescriptionFragment;
import mx.com.cceo.emprezando.Fragment.InformationFragment;
import mx.com.cceo.emprezando.Fragment.MemoriesFragment;
import mx.com.cceo.emprezando.Fragment.ProgramFragment;
import mx.com.cceo.emprezando.Fragment.RegisterFragment;
import mx.com.cceo.emprezando.Fragment.VenueFragment;
import mx.com.cceo.emprezando.Model.DescriptionItem;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private int selectedPosition;
    private int NUM_PAGES = 5;
    private  DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        drawerLayout = (DrawerLayout) findViewById(R.id.description_drawer);

        //binds drawer items to pager's pages
        initDrawer();

        //retrieves the position of the card the user selected to also set the adapter initial position
        Intent mIntent = getIntent();
        selectedPosition = mIntent.getIntExtra("position", 0);

        DescriptionItem temp = new DescriptionItem("Nymphetamine","Cradle of Filth", "Six feet deep is the incision in my heart that barless prison");
        DescriptionItem temp1 = new DescriptionItem("Blood and Thunder","Mastodon", "split your lungs with blood and thunder when you see the white whale");
        ArrayList<DescriptionItem> list = new ArrayList<>();
        list.add(temp);
        list.add(temp1);

        //looks up ViewPager and sets its adapter
        mPager = (ViewPager) findViewById(R.id.description_pager);
        mPagerAdapter = new DescriptionPagerAdapter(getSupportFragmentManager(),list);
        mPager.setAdapter(mPagerAdapter);

        mPager.setCurrentItem(selectedPosition);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public void onClick(View v) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        int selection = 0;

        switch (v.getId())
        {
            case R.id.drawer_information:

                selection = 0;
                break;
            case R.id.drawer_program:

                selection = 1;
                break;
            case R.id.drawer_memories:

                selection = 2;
                break;
            case R.id.drawer_venue:

                selection = 3;
                break;
            case R.id.drawer_register:

                selection = 4;
                break;
        }

        Intent intent = new Intent(DescriptionActivity.this,MainActivity.class);
        intent.putExtra("selection",selection);
        startActivity(intent);
        this.finish();
    }

    private class DescriptionPagerAdapter extends FragmentStatePagerAdapter {

        public ArrayList<DescriptionItem> dataSet;

        public DescriptionPagerAdapter(FragmentManager fm, ArrayList<DescriptionItem> dataSet) {
            super(fm);
            this.dataSet = dataSet;
        }

        @Override
        public Fragment getItem(int position) {

            DescriptionFragment descriptionFragment = new DescriptionFragment();
            descriptionFragment.setDescriptionItem(dataSet.get(position));
            return descriptionFragment;

        }

        @Override
        public int getCount() {
            return dataSet.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return  dataSet.get(position).getTitle();

        }
    }
}
