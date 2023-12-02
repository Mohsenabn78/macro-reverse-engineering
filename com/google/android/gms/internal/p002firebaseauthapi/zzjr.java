package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjr */
/* loaded from: classes4.dex */
public final class zzjr {
    private Context zza = null;
    private String zzb = null;
    private String zzc = null;
    private String zzd = null;
    private zzbd zze = null;
    private zzbv zzf = null;
    @GuardedBy("this")
    private zzca zzg;

    @Nullable
    private final zzbd zzj() throws GeneralSecurityException {
        String str;
        String str2;
        String str3;
        if (!zzjt.zzd()) {
            str3 = zzjt.zzc;
            Log.w(str3, "Android Keystore requires at least Android M");
            return null;
        }
        zzjv zzjvVar = new zzjv();
        try {
            boolean zzc = zzjv.zzc(this.zzd);
            try {
                return zzjvVar.zza(this.zzd);
            } catch (GeneralSecurityException | ProviderException e4) {
                if (zzc) {
                    str2 = zzjt.zzc;
                    Log.w(str2, "cannot use Android Keystore, it'll be disabled", e4);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzd), e4);
            }
        } catch (GeneralSecurityException | ProviderException e5) {
            str = zzjt.zzc;
            Log.w(str, "cannot use Android Keystore, it'll be disabled", e5);
            return null;
        }
    }

    private final zzca zzk(byte[] bArr) throws GeneralSecurityException, IOException {
        String str;
        try {
            this.zze = new zzjv().zza(this.zzd);
            try {
                return zzca.zzf(zzbz.zzh(zzbe.zzc(bArr), this.zze));
            } catch (IOException | GeneralSecurityException e4) {
                try {
                    return zzl(bArr);
                } catch (IOException unused) {
                    throw e4;
                }
            }
        } catch (GeneralSecurityException | ProviderException e5) {
            try {
                zzca zzl = zzl(bArr);
                str = zzjt.zzc;
                Log.w(str, "cannot use Android Keystore, it'll be disabled", e5);
                return zzl;
            } catch (IOException unused2) {
                throw e5;
            }
        }
    }

    private static final zzca zzl(byte[] bArr) throws GeneralSecurityException, IOException {
        return zzca.zzf(zzbg.zzb(zzbe.zzc(bArr)));
    }

    public final zzjr zzd(zzth zzthVar) {
        String zzg = zzthVar.zzg();
        byte[] zzq = zzthVar.zzf().zzq();
        zzui zze = zzthVar.zze();
        int i4 = zzjt.zza;
        zzui zzuiVar = zzui.UNKNOWN_PREFIX;
        int ordinal = zze.ordinal();
        int i5 = 1;
        if (ordinal != 1) {
            i5 = 2;
            if (ordinal != 2) {
                i5 = 3;
                if (ordinal != 3) {
                    i5 = 4;
                    if (ordinal != 4) {
                        throw new IllegalArgumentException("Unknown output prefix type");
                    }
                }
            }
        }
        this.zzf = zzbv.zzd(zzg, zzq, i5);
        return this;
    }

    public final zzjr zze(String str) {
        if (str.startsWith("android-keystore://")) {
            this.zzd = str;
            return this;
        }
        throw new IllegalArgumentException("key URI must start with android-keystore://");
    }

    public final zzjr zzf(Context context, String str, String str2) throws IOException {
        if (context != null) {
            this.zza = context;
            this.zzb = "GenericIdpKeyset";
            this.zzc = str2;
            return this;
        }
        throw new IllegalArgumentException("need an Android context");
    }

    public final synchronized zzjt zzg() throws GeneralSecurityException, IOException {
        Object obj;
        SharedPreferences sharedPreferences;
        byte[] bArr;
        zzjt zzjtVar;
        if (this.zzb != null) {
            obj = zzjt.zzb;
            synchronized (obj) {
                Context context = this.zza;
                String str = this.zzb;
                String str2 = this.zzc;
                if (str != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (str2 == null) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                    } else {
                        sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
                    }
                    try {
                        String string = sharedPreferences.getString(str, null);
                        if (string == null) {
                            bArr = null;
                        } else if (string.length() % 2 == 0) {
                            int length = string.length() / 2;
                            bArr = new byte[length];
                            for (int i4 = 0; i4 < length; i4++) {
                                int i5 = i4 + i4;
                                int digit = Character.digit(string.charAt(i5), 16);
                                int digit2 = Character.digit(string.charAt(i5 + 1), 16);
                                if (digit != -1 && digit2 != -1) {
                                    bArr[i4] = (byte) ((digit * 16) + digit2);
                                } else {
                                    throw new IllegalArgumentException("input is not hexadecimal");
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Expected a string of even length");
                        }
                        if (bArr == null) {
                            if (this.zzd != null) {
                                this.zze = zzj();
                            }
                            if (this.zzf != null) {
                                zzca zze = zzca.zze();
                                zze.zzc(this.zzf);
                                zze.zzd(zze.zzb().zzd().zzb(0).zza());
                                zzjw zzjwVar = new zzjw(this.zza, this.zzb, this.zzc);
                                zzbz zzb = zze.zzb();
                                zzbd zzbdVar = this.zze;
                                try {
                                    if (zzbdVar != null) {
                                        zzb.zzf(zzjwVar, zzbdVar);
                                    } else {
                                        zzbg.zza(zzb, zzjwVar);
                                    }
                                    this.zzg = zze;
                                } catch (IOException e4) {
                                    throw new GeneralSecurityException(e4);
                                }
                            } else {
                                throw new GeneralSecurityException("cannot read or generate keyset");
                            }
                        } else {
                            if (this.zzd != null && zzjt.zzd()) {
                                this.zzg = zzk(bArr);
                            }
                            this.zzg = zzl(bArr);
                        }
                        zzjtVar = new zzjt(this, null);
                    } catch (ClassCastException | IllegalArgumentException unused) {
                        throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
                    }
                } else {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        return zzjtVar;
    }
}
