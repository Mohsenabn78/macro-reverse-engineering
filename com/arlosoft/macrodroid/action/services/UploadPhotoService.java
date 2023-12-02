package com.arlosoft.macrodroid.action.services;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import androidx.loader.content.CursorLoader;
import com.arlosoft.macrodroid.action.email.GMailOauthSender;
import com.arlosoft.macrodroid.action.email.withpassword.GMailSender;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.settings.Settings;
import com.tencent.soter.core.model.ConstantsSoter;
import java.io.File;

/* loaded from: classes2.dex */
public class UploadPhotoService extends UploadService {
    public static final String EXTRA_PHOTO_FILE = "photo_file";
    public static final String EXTRA_PHOTO_URI = "photo_uri";

    /* loaded from: classes2.dex */
    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f4928a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4929b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f4930c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f4931d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f4932e;

        a(Intent intent, String str, String str2, String str3, String str4) {
            this.f4928a = intent;
            this.f4929b = str;
            this.f4930c = str2;
            this.f4931d = str3;
            this.f4932e = str4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Object lastPhoto;
            if (this.f4928a.getExtras().containsKey(UploadPhotoService.EXTRA_PHOTO_URI)) {
                lastPhoto = this.f4928a.getExtras().getParcelable(UploadPhotoService.EXTRA_PHOTO_URI);
            } else if (this.f4928a.getExtras().containsKey(UploadPhotoService.EXTRA_PHOTO_FILE)) {
                lastPhoto = this.f4928a.getExtras().getString(UploadPhotoService.EXTRA_PHOTO_FILE);
            } else {
                try {
                    Thread.sleep(ConstantsSoter.FACEID_AUTH_CHECK_TIME);
                } catch (InterruptedException unused) {
                }
                lastPhoto = Util.getLastPhoto(UploadPhotoService.this);
            }
            Object obj = lastPhoto;
            if (obj != null) {
                UploadService.QueueItem queueItem = new UploadService.QueueItem(obj, this.f4929b, this.f4930c, this.f4931d, this.f4932e);
                synchronized (UploadService.f4934i) {
                    UploadPhotoService.this.f4940d.add(queueItem);
                    if (UploadPhotoService.this.f4940d.size() == 1) {
                        UploadPhotoService.this.m(0);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("IN PHOTO - UPLOAD QUEUE SIZE IS ");
                        sb.append(UploadPhotoService.this.f4940d.size());
                        sb.append(" (NO ALARM SET)");
                    }
                }
                return;
            }
            Log.w("UploadPhotoService", "Could not detect last photo taken");
        }
    }

    private String v(Uri uri) {
        Looper.prepare();
        Cursor loadInBackground = new CursorLoader(this, uri, new String[]{"_data"}, null, null, null).loadInBackground();
        int columnIndexOrThrow = loadInBackground.getColumnIndexOrThrow("_data");
        loadInBackground.moveToFirst();
        String string = loadInBackground.getString(columnIndexOrThrow);
        loadInBackground.close();
        return string;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected String g() {
        return "preferences:upload_photo_notify_failure";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected String h() {
        return "preferences:upload_photo_notify_success";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected String i() {
        return "preferences:upload_photo_retry_period";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4938b = "photo";
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        if (intent == null) {
            return 2;
        }
        new a(intent, intent.getExtras().getString(UploadService.EXTRA_UPLOAD_SITE), intent.getExtras().getString(UploadService.EXTRA_UPLOAD_EMAIL_ADDRESS), intent.getExtras().getString("Subject"), intent.getExtras().getString("Body")).start();
        return 2;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected TwitterOutput.TwitterStatus q(Context context, UploadService.QueueItem queueItem) {
        return TwitterOutput.uploadPhoto(context, (Uri) queueItem.item);
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void s(Context context, UploadService.QueueItem queueItem, String str) throws Exception {
        File file;
        if (this.f4937a.item instanceof Uri) {
            file = new File(v((Uri) this.f4937a.item));
        } else {
            file = new File((String) this.f4937a.item);
        }
        GMailSender gMailSender = new GMailSender(str, Settings.getEmailPassword(context));
        UploadService.QueueItem queueItem2 = this.f4937a;
        gMailSender.sendMail(queueItem2.subject, queueItem2.body, str, queueItem2.email, file);
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void u(Context context, UploadService.QueueItem queueItem, String str, String str2) throws Exception {
        File file;
        if (this.f4937a.item instanceof Uri) {
            file = new File(v((Uri) this.f4937a.item));
        } else {
            file = new File((String) this.f4937a.item);
        }
        File file2 = file;
        GMailOauthSender gMailOauthSender = new GMailOauthSender();
        UploadService.QueueItem queueItem2 = this.f4937a;
        gMailOauthSender.sendMail(context, queueItem2.subject, queueItem2.body, str, str2, queueItem2.email, file2);
    }
}
