//
//  HapticPlugin.swift
//  Cordova Haptic Feedback Plugin
//
//  Created by Walter Robins on 6/24/24.
//

import Foundation

@objc(HapticPlugin)
class HapticPlugin : CDVPlugin {
    @objc(sendHapticFeedback:)func sendHapticFeedback(_ command: CDVInvokedUrlCommand) {
        let hapticFeedbackType = command.arguments[1] as? String
        if (hapticFeedbackType == "ImpactLight") {
            var feedback = UIImpactFeedbackGenerator(style: UIImpactFeedbackGenerator.FeedbackStyle.light)
            feedback.impactOccurred()
        }
        if (hapticFeedbackType == "ImpactMedium") {
            var feedback = UIImpactFeedbackGenerator(style: UIImpactFeedbackGenerator.FeedbackStyle.medium)
            feedback.impactOccurred()
        }
        if (hapticFeedbackType == "ImpactHeavy") {
            var feedback = UIImpactFeedbackGenerator(style: UIImpactFeedbackGenerator.FeedbackStyle.heavy)
            feedback.impactOccurred()
        }
        if (hapticFeedbackType == "ImpactSoft") {
            if #available(iOS 13.0, *) {
                var feedback = UIImpactFeedbackGenerator(style: UIImpactFeedbackGenerator.FeedbackStyle.soft)
                feedback.impactOccurred()
            }
        }
        if (hapticFeedbackType == "ImpactRigid") {
            if #available(iOS 13.0, *) {
                var feedback = UIImpactFeedbackGenerator(style: UIImpactFeedbackGenerator.FeedbackStyle.rigid)
                feedback.impactOccurred()
            }
        }
        if (hapticFeedbackType == "Success") {
            var feedback = UINotificationFeedbackGenerator()
            feedback.notificationOccurred(UINotificationFeedbackGenerator.FeedbackType.success)
        }
        if (hapticFeedbackType == "Warning") {
            var feedback = UINotificationFeedbackGenerator()
            feedback.notificationOccurred(UINotificationFeedbackGenerator.FeedbackType.warning)
        }
        if (hapticFeedbackType == "Error") {
            var feedback = UINotificationFeedbackGenerator()
            feedback.notificationOccurred(UINotificationFeedbackGenerator.FeedbackType.error)
        }
        if (hapticFeedbackType == "SelectionChanged") {
            var feedback = UISelectionFeedbackGenerator()
            feedback.selectionChanged()
        }
        self.commandDelegate!.send(CDVPluginResult(status: CDVCommandStatus_OK), callbackId: command.callbackId)
    }
}
