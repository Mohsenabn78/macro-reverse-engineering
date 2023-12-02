package com.google.android.gms.nearby.exposurenotification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "PackageConfigurationCreator")
/* loaded from: classes4.dex */
public final class PackageConfiguration extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PackageConfiguration> CREATOR = new zzn();
    @SafeParcelable.Field(getter = "getValues", id = 1)

    /* renamed from: a  reason: collision with root package name */
    final Bundle f22344a;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class PackageConfigurationBuilder {

        /* renamed from: a  reason: collision with root package name */
        private Bundle f22345a;

        @NonNull
        public PackageConfiguration build() {
            return new PackageConfiguration(this.f22345a);
        }

        @NonNull
        public PackageConfigurationBuilder setValues(@NonNull Bundle bundle) {
            this.f22345a = new Bundle(bundle);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PackageConfiguration(@SafeParcelable.Param(id = 1) Bundle bundle) {
        this.f22344a = bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof PackageConfiguration) {
            return Objects.equal(this.f22344a, ((PackageConfiguration) obj).getValues());
        }
        return false;
    }

    @NonNull
    public Bundle getValues() {
        return this.f22344a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22344a);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "PackageConfiguration<values: %s>", this.f22344a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, getValues(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
