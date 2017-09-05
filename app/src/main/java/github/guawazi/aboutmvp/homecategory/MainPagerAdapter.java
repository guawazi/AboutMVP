package github.guawazi.aboutmvp.homecategory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang on 2017/9/5.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mFragmentList = new ArrayList<>();
        this.mTitleList = new ArrayList<>();
    }

    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position).toString();
    }

    public void addFragmentAndTitle(Fragment fragment, @MainActivity.Category String title) {
        this.mFragmentList.add(fragment);
        this.mTitleList.add(title);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mFragmentList.clear();
        this.mTitleList.clear();
        notifyDataSetChanged();
    }
}
