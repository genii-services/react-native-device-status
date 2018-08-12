# react-native-device-status

[![NPM](https://nodei.co/npm/react-native-device-status.png)](https://www.npmjs.com/package/react-native-device-status)

## Features

### Android

- Check if the device is rooted.
- Check if the device has screen lock enabled.

### IOS (WIP)

- Check if the device is jailbroken.
- Check if the device has screen lock enabled.

## Requirements

### Android

API 16+

### IOS

IOS 8+

### React Native

RN 0.27+

## Getting started

`$ npm install react-native-device-status --save`

### Mostly automatic installation

Please follow manual instructions since rnpm only help with basic linking.
**Note: IOS will not automatically install because I am wrapping another library via cocoapods. Please follow manual instruction. (Suggestions welcome.)**

`$ react-native link react-native-device-status`

## Manual installation

### IOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-device-status` and add `RNDeviceStatus.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDeviceStatus.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Click RNDeviceStatus.xcodeproj in the project navigator and go the **Build Settings** tab. Make sure 'All' is toggled on (instead of 'Basic'). Look for **Header Search Paths** and make sure it contains the following and all marked as **recursive**:

   **$(SRCROOT)/../../React
   $(SRCROOT)/../../react-native/React
   ${SRCROOT}/../../react-native-device-status/ios/Pods/Headers/Public
   ${SRCROOT}/../../react-native-device-status/ios/Pods/Headers/Public/UIDevice-PasscodeStatus**

5. Inside your {ReactNativeProject}/ios directory add a file named **Podfile** with the following [content](https://github.com/beast/react-native-device-status/blob/master/Podfile.template)
6. Run pod install in the directory mentioned in step 5.
7. Run react-native run-ios or build in Xcode.

**Note: If you are building inside of xcode, make sure you open the workspace file not the proejct file.**

#### CocoaPods Warning

If you get the following warning.

```
[!] The `<YourAppName> [Debug]` target overrides the `OTHER_LDFLAGS` build setting defined in `Pods/Target Support Files/Pods/Pods.debug.xcconfig'. This can lead to problems with the CocoaPods installation
    - Use the `$(inherited)` flag, or
    - Remove the build settings from the target.

[!] The `<YourAppName> [Release]` target overrides the `OTHER_LDFLAGS` build setting defined in `Pods/Target Support Files/Pods/Pods.release.xcconfig'. This can lead to problems with the CocoaPods installation
    - Use the `$(inherited)` flag, or
    - Remove the build settings from the target.
```

Click `<YourAppName>.xcodeproj` in the project navigator and go the `Build Settings` tab. Make sure 'All' is toggled on (instead of 'Basic'). Look for `Other Linker Flags` and replace the value `-ObjC` with the value `$(inherited)` for your Application's Target.

#### libpods Error

If you received an libpods error for the RNDeviceStatus project, it's safe to remove under its build phases settings > Link binary with libraries

### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`

- Add `import my.fin.RNDeviceStatusPackage;` to the imports at the top of the file
- Add `new RNDeviceStatusPackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:
   ```
   include ':react-native-device-status'
   project(':react-native-device-status').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-device-status/android/app')
   ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
   ```
     compile project(':react-native-device-status')
   ```

## Usage

```javascript
import RNDeviceStatus from "react-native-device-status"

// Check if device is rooted or jailbroken.
const isRooted = RNDeviceStatus.isRooted()
console.log(isRooted)

// Check if device has screenslock enabled.
const isLocked = await RNDeviceStatus.isLocked()
console.log(isLocked)
```

##License
[MIT](./License)

##Credit
liamnichols - [UIDevice-Password](https://github.com/liamnichols/UIDevice-PasscodeStatus)
