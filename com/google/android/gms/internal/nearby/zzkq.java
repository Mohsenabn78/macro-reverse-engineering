package com.google.android.gms.internal.nearby;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@RequiresApi(19)
@TargetApi(19)
/* loaded from: classes4.dex */
public final class zzkq {
    private static final WeakHashMap zza = new WeakHashMap();
    private final Context zzb;
    private final WeakReference zzc;
    private final NfcAdapter zzd;
    private boolean zze = true;
    private boolean zzf;
    private boolean zzg;

    private zzkq(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        this.zzb = applicationContext;
        WeakReference weakReference = new WeakReference(activity);
        this.zzc = weakReference;
        this.zzd = NfcAdapter.getDefaultAdapter(applicationContext);
        activity.getApplication().registerActivityLifecycleCallbacks(new zzkp(this, weakReference));
    }

    public static synchronized zzkq zza(Activity activity) {
        zzkq zzkqVar;
        synchronized (zzkq.class) {
            WeakHashMap weakHashMap = zza;
            if (!weakHashMap.containsKey(activity)) {
                weakHashMap.put(activity, new zzkq(activity));
            }
            zzkqVar = (zzkq) weakHashMap.get(activity);
        }
        return zzkqVar;
    }

    public static /* synthetic */ void zzb(zzkq zzkqVar, Tag tag) {
        Intent intent = new Intent("android.nfc.action.TAG_DISCOVERED");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("android.nfc.extra.TAG", tag);
        zzkqVar.zzb.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        NfcAdapter nfcAdapter;
        Activity activity;
        if (this.zze && this.zzf) {
            if (this.zzg || !this.zzb.getPackageManager().hasSystemFeature("android.hardware.nfc") || ContextCompat.checkSelfPermission(this.zzb, "android.permission.NFC") != 0 || (nfcAdapter = this.zzd) == null || !nfcAdapter.isEnabled() || (activity = (Activity) this.zzc.get()) == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("presence", 100);
            this.zzd.enableReaderMode(activity, new NfcAdapter.ReaderCallback() { // from class: com.google.android.gms.internal.nearby.zzko
                @Override // android.nfc.NfcAdapter.ReaderCallback
                public final void onTagDiscovered(Tag tag) {
                    zzkq.zzb(zzkq.this, tag);
                }
            }, 385, bundle);
            this.zzg = true;
        } else if (!this.zzg) {
        } else {
            Activity activity2 = (Activity) this.zzc.get();
            if (activity2 != null) {
                this.zzd.disableReaderMode(activity2);
            }
            this.zzg = false;
        }
    }

    public final void zze() {
        this.zzf = true;
        zzg();
    }

    public final void zzf() {
        this.zzf = false;
        zzg();
    }
}
