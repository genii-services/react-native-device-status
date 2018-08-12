#if __has_include("RCTBridgeModule.h")
	#import "RCTBridgeModule.h"
#else
	#import <React/RCTBridgeModule.h>
#endif

@interface RNDeviceStatus : NSObject <RCTBridgeModule>

@end