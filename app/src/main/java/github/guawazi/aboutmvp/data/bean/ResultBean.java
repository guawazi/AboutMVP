package github.guawazi.aboutmvp.data.bean;

/**
 * Created by wangliang on 2017/9/5.
 */

public class ResultBean<T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
