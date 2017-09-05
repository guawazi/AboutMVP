package github.guawazi.aboutmvp.homecategory;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by wangliang on 2017/9/5.
 */

public class CategoryDefaultPresenter implements CategoryDefaultContract.Presenter {

    private static final int REQUEST_NETWORK = 1;

    private CategoryDefaultContract.View mCategoryDefaultView;
    private CategoryDefaultRepository mCategoryDefaultRepository;
    private Handler handler = new Handler(Looper.getMainLooper(), msg -> {
        switch (msg.what) {
            case REQUEST_NETWORK:
                mCategoryDefaultView.dismissLoadingView();
                mCategoryDefaultView.showContentView();
                break;
        }
        return true;
    });

    CategoryDefaultPresenter(CategoryDefaultContract.View categoryDefaultView, CategoryDefaultRepository categoryDefaultRepository) {
        this.mCategoryDefaultView = categoryDefaultView;
        this.mCategoryDefaultRepository = categoryDefaultRepository;
        mCategoryDefaultView.setPresenter(this);
    }

    @Override
    public void start() {
        mCategoryDefaultView.showLoadingView();
        mCategoryDefaultView.dismissContentView();
        Message message = Message.obtain();
        message.what = REQUEST_NETWORK;
        handler.sendMessageDelayed(message, 3000);
    }

    @Override
    public void forceRefresh() {

    }
}
