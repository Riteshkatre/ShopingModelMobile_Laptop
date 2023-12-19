package com.example.shopingmodel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.shopingmodel.Fragment.LaptopFregment;
import com.example.shopingmodel.Fragment.MobileFregment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tablay;
    ViewPager2 viewPage2;
    Fragment LaptopFregment, MobileFregment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablay = findViewById(R.id.tablay);
        viewPage2 = findViewById(R.id.viewpage2);

        LaptopFregment  = new LaptopFregment();
        MobileFregment  = new MobileFregment();

        tablay = findViewById(R.id.tablay);
        viewPage2 = findViewById(R.id.viewpage2);

        viewPage2.setAdapter(new ViewPagerAdapter(MainActivity.this));



        new TabLayoutMediator(tablay, viewPage2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position==0)
                    tab.setText("Laptop");
                else
                    tab.setText("Mobile");
            }
        }).attach();


    }

    public class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if(position==0){
                return LaptopFregment;
            }
            else {
                return MobileFregment;
            }



        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}




