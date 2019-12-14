package com.duiyi.simulatedclick;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

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
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        switch (eventType) {
            // 通知栏发生变化
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                // 模拟点击
                AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
                List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("信息");
                for (AccessibilityNodeInfo msgNodeInfo : list) {
                    msgNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
                break;
            default:
        }
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
