package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ScanInstanceCreator")
/* loaded from: classes4.dex */
public final class ScanInstance extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ScanInstance> CREATOR = new zzo();
    @SafeParcelable.Field(getter = "getTypicalAttenuationDb", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22346a;
    @SafeParcelable.Field(getter = "getMinAttenuationDb", id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22347b;
    @SafeParcelable.Field(getter = "getSecondsSinceLastScan", id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22348c;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f22349a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f22350b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f22351c = 0;

        @NonNull
        public ScanInstance build() {
            return new ScanInstance(this.f22349a, this.f22350b, this.f22351c);
        }

        @NonNull
        public Builder setMinAttenuationDb(int i4) {
            this.f22350b = i4;
            return this;
        }

        @NonNull
        public Builder setSecondsSinceLastScan(int i4) {
            this.f22351c = i4;
            return this;
        }

        @NonNull
        public Builder setTypicalAttenuationDb(int i4) {
            this.f22349a = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ScanInstance(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6) {
        this.f22346a = i4;
        this.f22347b = i5;
        this.f22348c = i6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ScanInstance.class == obj.getClass()) {
            ScanInstance scanInstance = (ScanInstance) obj;
            if (this.f22346a == scanInstance.f22346a && this.f22347b == scanInstance.f22347b && this.f22348c == scanInstance.f22348c) {
                return true;
            }
        }
        return false;
    }

    public int getMinAttenuationDb() {
        return this.f22347b;
    }

    public int getSecondsSinceLastScan() {
        return this.f22348c;
    }

    public int getTypicalAttenuationDb() {
        return this.f22346a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22346a), Integer.valueOf(this.f22347b), Integer.valueOf(this.f22348c));
    }

    @NonNull
    public String toString() {
        int i4 = this.f22346a;
        int i5 = this.f22347b;
        int i6 = this.f22348c;
        return "ScanInstance{typicalAttenuationDb=" + i4 + ", minAttenuationDb=" + i5 + ", secondsSinceLastScan=" + i6 + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getTypicalAttenuationDb());
        SafeParcelWriter.writeInt(parcel, 2, getMinAttenuationDb());
        SafeParcelWriter.writeInt(parcel, 3, getSecondsSinceLastScan());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
