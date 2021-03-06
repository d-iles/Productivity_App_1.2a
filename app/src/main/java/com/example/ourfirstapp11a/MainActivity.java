package com.example.ourfirstapp11a;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ViewPager2 viewPager2;
    private FragmentStateAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private String[] title = new String[] {"first", "second", "third", "fourth"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this);
        viewPager2.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("Tab" + position+1);
            }

        });

        tabLayout.selectTab(tabLayout.getTabAt(1));
        viewPager2.setCurrentItem(1);

    }

    void selectPage(int pageIndex){
        tabLayout.setScrollPosition(pageIndex,0f,true);
        viewPager2.setCurrentItem(pageIndex);
    }

}
