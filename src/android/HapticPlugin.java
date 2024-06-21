package com.wrobins.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import android.view.HapticFeedbackConstants;
import android.view.View;

public class HapticPlugin extends CordovaPlugin {
    private View cordovaWebView;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        cordovaWebView = webView.getView();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if ("sendHapticFeedback".equals(action)) {
            try {
                int hapticFeedbackType = HapticFeedbackConstants.NO_HAPTICS;
                switch (args.getString(0)) {
                    case "CLOCK_TICK":
                        hapticFeedbackType = HapticFeedbackConstants.CLOCK_TICK;
                        break;
                    case "CONFIRM":
                        hapticFeedbackType = HapticFeedbackConstants.CONFIRM;
                        break;
                    case "CONTEXT_CLICK":
                        hapticFeedbackType = HapticFeedbackConstants.CONTEXT_CLICK;
                        break;
                    case "DRAG_START":
                        hapticFeedbackType = HapticFeedbackConstants.DRAG_START;
                        break;
                    case "GESTURE_END":
                        hapticFeedbackType = HapticFeedbackConstants.GESTURE_END;
                        break;
                    case "GESTURE_START":
                        hapticFeedbackType = HapticFeedbackConstants.GESTURE_START;
                        break;
                    case "GESTURE_THRESHOLD_ACTIVATE":
                        hapticFeedbackType = HapticFeedbackConstants.GESTURE_THRESHOLD_ACTIVATE;
                        break;
                    case "GESTURE_THRESHOLD_DEACTIVATE":
                        hapticFeedbackType = HapticFeedbackConstants.GESTURE_THRESHOLD_DEACTIVATE;
                        break;
                    case "KEYBOARD_PRESS":
                        hapticFeedbackType = HapticFeedbackConstants.KEYBOARD_PRESS;
                        break;
                    case "KEYBOARD_RELEASE":
                        hapticFeedbackType = HapticFeedbackConstants.KEYBOARD_RELEASE;
                        break;
                    case "KEYBOARD_TAP":
                        hapticFeedbackType = HapticFeedbackConstants.KEYBOARD_TAP;
                        break;
                    case "LONG_PRESS":
                        hapticFeedbackType = HapticFeedbackConstants.LONG_PRESS;
                        break;
                    case "REJECT":
                        hapticFeedbackType = HapticFeedbackConstants.REJECT;
                        break;
                    case "SEGMENT_FREQUENT_TICK":
                        hapticFeedbackType = HapticFeedbackConstants.SEGMENT_FREQUENT_TICK;
                        break;
                    case "SEGMENT_TICK":
                        hapticFeedbackType = HapticFeedbackConstants.SEGMENT_TICK;
                        break;
                    case "TEXT_HANDLE_MOVE":
                        hapticFeedbackType = HapticFeedbackConstants.TEXT_HANDLE_MOVE;
                        break;
                    case "TOGGLE_OFF":
                        hapticFeedbackType = HapticFeedbackConstants.TOGGLE_OFF;
                        break;
                    case "TOGGLE_ON":
                        hapticFeedbackType = HapticFeedbackConstants.TOGGLE_ON;
                        break;
                    case "VIRTUAL_KEY":
                        hapticFeedbackType = HapticFeedbackConstants.VIRTUAL_KEY;
                        break;
                    case "VIRTUAL_KEY_RELEASE":
                        hapticFeedbackType = HapticFeedbackConstants.VIRTUAL_KEY_RELEASE;
                }
                this.cordovaWebView.performHapticFeedback(hapticFeedbackType);
                callbackContext.success();
            }
            catch (Exception ex) {
                callbackContext.error(ex.getMessage());
            }
            return true;
        }
        return false;
    }
}