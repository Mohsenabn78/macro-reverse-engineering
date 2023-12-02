package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "MetadataImplCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes5.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getEventStatus", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private int f28807a;
    @SafeParcelable.Field(getter = "isUploadable", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28808b;
    @SafeParcelable.Field(getter = "getCompletionToken", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28809c;
    @SafeParcelable.Field(getter = "getAccountName", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f28810d;
    @SafeParcelable.Field(getter = "getSsbContext", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f28811e;
    @SafeParcelable.Field(getter = "isContextOnly", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f28812f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) boolean z4) {
        this.f28807a = i4;
        this.f28808b = z3;
        this.f28809c = str;
        this.f28810d = str2;
        this.f28811e = bArr;
        this.f28812f = z4;
    }

    public final String toString() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("MetadataImpl { { eventStatus: '");
        sb.append(this.f28807a);
        sb.append("' } { uploadable: '");
        sb.append(this.f28808b);
        sb.append("' } ");
        if (this.f28809c != null) {
            sb.append("{ completionToken: '");
            sb.append(this.f28809c);
            sb.append("' } ");
        }
        if (this.f28810d != null) {
            sb.append("{ accountName: '");
            sb.append(this.f28810d);
            sb.append("' } ");
        }
        if (this.f28811e != null) {
            sb.append("{ ssbContext: [ ");
            for (byte b4 : this.f28811e) {
                sb.append("0x");
                sb.append(Integer.toHexString(b4));
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            sb.append("] } ");
        }
        sb.append("{ contextOnly: '");
        sb.append(this.f28812f);
        sb.append("' } }");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f28807a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f28808b);
        SafeParcelWriter.writeString(parcel, 3, this.f28809c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f28810d, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.f28811e, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f28812f);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(int i4) {
        this.f28807a = i4;
    }

    public zzb(boolean z3, String str, String str2, byte[] bArr, boolean z4) {
        this.f28807a = 0;
        this.f28808b = z3;
        this.f28809c = null;
        this.f28810d = null;
        this.f28811e = null;
        this.f28812f = false;
    }
}
