package github.guawazi.aboutmvp.HomeCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import github.guawazi.aboutmvp.R;

public class CategoryDefaultFragment extends Fragment {

    private static final String CATEGORY_TYPE = "type";

    private String mType;


    public CategoryDefaultFragment() {
    }

    /**
     *
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
        return inflater.inflate(R.layout.fragment_category_default, container, false);
    }



}
