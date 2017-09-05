package github.guawazi.aboutmvp.HomeCategory;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import github.guawazi.aboutmvp.R;

public class MainActivity extends AppCompatActivity {
    
        public static final String ANDROID = "Android";
        public static final String IOS = "iOS";
        public static final String RESTVIDEO = "休息视频";
        public static final String WELFARE = "福利";
        public static final String EXPANDRESOURCES = "拓展资源";
        public static final String FRONTEND = "前端";
        public static final String RECOMMEND = "瞎推荐";
    
        private TabLayout mTab;
        private ViewPager mPager;
        private MainPagerAdapter mAdapter;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initView();
            initData();
        }
    
        @StringDef({ANDROID, IOS, RESTVIDEO, WELFARE, EXPANDRESOURCES, FRONTEND, RECOMMEND})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Category {
    
        }
    
        private void initView() {
            mTab = (TabLayout) findViewById(R.id.tab);
            mPager = (ViewPager) findViewById(R.id.pager);
            mAdapter = new MainPagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mAdapter);
            mTab.setupWithViewPager(mPager);
        }
    
        private void initData() {
            initFragments();
        }
    
        private void initFragments() {
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(ANDROID),ANDROID);
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(IOS),IOS);
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(RESTVIDEO),RESTVIDEO);
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(WELFARE),WELFARE);
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(EXPANDRESOURCES),EXPANDRESOURCES);
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(FRONTEND),FRONTEND);
            mAdapter.addFragmentAndTitle(CategoryDefaultFragment.newInstance(RECOMMEND),RECOMMEND);
        }
    }