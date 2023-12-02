package com.arlosoft.macrodroid.celltowers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public class CellTowerBackgroundScanService extends Service {
    public static final String EXTRA_END_TIME = "endTime";

    /* renamed from: a  reason: collision with root package name */
    private static long f9610a;

    /* renamed from: b  reason: collision with root package name */
    private static PendingIntent f9611b;

    /* renamed from: c  reason: collision with root package name */
    private static String f9612c;

    public static long calculateEndTimeFromDuration(int i4) {
        return System.currentTimeMillis() + (i4 * 60 * 1000);
    }

    public static void cancelScanning(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = f9611b;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
        context.stopService(new Intent(context, CellTowerBackgroundScanService.class));
        NotificationManagerCompat.from(context).cancel(8835);
    }

    public static String getCurrentScanGroup() {
        return f9612c;
    }

    public static void scheduleAlarm(Context context, String str) {
        if (System.currentTimeMillis() < f9610a - 30000) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(context, CellTowerBGScanReceiver.class);
            intent.putExtra(Constants.EXTRA_CELL_TOWER_GROUP_NAME, str);
            f9611b = PendingIntent.getBroadcast(context, 8836, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
            AlarmHelper.scheduleExactAlarmWithInexactFallback(0, System.currentTimeMillis() + 30000, f9611b, false);
            return;
        }
        cancelScanning(context);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SystemLog.logInfo("Cell background Scan service created");
    }

    @Override // android.app.Service
    public void onDestroy() {
        SystemLog.logInfo("Cell background scan service destroyed");
        f9612c = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        if (intent == null) {
            return 3;
        }
        String stringExtra = intent.getStringExtra(Constants.EXTRA_CELL_TOWER_GROUP_NAME);
        f9612c = stringExtra;
        f9610a = intent.getLongExtra(EXTRA_END_TIME, 0L);
        String format = new SimpleDateFormat("HH:mm").format(new Date(f9610a));
        Intent intent2 = new Intent(this, CellTowerStopScanningReceiver.class);
        int i6 = PendingIntentHelper.FLAG_IMMUTABLE;
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, intent2, i6 | 268435456);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_radio_tower_white_24dp);
        builder.setContentTitle(getString(R.string.scanning_cell_towers));
        builder.setContentText(stringExtra + ": " + getString(R.string.scanning_ends_at) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + format);
        builder.setVisibility(1);
        builder.addAction(0, getString(R.string.stop_scanning), broadcast);
        builder.setOngoing(true);
        builder.setWhen(0L);
        builder.setPriority(2);
        builder.setChannelId(Constants.NOTIFICATION_CHANNEL_INFO);
        Intent intent3 = new Intent(this, CellTowerGroupActivity.class);
        intent3.putExtra("CellTowerGroupName", stringExtra);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, intent3, i6 | 268435456));
        NotificationManagerCompat.from(this).notify(8835, builder.build());
        scheduleAlarm(this, stringExtra);
        return 3;
    }
}
