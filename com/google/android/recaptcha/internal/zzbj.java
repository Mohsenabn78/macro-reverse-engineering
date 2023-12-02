package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbj {
    @NotNull
    public static final zzbj zza = new zzbj();
    @Nullable
    private static Set zzb;
    @Nullable
    private static Set zzc;
    @Nullable
    private static Long zzd;
    private static int zze;

    private zzbj() {
    }

    public static final void zza(@NotNull zzlr zzlrVar) {
        Set set;
        Set set2;
        set = CollectionsKt___CollectionsKt.toSet(zzlrVar.zzf().zzi());
        zzb = set;
        set2 = CollectionsKt___CollectionsKt.toSet(zzlrVar.zzg().zzi());
        zzc = set2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x016a  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object zzb(@org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull android.content.Context r23, @org.jetbrains.annotations.NotNull com.google.android.recaptcha.internal.zzr r24, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbj.zzb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context, com.google.android.recaptcha.internal.zzr, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean zzc(@NotNull String str) {
        Set set = zzb;
        if (set != null && zzc != null) {
            Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            if (set.isEmpty()) {
                return true;
            }
            Set set2 = zzc;
            Intrinsics.checkNotNull(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            if (zzd(str, set2)) {
                return false;
            }
            return zzd(str, set);
        }
        if (zzd == null) {
            zzd = Long.valueOf(System.currentTimeMillis());
        }
        zze++;
        return true;
    }

    private static final boolean zzd(String str, Set set) {
        List<String> split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        String str2 = "";
        for (String str3 : split$default) {
            String concat = str2.concat(String.valueOf(str3));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(".");
        }
        return false;
    }
}
