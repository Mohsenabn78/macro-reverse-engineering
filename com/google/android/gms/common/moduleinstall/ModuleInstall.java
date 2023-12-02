package com.google.android.gms.common.moduleinstall;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.moduleinstall.internal.zay;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class ModuleInstall {
    private ModuleInstall() {
    }

    @NonNull
    public static ModuleInstallClient getClient(@NonNull Activity activity) {
        return new zay(activity);
    }

    @NonNull
    public static ModuleInstallClient getClient(@NonNull Context context) {
        return new zay(context);
    }
}
