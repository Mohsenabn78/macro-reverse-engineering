package com.arlosoft.macrodroid.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HelperCommonFunctionality.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HelperCommonFunctionality {
    public static final int $stable = 0;
    @NotNull
    public static final HelperCommonFunctionality INSTANCE = new HelperCommonFunctionality();

    private HelperCommonFunctionality() {
    }

    @JvmStatic
    public static final void showMissingHelperFileNotification(@NotNull Context context, @NotNull String actionName, @NotNull String requiredVersion) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(requiredVersion, "requiredVersion");
        PendingIntent activity = PendingIntent.getActivity(context, 29873, new Intent("android.intent.action.VIEW", Uri.parse(PermissionsHelper.HELPER_FILE_LINK)), 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationCompat.Builder when = builder.setContentTitle(actionName).setWhen(System.currentTimeMillis());
        String string = context.getString(R.string.helper_apk_required);
        when.setContentText(string + requiredVersion + "+)").setContentIntent(activity).setSmallIcon(R.drawable.ic_warning_white_24dp).setAutoCancel(true).setColor(ContextCompat.getColor(context, R.color.md_red_500)).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY);
        Notification build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(29873, build);
    }
}
