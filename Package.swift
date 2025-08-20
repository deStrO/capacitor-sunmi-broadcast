// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorSunmiBroadcast",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorSunmiBroadcast",
            targets: ["SunmiBroadcastPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "SunmiBroadcastPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/SunmiBroadcastPlugin"),
        .testTarget(
            name: "SunmiBroadcastPluginTests",
            dependencies: ["SunmiBroadcastPlugin"],
            path: "ios/Tests/SunmiBroadcastPluginTests")
    ]
)