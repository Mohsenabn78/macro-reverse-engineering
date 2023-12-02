package com.google.mlkit.nl.translate.internal;

import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.Arrays;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzad {

    /* renamed from: a  reason: collision with root package name */
    private static final com.google.android.gms.internal.mlkit_translate.zzv f33092a = com.google.android.gms.internal.mlkit_translate.zzv.zzn("merged_dict_%1$s_%2$s_update.bin", "merged_dict_%1$s_%2$s_both.bin", "merged_dict_%1$s_%2$s_from_%3$s.bin", "merged_dict_%1$s_%2$s_from_%4$s.bin");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] a(String str) {
        if (str.matches("[a-z]{2,3}_[a-z]{2,3}")) {
            return str.split("_", -1);
        }
        throw new IllegalArgumentException(String.format("Model name expected to be matching %s", "[a-z]{2,3}_[a-z]{2,3}"));
    }

    public static com.google.android.gms.internal.mlkit_translate.zzv zza(String str) {
        String[] a4 = a(str);
        String str2 = a4[0];
        String str3 = a4[1];
        String[] strArr = new String[f33092a.size()];
        int i4 = 0;
        while (true) {
            com.google.android.gms.internal.mlkit_translate.zzv zzvVar = f33092a;
            if (i4 < zzvVar.size()) {
                strArr[i4] = String.format((String) zzvVar.get(i4), str, "25", str2, str3);
                i4++;
            } else {
                return com.google.android.gms.internal.mlkit_translate.zzv.zzj(strArr);
            }
        }
    }

    public static com.google.android.gms.internal.mlkit_translate.zzv zzb(String str, String str2) {
        if (str.equals(str2)) {
            return com.google.android.gms.internal.mlkit_translate.zzv.zzk(str);
        }
        if (!str.equals("en") && !str2.equals("en")) {
            return com.google.android.gms.internal.mlkit_translate.zzv.zzm(str, "en", str2);
        }
        return com.google.android.gms.internal.mlkit_translate.zzv.zzl(str, str2);
    }

    public static com.google.android.gms.internal.mlkit_translate.zzaa zzc(@TranslateLanguage.Language String str, @TranslateLanguage.Language String str2) {
        if (!str.equals(str2)) {
            com.google.android.gms.internal.mlkit_translate.zzz zzzVar = new com.google.android.gms.internal.mlkit_translate.zzz();
            if (!str.equals("en")) {
                zzzVar.zzc(str);
            }
            if (!str2.equals("en")) {
                zzzVar.zzc(str2);
            }
            return zzzVar.zzd();
        }
        return com.google.android.gms.internal.mlkit_translate.zzaa.zzj();
    }

    public static String zzd(String str) {
        return String.format("dict.%1$s_%2$s", str, "25");
    }

    public static String zze(@TranslateLanguage.Language String str) {
        return zzf("en", TranslateLanguage.zza(str));
    }

    public static String zzf(String str, String str2) {
        if ((str.equals("en") || str2.equals("en")) && !str.equals(str2)) {
            String[] strArr = {str, str2};
            Arrays.sort(strArr);
            return String.format("%s_%s", strArr[0], strArr[1]);
        }
        throw new IllegalArgumentException();
    }
}
