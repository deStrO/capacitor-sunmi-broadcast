import Foundation

@objc public class SunmiBroadcast: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
