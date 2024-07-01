module.exports = {
    sendHapticFeedback: function(
        androidType = 'CONFIRM',
        iosType = 'Success',
        errorCallback = (errorMessage) => console.error(errorMessage)
    ) {
        cordova.exec(null, errorCallback, 'HapticPlugin', 'sendHapticFeedback', [androidType, iosType]);
    }
}