package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
@SafeParcelable.Class(creator = "AssetCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class Asset extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Asset> CREATOR = new zzc();
    @Nullable
    @SafeParcelable.Field(getter = "getData", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private byte[] f22616a;
    @Nullable
    @SafeParcelable.Field(getter = "getDigest", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private String f22617b;
    @Nullable
    @SafeParcelable.Field(id = 4)
    public ParcelFileDescriptor zza;
    @Nullable
    @SafeParcelable.Field(id = 5)
    public Uri zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Asset(@Nullable @SafeParcelable.Param(id = 2) byte[] bArr, @Nullable @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @Nullable @SafeParcelable.Param(id = 5) Uri uri) {
        this.f22616a = bArr;
        this.f22617b = str;
        this.zza = parcelFileDescriptor;
        this.zzb = uri;
    }

    @NonNull
    @VisibleForTesting
    public static Asset createFromBytes(@NonNull byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        return new Asset(bArr, null, null, null);
    }

    @NonNull
    @VisibleForTesting
    public static Asset createFromFd(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        Preconditions.checkNotNull(parcelFileDescriptor);
        return new Asset(null, null, parcelFileDescriptor, null);
    }

    @NonNull
    public static Asset createFromRef(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return new Asset(null, str, null, null);
    }

    @NonNull
    @VisibleForTesting
    public static Asset createFromUri(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri);
        return new Asset(null, null, null, uri);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        if (Arrays.equals(this.f22616a, asset.f22616a) && Objects.equal(this.f22617b, asset.f22617b) && Objects.equal(this.zza, asset.zza) && Objects.equal(this.zzb, asset.zzb)) {
            return true;
        }
        return false;
    }

    @Nullable
    @Pure
    public String getDigest() {
        return this.f22617b;
    }

    @Nullable
    public ParcelFileDescriptor getFd() {
        return this.zza;
    }

    @Nullable
    public Uri getUri() {
        return this.zzb;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this.f22616a, this.f22617b, this.zza, this.zzb});
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.f22617b == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.f22617b);
        }
        if (this.f22616a != null) {
            sb.append(", size=");
            sb.append(((byte[]) Preconditions.checkNotNull(this.f22616a)).length);
        }
        if (this.zza != null) {
            sb.append(", fd=");
            sb.append(this.zza);
        }
        if (this.zzb != null) {
            sb.append(", uri=");
            sb.append(this.zzb);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int i5 = i4 | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22616a, false);
        SafeParcelWriter.writeString(parcel, 3, getDigest(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zza, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzb, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    @Pure
    public final byte[] zza() {
        return this.f22616a;
    }
}
