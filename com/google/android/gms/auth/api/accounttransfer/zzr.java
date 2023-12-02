package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorAnnotatedDataCreator")
/* loaded from: classes4.dex */
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f19670g;
    @SafeParcelable.Indicator

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f19671a;
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final int f19672b;
    @SafeParcelable.Field(getter = "getInfo", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private zzt f19673c;
    @SafeParcelable.Field(getter = "getSignature", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private String f19674d;
    @SafeParcelable.Field(getter = "getPackageName", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private String f19675e;
    @SafeParcelable.Field(getter = "getId", id = 5)

    /* renamed from: f  reason: collision with root package name */
    private String f19676f;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f19670g = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzt.class));
        hashMap.put("signature", FastJsonResponse.Field.forString("signature", 3));
        hashMap.put("package", FastJsonResponse.Field.forString("package", 4));
    }

    public zzr() {
        this.f19671a = new HashSet(3);
        this.f19672b = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t3) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.f19673c = (zzt) t3;
            this.f19671a.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(safeParcelableFieldId), t3.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map getFieldMappings() {
        return f19670g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 1) {
            if (safeParcelableFieldId != 2) {
                if (safeParcelableFieldId != 3) {
                    if (safeParcelableFieldId == 4) {
                        return this.f19675e;
                    }
                    int safeParcelableFieldId2 = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Unknown SafeParcelable id=");
                    sb.append(safeParcelableFieldId2);
                    throw new IllegalStateException(sb.toString());
                }
                return this.f19674d;
            }
            return this.f19673c;
        }
        return Integer.valueOf(this.f19672b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f19671a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 3) {
            if (safeParcelableFieldId == 4) {
                this.f19675e = str2;
            } else {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(safeParcelableFieldId)));
            }
        } else {
            this.f19674d = str2;
        }
        this.f19671a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.f19671a;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.f19672b);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.f19673c, i4, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeString(parcel, 3, this.f19674d, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.f19675e, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.f19676f, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) zzt zztVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3) {
        this.f19671a = set;
        this.f19672b = i4;
        this.f19673c = zztVar;
        this.f19674d = str;
        this.f19675e = str2;
        this.f19676f = str3;
    }
}
