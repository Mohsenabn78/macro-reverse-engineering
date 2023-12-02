package com.twofortyfouram.locale.sdk.host.model;

import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.api.Intent;
import com.twofortyfouram.log.Lumberjack;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public enum PluginErrorRegister implements IPluginError {
    ACTIVITY_REQUIRES_PERMISSION("The Activity requires a permission that is not granted to the host.  To resolve this issue, remove the permission attribute from the Activity's entry in the Android Manifest.", true),
    ACTIVITY_NOT_ENABLED("The Activity is disabled.  To resolve this issue, remove enabled=\"false\" from the Activity element in the Android Manifest.", true),
    ACTIVITY_NOT_EXPORTED("The Activity is not exported.  To resolve this issue, remove exported=\"false\" from the Activity element in the Android Manifest.", true),
    INSTALL_LOCATION_BAD("Plug-ins must be installed on internal storage.  To resolve this issue, set installLocation=\"internalOnly\" in the AndroidManifest", false),
    RECEIVER_REQUIRES_PERMISSION("The BroadcastReceiver requires a permission that is not granted to the host.  To resolve this issue, remove the permission attribute from the BroadcastReceiver's entry in the Android Manifest.", true),
    APPLICATION_NOT_ENABLED("The Application is disabled.  To resolve this issue, remove enabled=\"false\" from the Application element in the Android Manifest.", true),
    RECEIVER_NOT_ENABLED("The BroadcastReceiver is disabled.  To resolve this issue, remove enabled=\"false\" from the BroadcastReceiver element in the Android Manifest.", true),
    RECEIVER_NOT_EXPORTED("The BroadcastReceiver is not exported.  To resolve this issue, remove exported=\"false\" from the BroadcastReceiver element in the Android Manifest.", true),
    RECEIVER_DUPLICATE(Lumberjack.formatMessage("The plug-in has multiple BroadcastReceivers for the plug-in Intent action.  To resolve this issue, each plug-in must only have a single BroadcastReceiver for %s and/or %s", Intent.ACTION_QUERY_CONDITION, Intent.ACTION_FIRE_SETTING), true),
    MISSING_RECEIVER(Lumberjack.formatMessage("The plug-in has no BroadcastReceivers for the plug-in Intent action.  To resolve this issue, each plug-in must have a single BroadcastReceiver for %s and/or %s", Intent.ACTION_QUERY_CONDITION, Intent.ACTION_FIRE_SETTING), true);
    
    @NonNull
    private final String mDeveloperExplanation;
    private final boolean mIsFatal;

    PluginErrorRegister(@NonNull String str, boolean z3) {
        Assertions.assertNotNull(str, "developerExplanation");
        this.mDeveloperExplanation = str;
        this.mIsFatal = z3;
    }

    @Override // com.twofortyfouram.locale.sdk.host.model.IPluginError
    @NonNull
    public String getDeveloperExplanation() {
        return this.mDeveloperExplanation;
    }

    @Override // com.twofortyfouram.locale.sdk.host.model.IPluginError
    public boolean isFatal() {
        return this.mIsFatal;
    }
}
