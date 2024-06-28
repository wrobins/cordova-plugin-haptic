//
//  HapticPlugin.swift
//  CordovaPlayground
//
//  Created by Walter Robins on 6/24/24.
//

import Foundation

@objc(HapticPlugin)
class HapticPlugin : CDVPlugin {
    var pluginResult = CDVPluginResult(status: CDVCommandStatus_ERROR)
    @objc(sendHapticFeedback:)func sendHapticFeedback(_ command: CDVInvokedUrlCommand) {
        let hapticFeedbackType = command.arguments[1] as? String
        self.commandDelegate!.send(pluginResult, callbackId: command.callbackId)
    }
}