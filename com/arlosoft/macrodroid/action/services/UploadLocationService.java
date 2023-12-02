package com.arlosoft.macrodroid.action.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.arlosoft.macrodroid.action.email.GMailOauthSender;
import com.arlosoft.macrodroid.action.email.withpassword.GMailSender;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes2.dex */
public class UploadLocationService extends UploadService {
    public static final String EXTRA_LOCATION_MESSAGE = "LocationMessage";

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected String g() {
        return "preferences:share_location_notify_failure";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected String h() {
        return "preferences:share_location_notify_success";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected String i() {
        return "preferences:share_location_retry_period";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4938b = FirebaseAnalytics.Param.LOCATION;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        if (intent == null) {
            return 2;
        }
        String string = intent.getExtras().getString(UploadService.EXTRA_UPLOAD_SITE);
        String string2 = intent.getExtras().getString(EXTRA_LOCATION_MESSAGE);
        String string3 = intent.getExtras().getString(UploadService.EXTRA_UPLOAD_EMAIL_ADDRESS);
        if (string2 != null) {
            UploadService.QueueItem queueItem = new UploadService.QueueItem(string2, string, string3);
            synchronized (UploadService.f4934i) {
                this.f4940d.add(queueItem);
            }
            if (this.f4940d.size() == 1) {
                m(0);
            }
        } else {
            Log.w("UploadLocationService", "location message is null");
        }
        return 2;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected TwitterOutput.TwitterStatus q(Context context, UploadService.QueueItem queueItem) {
        return TwitterOutput.uploadMessage(context, (String) queueItem.item);
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void s(Context context, UploadService.QueueItem queueItem, String str) throws Exception {
        GMailSender gMailSender = new GMailSender(str, Settings.getEmailPassword(context));
        UploadService.QueueItem queueItem2 = this.f4937a;
        gMailSender.sendMail("Sharing Location", (String) queueItem2.item, str, queueItem2.email);
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void u(Context context, UploadService.QueueItem queueItem, String str, String str2) throws Exception {
        GMailOauthSender gMailOauthSender = new GMailOauthSender();
        UploadService.QueueItem queueItem2 = this.f4937a;
        gMailOauthSender.sendMail(context, "Sharing Location", (String) queueItem2.item, str, str2, queueItem2.email);
    }
}
