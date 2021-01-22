package com.toutiao.bawei.a1805toutiao.lazy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.toutiao.bawei.a1805toutiao.R;

public class LazyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lazy);
        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = findViewById(R.id.lazyViewPager);
        LazyFrgmentAdpater lazyFrgmentAdpater = new LazyFrgmentAdpater(getSupportFragmentManager());
        viewPager.setAdapter(lazyFrgmentAdpater);
    }


    private class LazyFrgmentAdpater extends FragmentStatePagerAdapter {
        private Fragment[] fragments = new Fragment[] {new FirstFragment(),new SecondFragment(),new ThirdFragment(),new FourthFragment()};

        public LazyFrgmentAdpater(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments[i];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
