package com.arlosoft.macrodroid.saf;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import java.net.URLEncoder;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: StorageAccessFrameworkHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class StorageAccessFrameworkHelper {
    public static final int $stable = 0;
    @NotNull
    public static final StorageAccessFrameworkHelper INSTANCE = new StorageAccessFrameworkHelper();

    private StorageAccessFrameworkHelper() {
    }

    @JvmStatic
    public static final void requiresAccessGranted(@NotNull Context context, @NotNull String userMessage, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userMessage, "userMessage");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        try {
            String encode = URLEncoder.encode(macroName, "UTF-8");
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse(Constants.MACRO_NAME_LINK_URI + encode)), 335544320);
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.material_ic_error_24px_svg).setContentTitle(macroName).setContentText(userMessage).setAutoCancel(true).setContentIntent(activity).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setContentIntent(activity);
            Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(context)\n       …tentIntent(pendingIntent)");
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            Intrinsics.checkNotNullExpressionValue(from, "from(context)");
            from.notify(0, contentIntent.build());
        } catch (Exception unused) {
        }
    }
}
