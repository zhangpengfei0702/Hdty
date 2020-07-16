package com.zhjy.hdty.work.baselib.mvp.base;

import android.os.Bundle;

import com.zhjy.hdty.work.baselib.mvp.FragmentPresenter;
import com.zhjy.hdty.work.baselib.mvp.GEMUI;
import com.zhjy.hdty.work.baselib.mvp.MVPFragment;
import com.zhjy.hdty.work.baselib.mvp.ViewFinder;


/**
 *
 */

/**
 * Created by zpf on 2018/7/22.
 * Fragment的base基类
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseFragment<V extends GEMUI, P extends FragmentPresenter<V>> extends MVPFragment<V, P>
        implements GEMUI {
    private ViewFinder finder;
    private P presenter;

//    private ShapeLoadingDialog dialog;

//    private AlertDialogView alertDialogView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            finder = new ViewFinder(getActivity());
        }

        initViews();
        presenter = createPresenter();
        presenter.onActivityCreated(savedInstanceState);
    }


     abstract void initViews();

    @Override
    public ViewFinder finder() {
        return finder;
    }

    @Override
    public void showProgress() {


//        if (dialog == null) {
//
//            dialog = new ShapeLoadingDialog.Builder(getActivity())
//                    .loadText("加载中...")
//                    .build();
//            dialog.setCanceledOnTouchOutside(false);
////            dialog.setCancelable(false);
//
//        }
//        dialog.show();
//        if (getActivity() instanceof BaseActivity)
//            ((BaseActivity) getActivity()).showProgress(title, content);
    }

    @Override
    public void dismissProgress() {
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//        dialog = null;
//        if (getActivity() instanceof BaseActivity)
//            ((BaseActivity) getActivity()).dismissProgress();
    }


}