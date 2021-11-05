package com.example.kushvanthsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewpager();

    }
        private void initViewpager() {
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewpageAdapter viewpageAdapter = new ViewpageAdapter(getSupportFragmentManager());
        viewpageAdapter.addFragments(new Youtube(), "youtube");
        viewpageAdapter.addFragments(new instagram(), "instagram");
        viewpageAdapter.addFragments(new Telegram(), "Telegram");
        viewPager.setAdapter(viewpageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
        class ViewpageAdapter extends FragmentPagerAdapter {
            private ArrayList<Fragment> fragments;
            private ArrayList<String> titles;


            public ViewpageAdapter(@NonNull FragmentManager fm) {
                super(fm);
                this.fragments = new ArrayList<>();
                this.titles = new ArrayList<>();
            }

            void addFragments(Fragment fragment, String title) {
                fragments.add(fragment);
                titles.add(title);

            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        }
    }
