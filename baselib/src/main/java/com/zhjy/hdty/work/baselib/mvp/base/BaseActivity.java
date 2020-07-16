package com.zhjy.hdty.work.baselib.mvp.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.zhjy.hdty.work.baselib.R;
import com.zhjy.hdty.work.baselib.mvp.ActPresenter;
import com.zhjy.hdty.work.baselib.mvp.GEMUI;
import com.zhjy.hdty.work.baselib.mvp.MVPActivity;
import com.zhjy.hdty.work.baselib.mvp.ViewFinder;

import java.util.List;

//import com.bugtags.library.Bugtags;


/**
 * Created by wpy on 2017/7/22.
 */

/**
 * Activity的base基类
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseActivity<V extends GEMUI, P extends ActPresenter<V>> extends MVPActivity<V, P> implements GEMUI {
    private ViewFinder finder;

//    private ShapeLoadingDialog dialog;

//    private AlertDialogView alertDialogView;


    @Override
    public Resources getResources() {//还原字体大小
        Resources res = super.getResources();
        //非默认值
        if (res.getConfiguration().fontScale != 1) {
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }


    @Override
    public void hideStatus() {
        if (finder == null) {
            //此处做判空处理
            finder = new ViewFinder(this);
        }
//        if (finder.find(R.id.item_head) != null) {
//            finder.find(R.id.item_head).setVisibility(View.GONE);
//        }
    }

    @Override
    public ViewFinder finder() {
        if (finder == null) {


            finder = new ViewFinder(this);
        }
        return finder;
    }

    @Override
    public void showProgress() {
//        if (dialog == null) {
//
//            dialog = new ShapeLoadingDialog.Builder(this)
//                    .loadText("加载中...")
//                    .build();
//            dialog.setCanceledOnTouchOutside(false);
////            dialog.setCancelable(false);
//        }
//        dialog.show();
    }

    @Override
    public void dismissProgress() {
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//        dialog = null;
    }




    //    @Override
//    public Resources getResources() {
//        Resources resources = super.getResources();
//        Configuration configuration = resources.getConfiguration();
//        configuration.fontScale = 1.5f;
//        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//
//        return resources;
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(TextUtils.isEmpty(AuthController.SingleTon.getInstance().getAuth())) {
//            AuthController.SingleTon.getInstance().getAuthInfoN(this);
//        }
//        if (!BuildConfig.DEBUG){
//            MobclickAgent.onResume(this);
//        }else{
//            Bugtags.onResume(this);
//        }
//        Bugtags.onResume(this);

    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        getPresenter().onActivityResult(requestCode, resultCode, data);
//        FragmentManager fm = getSupportFragmentManager();
//
//        Fragment frag = fm.findFragmentByTag(RedPacketFragment.class.getName());
//        if (frag == null) {
//        } else {
//            handleResult(frag, requestCode, resultCode, data);
//        }
//        return;
//    }

    /**
     * 递归调用，对所有子Fragement生效
     *
     * @param frag
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (!BuildConfig.DEBUG){
//            MobclickAgent.onPause(this);
//        }else{
//            Bugtags.onPause(this);
//        }
//        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //注：回调 3
//        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }

    /**
     * 请求权限
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

//        switch (requestCode) {
//            case Constant.REQ_CODE_PERMISSION: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED&&permissions[0].equals(Manifest.permission.CAMERA)) {
//                    EventBus.getDefault().post(new ScanEvent());
//                }
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED&&permissions[0].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    EventBus.getDefault().post(new MassiteEvent());
//                }
//                return;
//            }
//        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ToastUtil.cancelToast();
//        PopupController.SingleTon.getInstance().wipe();
//        DialogController.SingleTon.getInstance().wipe();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
