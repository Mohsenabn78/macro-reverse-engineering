package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.icing.zzbp;
import com.google.firebase.appindexing.Indexable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "MetadataCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes5.dex */
public final class zzac extends AbstractSafeParcelable implements Indexable.Metadata {
    public static final Parcelable.Creator<zzac> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getWorksOffline", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28801a;
    @SafeParcelable.Field(getter = "getScore", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f28802b;
    @SafeParcelable.Field(getter = "getAccountEmail", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28803c;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f28804d;
    @SafeParcelable.Field(getter = "getEmbeddingProperties", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f28805e;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) Bundle bundle2) {
        this.f28801a = z3;
        this.f28802b = i4;
        this.f28803c = str;
        this.f28804d = bundle == null ? new Bundle() : bundle;
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.f28805e = bundle2;
        ClassLoader classLoader = zzac.class.getClassLoader();
        zzbp.zza(classLoader);
        bundle2.setClassLoader(classLoader);
    }

    public final boolean equals(Object obj) {
        boolean f4;
        boolean f5;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzac)) {
            return false;
        }
        zzac zzacVar = (zzac) obj;
        if (Objects.equal(Boolean.valueOf(this.f28801a), Boolean.valueOf(zzacVar.f28801a)) && Objects.equal(Integer.valueOf(this.f28802b), Integer.valueOf(zzacVar.f28802b)) && Objects.equal(this.f28803c, zzacVar.f28803c)) {
            f4 = Thing.f(this.f28804d, zzacVar.f28804d);
            if (f4) {
                f5 = Thing.f(this.f28805e, zzacVar.f28805e);
                if (f5) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int g4;
        int g5;
        g4 = Thing.g(this.f28804d);
        g5 = Thing.g(this.f28805e);
        return Objects.hashCode(Boolean.valueOf(this.f28801a), Integer.valueOf(this.f28802b), this.f28803c, Integer.valueOf(g4), Integer.valueOf(g5));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("worksOffline: ");
        sb.append(this.f28801a);
        sb.append(", score: ");
        sb.append(this.f28802b);
        if (!this.f28803c.isEmpty()) {
            sb.append(", accountEmail: ");
            sb.append(this.f28803c);
        }
        Bundle bundle = this.f28804d;
        if (bundle != null && !bundle.isEmpty()) {
            sb.append(", Properties { ");
            Thing.e(this.f28804d, sb);
            sb.append("}");
        }
        if (!this.f28805e.isEmpty()) {
            sb.append(", embeddingProperties { ");
            Thing.e(this.f28805e, sb);
            sb.append("}");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f28801a);
        SafeParcelWriter.writeInt(parcel, 2, this.f28802b);
        SafeParcelWriter.writeString(parcel, 3, this.f28803c, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.f28804d, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.f28805e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
