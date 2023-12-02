package com.google.android.recaptcha.internal;

import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbt implements zzby {
    @NotNull
    public static final zzbt zza = new zzbt();

    private zzbt() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        String joinToString$default;
        String str;
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (true != (obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                if (obj instanceof int[]) {
                    joinToString$default = ArraysKt___ArraysKt.joinToString$default((int[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else {
                    if (obj instanceof byte[]) {
                        str = new String((byte[]) obj, Charsets.UTF_8);
                    } else if (obj instanceof long[]) {
                        joinToString$default = ArraysKt___ArraysKt.joinToString$default((long[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof short[]) {
                        joinToString$default = ArraysKt___ArraysKt.joinToString$default((short[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof float[]) {
                        joinToString$default = ArraysKt___ArraysKt.joinToString$default((float[]) obj, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof double[]) {
                        joinToString$default = ArraysKt___ArraysKt.joinToString$default((double[]) obj, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof char[]) {
                        str = new String((char[]) obj);
                    } else if (obj instanceof Object[]) {
                        joinToString$default = ArraysKt___ArraysKt.joinToString$default((Object[]) obj, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof Collection) {
                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default((Iterable) obj, ",", "[", "]", 0, null, null, 56, null);
                    } else {
                        throw new zzt(4, 5, null);
                    }
                    joinToString$default = str;
                }
                zzblVar.zzc().zzf(i4, joinToString$default);
                return;
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
