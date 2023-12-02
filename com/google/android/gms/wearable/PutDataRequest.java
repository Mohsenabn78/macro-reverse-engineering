package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
@SafeParcelable.Class(creator = "PutDataRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PutDataRequest extends AbstractSafeParcelable {
    @NonNull
    public static final String WEAR_URI_SCHEME = "wear";
    @SafeParcelable.Field(getter = "getUri", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final Uri f22640a;
    @SafeParcelable.Field(getter = "getAssetsInternal", id = 4)

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f22641b;
    @Nullable
    @SafeParcelable.Field(getter = "getData", id = 5)

    /* renamed from: c  reason: collision with root package name */
    private byte[] f22642c;
    @SafeParcelable.Field(getter = "getSyncDeadline", id = 6)

    /* renamed from: d  reason: collision with root package name */
    private long f22643d;
    @NonNull
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzg();

    /* renamed from: e  reason: collision with root package name */
    private static final long f22638e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: f  reason: collision with root package name */
    private static final Random f22639f = new SecureRandom();

    private PutDataRequest(Uri uri) {
        this(uri, new Bundle(), null, f22638e);
    }

    private static Uri b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                if (!str.startsWith("//")) {
                    return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
                }
                throw new IllegalArgumentException("A path must start with a single / .");
            }
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        throw new IllegalArgumentException("An empty path was supplied.");
    }

    @NonNull
    public static PutDataRequest create(@NonNull String str) {
        Preconditions.checkNotNull(str, "path must not be null");
        return zza(b(str));
    }

    @NonNull
    public static PutDataRequest createFromDataItem(@NonNull DataItem dataItem) {
        Preconditions.checkNotNull(dataItem, "source must not be null");
        PutDataRequest zza = zza(dataItem.getUri());
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getValue().getId() != null) {
                zza.putAsset(entry.getKey(), Asset.createFromRef(entry.getValue().getId()));
            } else {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: ".concat(String.valueOf(entry.getKey())));
            }
        }
        zza.setData(dataItem.getData());
        return zza;
    }

    @NonNull
    public static PutDataRequest createWithAutoAppendedId(@NonNull String str) {
        Preconditions.checkNotNull(str, "pathPrefix must not be null");
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        }
        sb.append("PN");
        sb.append(f22639f.nextLong());
        return new PutDataRequest(b(sb.toString()));
    }

    @NonNull
    public static PutDataRequest zza(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri, "uri must not be null");
        return new PutDataRequest(uri);
    }

    @Nullable
    @VisibleForTesting
    public Asset getAsset(@NonNull String str) {
        Preconditions.checkNotNull(str, "key must not be null");
        return (Asset) this.f22641b.getParcelable(str);
    }

    @NonNull
    public Map<String, Asset> getAssets() {
        HashMap hashMap = new HashMap();
        for (String str : this.f22641b.keySet()) {
            hashMap.put(str, (Asset) this.f22641b.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @Nullable
    @VisibleForTesting
    @Pure
    public byte[] getData() {
        return this.f22642c;
    }

    @NonNull
    public Uri getUri() {
        return this.f22640a;
    }

    public boolean hasAsset(@NonNull String str) {
        Preconditions.checkNotNull(str, "key must not be null");
        return this.f22641b.containsKey(str);
    }

    public boolean isUrgent() {
        if (this.f22643d == 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public PutDataRequest putAsset(@NonNull String str, @NonNull Asset asset) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(asset);
        this.f22641b.putParcelable(str, asset);
        return this;
    }

    @NonNull
    public PutDataRequest removeAsset(@NonNull String str) {
        Preconditions.checkNotNull(str, "key must not be null");
        this.f22641b.remove(str);
        return this;
    }

    @NonNull
    public PutDataRequest setData(@Nullable byte[] bArr) {
        this.f22642c = bArr;
        return this;
    }

    @NonNull
    public PutDataRequest setUrgent() {
        this.f22643d = 0L;
        return this;
    }

    @NonNull
    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel, "dest must not be null");
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i4, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.f22641b, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.f22643d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PutDataRequest(@SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 4) Bundle bundle, @Nullable @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) long j4) {
        this.f22640a = uri;
        this.f22641b = bundle;
        bundle.setClassLoader((ClassLoader) Preconditions.checkNotNull(DataItemAssetParcelable.class.getClassLoader()));
        this.f22642c = bArr;
        this.f22643d = j4;
    }

    @NonNull
    public String toString(boolean z3) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        byte[] bArr = this.f22642c;
        sb.append("dataSz=".concat((bArr == null ? "null" : Integer.valueOf(bArr.length)).toString()));
        int size = this.f22641b.size();
        sb.append(", numAssets=" + size);
        sb.append(", uri=".concat(String.valueOf(this.f22640a)));
        long j4 = this.f22643d;
        sb.append(", syncDeadline=" + j4);
        if (!z3) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.f22641b.keySet()) {
            String valueOf = String.valueOf(this.f22641b.getParcelable(str));
            sb.append("\n    " + str + ": " + valueOf);
        }
        sb.append("\n  ]");
        return sb.toString();
    }
}
