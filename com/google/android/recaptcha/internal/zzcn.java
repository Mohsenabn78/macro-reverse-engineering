package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcn implements zzby {
    @NotNull
    public static final zzcn zza = new zzcn();

    private zzcn() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 2) {
            Object obj = objArr[0];
            if (true != (obj instanceof int[])) {
                obj = null;
            }
            int[] iArr = (int[]) obj;
            if (iArr != null) {
                Object obj2 = objArr[1];
                if (true != (obj2 instanceof String)) {
                    obj2 = null;
                }
                String str = (String) obj2;
                if (str != null) {
                    zzbm zzc = zzblVar.zzc();
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (int i5 : iArr) {
                            sb.append(str.charAt(i5));
                        }
                        zzc.zzf(i4, sb.toString());
                        return;
                    } catch (Exception e4) {
                        throw new zzt(4, 22, e4);
                    }
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
