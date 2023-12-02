package com.twofortyfouram.locale.sdk.host.model;

import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.api.Intent;
import com.twofortyfouram.log.Lumberjack;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public enum PluginErrorEdit implements IPluginError {
    ACTIVITY_NOT_FOUND_EXCEPTION("The Activity could not be found.  To resolve this issue, make sure the plug-in package is still installed.", true),
    BLURB_MISSING(Lumberjack.formatMessage("%s is missing.  To resolve this issue, put the blurb extra in the Activity result Intent.", Intent.EXTRA_STRING_BLURB), true),
    BUNDLE_TOO_LARGE(Lumberjack.formatMessage("%s is larger than the allowed maximum of %d bytes.  To resolve this issue, store less data in the Bundle.", Intent.EXTRA_BUNDLE, Integer.valueOf((int) PluginInstanceData.MAXIMUM_BUNDLE_SIZE_BYTES)), true),
    BUNDLE_MISSING(Lumberjack.formatMessage("Extra %s is required.  To resolve this issue, put the Bundle extra in the Activity result Intent.", Intent.EXTRA_BUNDLE), true),
    BUNDLE_NOT_SERIALIZABLE(Lumberjack.formatMessage("%s could not be serialized.  To resolve this issue, be sure the Bundle doesn't contain Parcelable or private Serializable subclasses", Intent.EXTRA_BUNDLE), true),
    INTENT_NULL("Activity result Intent is null.  To resolve this issue, the child Activity needs to call setResult(RESULT_OK, Intent) or setResult(RESULT_CANCELED) before finishing.", true),
    PRIVATE_SERIALIZABLE("Intent or Bundle contains a private Serializable subclass which is not known to this app's classloader.  To resolve this issue, the DO NOT place a private Serializable subclass in Intents sent across processes.", true),
    SECURITY_EXCEPTION("The Activity could not be launched because of a security error.  To resolve this issue, make sure the Activity is exported and does not require a permission.", true),
    UNKNOWN_ACTIVITY_RESULT_CODE("Plug-ins must return one of the result codes ACTIVITY.RESULT_OK or ACTIVITY.RESULT_CANCELED", true);
    
    @NonNull
    private final String mDeveloperExplanation;
    private final boolean mIsFatal;

    PluginErrorEdit(@NonNull String str, boolean z3) {
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
