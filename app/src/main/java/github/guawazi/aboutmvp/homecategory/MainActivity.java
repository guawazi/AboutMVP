package github.guawazi.aboutmvp.homecategory;

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
    private CategoryDefaultPresenter mAndroidPresenter;
    private CategoryDefaultPresenter mIOSPresenter;
    private CategoryDefaultPresenter mRestVideoPresenter;
    private CategoryDefaultPresenter mWelfarePresenter;
    private CategoryDefaultPresenter mExpandresourcesPresenter;
    private CategoryDefaultPresenter mFrontendPresenter;
    private CategoryDefaultPresenter mRecommendPresenter;

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
        // now use default fragment  Change as needed
        CategoryDefaultFragment fragmentAnroid = CategoryDefaultFragment.newInstance(ANDROID);
        CategoryDefaultFragment fragmentIOS = CategoryDefaultFragment.newInstance(IOS);
        CategoryDefaultFragment fragmentRestVideo = CategoryDefaultFragment.newInstance(RESTVIDEO);
        CategoryDefaultFragment fragmentWelfare = CategoryDefaultFragment.newInstance(WELFARE);
        CategoryDefaultFragment fragmentExpandresources = CategoryDefaultFragment.newInstance(EXPANDRESOURCES);
        CategoryDefaultFragment fragmentFrontend = CategoryDefaultFragment.newInstance(FRONTEND);
        CategoryDefaultFragment fragmentRecommend = CategoryDefaultFragment.newInstance(RECOMMEND);

        // use default repository  Change as needed
        CategoryDefaultRepository categoryDefaultRepository = new CategoryDefaultRepository();

        // use default presenter  Change as needed
        mAndroidPresenter = new CategoryDefaultPresenter(fragmentAnroid,categoryDefaultRepository);
        mIOSPresenter = new CategoryDefaultPresenter(fragmentIOS,categoryDefaultRepository);
        mRestVideoPresenter = new CategoryDefaultPresenter(fragmentRestVideo,categoryDefaultRepository);
        mWelfarePresenter = new CategoryDefaultPresenter(fragmentWelfare,categoryDefaultRepository);
        mExpandresourcesPresenter = new CategoryDefaultPresenter(fragmentExpandresources,categoryDefaultRepository);
        mFrontendPresenter = new CategoryDefaultPresenter(fragmentFrontend,categoryDefaultRepository);
        mRecommendPresenter = new CategoryDefaultPresenter(fragmentRecommend,categoryDefaultRepository);

        mAdapter.addFragmentAndTitle(fragmentAnroid, ANDROID);
        mAdapter.addFragmentAndTitle(fragmentIOS, IOS);
        mAdapter.addFragmentAndTitle(fragmentRestVideo, RESTVIDEO);
        mAdapter.addFragmentAndTitle(fragmentWelfare, WELFARE);
        mAdapter.addFragmentAndTitle(fragmentExpandresources, EXPANDRESOURCES);
        mAdapter.addFragmentAndTitle(fragmentFrontend, FRONTEND);
        mAdapter.addFragmentAndTitle(fragmentRecommend, RECOMMEND);
    }
}