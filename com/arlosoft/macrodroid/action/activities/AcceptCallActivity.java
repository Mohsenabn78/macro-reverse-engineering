package com.arlosoft.macrodroid.action.activities;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* loaded from: classes2.dex */
public class AcceptCallActivity extends NonAppActivity {

    /* renamed from: d  reason: collision with root package name */
    private KeyguardManager f2784d;

    /* renamed from: e  reason: collision with root package name */
    private AudioManager f2785e;

    /* renamed from: f  reason: collision with root package name */
    private b f2786f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AcceptCallActivity.this.finish();
        }
    }

    private void h() {
        boolean z3;
        if ("HTC".equalsIgnoreCase(Build.MANUFACTURER) && !this.f2785e.isWiredHeadsetOn()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i(false);
        }
        try {
            try {
                k();
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("input keyevent " + Integer.toString(79));
            } catch (Exception unused) {
                Intent putExtra = new Intent("android.intent.action.MEDIA_BUTTON").putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, 79));
                Intent putExtra2 = new Intent("android.intent.action.MEDIA_BUTTON").putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
                sendOrderedBroadcast(putExtra, "android.permission.CALL_PRIVILEGED");
                sendOrderedBroadcast(putExtra2, "android.permission.CALL_PRIVILEGED");
            }
            if (z3) {
                i(false);
            }
        } catch (Throwable th) {
            if (z3) {
                i(false);
            }
            throw th;
        }
    }

    private void i(boolean z3) {
        Intent intent = new Intent("android.intent.action.HEADSET_PLUG");
        intent.addFlags(1073741824);
        intent.putExtra(RemoteConfigConstants.ResponseFieldKey.STATE, z3 ? 1 : 0);
        intent.putExtra("name", "mysms");
        try {
            sendOrderedBroadcast(intent, null);
        } catch (Exception unused) {
        }
    }

    private void j() {
        this.f2786f = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(this.f2786f, intentFilter);
    }

    private void l() {
        if (this.f2784d.inKeyguardRestrictedInputMode()) {
            getWindow().addFlags(6815744);
        } else {
            getWindow().clearFlags(4718720);
        }
    }

    @TargetApi(21)
    void k() {
        try {
            for (MediaController mediaController : ((MediaSessionManager) getApplicationContext().getSystemService("media_session")).getActiveSessions(new ComponentName(getApplicationContext(), NotificationService.class))) {
                if ("com.android.server.telecom".equals(mediaController.getPackageName())) {
                    mediaController.dispatchMediaButtonEvent(new KeyEvent(1, 79));
                    return;
                }
            }
        } catch (SecurityException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2784d = (KeyguardManager) getSystemService("keyguard");
        this.f2785e = (AudioManager) getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b bVar = this.f2786f;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.f2786f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        j();
        l();
        h();
    }
}
