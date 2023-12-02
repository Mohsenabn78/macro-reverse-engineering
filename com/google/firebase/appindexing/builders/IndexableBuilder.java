package com.google.firebase.appindexing.builders;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.Thing;
import com.google.firebase.appindexing.internal.zzac;
import com.google.firebase.appindexing.internal.zzw;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public abstract class IndexableBuilder<T extends IndexableBuilder<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f28792a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28793b;

    /* renamed from: c  reason: collision with root package name */
    private zzac f28794c;

    /* renamed from: d  reason: collision with root package name */
    private String f28795d;

    /* JADX INFO: Access modifiers changed from: protected */
    public IndexableBuilder(@NonNull String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotEmpty(str);
        this.f28792a = new Bundle();
        this.f28793b = str;
    }

    private static void b(@NonNull Bundle bundle, @NonNull String str, @NonNull Thing... thingArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(thingArr);
        if (thingArr.length > 0) {
            int i4 = 0;
            for (int i5 = 0; i5 < thingArr.length; i5++) {
                thingArr[i4] = thingArr[i5];
                if (thingArr[i5] == null) {
                    StringBuilder sb = new StringBuilder(58);
                    sb.append("Thing at ");
                    sb.append(i5);
                    sb.append(" is null and is ignored by put method.");
                    zzw.zza(sb.toString());
                } else {
                    i4++;
                }
            }
            if (i4 > 0) {
                bundle.putParcelableArray(str, (Parcelable[]) c((Thing[]) Arrays.copyOfRange(thingArr, 0, i4)));
                return;
            }
            return;
        }
        zzw.zza("Thing array is empty and is ignored by put method.");
    }

    private static <S> S[] c(S[] sArr) {
        if (sArr.length < 100) {
            return sArr;
        }
        zzw.zza("Input Array of elements is too big, cutting off.");
        return (S[]) Arrays.copyOf(sArr, 100);
    }

    public static void zza(@NonNull Bundle bundle, @NonNull String str, @NonNull String... strArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(strArr);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (strArr2.length > 0) {
            int i4 = 0;
            for (int i5 = 0; i5 < Math.min(strArr2.length, 100); i5++) {
                String str2 = strArr2[i5];
                strArr2[i4] = str2;
                if (strArr2[i5] == null) {
                    StringBuilder sb = new StringBuilder(59);
                    sb.append("String at ");
                    sb.append(i5);
                    sb.append(" is null and is ignored by put method.");
                    zzw.zza(sb.toString());
                } else {
                    int i6 = 20000;
                    if (str2.length() > 20000) {
                        StringBuilder sb2 = new StringBuilder(53);
                        sb2.append("String at ");
                        sb2.append(i5);
                        sb2.append(" is too long, truncating string.");
                        zzw.zza(sb2.toString());
                        String str3 = strArr2[i4];
                        if (str3.length() > 20000) {
                            if (Character.isHighSurrogate(str3.charAt(19999)) && Character.isLowSurrogate(str3.charAt(20000))) {
                                i6 = 19999;
                            }
                            str3 = str3.substring(0, i6);
                        }
                        strArr2[i4] = str3;
                    }
                    i4++;
                }
            }
            if (i4 > 0) {
                bundle.putStringArray(str, (String[]) c((String[]) Arrays.copyOfRange(strArr2, 0, i4)));
                return;
            }
            return;
        }
        zzw.zza("String array is empty and is ignored by put method.");
    }

    public static void zzb(@NonNull Bundle bundle, @NonNull String str, @NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(indexableArr);
        Thing[] thingArr = new Thing[indexableArr.length];
        for (int i4 = 0; i4 < indexableArr.length; i4++) {
            Indexable indexable = indexableArr[i4];
            if (indexable != null && !(indexable instanceof Thing)) {
                throw new FirebaseAppIndexingInvalidArgumentException("Invalid Indexable encountered. Use Indexable.Builder or convenience methods under Indexables to create the Indexable.");
            }
            thingArr[i4] = (Thing) indexable;
        }
        b(bundle, str, thingArr);
    }

    public static void zzc(@NonNull Bundle bundle, @NonNull String str, @NonNull boolean... zArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zArr);
        int length = zArr.length;
        if (length > 0) {
            if (length >= 100) {
                zzw.zza("Input Array of elements is too big, cutting off.");
                zArr = Arrays.copyOf(zArr, 100);
            }
            bundle.putBooleanArray(str, zArr);
            return;
        }
        zzw.zza("Boolean array is empty and is ignored by put method.");
    }

    public static void zzd(@NonNull Bundle bundle, @NonNull String str, @NonNull long... jArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(jArr);
        int length = jArr.length;
        if (length > 0) {
            if (length >= 100) {
                zzw.zza("Input Array of elements is too big, cutting off.");
                jArr = Arrays.copyOf(jArr, 100);
            }
            bundle.putLongArray(str, jArr);
            return;
        }
        zzw.zza("Long array is empty and is ignored by put method.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public <S extends IndexableBuilder> T a(@NonNull String str, @NonNull S... sArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(sArr);
        int length = sArr.length;
        if (length > 0) {
            Thing[] thingArr = new Thing[length];
            for (int i4 = 0; i4 < sArr.length; i4++) {
                S s3 = sArr[i4];
                if (s3 == null) {
                    StringBuilder sb = new StringBuilder(60);
                    sb.append("Builder at ");
                    sb.append(i4);
                    sb.append(" is null and is ignored by put method.");
                    zzw.zza(sb.toString());
                } else {
                    thingArr[i4] = (Thing) s3.build();
                }
            }
            b(this.f28792a, str, thingArr);
        } else {
            zzw.zza("Builder array is empty and is ignored by put method.");
        }
        return this;
    }

    @NonNull
    public final Indexable build() {
        Bundle bundle = new Bundle(this.f28792a);
        zzac zzacVar = this.f28794c;
        if (zzacVar == null) {
            zzacVar = new Indexable.Metadata.Builder().zza();
        }
        return new Thing(bundle, zzacVar, this.f28795d, this.f28793b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T put(@NonNull String str, @NonNull long... jArr) {
        zzd(this.f28792a, str, jArr);
        return this;
    }

    @NonNull
    public T setAlternateName(@NonNull String... strArr) {
        Preconditions.checkNotNull(strArr);
        return put("alternateName", strArr);
    }

    @NonNull
    public final T setDescription(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("description", str);
    }

    @NonNull
    public T setId(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("id", str);
    }

    @NonNull
    public final T setImage(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("image", str);
    }

    @NonNull
    public final <S extends IndexableBuilder> T setIsPartOf(@NonNull S... sArr) {
        Preconditions.checkNotNull(sArr);
        return a("isPartOf", sArr);
    }

    @NonNull
    public final T setKeywords(@NonNull String... strArr) {
        return put("keywords", strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T setMetadata(@NonNull Indexable.Metadata.Builder builder) {
        boolean z3;
        if (this.f28794c == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "setMetadata may only be called once");
        Preconditions.checkNotNull(builder);
        this.f28794c = builder.zza();
        return this;
    }

    @NonNull
    public final T setName(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("name", str);
    }

    @NonNull
    public final T setSameAs(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("sameAs", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final T setUrl(@NonNull String str) {
        Preconditions.checkNotNull(str);
        this.f28795d = str;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T put(@NonNull String str, @NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
        zzb(this.f28792a, str, indexableArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T put(@NonNull String str, @NonNull String... strArr) {
        zza(this.f28792a, str, strArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T put(@NonNull String str, @NonNull boolean... zArr) {
        zzc(this.f28792a, str, zArr);
        return this;
    }
}
