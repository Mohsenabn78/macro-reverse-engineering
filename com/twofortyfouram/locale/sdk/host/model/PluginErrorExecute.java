package com.twofortyfouram.locale.sdk.host.model;

import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public enum PluginErrorExecute implements IPluginError {
    CONDITION_RESULT_CODE_BAD("Plug-in conditions must return one of the result codes RESULT_SATISFIED, RESULT_UNSATISFIED, or RESULT_UNKNOWN", true);
    
    @NonNull
    private final String mDeveloperExplanation;
    private final boolean mIsFatal;

    PluginErrorExecute(@NonNull String str, boolean z3) {
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
