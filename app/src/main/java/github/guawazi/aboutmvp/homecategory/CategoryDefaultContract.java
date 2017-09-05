package github.guawazi.aboutmvp.homecategory;

import github.guawazi.aboutmvp.BasePresenter;
import github.guawazi.aboutmvp.BaseView;

/**
 * Created by wangliang on 2017/9/5.
 */

public interface CategoryDefaultContract {
    interface View extends BaseView<Presenter> {
        void showEmptyView();

        void dismissEmptyView();

        void showLoadingView();

        void dismissLoadingView();

        void showErrorView();

        void dismissErrorView();

        void showContentView();

        void dismissContentView();
    }

    interface Presenter extends BasePresenter {
        void forceRefresh();
    }
}
