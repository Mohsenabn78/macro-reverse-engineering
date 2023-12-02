package com.arlosoft.macrodroid.triggers.receivers.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.utils.IconUtils;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WidgetProviderCustom extends AppWidgetProvider {
    private static void a(Context context, int i4, AppWidgetManager appWidgetManager) {
        int i5;
        int i6;
        Intent intent = new Intent(context, WidgetPressedService.class);
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        sb.append(WidgetPressedTrigger.getWidgetTypes()[0]);
        sb.append(",");
        sb.append(i4);
        intent.setAction(sb.toString());
        PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        String t3 = MacroDroidWidgetConfigureActivity.t(context, i4);
        int v3 = MacroDroidWidgetConfigureActivity.v(context, i4);
        String x3 = MacroDroidWidgetConfigureActivity.x(context, i4);
        String u3 = MacroDroidWidgetConfigureActivity.u(context, i4);
        String w3 = MacroDroidWidgetConfigureActivity.w(context, i4);
        String s3 = MacroDroidWidgetConfigureActivity.s(context, i4);
        boolean r4 = MacroDroidWidgetConfigureActivity.r(context, i4);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.custom_widget_layout);
        if (r4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        remoteViews.setViewVisibility(R.id.custom_widget_button_faded, i5);
        if (r4) {
            i7 = 8;
        }
        remoteViews.setViewVisibility(R.id.custom_widget_button, i7);
        if (r4) {
            i6 = R.id.custom_widget_button_faded;
        } else {
            i6 = R.id.custom_widget_button;
        }
        IconUtils.setImageOnRemoteView(context, remoteViews, i6, t3, u3, v3, w3, null, s3);
        remoteViews.setTextViewText(R.id.custom_widget_label, x3);
        remoteViews.setOnClickPendingIntent(R.id.custom_widget_button, service);
        remoteViews.setOnClickPendingIntent(R.id.custom_widget_button_faded, service);
        try {
            appWidgetManager.updateAppWidget(i4, remoteViews);
        } catch (Exception e4) {
            SystemLog.logError("Failed to update custom widget, maybe bitmap is too large?: " + e4.toString());
        }
    }

    private void b(Context context, AppWidgetManager appWidgetManager, int[] iArr, Object obj) {
        for (int i4 : iArr) {
            a(context, i4, appWidgetManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, AppWidgetManager appWidgetManager, int i4, String str, int i5, String str2, String str3, Uri uri) {
        a(context, i4, appWidgetManager);
    }

    public static void updateMyWidgets(@NonNull Context context, @Nullable Parcelable parcelable, long j4, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, boolean z3, String str5) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, WidgetProviderCustom.class));
        for (int i4 = 0; i4 < appWidgetIds.length; i4++) {
            if (MacroDroidWidgetConfigureActivity.y(context, appWidgetIds[i4]) == j4) {
                MacroDroidWidgetConfigureActivity.saveLabelPref(context, appWidgetIds[i4], str);
                MacroDroidWidgetConfigureActivity.saveImageResourceNamePref(context, appWidgetIds[i4], str2);
                MacroDroidWidgetConfigureActivity.saveImageResourcePackagePref(context, appWidgetIds[i4], str3);
                MacroDroidWidgetConfigureActivity.saveImageResourceUriPref(context, appWidgetIds[i4], str4);
                MacroDroidWidgetConfigureActivity.saveImageFadedPref(context, appWidgetIds[i4], z3);
                MacroDroidWidgetConfigureActivity.saveImageTextIcon(context, appWidgetIds[i4], str5);
                a(context, appWidgetIds[i4], appWidgetManager);
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        for (int i4 : iArr) {
            MacroDroidWidgetConfigureActivity.q(context, i4);
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getExtras() == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = intent.getExtras().getIntegerArrayList("widget_ids");
        String stringExtra = intent.getStringExtra("widget_label");
        String stringExtra2 = intent.getStringExtra("resource_name");
        String stringExtra3 = intent.getStringExtra("package_name");
        String stringExtra4 = intent.getStringExtra(PopUpActionActivity.EXTRA_IMAGE_URI);
        String stringExtra5 = intent.getStringExtra("icon_text");
        boolean booleanExtra = intent.getBooleanExtra("image_faded", false);
        if (integerArrayList == null) {
            return;
        }
        int[] iArr = new int[integerArrayList.size()];
        for (int i4 = 0; i4 < integerArrayList.size(); i4++) {
            int intValue = integerArrayList.get(i4).intValue();
            iArr[i4] = intValue;
            MacroDroidWidgetConfigureActivity.saveLabelPref(context, intValue, stringExtra);
            MacroDroidWidgetConfigureActivity.saveImageResourceNamePref(context, iArr[i4], stringExtra2);
            MacroDroidWidgetConfigureActivity.saveImageResourcePackagePref(context, iArr[i4], stringExtra3);
            MacroDroidWidgetConfigureActivity.saveImageResourceUriPref(context, iArr[i4], stringExtra4);
            MacroDroidWidgetConfigureActivity.saveImageFadedPref(context, iArr[i4], booleanExtra);
            MacroDroidWidgetConfigureActivity.saveImageTextIcon(context, iArr[i4], stringExtra5);
        }
        b(context, AppWidgetManager.getInstance(context), iArr, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        b(context, appWidgetManager, iArr, null);
    }
}
