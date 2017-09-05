package github.guawazi.aboutmvp.network;

import github.guawazi.aboutmvp.data.bean.ListContentBean;
import github.guawazi.aboutmvp.data.bean.ResultBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wangliang on 2017/9/5.
 */

public interface ContentServer {
    @GET("data/{type}/{month}/{day}")
    Call<ResultBean<ListContentBean>> getListData(@Path("type") String type,@Path("month") int month,@Path("day") int day);
}
