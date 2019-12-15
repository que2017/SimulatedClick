package com.duiyi.simulatedclick;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * 模拟点击的服务类
 *
 * @author zhang
 * @since 2019-12-14
 */
public class SimulatedClickService extends AccessibilityService {
    private static final String TAG = SimulatedClickService.class.getSimpleName();

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public void handleMessage(Message msg) {
            dispatchGestureClick(160, 60);
        }
    };

    /**
     * 监听窗口变化的回调
     *
     * @param event 窗口变化事件
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        Log.i(TAG, "onAccessibilityEvent: " + eventType);
        switch (eventType) {
            // 通知栏发生变化
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                // 模拟点击通知栏，因为通知栏弹出有动画，所以需要延迟
                handler.sendEmptyMessageDelayed(0, 1500);
                break;
            default:
        }
    }
    @RequiresApi(24)
    public void dispatchGestureClick(int x, int y) {
        Path path = new Path();
        path.moveTo(x, y);
        boolean click = dispatchGesture(new GestureDescription
                .Builder()
                .addStroke(new GestureDescription.StrokeDescription(path, 0, 100)).build(),null, null);
        Log.i(TAG, "dispatchGestureClick: " + click);
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
