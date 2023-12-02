package com.google.mlkit.nl.translate.internal;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_translate.zzat;
import com.google.android.gms.internal.mlkit_translate.zznv;
import com.google.android.gms.internal.mlkit_translate.zzqt;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzaf {

    /* renamed from: a  reason: collision with root package name */
    private final zzqt f33094a;

    /* renamed from: b  reason: collision with root package name */
    private final zzr f33095b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelFileHelper f33096c;

    /* renamed from: d  reason: collision with root package name */
    private final zzae f33097d;

    public zzaf(zzqt zzqtVar, zzae zzaeVar, zzr zzrVar, ModelFileHelper modelFileHelper, byte[] bArr) {
        this.f33094a = zzqtVar;
        this.f33097d = zzaeVar;
        this.f33095b = zzrVar;
        this.f33096c = modelFileHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String b(String str, String str2) {
        return String.format("fallback_to_pb_%s.pb.bin", g(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String c(String str, String str2) {
        return String.format("nmt_rapid_response_%s.pb.bin", g(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String d(String str, String str2) {
        return String.format("stt_rapid_response_%s.pb.bin", g(str, str2));
    }

    @VisibleForTesting
    static final void e(File file, String str, @Nullable String str2) throws IOException {
        File file2 = new File(file, str);
        if (com.google.android.gms.internal.mlkit_translate.zzl.zzc(str2)) {
            if (file2.exists()) {
                file2.delete();
                return;
            }
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            fileOutputStream.write(zzat.zzd().zze(str2));
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void f(File file, String str, String str2) {
        new File(file, c(str, str2)).delete();
        new File(file, d(str, str2)).delete();
        new File(file, b(str, str2)).delete();
    }

    private static String g(String str, String str2) {
        return String.format("%s_%s", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        File modelDirUnsafe = this.f33096c.getModelDirUnsafe(zzad.zzf(str, str2), ModelType.TRANSLATE, false);
        String g4 = g(str, str2);
        try {
            zzd.a(modelDirUnsafe);
            e(modelDirUnsafe, c(str, str2), this.f33097d.f33093a.zzf(String.format("nl_translate_rapid_response_nmt_%s", g4)));
            e(modelDirUnsafe, b(str, str2), this.f33097d.f33093a.zzf(String.format("nl_translate_rapid_response_pbmt_%s", g4)));
            e(modelDirUnsafe, d(str, str2), this.f33097d.f33093a.zzf(String.format("nl_translate_rapid_response_stt_%s", g4)));
        } catch (IOException unused) {
            zznv zznvVar = new zznv();
            zznvVar.zza(str);
            zznvVar.zzb(str2);
            this.f33095b.zza(zznvVar.zzc()).x();
        }
    }

    public final void zzb() {
        this.f33094a.zza(zzqt.zza);
    }
}
