package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzc extends com.google.android.play.core.appupdate.internal.zzl {
    public zzc(Context context) {
        super(new com.google.android.play.core.appupdate.internal.zzm("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.play.core.appupdate.internal.zzl
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f25180a.zza("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.f25180a.zza("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f25180a.zza("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        InstallState zzb = InstallState.zzb(intent, this.f25180a);
        this.f25180a.zza("ListenerRegistryBroadcastReceiver.onReceive: %s", zzb);
        zzd(zzb);
    }
}
