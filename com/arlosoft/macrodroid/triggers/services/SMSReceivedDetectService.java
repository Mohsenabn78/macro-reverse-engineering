package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.ContactsContract;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.sms.SMSMessage;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.sun.mail.imap.IMAPStore;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;

/* loaded from: classes3.dex */
public class SMSReceivedDetectService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static SMSReceivedReceiver f15538a = null;

    /* renamed from: b  reason: collision with root package name */
    private static SMSObserver f15539b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f15540c = "";

    /* loaded from: classes3.dex */
    public static class SMSObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private Context f15541a;

        public SMSObserver(Handler handler, Context context) {
            super(handler);
            this.f15541a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            int i4;
            super.onChange(z3);
            Uri parse = Uri.parse("content://sms");
            if (ContextCompat.checkSelfPermission(this.f15541a, "android.permission.READ_SMS") == -1) {
                PermissionsHelper.showNeedsPermission(this.f15541a, "android.permission.READ_SMS", null, true, false);
                return;
            }
            Cursor query = MacroDroidApplication.getInstance().getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        try {
                            query.moveToNext();
                            int i5 = query.getInt(query.getColumnIndex("type"));
                            String string = query.getString(query.getColumnIndex(IMAPStore.ID_ADDRESS));
                            String string2 = query.getString(query.getColumnIndex("body"));
                            String string3 = query.getString(query.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID));
                            int columnIndex = query.getColumnIndex("sim_id");
                            if (columnIndex != -1) {
                                i4 = query.getInt(columnIndex);
                            } else {
                                i4 = 0;
                            }
                            if (i5 == 1 && !SMSReceivedDetectService.f15540c.equals(string3)) {
                                SMSReceivedDetectService.d(this.f15541a, new SMSMessage(string, string2, false, i4));
                                String unused = SMSReceivedDetectService.f15540c = string3;
                            }
                        } catch (CursorIndexOutOfBoundsException e4) {
                            FirebaseAnalyticsEventLogger.logHandledException(e4);
                        }
                    }
                } finally {
                    query.close();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SMSReceivedReceiver extends BroadcastReceiver {
        public SMSReceivedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Util.SMS_RECEIVED_INTENT)) {
                SMSReceivedDetectService.d(context, (SMSMessage) intent.getExtras().get(Util.SMS_MESSAGE_EXTRA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SMSMessage f15543a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15544b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PowerManager.WakeLock f15545c;

        a(SMSMessage sMSMessage, Context context, PowerManager.WakeLock wakeLock) {
            this.f15543a = sMSMessage;
            this.f15544b = context;
            this.f15545c = wakeLock;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Cursor cursor;
            String string;
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Util.sanitizeNumber(this.f15543a.getNumber()));
            if (ContextCompat.checkSelfPermission(this.f15544b, "android.permission.READ_CONTACTS") != 0) {
                Context context = this.f15544b;
                PermissionsHelper.showNeedsPermission(context, "android.permission.READ_CONTACTS", context.getString(R.string.trigger_sms_sent), true, false);
                return;
            }
            try {
                cursor = MacroDroidApplication.getInstance().getContentResolver().query(withAppendedPath, new String[]{"display_name"}, null, null, null);
            } catch (Exception unused) {
                cursor = null;
            }
            String str = "";
            if (cursor != null) {
                if (cursor.moveToFirst() && (string = cursor.getString(cursor.getColumnIndex("display_name"))) != null && string.length() > 0) {
                    str = string;
                }
                cursor.close();
            }
            IncomingSMSUtil.checkMessage(this.f15544b, this.f15543a.getNumber(), this.f15543a.getMessage(), str, this.f15543a.getSimId());
            if (this.f15545c.isHeld()) {
                this.f15545c.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, SMSMessage sMSMessage) {
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "macrodroid:SMSReceivedDetectService");
        newWakeLock.acquire(10000L);
        new a(sMSMessage, context, newWakeLock).start();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            f15539b = new SMSObserver(new Handler(), this);
            getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, f15539b);
            IntentFilter intentFilter = new IntentFilter(Util.SMS_RECEIVED_INTENT);
            SMSReceivedReceiver sMSReceivedReceiver = new SMSReceivedReceiver();
            f15538a = sMSReceivedReceiver;
            registerReceiver(sMSReceivedReceiver, intentFilter);
        } catch (SecurityException unused) {
            SystemLog.logError("SMS dectection is missing access to SMS_RECEIVED permission");
            PermissionsHelper.showNeedsPermission(this, "android.permission.READ_SMS", getString(R.string.trigger_incoming_sms), true, false);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            getContentResolver().unregisterContentObserver(f15539b);
        } catch (Exception unused) {
        }
        try {
            unregisterReceiver(f15538a);
        } catch (Exception unused2) {
        }
        super.onDestroy();
    }
}
