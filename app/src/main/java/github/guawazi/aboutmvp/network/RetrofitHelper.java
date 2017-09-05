package github.guawazi.aboutmvp.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by wangliang on 2017/9/5.
 */

public class RetrofitHelper {
    private RetrofitHelper(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3000, TimeUnit.MICROSECONDS);

    }
}
