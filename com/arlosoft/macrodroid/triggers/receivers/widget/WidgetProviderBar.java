package com.arlosoft.macrodroid.triggers.receivers.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;

/* loaded from: classes3.dex */
public class WidgetProviderBar extends AppWidgetProvider {
    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i4 : iArr) {
            Intent intent = new Intent(context, WidgetPressedService.class);
            intent.setAction(WidgetPressedTrigger.getWidgetTypes()[1]);
            int i5 = PendingIntentHelper.FLAG_IMMUTABLE;
            PendingIntent service = PendingIntent.getService(context, 1000, intent, i5 | 134217728);
            Intent intent2 = new Intent(context, WidgetPressedService.class);
            intent2.setAction(WidgetPressedTrigger.getWidgetTypes()[2]);
            PendingIntent service2 = PendingIntent.getService(context, 1000, intent2, i5 | 134217728);
            Intent intent3 = new Intent(context, WidgetPressedService.class);
            intent3.setAction(WidgetPressedTrigger.getWidgetTypes()[4]);
            PendingIntent service3 = PendingIntent.getService(context, 1000, intent3, i5 | 134217728);
            Intent intent4 = new Intent(context, WidgetPressedService.class);
            intent4.setAction(WidgetPressedTrigger.getWidgetTypes()[3]);
            PendingIntent service4 = PendingIntent.getService(context, 1000, intent4, i5 | 134217728);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.widget_button_bar);
            remoteViews.setOnClickPendingIntent(R.id.widget_button_1, service);
            remoteViews.setOnClickPendingIntent(R.id.widget_button_2, service2);
            remoteViews.setOnClickPendingIntent(R.id.widget_button_3, service3);
            remoteViews.setOnClickPendingIntent(R.id.widget_button_4, service4);
            remoteViews.setImageViewResource(R.id.widget_button_1, R.drawable.green_widget);
            remoteViews.setImageViewResource(R.id.widget_button_2, R.drawable.blue_widget);
            remoteViews.setImageViewResource(R.id.widget_button_3, R.drawable.yellow_widget);
            remoteViews.setImageViewResource(R.id.widget_button_4, R.drawable.red_widget);
            appWidgetManager.updateAppWidget(i4, remoteViews);
        }
    }
}
