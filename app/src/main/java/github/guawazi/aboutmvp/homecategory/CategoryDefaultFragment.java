package github.guawazi.aboutmvp.homecategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import github.guawazi.aboutmvp.R;

public class CategoryDefaultFragment extends Fragment implements CategoryDefaultContract.View {

    private static final String CATEGORY_TYPE = "type";

    private String mType;
    private RecyclerView mRecycler;
    private ImageView mIvStatus;
    private CategoryDefaultContract.Presenter mPresenter;


    public CategoryDefaultFragment() {
    }

    /**
     * @param type 传入fragment 类型
     * @return
     */
    public static CategoryDefaultFragment newInstance(@MainActivity.Category String type) {
        CategoryDefaultFragment fragment = new CategoryDefaultFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getString(CATEGORY_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_default, container, false);
        initView(view);
        return view;
    }

    private void initView(View root) {
        mRecycler = ((RecyclerView) root.findViewById(R.id.recycler));
        mIvStatus = ((ImageView) root.findViewById(R.id.iv_status));
    }



    @Override
    public void setPresenter(CategoryDefaultContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showEmptyView() {
        if (mIvStatus != null) {
            mIvStatus.setImageResource(R.drawable.empty_view);
            mIvStatus.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismissEmptyView() {
        if (mIvStatus != null) {
            mIvStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoadingView() {
        if (mIvStatus != null) {
            mIvStatus.setImageResource(R.drawable.loading_view);
            mIvStatus.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismissLoadingView() {
        if (mIvStatus != null) {
            mIvStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public void showErrorView() {
        if (mIvStatus != null) {
            mIvStatus.setImageResource(R.drawable.error_view);
            mIvStatus.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismissErrorView() {
        if (mIvStatus != null) {
            mIvStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public void showContentView() {
        if (mRecycler != null) {
            mRecycler.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismissContentView() {
        if (mRecycler != null) {
            mRecycler.setVisibility(View.GONE);
        }
    }
}
