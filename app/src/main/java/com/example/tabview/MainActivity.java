package com.example.tabview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    ViewPageAdapter adapter;
  //  FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=(TabLayout)findViewById(R.id.tab);
        viewPager=(ViewPager)findViewById(R.id.pager);

        adapter=new ViewPageAdapter(getSupportFragmentManager());

        adapter.AddFragment(new HomePage(),"Exercise");
        adapter.AddFragment(new TipsPage(),"Tips");
        adapter.AddFragment(new UtilityPage(),"Utility");

        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);

        tab.setTabGravity(TabLayout.GRAVITY_FILL);

    }
    public class ViewPageAdapter extends FragmentPagerAdapter {
        public final List<Fragment> tabFragment=new ArrayList<>();
        public final List<String>tabTitles=new ArrayList<>();

        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return tabTitles.size();
        }
        @Override
        public CharSequence getPageTitle(int position){
            return tabTitles.get(position);
        }
        public void AddFragment(Fragment fragment, String titles){
            tabFragment.add(fragment);
            tabTitles.add(titles);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragment.get(position);
        }
    }
//    public class FragmentAdapter extends FragmentStatePagerAdapter {
//
//        int Tabcount;
//        public FragmentAdapter(FragmentManager fm, int Tabcount) {
//            super(fm);
//            this.Tabcount=Tabcount;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position)
//            {
//                case 0:
//                    HomePage ob=new HomePage();
//                    return ob;
//
//                case  1:
//                    TipsPage ob1=new TipsPage();
//                    return  ob1;
//
//                case 2:
//                    UtilityPage ob2=new UtilityPage();
//                    return ob2;
//            }
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            return Tabcount;
//        }
//    }
}