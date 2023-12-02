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
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.sms.SMSMessage;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.sun.mail.imap.IMAPStore;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;

/* loaded from: classes3.dex */
public class SMSSentDetectService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static SMSSentReceiver f15546a = null;

    /* renamed from: b  reason: collision with root package name */
    private static SMSObserver f15547b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f15548c = "";

    /* loaded from: classes3.dex */
    public static class SMSObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private boolean f15549a;

        public SMSObserver(Handler handler) {
            super(handler);
            this.f15549a = false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            super.onChange(z3);
            if (ContextCompat.checkSelfPermission(MacroDroidApplication.getInstance(), "android.permission.READ_SMS") != 0) {
                PermissionsHelper.showNeedsPermission(MacroDroidApplication.getInstance(), "android.permission.READ_SMS", MacroDroidApplication.getInstance().getString(R.string.trigger_sms_sent), true, false);
                return;
            }
            Cursor query = MacroDroidApplication.getInstance().getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
            try {
                try {
                    if (query.getCount() > 0) {
                        query.moveToNext();
                        query.getString(query.getColumnIndex("protocol"));
                        int i4 = query.getInt(query.getColumnIndex("type"));
                        String string = query.getString(query.getColumnIndex(IMAPStore.ID_ADDRESS));
                        String string2 = query.getString(query.getColumnIndex("body"));
                        String string3 = query.getString(query.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID));
                        if (i4 == 6) {
                            this.f15549a = true;
                        }
                        if (i4 == 2 && !SMSSentDetectService.f15548c.equals(string3)) {
                            SMSSentDetectService.d(new SMSMessage(string, string2, false, 0));
                            this.f15549a = false;
                            String unused = SMSSentDetectService.f15548c = string3;
                        }
                    }
                } catch (CursorIndexOutOfBoundsException e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SMSSentDetectService: CursorIndexOutOfBoundsException: " + e4.toString()));
                    if (query == null) {
                        return;
                    }
                }
                query.close();
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SMSSentReceiver extends BroadcastReceiver {
        public SMSSentReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Util.SMS_SENT_INTENT)) {
                SMSSentDetectService.d((SMSMessage) intent.getExtras().get(Util.SMS_MESSAGE_EXTRA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(com.arlosoft.macrodroid.action.sms.SMSMessage r25) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.SMSSentDetectService.d(com.arlosoft.macrodroid.action.sms.SMSMessage):void");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f15547b = new SMSObserver(new Handler());
        getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, f15547b);
        IntentFilter intentFilter = new IntentFilter(Util.SMS_SENT_INTENT);
        SMSSentReceiver sMSSentReceiver = new SMSSentReceiver();
        f15546a = sMSSentReceiver;
        registerReceiver(sMSSentReceiver, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        getContentResolver().unregisterContentObserver(f15547b);
        unregisterReceiver(f15546a);
        super.onDestroy();
    }
}
