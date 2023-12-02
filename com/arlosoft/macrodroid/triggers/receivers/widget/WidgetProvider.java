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
public abstract class WidgetProvider extends AppWidgetProvider {
    public static final int BLUE = 1;
    public static final int CUSTOM = 4;
    public static final int GREEN = 0;
    public static final int RED = 2;
    public static final int YELLOW = 3;

    /* renamed from: a  reason: collision with root package name */
    int f15379a;

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i4 : iArr) {
            Intent intent = new Intent(context, WidgetPressedService.class);
            intent.setAction(WidgetPressedTrigger.getWidgetTypes()[this.f15379a + 1]);
            PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.widgetlayout);
            remoteViews.setOnClickPendingIntent(R.id.widget_button, service);
            int i5 = this.f15379a;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            remoteViews.setImageViewResource(R.id.widget_button, R.drawable.yellow_widget);
                        }
                    } else {
                        remoteViews.setImageViewResource(R.id.widget_button, R.drawable.red_widget);
                    }
                } else {
                    remoteViews.setImageViewResource(R.id.widget_button, R.drawable.blue_widget);
                }
            } else {
                remoteViews.setImageViewResource(R.id.widget_button, R.drawable.green_widget);
            }
            appWidgetManager.updateAppWidget(i4, remoteViews);
        }
    }
}
