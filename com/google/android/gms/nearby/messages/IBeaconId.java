package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class IBeaconId {
    public static final int LENGTH = 20;

    /* renamed from: a  reason: collision with root package name */
    private final zzl f22371a;

    public IBeaconId(@NonNull UUID uuid, short s3, short s4) {
        this.f22371a = new zzl(uuid, Short.valueOf(s3), Short.valueOf(s4));
    }

    @NonNull
    public static IBeaconId from(@NonNull Message message) {
        boolean zza = message.zza(Message.MESSAGE_TYPE_I_BEACON_ID);
        String type = message.getType();
        Preconditions.checkArgument(zza, "Message type '" + type + "' is not Message.MESSAGE_TYPE_I_BEACON_ID");
        return new IBeaconId(message.getContent());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IBeaconId)) {
            return false;
        }
        return Objects.equal(this.f22371a, ((IBeaconId) obj).f22371a);
    }

    public short getMajor() {
        return this.f22371a.zze().shortValue();
    }

    public short getMinor() {
        return this.f22371a.zzf().shortValue();
    }

    @NonNull
    public UUID getProximityUuid() {
        return this.f22371a.zzg();
    }

    public int hashCode() {
        return Objects.hashCode(this.f22371a);
    }

    @NonNull
    public String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        short major = getMajor();
        short minor = getMinor();
        return "IBeaconId{proximityUuid=" + valueOf + ", major=" + ((int) major) + ", minor=" + ((int) minor) + "}";
    }

    public IBeaconId(@NonNull byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        this.f22371a = new zzl(bArr);
    }
}
