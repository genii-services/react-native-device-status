/**
 * @providesModule RNDeviceStatus
 * @flow
 */
"use strict"

var NativeRNDeviceStatus = require("NativeModules").RNDeviceStatus

/**
 * High-level docs for the RNDeviceStatus iOS API can be written here.
 */

var RNDeviceStatus = {
	test: function() {
		NativeRNDeviceStatus.test()
	}
}

module.exports = RNDeviceStatus
