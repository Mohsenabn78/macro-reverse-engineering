package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import javax.crypto.KeyGenerator;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjv implements zzcc {
    private static final Object zza = new Object();
    private static final String zzb = "zzjv";
    @GuardedBy("this")
    private KeyStore zzc;

    @RequiresApi(23)
    public zzjv() throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                this.zzc = keyStore;
                return;
            } catch (IOException | GeneralSecurityException e4) {
                throw new IllegalStateException(e4);
            }
        }
        throw new IllegalStateException("need Android Keystore on Android M or newer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(23)
    public static boolean zzc(String str) throws GeneralSecurityException {
        KeyGenParameterSpec.Builder keySize;
        KeyGenParameterSpec.Builder blockModes;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec build;
        zzjv zzjvVar = new zzjv();
        synchronized (zza) {
            if (!zzjvVar.zzd(str)) {
                String zza2 = zzwf.zza("android-keystore://", str);
                KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES, "AndroidKeyStore");
                keySize = new KeyGenParameterSpec.Builder(zza2, 3).setKeySize(256);
                blockModes = keySize.setBlockModes("GCM");
                encryptionPaddings = blockModes.setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_NONE);
                build = encryptionPaddings.build();
                keyGenerator.init(build);
                keyGenerator.generateKey();
                return true;
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcc
    public final synchronized zzbd zza(String str) throws GeneralSecurityException {
        zzju zzjuVar;
        zzjuVar = new zzju(zzwf.zza("android-keystore://", str), this.zzc);
        byte[] zzb2 = zzlx.zzb(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zzb2, zzjuVar.zza(zzjuVar.zzb(zzb2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzjuVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcc
    @RequiresApi(23)
    public final synchronized boolean zzb(String str) {
        if (str.toLowerCase(Locale.US).startsWith("android-keystore://")) {
            return true;
        }
        return false;
    }

    final synchronized boolean zzd(String str) throws GeneralSecurityException {
        String str2;
        try {
        } catch (NullPointerException unused) {
            Log.w(zzb, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
            try {
                try {
                    Thread.sleep((int) (Math.random() * 40.0d));
                } catch (InterruptedException unused2) {
                }
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zzc = keyStore;
                keyStore.load(null);
                return this.zzc.containsAlias(str2);
            } catch (IOException e4) {
                throw new GeneralSecurityException(e4);
            }
        }
        return this.zzc.containsAlias(zzwf.zza("android-keystore://", str));
    }
}
