package com.arlosoft.macrodroid.utils;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: UninstallHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UninstallHelper {
    public static final int $stable = 0;
    @NotNull
    public static final UninstallHelper INSTANCE = new UninstallHelper();

    private UninstallHelper() {
    }

    @JvmStatic
    public static final void uninstallMacroDroid(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ComponentName componentName = new ComponentName(context, MacroDroidDeviceAdminReceiver.class);
            Object systemService = context.getSystemService("device_policy");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
            ((DevicePolicyManager) systemService).removeActiveAdmin(componentName);
        } catch (Exception unused) {
        }
        try {
            Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE");
            intent.setData(Uri.parse("package:com.arlosoft.macrodroid"));
            intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            context.startActivity(intent);
        } catch (Exception unused2) {
            ToastCompat.makeText(context.getApplicationContext(), (CharSequence) "Device does not support ACTION_UNINSTALL_PACKAGE intent", 1).show();
        }
    }
}
