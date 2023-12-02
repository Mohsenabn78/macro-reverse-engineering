package com.arlosoft.macrodroid.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.extras.stopclub.StopClubActivity;
import com.arlosoft.macrodroid.triggers.NotificationTrigger;

/* loaded from: classes3.dex */
public class NotificationUtils {
    public static boolean checkForPackageMatch(String str, NotificationTrigger notificationTrigger) {
        for (String str2 : notificationTrigger.getPackageNameList()) {
            if (!str2.equals(NotificationTrigger.ANY_APPLICATION) && !str2.equals(NotificationTrigger.ANY_APPLICATION_FIXED)) {
                if (str2.equals(str)) {
                    return !notificationTrigger.isExclude();
                }
            } else {
                return !notificationTrigger.isExclude();
            }
        }
        return notificationTrigger.isExclude();
    }

    public static void displayExtrasExpiredUpdateNotification(Context context, String str) {
        Intent intent = new Intent(context, StopClubActivity.class);
        intent.addFlags(268435456);
        NotificationManagerCompat.from(context).notify(0, new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_warning_white_24dp).setContentTitle(String.format(context.getString(R.string.extra_subscription_expired), str)).setContentText(context.getString(R.string.renew_subscription_to_continue_using)).setPriority(2).setContentIntent(PendingIntent.getActivity(context, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setOnlyAlertOnce(true).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setAutoCancel(true).build());
    }

    public static void displayExtrasRequiresMacroDroidUpdateNotification(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.arlosoft.macrodroid"));
        intent.addFlags(268435456);
        NotificationManagerCompat.from(context).notify(0, new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_warning_white_24dp).setContentTitle(context.getString(R.string.update_required)).setContentText(String.format(context.getString(R.string.extra_requires_macrodroid_version_update), str)).setContentIntent(PendingIntent.getActivity(context, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setOnlyAlertOnce(true).setPriority(2).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setAutoCancel(true).build());
    }

    public static void displayFileAccessNotification(Context context, String str) {
        NotificationManagerCompat.from(context).notify(0, new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_warning_white_24dp).setContentTitle(str).setContentText(context.getString(R.string.please_reconigiure_file_path_to_accessible_location)).setContentIntent(PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse(Constants.MACRO_NAME_LINK_URI + str)), 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setOnlyAlertOnce(true).setPriority(2).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_INFO).setAutoCancel(true).build());
    }

    public static void displayStopClubUpdataAvaialable(Context context, String str) {
        Intent intent = new Intent(context, StopClubActivity.class);
        intent.addFlags(268435456);
        NotificationManagerCompat.from(context).notify(0, new NotificationCompat.Builder(context).setSmallIcon(R.drawable.sc_logo_bw).setContentTitle(context.getString(R.string.stopclub_update_available)).setContentText(String.format(context.getString(R.string.stopclub_update_available_content), str)).setContentIntent(PendingIntent.getActivity(context, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setOnlyAlertOnce(true).setPriority(2).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setAutoCancel(true).build());
    }
}
