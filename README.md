# Cordova Haptic Feedback Plugin
Rather than hacking the new JavaScript API, add a native haptic feedback experience here!
Choose from Android and iOS built-in feedback patterns to play. All out-of-the-box native patterns should be supported. Details on implementation, as well as supported strings to pass to each platform, are below.
## Android
The Android haptic system makes use of the [[View component pattern](https://developer.android.com/develop/ui/views/haptics/haptic-feedback#view)] and all related constants (see below). Some of these constants require Android API level 34+ thus the plugin requirements.
### Constants
Pass one of the following strings to play the feedback pattern:
#### "CLOCK_TICK"
The user has pressed either an hour or minute tick of a Clock.
#### "CONFIRM"
A haptic effect to signal the confirmation or successful completion of a user interaction.
#### "CONTEXT_CLICK"
The user has performed a context click on an object.
#### "DRAG_START"
The user has started a drag-and-drop gesture.
#### "GESTURE_END"
The user has finished a gesture (e.g. on the soft keyboard).
#### "GESTURE_START"
The user has started a gesture (e.g. on the soft keyboard).
#### "GESTURE_THRESHOLD_ACTIVATE"
The user is executing a swipe/drag-style gesture, such as pull-to-refresh, where the gesture action is "eligible" at a certain threshold of movement, and can be cancelled by moving back past the threshold.
#### "GESTURE_THRESHOLD_DEACTIVATE"
The user is executing a swipe/drag-style gesture, such as pull-to-refresh, where the gesture action is "eligible" at a certain threshold of movement, and can be cancelled by moving back past the threshold.
#### "KEYBOARD_PRESS"
The user has pressed a virtual or software keyboard key.
#### "KEYBOARD_RELEASE"
The user has released a virtual keyboard key.
#### "KEYBOARD_TAP"
The user has pressed a soft keyboard key.
#### "LONG_PRESS"
The user has performed a long press on an object that is resulting in an action being performed.
#### "REJECT"
A haptic effect to signal the rejection or failure of a user interaction.
#### "SEGMENT_FREQUENT_TICK"
The user is switching between a series of many potential choices, for example minutes on a clock face, or individual percentages.
#### "SEGMENT_TICK"
The user is switching between a series of potential choices, for example items in a list or discrete points on a slider.
#### "TEXT_HANDLE_MOVE"
The user has performed a selection/insertion handle move on text field.
#### "TOGGLE_OFF"
The user has toggled a switch or button into the off position.
#### "TOGGLE_ON"
The user has toggled a switch or button into the on position.
#### "VIRTUAL_KEY"
The user has pressed on a virtual on-screen key.
#### "VIRTUAL_KEY_RELEASE"
The user has released a virtual key.
## iOS
The iOS haptic systems makes use of the [[UIFeedbackGenerator](https://developer.apple.com/documentation/uikit/animation_and_haptics)] subclasses and constants from UIKit, with the exception of UICanvasFeedbackGenerator. Some of the constants require iOS 13+ thus the plugin requirements. Note that these classes are generated on the fly when the feedback is sent in this plugin without making use of prepare() ahead of time, so keep that in mind when considering latency. Also, location-based feedback (passing location coordinates) is not supported, though I might add support in future releases.
### Constants
Pass one of the following strings to play the feedback pattern:
#### "ImpactLight"
A collision between small, light user interface elements.
#### "ImpactMedium"
A collision between moderately sized user interface elements.
#### "ImpactHeavy"
A collision between large, heavy user interface elements.
#### "ImpactSoft"
A collision between user interface elements that are soft, exhibiting a large amount of compression or elasticity.
#### "ImpactRigid"
A collision between user interface elements that are rigid, exhibiting a small amount of compression or elasticity.
#### "Success"
A notification feedback type that indicates a task has completed successfully.
#### "Warning"
A notification feedback type that indicates a task has produced a warning.
#### "Error"
A notification feedback type that indicates a task has failed.
#### "SelectionChanged"
Use selection feedback to communicate movement through a series of discrete values. For example, you might trigger selection feedback to indicate that a UI element’s values are changing.
## Usage
Playing haptic feedback is as simple as calling:
```js
cordova.plugins.hapticPlugin.sendHapticFeedback(androidType, iosType, errorMessage => doSomething(errorMessage));
```
All three parameters are optional, although you probably want to at least specify the first two if you don't want the 'CONFIRM' and 'Success' playbacks performed. If you don't specify an error callback, you'll get an error message in your JavaScript console if something goes wrong. Otherwise, the function is completely non-blocking and will not wait for an 'OK' plugin result. The rationale is you probably have better things to worry about in the app you're developing than making sure some subtle tactile candy plays when something happens in your interface.