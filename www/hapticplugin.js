module.exports = {
    sendHapticFeedback: function(
        androidType = 'CONFIRM',
        iosType = 'success',
        errorCallback = (errorMessage) => console.error(errorMessage)
    ) {
        cordova.exec(null, errorCallback, 'HapticPlugin', 'sendHapticFeedback', [androidType, iosType]);
    }
}