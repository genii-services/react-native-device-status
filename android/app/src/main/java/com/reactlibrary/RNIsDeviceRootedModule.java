
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNIsDeviceRootedModule extends ReactContextBaseJavaModule {

	private final ReactApplicationContext reactContext;

	public RNIsDeviceRootedModule(ReactApplicationContext reactContext) {
	super(reactContext);
	this.reactContext = reactContext;
	}

	@Override
	public String getName() {
	return "RNIsDeviceRooted";
	}

	@ReactMethod
	public boolean isDeviceRooted() {
		return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
	}

	private static boolean checkRootMethod1() {
	    String buildTags = android.os.Build.TAGS;
	    return buildTags != null && buildTags.contains("test-keys");
	}

	private static boolean checkRootMethod2() {
	    String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
	            "/system/bin/failsafe/su", "/data/local/su" };
	    for (String path : paths) {
	        if (new File(path).exists()) return true;
	    }
	    return false;
	}

	private static boolean checkRootMethod3() {
	    Process process = null;
	    try {
	        process = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
	        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        if (in.readLine() != null) return true;
	        return false;
	    } catch (Throwable t) {
	        return false;
	    } finally {
	        if (process != null) process.destroy();
	    }
	}
}