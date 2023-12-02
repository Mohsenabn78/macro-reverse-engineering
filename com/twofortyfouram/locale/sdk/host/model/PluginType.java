package com.twofortyfouram.locale.sdk.host.model;

import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.api.Intent;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public enum PluginType {
    CONDITION(Intent.ACTION_EDIT_CONDITION, Intent.ACTION_QUERY_CONDITION),
    SETTING(Intent.ACTION_EDIT_SETTING, Intent.ACTION_FIRE_SETTING),
    EVENT("net.dinglisch.android.tasker.ACTION_EDIT_EVENT", Intent.ACTION_QUERY_CONDITION);
    
    @NonNull
    private final String mActivityIntentAction;
    @NonNull
    private final String mReceiverIntentAction;

    PluginType(@NonNull String str, @NonNull String str2) {
        Assertions.assertNotEmpty(str, "activityIntentAction");
        Assertions.assertNotEmpty(str2, "receiverIntentAction");
        this.mActivityIntentAction = str;
        this.mReceiverIntentAction = str2;
    }

    @NonNull
    public String getActivityIntentAction() {
        return this.mActivityIntentAction;
    }

    @NonNull
    public String getReceiverIntentAction() {
        return this.mReceiverIntentAction;
    }
}
