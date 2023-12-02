package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbg extends zzbd {
    @NotNull
    private final zzbf zza;
    @NotNull
    private final String zzb;

    public zzbg(@NotNull zzbf zzbfVar, @NotNull String str, @Nullable Object obj) {
        super(obj);
        this.zza = zzbfVar;
        this.zzb = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        r2 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r3);
     */
    @Override // com.google.android.recaptcha.internal.zzbd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(@org.jetbrains.annotations.NotNull java.lang.Object r1, @org.jetbrains.annotations.NotNull java.lang.reflect.Method r2, @org.jetbrains.annotations.Nullable java.lang.Object[] r3) {
        /*
            r0 = this;
            java.lang.String r1 = r2.getName()
            java.lang.String r2 = r0.zzb
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L1f
            com.google.android.recaptcha.internal.zzbf r1 = r0.zza
            if (r3 == 0) goto L16
            java.util.List r2 = kotlin.collections.ArraysKt.asList(r3)
            if (r2 != 0) goto L1a
        L16:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L1a:
            r1.zzb(r2)
            r1 = 1
            return r1
        L1f:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbg.zza(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):boolean");
    }
}
