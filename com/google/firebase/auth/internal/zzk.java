package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzcb;
import com.google.android.gms.internal.p002firebaseauthapi.zzio;
import com.google.android.gms.internal.p002firebaseauthapi.zzit;
import com.google.android.gms.internal.p002firebaseauthapi.zzjr;
import com.google.android.gms.internal.p002firebaseauthapi.zzjt;
import com.google.android.gms.internal.p002firebaseauthapi.zzly;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzk {

    /* renamed from: c  reason: collision with root package name */
    private static zzk f29071c;

    /* renamed from: a  reason: collision with root package name */
    private final String f29072a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final zzjt f29073b;

    private zzk(Context context, String str, boolean z3) {
        zzjt zzjtVar;
        this.f29072a = str;
        try {
            zzio.zza();
            zzjr zzjrVar = new zzjr();
            zzjrVar.zzf(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str));
            zzjrVar.zzd(zzit.zza);
            zzjrVar.zze(String.format("android-keystore://firebear_master_key_id.%s", str));
            zzjtVar = zzjrVar.zzg();
        } catch (IOException | GeneralSecurityException e4) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n".concat(String.valueOf(e4.getMessage())));
            zzjtVar = null;
        }
        this.f29073b = zzjtVar;
    }

    public static zzk zza(Context context, String str) {
        zzk zzkVar = f29071c;
        if (zzkVar == null || !com.google.android.gms.internal.p002firebaseauthapi.zzq.zza(zzkVar.f29072a, str)) {
            f29071c = new zzk(context, str, true);
        }
        return f29071c;
    }

    @Nullable
    public final String zzb(String str) {
        String str2;
        zzjt zzjtVar = this.f29073b;
        if (zzjtVar != null) {
            try {
                synchronized (zzjtVar) {
                    str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzbk) this.f29073b.zza().zze(zzly.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbk.class)).zza(Base64.decode(str, 8), null), "UTF-8");
                }
                return str2;
            } catch (UnsupportedEncodingException | GeneralSecurityException e4) {
                Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n".concat(String.valueOf(e4.getMessage())));
                return null;
            }
        }
        Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
        return null;
    }

    @Nullable
    public final String zzc() {
        if (this.f29073b == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzcb zza = com.google.android.gms.internal.p002firebaseauthapi.zzbf.zza(byteArrayOutputStream);
        try {
            synchronized (this.f29073b) {
                this.f29073b.zza().zzb().zzg(zza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e4) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n".concat(String.valueOf(e4.getMessage())));
            return null;
        }
    }
}
