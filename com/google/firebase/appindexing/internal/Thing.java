package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.icing.zzbp;
import com.google.firebase.appindexing.Indexable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "ThingCreator")
/* loaded from: classes5.dex */
public final class Thing extends AbstractSafeParcelable implements Indexable, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Thing> CREATOR = new zzad();
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f28796a;
    @SafeParcelable.Field(getter = "getMetadata", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final zzac f28797b;
    @SafeParcelable.Field(getter = "getUrl", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28798c;
    @SafeParcelable.Field(getter = "getType", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f28799d;
    @SafeParcelable.Field(getter = "getVersionCode", id = 1000)
    public final int zza;

    @SafeParcelable.Constructor
    public Thing(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzac zzacVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = i4;
        this.f28796a = bundle;
        this.f28797b = zzacVar;
        this.f28798c = str;
        this.f28799d = str2;
        ClassLoader classLoader = Thing.class.getClassLoader();
        zzbp.zza(classLoader);
        bundle.setClassLoader(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(@NonNull Bundle bundle, @NonNull StringBuilder sb) {
        try {
            Set<String> keySet = bundle.keySet();
            String[] strArr = (String[]) keySet.toArray(new String[keySet.size()]);
            Arrays.sort(strArr, zzab.f28800a);
            for (String str : strArr) {
                sb.append("{ key: '");
                sb.append(str);
                sb.append("' value: ");
                Object obj = bundle.get(str);
                if (obj == null) {
                    sb.append("<null>");
                } else if (obj.getClass().isArray()) {
                    sb.append("[ ");
                    for (int i4 = 0; i4 < Array.getLength(obj); i4++) {
                        sb.append("'");
                        sb.append(Array.get(obj, i4));
                        sb.append("' ");
                    }
                    sb.append("]");
                } else {
                    sb.append(obj.toString());
                }
                sb.append(" } ");
            }
        } catch (RuntimeException unused) {
            sb.append("<error>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !f((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
                obj2 = null;
            }
            if (obj instanceof boolean[]) {
                if (!(obj2 instanceof boolean[]) || !Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof long[]) {
                if (!(obj2 instanceof long[]) || !Arrays.equals((long[]) obj, (long[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof double[]) {
                if (!(obj2 instanceof double[]) || !Arrays.equals((double[]) obj, (double[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else if ((obj instanceof Object[]) && (!(obj2 instanceof Object[]) || !Arrays.equals((Object[]) obj, (Object[]) obj2))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Bundle bundle) {
        ArrayList arrayList = new ArrayList(bundle.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = bundle.get((String) arrayList.get(i4));
            if (obj instanceof boolean[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((boolean[]) obj)));
            } else if (obj instanceof long[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((long[]) obj)));
            } else if (obj instanceof double[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((double[]) obj)));
            } else if (obj instanceof byte[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((byte[]) obj)));
            } else if (obj instanceof Object[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((Object[]) obj)));
            } else {
                arrayList2.add(Integer.valueOf(Objects.hashCode(obj)));
            }
        }
        return Objects.hashCode(arrayList2.toArray());
    }

    public final boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thing)) {
            return false;
        }
        Thing thing = (Thing) obj;
        if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(thing.zza)) && Objects.equal(this.f28798c, thing.f28798c) && Objects.equal(this.f28799d, thing.f28799d) && Objects.equal(this.f28797b, thing.f28797b) && f(this.f28796a, thing.f28796a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.f28798c, this.f28799d, Integer.valueOf(this.f28797b.hashCode()), Integer.valueOf(g(this.f28796a)));
    }

    @NonNull
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f28799d.equals("Thing")) {
            str = "Indexable";
        } else {
            str = this.f28799d;
        }
        sb.append(str);
        sb.append(" { { id: ");
        if (this.f28798c == null) {
            sb.append("<null>");
        } else {
            sb.append("'");
            sb.append(this.f28798c);
            sb.append("'");
        }
        sb.append(" } Properties { ");
        e(this.f28796a, sb);
        sb.append("} Metadata { ");
        sb.append(this.f28797b.toString());
        sb.append(" } }");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f28796a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f28797b, i4, false);
        SafeParcelWriter.writeString(parcel, 3, this.f28798c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f28799d, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Thing(@NonNull Bundle bundle, @NonNull zzac zzacVar, String str, @NonNull String str2) {
        this.zza = 10;
        this.f28796a = bundle;
        this.f28797b = zzacVar;
        this.f28798c = str;
        this.f28799d = str2;
    }
}
