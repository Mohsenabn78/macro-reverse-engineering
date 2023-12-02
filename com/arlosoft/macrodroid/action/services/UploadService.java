package com.arlosoft.macrodroid.action.services;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.twitter.TwitterFailNotificationClickReceiver;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.mail.AuthenticationFailedException;

/* loaded from: classes2.dex */
public abstract class UploadService extends Service {
    public static final String EXTRA_BODY = "Body";
    public static final String EXTRA_SUBJECT = "Subject";
    public static final String EXTRA_UPLOAD_EMAIL_ADDRESS = "EmailAddress";
    public static final String EXTRA_UPLOAD_SITE = "UploadSite";
    public static final String UPLOAD_EMAIL = "Email";
    public static final String UPLOAD_FACEBOOK = "Facebook";
    public static final String UPLOAD_TWITTER = "Twitter";

    /* renamed from: i  reason: collision with root package name */
    protected static final Object f4934i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static int f4935j = 7385250;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f4936k;

    /* renamed from: a  reason: collision with root package name */
    QueueItem f4937a;

    /* renamed from: b  reason: collision with root package name */
    String f4938b;

    /* renamed from: c  reason: collision with root package name */
    private String f4939c;

    /* renamed from: d  reason: collision with root package name */
    final Queue<QueueItem> f4940d = new LinkedBlockingQueue();

    /* renamed from: e  reason: collision with root package name */
    final Object f4941e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private PendingIntent f4942f;

    /* renamed from: g  reason: collision with root package name */
    private QueueUpdateReceiver f4943g;

