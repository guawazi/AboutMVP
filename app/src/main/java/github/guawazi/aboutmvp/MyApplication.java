package github.guawazi.aboutmvp;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by wangliang on 2017/9/5.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidLogAdapter adapter = new AndroidLogAdapter();
        Logger.addLogAdapter(adapter);
    }
}
