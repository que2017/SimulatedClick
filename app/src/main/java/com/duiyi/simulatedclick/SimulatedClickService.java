package com.duiyi.simulatedclick;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/**
 * 模拟点击的服务类
 *
 * @author zhang
 * @since 2019-12-14
 */
public class SimulatedClickService extends AccessibilityService {
    private static final String TAG = SimulatedClickService.class.getSimpleName();

    /**
     * 监听窗口变化的回调
     *
     * @param event 窗口变化事件
     */
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

    }

    /**
     * 中断服务的回调
     */
    @Override
    public void onInterrupt() {
    }

    /**
     * 当服务启动时的回调，可以做一些初始化操作
     */
    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }
}
