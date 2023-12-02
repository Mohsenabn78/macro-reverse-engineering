package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.nearby.messages.internal.zzg f22370a;

    public EddystoneUid(@NonNull String str) {
        this(com.google.android.gms.nearby.messages.internal.zzc.zzd(str));
    }

    @NonNull
    public static EddystoneUid from(@NonNull Message message) {
        boolean zza = message.zza(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String type = message.getType();
        Preconditions.checkArgument(zza, "Message type '" + type + "' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        return new EddystoneUid(message.getContent());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EddystoneUid)) {
            return false;
        }
        return Objects.equal(this.f22370a, ((EddystoneUid) obj).f22370a);
    }

    @NonNull
    public String getHex() {
        return this.f22370a.zza();
    }

    @NonNull
    public String getInstance() {
        byte[] zzc = this.f22370a.zzc();
        if (zzc.length < 16) {
            return null;
        }
        return com.google.android.gms.nearby.messages.internal.zzc.zzb(Arrays.copyOfRange(zzc, 10, 16));
    }

    @NonNull
    public String getNamespace() {
        return com.google.android.gms.nearby.messages.internal.zzc.zzb(Arrays.copyOfRange(this.f22370a.zzc(), 0, 10));
    }

    public int hashCode() {
        return Objects.hashCode(this.f22370a);
    }

    @NonNull
    public String toString() {
        String hex = getHex();
        return "EddystoneUid{id=" + hex + "}";
    }

    public EddystoneUid(@NonNull String str, @NonNull String str2) {
        this.f22370a = new com.google.android.gms.nearby.messages.internal.zzg(str, str2);
    }

    public EddystoneUid(@NonNull byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.f22370a = new com.google.android.gms.nearby.messages.internal.zzg(bArr);
    }
}