    /* renamed from: h  reason: collision with root package name */
    private QueueItem f4944h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class QueueUpdateReceiver extends BroadcastReceiver {
        protected QueueUpdateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UploadService.this.m(30000);
            UploadService.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4947a;

        static {
            int[] iArr = new int[TwitterOutput.TwitterStatus.values().length];
            f4947a = iArr;
            try {
                iArr[TwitterOutput.TwitterStatus.AuthenticationFailure.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4947a[TwitterOutput.TwitterStatus.AlreadyUploaded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4948a;

        /* renamed from: b  reason: collision with root package name */
        private final QueueItem f4949b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4950c;

        public b(Context context, QueueItem queueItem) {
            this.f4949b = queueItem;
            this.f4948a = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            boolean z3 = false;
            try {
                UploadService uploadService = UploadService.this;
                uploadService.s(this.f4948a, this.f4949b, uploadService.f4939c);
                this.f4950c = false;
                z3 = true;
            } catch (AuthenticationFailedException unused) {
                this.f4950c = true;
            } catch (Exception unused2) {
                this.f4950c = false;
            }
            return Boolean.valueOf(z3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4948a);
            boolean z3 = true;
            boolean z4 = defaultSharedPreferences.getBoolean(UploadService.this.h(), true);
            boolean z5 = defaultSharedPreferences.getBoolean(UploadService.this.g(), true);
            int intValue = Integer.valueOf(defaultSharedPreferences.getString(UploadService.this.i(), "0")).intValue() * 60 * 1000;
            synchronized (UploadService.this.f4941e) {
                if (bool.booleanValue()) {
                    if (z4) {
                        Util.displayNotification(UploadService.this, UploadService.this.f4938b + " sent", UploadService.this.f4938b + " was sent to: " + this.f4949b.email, false);
                    }
                    UploadService.this.f4940d.remove(this.f4949b);
                    UploadService.this.k();
                    SystemLog.logInfo(UploadService.this.f4938b + " was sent to: " + this.f4949b.email);
                } else if (this.f4950c) {
                    UploadService.this.j();
                    if (z5) {
                        Util.displayNotification(UploadService.this, UploadService.this.f4938b + " sending failed", "Authentication failed - check your password", false);
                    }
                    UploadService.this.f4940d.remove(this.f4949b);
                    SystemLog.logInfo(UploadService.this.f4938b + " sending failed - authentication problem");
                } else {
                    if (this.f4949b.startTime + intValue > System.currentTimeMillis()) {
                        z3 = false;
                    } else {
                        UploadService.this.j();
                        if (z5) {
                            Util.displayNotification(UploadService.this, UploadService.this.f4938b + " sending failed", UploadService.this.f4938b + " not sent to: " + UploadService.this.f4937a.email, false);
                        }
                        UploadService.this.f4940d.remove(this.f4949b);
                        SystemLog.logInfo(UploadService.this.f4938b + " sending failed - Giving up");
                    }
                }
                boolean unused = UploadService.f4936k = false;
                if (UploadService.this.f4940d.size() == 0) {
                    UploadService.this.l();
                    UploadService.this.stopSelf();
                } else if (z3) {
                    UploadService.this.n();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4960a;

        /* renamed from: b  reason: collision with root package name */
        private final QueueItem f4961b;

        /* renamed from: c  reason: collision with root package name */
        TwitterOutput.TwitterStatus f4962c;

        public d(Context context, QueueItem queueItem) {
            this.f4961b = queueItem;
            this.f4960a = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f4962c = UploadService.this.q(this.f4960a, this.f4961b);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r18) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4960a);
            boolean z3 = true;
            boolean z4 = defaultSharedPreferences.getBoolean(UploadService.this.h(), true);
            boolean z5 = defaultSharedPreferences.getBoolean(UploadService.this.g(), true);
            int intValue = Integer.valueOf(defaultSharedPreferences.getString(UploadService.this.i(), "0")).intValue() * 60 * 1000;
            synchronized (UploadService.this.f4941e) {
                TwitterOutput.TwitterStatus twitterStatus = this.f4962c;
                if (twitterStatus == TwitterOutput.TwitterStatus.Ok) {
                    if (z4) {
                        Util.displayNotification(this.f4960a, "Twitter " + UploadService.this.f4938b + " uploaded", "The " + UploadService.this.f4938b + " was uploaded to twitter", false);
                    }
                    UploadService.this.f4940d.remove(this.f4961b);
                } else {
                    if (twitterStatus == TwitterOutput.TwitterStatus.ConnectionFailure) {
                        if (this.f4961b.startTime + intValue <= System.currentTimeMillis()) {
                            if (z5) {
                                Util.displayNotification(this.f4960a, UploadService.this.getString(R.string.upload_failed) + " (Twitter " + UploadService.this.f4938b + ")", "Retry limit reached", false);
                            }
                            UploadService.this.f4940d.remove(this.f4961b);
                        }
                    } else {
                        if (z5) {
                            int i4 = a.f4947a[twitterStatus.ordinal()];
                            if (i4 != 1) {
                                if (i4 != 2) {
                                    Util.displayNotification(this.f4960a, UploadService.this.getString(R.string.upload_failed) + " (Twitter " + UploadService.this.f4938b + ")", "Retry limit reached", false);
                                } else {
                                    Util.displayNotification(this.f4960a, UploadService.this.getString(R.string.upload_failed) + " (Twitter " + UploadService.this.f4938b + ")", "The " + UploadService.this.f4938b + " has already been uploaded", false);
                                }
                            } else {
                                PendingIntent broadcast = PendingIntent.getBroadcast(this.f4960a, UploadService.f(), new Intent(this.f4960a, TwitterFailNotificationClickReceiver.class), PendingIntentHelper.FLAG_IMMUTABLE | 134217728);
                                Util.displayNotification(this.f4960a, UploadService.this.getString(R.string.upload_failed) + " (Twitter " + UploadService.this.f4938b + ")", UploadService.this.getString(R.string.authentication_failed_click_to_reauthenticate), false, -1, broadcast, -3355444, Constants.NOTIFICATION_CHANNEL_INFO);
                            }
                        }
                        UploadService.this.f4940d.remove(this.f4961b);
                    }
                    z3 = false;
                }
                boolean unused = UploadService.f4936k = false;
                if (UploadService.this.f4940d.size() == 0) {
                    UploadService.this.l();
                    UploadService.this.stopSelf();
                } else if (z3) {
                    UploadService.this.n();
                }
            }
        }
    }

    static /* synthetic */ int f() {
        int i4 = f4935j;
        f4935j = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        ((AlarmManager) MacroDroidApplication.getInstance().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f4942f);
        if (this.f4943g != null) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(this.f4943g);
            } catch (Exception unused) {
            }
            this.f4943g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.f4941e) {
            if (!f4936k) {
                if (this.f4940d.size() > 0) {
                    o(this.f4940d.peek());
                    f4936k = true;
                } else {
                    l();
                    stopSelf();
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void o(QueueItem queueItem) {
        char c4;
        SystemLog.logInfo("Sending to " + queueItem.uploadSite);
        String str = queueItem.uploadSite;
        switch (str.hashCode()) {
            case -1904619323:
                if (str.equals("Picasa")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 67066748:
                if (str.equals(UPLOAD_EMAIL)) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 561774310:
                if (str.equals(UPLOAD_FACEBOOK)) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 748307027:
                if (str.equals(UPLOAD_TWITTER)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 == 2) {
                    t(queueItem);
                    return;
                }
                return;
            }
            r(queueItem);
            return;
        }
        p(queueItem);
    }

    private void p(QueueItem queueItem) {
        SystemLog.logError("Sorry - Upload to facebook is no longer supported due to unacceptable terms and conditions of using Facebook's API.");
    }

    private void r(QueueItem queueItem) {
        new d(MacroDroidApplication.getInstance(), queueItem).execute((Object[]) null);
    }

    @SuppressLint({"NewApi"})
    private void t(QueueItem queueItem) {
        Account account;
        String emailGmailAddress = Settings.getEmailGmailAddress(this);
        this.f4939c = emailGmailAddress;
        this.f4937a = queueItem;
        if (emailGmailAddress == null) {
            Util.displayNotification(this, "Cannot Send Email", "No email address configured - check your settings", false);
            SystemLog.logError("Cannot Send Email. No email address configured - check your settings");
        } else if (Settings.getEmailUsePassword(this)) {
            SystemLog.logInfo("Using email password");
            new b(MacroDroidApplication.getInstance(), queueItem).execute((Object[]) null);
        } else {
            SystemLog.logInfo("Using OAUTH");
            AccountManager accountManager = AccountManager.get(this);
            Account[] accountsByType = accountManager.getAccountsByType("com.google");
            int i4 = 0;
            while (true) {
                if (i4 < accountsByType.length) {
                    if (accountsByType[i4].name.equals(this.f4939c)) {
                        account = accountsByType[i4];
                        break;
                    }
                    i4++;
                } else {
                    account = null;
                    break;
                }
            }
            if (account == null) {
                SystemLog.logError("Upload Service: Could not find google account - cannot send email");
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Upload Service: Could not find google account - cannot send email"));
                Util.displayNotification(this, "Cannot Send Email", "Gmail account not found", false);
                return;
            }
            this.f4944h = this.f4937a;
            accountManager.getAuthToken(account, "oauth2:https://www.googleapis.com/auth/gmail.send", true, new c(this, null), null);
        }
    }

    protected abstract String g();

    protected abstract String h();

    protected abstract String i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i4) {
        AlarmManager alarmManager = (AlarmManager) MacroDroidApplication.getInstance().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = this.f4942f;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (this.f4943g != null) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(this.f4943g);
            } catch (Exception unused) {
            }
            this.f4943g = null;
        }
        IntentFilter intentFilter = new IntentFilter("UploadQueueItem");
        this.f4943g = new QueueUpdateReceiver();
        MacroDroidApplication.getInstance().registerReceiver(this.f4943g, intentFilter);
        this.f4942f = PendingIntent.getBroadcast(MacroDroidApplication.getInstance(), 1948273, new Intent("UploadQueueItem"), 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
        AlarmHelper.scheduleExactAlarmWithInexactFallback(0, System.currentTimeMillis() + i4, this.f4942f, false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SystemLog.logInfo("Upload Service created");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SystemLog.logInfo("Upload Service destroyed");
    }

    protected abstract TwitterOutput.TwitterStatus q(Context context, QueueItem queueItem);

    protected abstract void s(Context context, QueueItem queueItem, String str) throws Exception;

    protected abstract void u(Context context, QueueItem queueItem, String str, String str2) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class QueueItem {
        public File attachFile;
        public String attachFileName;
        public List<String> attachFileNameList;
        public String body;
        public String email;
        public final Object item;
        public final long startTime = System.currentTimeMillis();
        public String subject;
        public final String uploadSite;

        public QueueItem(Object obj, String str) {
            this.item = obj;
            this.uploadSite = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof QueueItem)) {
                return false;
            }
            QueueItem queueItem = (QueueItem) obj;
            if (!queueItem.item.equals(this.item) || !queueItem.uploadSite.equals(this.uploadSite)) {
                return false;
            }
            return true;
        }

        public QueueItem(Object obj, String str, String str2) {
            this.item = obj;
            this.uploadSite = str;
            this.email = str2;
        }

        public QueueItem(Object obj, String str, String str2, String str3) {
            this.item = obj;
            this.uploadSite = str;
            this.email = str2;
            this.subject = str3;
        }

        public QueueItem(Object obj, String str, String str2, String str3, String str4) {
            this.item = obj;
            this.uploadSite = str;
            this.email = str2;
            this.subject = str3;
            this.body = str4;
        }

        public QueueItem(Object obj, String str, String str2, String str3, File file) {
            this.item = obj;
            this.uploadSite = str;
            this.email = str2;
            this.subject = str3;
            this.attachFile = file;
        }

        public QueueItem(Object obj, String str, String str2, String str3, File file, String str4) {
            this.item = obj;
            this.uploadSite = str;
            this.email = str2;
            this.subject = str3;
            this.attachFile = file;
            this.attachFileName = str4;
        }

        public QueueItem(Object obj, String str, String str2, String str3, File file, List<String> list) {
            this.item = obj;
            this.uploadSite = str;
            this.email = str2;
            this.subject = str3;
            this.attachFile = file;
            this.attachFileNameList = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements AccountManagerCallback<Bundle> {

        /* renamed from: a  reason: collision with root package name */
        final SharedPreferences f4952a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f4953b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f4954c;

        /* renamed from: d  reason: collision with root package name */
        final String f4955d;

        /* renamed from: e  reason: collision with root package name */
        final int f4956e;

        /* loaded from: classes2.dex */
        class a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f4958a;

            a(String str) {
                this.f4958a = str;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                String str2;
                boolean z3 = true;
                try {
                    UploadService uploadService = UploadService.this;
                    uploadService.u(uploadService, uploadService.f4937a, uploadService.f4939c, this.f4958a);
                    c cVar = c.this;
                    if (cVar.f4953b) {
                        try {
                            str = String.format(UploadService.this.getString(R.string.upload_or_share_x_was_sent), UploadService.this.f4938b);
                            String string = UploadService.this.getString(R.string.upload_or_share_x_was_sent_to_y);
                            UploadService uploadService2 = UploadService.this;
                            str2 = String.format(string, uploadService2.f4938b, uploadService2.f4937a.email);
                        } catch (Exception unused) {
                            str = UploadService.this.f4938b + " sent";
                            str2 = UploadService.this.f4938b + " was sent to: " + UploadService.this.f4937a.email;
                        }
                        Util.displayNotification(UploadService.this, str, str2, false);
                    }
                    UploadService.this.k();
                    if (UploadService.this.f4944h != null) {
                        UploadService uploadService3 = UploadService.this;
                        uploadService3.f4940d.remove(uploadService3.f4944h);
                    }
                } catch (UserRecoverableAuthIOException e4) {
                    SystemLog.logVerbose("OAUTH Token issue: " + e4);
                    Intent intent = e4.getIntent();
                    intent.addFlags(268435456);
                    GmailHelper.getInstance(UploadService.this).showAuthorizatinRequireNotification(intent);
                    if (UploadService.this.f4944h != null) {
                        UploadService uploadService4 = UploadService.this;
                        uploadService4.f4940d.remove(uploadService4.f4944h);
                    }
                    UploadService.this.j();
                } catch (Exception e5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SystemLog.logVerbose("OAUTH Token issue: " + e5);
                    if (UploadService.this.f4944h.startTime + (Integer.valueOf(c.this.f4955d).intValue() * 60 * 1000) > currentTimeMillis) {
                        z3 = false;
                    } else {
                        c cVar2 = c.this;
                        if (cVar2.f4954c) {
                            Util.displayNotification(UploadService.this, UploadService.this.f4938b + " sending failed", UploadService.this.f4938b + " not sent to: " + UploadService.this.f4937a.email, false);
                        }
                        if (UploadService.this.f4944h != null) {
                            UploadService uploadService5 = UploadService.this;
                            uploadService5.f4940d.remove(uploadService5.f4944h);
                        }
                        UploadService.this.j();
                    }
                }
                boolean unused2 = UploadService.f4936k = false;
                if (UploadService.this.f4940d.size() == 0) {
                    UploadService.this.l();
                    UploadService.this.stopSelf();
                } else if (z3) {
                    UploadService.this.n();
                }
            }
        }

        private c() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(UploadService.this);
            this.f4952a = defaultSharedPreferences;
            this.f4953b = defaultSharedPreferences.getBoolean(UploadService.this.h(), true);
            this.f4954c = defaultSharedPreferences.getBoolean(UploadService.this.g(), true);
            String string = defaultSharedPreferences.getString(UploadService.this.i(), "0");
            this.f4955d = string;
            this.f4956e = Integer.valueOf(string).intValue() * 60 * 1000;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            boolean z3;
            String str;
            try {
                String string = accountManagerFuture.getResult().getString("authtoken");
                if (string == null) {
                    SystemLog.logVerbose("OAUTH was null.");
                } else {
                    SystemLog.logVerbose("OAUTH Token acquired");
                }
                new a(string).start();
            } catch (Exception unused) {
                if (UploadService.this.f4944h.startTime + this.f4956e > System.currentTimeMillis()) {
                    z3 = false;
                } else {
                    z3 = true;
                    if (this.f4954c) {
                        try {
                            String string2 = UploadService.this.getString(R.string.upload_or_share_x_was_not_sent_to_y);
                            UploadService uploadService = UploadService.this;
                            str = String.format(string2, uploadService.f4938b, uploadService.f4937a.email);
                        } catch (Exception unused2) {
                            str = UploadService.this.f4938b + " was not sent to " + UploadService.this.f4937a.email;
                        }
                        UploadService uploadService2 = UploadService.this;
                        Util.displayNotification(uploadService2, uploadService2.getString(R.string.upload_or_share_sending_failed), str, false);
                    }
                    UploadService.this.j();
                    if (UploadService.this.f4944h != null) {
                        UploadService uploadService3 = UploadService.this;
                        uploadService3.f4940d.remove(uploadService3.f4944h);
                    }
                }
                boolean unused3 = UploadService.f4936k = false;
                if (UploadService.this.f4940d.size() == 0) {
                    UploadService.this.l();
                    UploadService.this.stopSelf();
                } else if (z3) {
                    UploadService.this.n();
                }
            }
        }

        /* synthetic */ c(UploadService uploadService, a aVar) {
            this();
        }
    }

    protected void j() {
    }

    protected void k() {
    }
}
