package com.google.mlkit.nl.translate.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelResource;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.io.File;
import java.nio.charset.Charset;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public class TranslateJni extends ModelResource {

    /* renamed from: j */
    private static boolean f33061j;

    /* renamed from: d */
    private final zzaf f33062d;

    /* renamed from: e */
    private final zzt f33063e;

    /* renamed from: f */
    private final ModelFileHelper f33064f;

    /* renamed from: g */
    private final String f33065g;

    /* renamed from: h */
    private final String f33066h;

    /* renamed from: i */
    private long f33067i;

    @VisibleForTesting
    public TranslateJni(zzaf zzafVar, zzt zztVar, ModelFileHelper modelFileHelper, String str, String str2) {
        this.f33062d = zzafVar;
        this.f33063e = zztVar;
        this.f33064f = modelFileHelper;
        this.f33065g = str;
        this.f33066h = str2;
    }

    private final File d(String str) {
        return this.f33064f.getModelDirUnsafe(str, ModelType.TRANSLATE, false);
    }

    private native void nativeDestroy(long j4);

    private native long nativeInit(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) throws zzl;

    @UsedByNative("translate_jni.cc")
    private static Exception newLoadingException(int i4) {
        return new zzl(i4, null);
    }

    @UsedByNative("translate_jni.cc")
    private static Exception newTranslateException(int i4) {
        return new zzn(i4, null);
    }

    @VisibleForTesting
    public static void zze() throws MlKitException {
        if (f33061j) {
            return;
        }
        try {
            System.loadLibrary("translate_jni");
            f33061j = true;
        } catch (UnsatisfiedLinkError e4) {
            throw new MlKitException("Couldn't load translate native code library.", 12, e4);
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final void load() throws MlKitException {
        boolean z3;
        String str;
        Exception exc;
        boolean z4;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (this.f33067i == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            zze();
            com.google.android.gms.internal.mlkit_translate.zzv zzb = zzad.zzb(this.f33065g, this.f33066h);
            if (zzb.size() < 2) {
                exc = null;
            } else {
                String absolutePath = d(zzad.zzf((String) zzb.get(0), (String) zzb.get(1))).getAbsolutePath();
                zzp zzpVar = new zzp(this, null);
                zzpVar.a(absolutePath, (String) zzb.get(0), (String) zzb.get(1));
                zzp zzpVar2 = new zzp(this, null);
                if (zzb.size() > 2) {
                    String absolutePath2 = d(zzad.zzf((String) zzb.get(1), (String) zzb.get(2))).getAbsolutePath();
                    zzpVar2.a(absolutePath2, (String) zzb.get(1), (String) zzb.get(2));
                    str = absolutePath2;
                } else {
                    str = null;
                }
                try {
                    exc = null;
                    long nativeInit = nativeInit(this.f33065g, this.f33066h, absolutePath, str, zzpVar.f33130a, zzpVar2.f33130a, zzpVar.f33131b, zzpVar2.f33131b, zzpVar.f33132c, zzpVar2.f33132c);
                    this.f33067i = nativeInit;
                    if (nativeInit != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Preconditions.checkState(z4);
                } catch (zzl e4) {
                    if (e4.zza() != 1 && e4.zza() != 8) {
                        throw new MlKitException("Error loading translation model", 2, e4);
                    }
                    throw new MlKitException("Translation model files not found. Make sure to call downloadModelIfNeeded and if that fails, delete the models and retry.", 5, e4);
                }
            }
            this.f33063e.zzo(elapsedRealtime, exc);
        } catch (Exception e5) {
            this.f33063e.zzo(elapsedRealtime, e5);
            throw e5;
        }
    }

    @NonNull
    @VisibleForTesting
    public native byte[] nativeTranslate(long j4, @NonNull byte[] bArr) throws zzn;

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final void release() {
        long j4 = this.f33067i;
        if (j4 == 0) {
            return;
        }
        nativeDestroy(j4);
        this.f33067i = 0L;
    }

    @NonNull
    public final String zzd(@NonNull String str) throws MlKitException {
        if (this.f33065g.equals(this.f33066h)) {
            return str;
        }
        try {
            long j4 = this.f33067i;
            Charset charset = com.google.android.gms.internal.mlkit_translate.zzc.zzc;
            return new String(nativeTranslate(j4, str.getBytes(charset)), charset);
        } catch (zzn e4) {
            throw new MlKitException("Error translating", 2, e4);
        }
    }
}
