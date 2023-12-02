package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
/* loaded from: classes4.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20640a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f20641b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f20642c;

    @KeepForSdk
    public StringToIntConverter() {
        this.f20640a = 1;
        this.f20641b = new HashMap();
        this.f20642c = new SparseArray();
    }

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public StringToIntConverter add(@NonNull String str, int i4) {
        this.f20641b.put(str, Integer.valueOf(i4));
        this.f20642c.put(i4, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20640a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f20641b.keySet()) {
            arrayList.add(new zac(str, ((Integer) this.f20641b.get(str)).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int zaa() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int zab() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    @Nullable
    public final /* bridge */ /* synthetic */ Object zac(@NonNull Object obj) {
        Integer num = (Integer) this.f20641b.get((String) obj);
        if (num == null) {
            return (Integer) this.f20641b.get("gms_unknown");
        }
        return num;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    @NonNull
    public final /* bridge */ /* synthetic */ Object zad(@NonNull Object obj) {
        String str = (String) this.f20642c.get(((Integer) obj).intValue());
        if (str == null && this.f20641b.containsKey("gms_unknown")) {
            return "gms_unknown";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public StringToIntConverter(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) ArrayList arrayList) {
        this.f20640a = i4;
        this.f20641b = new HashMap();
        this.f20642c = new SparseArray();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            zac zacVar = (zac) arrayList.get(i5);
            add(zacVar.f20646b, zacVar.f20647c);
        }
    }
}
