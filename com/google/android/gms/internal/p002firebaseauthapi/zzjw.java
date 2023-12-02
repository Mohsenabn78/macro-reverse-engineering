package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjw implements zzcb {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzjw(Context context, String str, String str2) {
        if (str != null) {
            this.zzb = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
                return;
            } else {
                this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
                return;
            }
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final void zzb(zzry zzryVar) throws IOException {
        if (this.zza.putString(this.zzb, zzvy.zza(zzryVar.zzq())).commit()) {
            return;
        }
        throw new IOException("Failed to write to SharedPreferences");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final void zzc(zztp zztpVar) throws IOException {
        if (this.zza.putString(this.zzb, zzvy.zza(zztpVar.zzq())).commit()) {
            return;
        }
        throw new IOException("Failed to write to SharedPreferences");
    }
}
