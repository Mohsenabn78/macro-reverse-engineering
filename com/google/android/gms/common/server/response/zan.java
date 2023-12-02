package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
/* loaded from: classes4.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20692a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f20693b;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f20694c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zan(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) ArrayList arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.f20692a = i4;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            zal zalVar = (zal) arrayList.get(i5);
            String str2 = zalVar.f20687b;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) Preconditions.checkNotNull(zalVar.f20688c)).size();
            for (int i6 = 0; i6 < size2; i6++) {
                zam zamVar = (zam) zalVar.f20688c.get(i6);
                hashMap2.put(zamVar.f20690b, zamVar.f20691c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f20693b = hashMap;
        this.f20694c = (String) Preconditions.checkNotNull(str);
        zad();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f20693b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.f20693b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20692a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f20693b.keySet()) {
            arrayList.add(new zal(str, (Map) this.f20693b.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.f20694c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zaa() {
        return this.f20694c;
    }

    @Nullable
    public final Map zab(String str) {
        return (Map) this.f20693b.get(str);
    }

    public final void zac() {
        for (String str : this.f20693b.keySet()) {
            Map map = (Map) this.f20693b.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, ((FastJsonResponse.Field) map.get(str2)).zab());
            }
            this.f20693b.put(str, hashMap);
        }
    }

    public final void zad() {
        for (String str : this.f20693b.keySet()) {
            Map map = (Map) this.f20693b.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zai(this);
            }
        }
    }

    public final void zae(Class cls, Map map) {
        this.f20693b.put((String) Preconditions.checkNotNull(cls.getCanonicalName()), map);
    }

    public final boolean zaf(Class cls) {
        return this.f20693b.containsKey(Preconditions.checkNotNull(cls.getCanonicalName()));
    }

    public zan(Class cls) {
        this.f20692a = 1;
        this.f20693b = new HashMap();
        this.f20694c = (String) Preconditions.checkNotNull(cls.getCanonicalName());
    }
}
