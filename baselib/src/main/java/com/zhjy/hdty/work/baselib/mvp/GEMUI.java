package com.zhjy.hdty.work.baselib.mvp;



/**
 * MVP - View interface
 * <p>
 * Created by zpf on 2017/7/22.
 */

public interface GEMUI {

    boolean isAlive();

    /**
     * whether is resumed or visible to user
     *
     *
     */
    boolean isActive();


    /**
     * Return activity_details_rc_top resource for activity or fragment
     *
     *
     */
    int getContentLayout();

    /**
     * Provide a viewfinder to simplify find a View in Res
     *
     *
     */
    ViewFinder finder();

    /**
     * 展示加载动画
     */
    void showProgress();

    /**
     * 关闭加载动画
     */
    void dismissProgress();


//    void showAlertinfo(String status, String content);




}
