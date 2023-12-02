package com.arlosoft.macrodroid.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.ConfigureNotificationBarActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.receivers.NotificationBarButtonReceiver;
import com.arlosoft.macrodroid.utils.BitmapUtils;
import com.arlosoft.macrodroid.utils.IconUtils;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class NotificationUtil {
    private static Notification a(Context context, int i4, String str, int i5, String str2) {
        List<Pair<Long, Long>> arrayList;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, str2);
        if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(IconCompat.createWithBitmap(BitmapUtils.textAsBitmap(str, -1)));
        } else {
            builder.setSmallIcon(i4);
        }
        builder.setPriority(i5);
        builder.setShowWhen(false);
        builder.setOngoing(true);
        builder.setForegroundServiceBehavior(1);
        String macroDroidNotificationTitle = Settings.getMacroDroidNotificationTitle(context);
        if (macroDroidNotificationTitle == null) {
            macroDroidNotificationTitle = "MacroDroid";
        }
        String macroDroidNotificationBody = Settings.getMacroDroidNotificationBody(context);
        if (macroDroidNotificationBody == null) {
            macroDroidNotificationBody = SelectableItem.r(R.string.mode) + ": " + Settings.getMode(context);
        }
        if (Settings.getShowLastRunMacrosInNotification(context)) {
            builder.setContentTitle("MacroDroid " + SelectableItem.r(R.string.mode) + ": " + Settings.getMode(context));
            if (Database.getInstance() != null) {
                arrayList = Database.getInstance().getLastRunTimesList(20);
            } else {
                arrayList = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            if (arrayList != null) {
                int i6 = 0;
                for (int i7 = 0; i7 < arrayList.size() && i6 < 4; i7++) {
                    Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(arrayList.get(i7).first.longValue());
                    String format = simpleDateFormat.format(Long.valueOf(arrayList.get(i7).second.longValue()));
                    if (macroByGUID != null && !macroByGUID.isExcludedFromLog()) {
                        StringBuilder sb2 = new StringBuilder();
                        if (i6 != 0) {
                            sb2.append("\n");
                        }
                        sb2.append(format);
                        sb2.append(" - ");
                        sb2.append(macroByGUID.getName());
                        String sb3 = sb2.toString();
                        sb.append(sb3);
                        if (i6 == 0) {
                            builder.setContentText(sb3);
                        }
                        i6++;
                    }
                }
            }
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(sb.toString()));
        } else {
            builder.setContentTitle(macroDroidNotificationTitle);
            builder.setContentText(macroDroidNotificationBody);
        }
        builder.setVisibility(1);
        Intent intent = new Intent(context, NewHomeScreenActivity.class);
        intent.setFlags(603979776);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE));
        return builder.build();
    }

    private static boolean b(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static Notification constructNotification(Context context, int i4, String str, int i5, String str2) {
        NotificationCompat.Builder builder;
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        int i6;
        RemoteViews remoteViews3;
        int[] iArr;
        if (!Settings.getForceHideIcon(context)) {
            builder = new NotificationCompat.Builder(context, str2);
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 23) {
                builder.setSmallIcon(IconCompat.createWithBitmap(BitmapUtils.textAsBitmap(str, -1)));
            } else {
                builder.setSmallIcon(i4);
            }
            builder.setVisibility(1);
            builder.setShowWhen(false);
            if (Build.VERSION.SDK_INT >= 31) {
                builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            }
            List<NotificationButton> notificationButtons = Settings.getNotificationButtons(context);
            int[] iArr2 = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7};
            int[] iArr3 = {R.id.button_frame_1, R.id.button_frame_2, R.id.button_frame_3, R.id.button_frame_4, R.id.button_frame_5, R.id.button_frame_6, R.id.button_frame_7};
            boolean buttonBarBlackBg = Settings.getButtonBarBlackBg(context);
            if (notificationButtons.size() == 0) {
                if (buttonBarBlackBg) {
                    remoteViews2 = new RemoteViews(context.getPackageName(), (int) R.layout.notification_bar_button_configure_state_dark);
                } else {
                    remoteViews2 = new RemoteViews(context.getPackageName(), (int) R.layout.notification_bar_button_configure_state);
                    if (!b(context)) {
                        remoteViews2.setImageViewResource(R.id.notification_bar_configure_button, R.drawable.ic_add_circle_black_48dp);
                        remoteViews2.setTextColor(R.id.current_mode, ContextCompat.getColor(context, R.color.default_text_color));
                    }
                }
                remoteViews2.setOnClickPendingIntent(R.id.notification_bar_configure_button, PendingIntent.getActivity(context, 0, new Intent(context, ConfigureNotificationBarActivity.class), PendingIntentHelper.FLAG_IMMUTABLE | 268435456));
                if (!Settings.getShowMacroDroidIcon(context)) {
                    remoteViews2.setViewVisibility(R.id.logo, 8);
                } else {
                    remoteViews2.setViewVisibility(R.id.logo, 0);
                }
                if (Settings.getShowNotificationCurrentMode(context)) {
                    remoteViews2.setTextViewText(R.id.current_mode, Settings.getMode(context));
                } else {
                    remoteViews2.setViewVisibility(R.id.current_mode, 8);
                }
            } else {
                if (buttonBarBlackBg) {
                    remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.include_notification_bar_buttons_dark);
                } else {
                    remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.include_notification_bar_buttons);
                    if (!b(context)) {
                        remoteViews.setTextColor(R.id.current_mode, ContextCompat.getColor(context, R.color.default_text_color));
                    }
                }
                RemoteViews remoteViews4 = remoteViews;
                for (int i7 = 0; i7 < 7; i7++) {
                    remoteViews4.setViewVisibility(iArr3[i7], 8);
                }
                if (!Settings.getShowMacroDroidIcon(context)) {
                    remoteViews4.setViewVisibility(R.id.logo, 8);
                }
                int buttonBarIconTint = Settings.getButtonBarIconTint(context);
                int i8 = 0;
                for (int i9 = 7; i8 < notificationButtons.size() && i8 < i9; i9 = 7) {
                    NotificationButton notificationButton = notificationButtons.get(i8);
                    Intent intent = new Intent(context, NotificationBarButtonReceiver.class);
                    intent.setAction("" + notificationButton.getId());
                    intent.putExtra(Util.NOTIFICATION_BUTTON_EXTRA, notificationButton.getId());
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
                    if (notificationButton.getImageUri() != null) {
                        remoteViews4.setImageViewUri(iArr2[i8], notificationButton.getImageUri());
                        remoteViews4.setOnClickPendingIntent(iArr2[i8], broadcast);
                        remoteViews4.setViewVisibility(iArr3[i8], 0);
                        i6 = i8;
                        remoteViews3 = remoteViews4;
                        iArr = iArr3;
                    } else {
                        i6 = i8;
                        remoteViews3 = remoteViews4;
                        iArr = iArr3;
                        IconUtils.setImageOnRemoteView(context, remoteViews4, iArr2[i8], notificationButton.getImageResourceName(), notificationButton.getImageResourcePackage(), -1, null, Integer.valueOf(buttonBarIconTint), null);
                        remoteViews3.setOnClickPendingIntent(iArr2[i6], broadcast);
                        remoteViews3.setViewVisibility(iArr[i6], 0);
                    }
                    i8 = i6 + 1;
                    remoteViews4 = remoteViews3;
                    iArr3 = iArr;
                }
                remoteViews2 = remoteViews4;
            }
            remoteViews2.setImageViewResource(R.id.icon, R.drawable.launcher_no_border);
            if (Settings.getShowNotificationCurrentMode(context)) {
                remoteViews2.setTextViewText(R.id.current_mode, Settings.getMode(context));
            } else {
                remoteViews2.setViewVisibility(R.id.current_mode, 8);
            }
            builder.setContent(remoteViews2);
            Intent intent2 = new Intent(context, NewHomeScreenActivity.class);
            intent2.setFlags(603979776);
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent2, PendingIntentHelper.FLAG_IMMUTABLE | 268435456));
        } else {
            builder = new NotificationCompat.Builder(context, Constants.NOTIFICATION_CHANNEL_PERSISTENT);
            builder.setSmallIcon(i4);
            builder.setLargeIcon(null);
        }
        builder.setPriority(i5);
        builder.setOngoing(true);
        Notification build = builder.build();
        build.when = 0L;
        return build;
    }

    public static Notification createClassicNotificationBar(Context context, int i4, String str, int i5, String str2) {
        return a(context, i4, str, i5, str2);
    }
}
