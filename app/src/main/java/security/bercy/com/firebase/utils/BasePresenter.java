package security.bercy.com.firebase.utils;

/**
 * Created by Bercy on 12/20/17.
 */

public interface BasePresenter<V extends BaseView >  {
    void attchView(V view);
    void detachView();
}
