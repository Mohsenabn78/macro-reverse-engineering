package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "AccountTransferProgressCreator")
/* loaded from: classes4.dex */
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: g  reason: collision with root package name */
    private static final ArrayMap<String, FastJsonResponse.Field<?, ?>> f19663g;
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f19664a;
    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private List<String> f19665b;
    @SafeParcelable.Field(getter = "getInProgressAccountTypes", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private List<String> f19666c;
    @SafeParcelable.Field(getter = "getSuccessAccountTypes", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private List<String> f19667d;
    @SafeParcelable.Field(getter = "getFailedAccountTypes", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private List<String> f19668e;
    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private List<String> f19669f;

    static {
        ArrayMap<String, FastJsonResponse.Field<?, ?>> arrayMap = new ArrayMap<>();
        f19663g = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.forStrings("registered", 2));
        arrayMap.put("in_progress", FastJsonResponse.Field.forStrings("in_progress", 3));
        arrayMap.put(FirebaseAnalytics.Param.SUCCESS, FastJsonResponse.Field.forStrings(FirebaseAnalytics.Param.SUCCESS, 4));
        arrayMap.put("failed", FastJsonResponse.Field.forStrings("failed", 5));
        arrayMap.put("escrowed", FastJsonResponse.Field.forStrings("escrowed", 6));
    }

    public zzo() {
        this.f19664a = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        return f19663g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.f19664a);
            case 2:
                return this.f19665b;
            case 3:
                return this.f19666c;
            case 4:
                return this.f19667d;
            case 5:
                return this.f19668e;
            case 6:
                return this.f19669f;
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(safeParcelableFieldId);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 2) {
            if (safeParcelableFieldId != 3) {
                if (safeParcelableFieldId != 4) {
                    if (safeParcelableFieldId != 5) {
                        if (safeParcelableFieldId == 6) {
                            this.f19669f = arrayList;
                            return;
                        }
                        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(safeParcelableFieldId)));
                    }
                    this.f19668e = arrayList;
                    return;
                }
                this.f19667d = arrayList;
                return;
            }
            this.f19666c = arrayList;
            return;
        }
        this.f19665b = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19664a);
        SafeParcelWriter.writeStringList(parcel, 2, this.f19665b, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.f19666c, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.f19667d, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.f19668e, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.f19669f, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) List<String> list, @Nullable @SafeParcelable.Param(id = 3) List<String> list2, @Nullable @SafeParcelable.Param(id = 4) List<String> list3, @Nullable @SafeParcelable.Param(id = 5) List<String> list4, @Nullable @SafeParcelable.Param(id = 6) List<String> list5) {
        this.f19664a = i4;
        this.f19665b = list;
        this.f19666c = list2;
        this.f19667d = list3;
        this.f19668e = list4;
        this.f19669f = list5;
    }
}
