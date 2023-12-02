package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "ChannelImplCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbq extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbr();
    @SafeParcelable.Field(getter = "getToken", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final String f22709a;
    @SafeParcelable.Field(getter = "getNodeId", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f22710b;
    @SafeParcelable.Field(getter = "getPath", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final String f22711c;

    @SafeParcelable.Constructor
    public zzbq(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3) {
        this.f22709a = (String) Preconditions.checkNotNull(str);
        this.f22710b = (String) Preconditions.checkNotNull(str2);
        this.f22711c = (String) Preconditions.checkNotNull(str3);
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        return zzc.a(googleApiClient, new zzbn(this.f22709a, new IntentFilter[]{zzhl.zza("com.google.android.gms.wearable.CHANNEL_EVENT")}), channelListener);
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbh(this, googleApiClient));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbq)) {
            return false;
        }
        zzbq zzbqVar = (zzbq) obj;
        if (this.f22709a.equals(zzbqVar.f22709a) && Objects.equal(zzbqVar.f22710b, this.f22710b) && Objects.equal(zzbqVar.f22711c, this.f22711c)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbj(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.Channel, com.google.android.gms.wearable.ChannelClient.Channel
    public final String getNodeId() {
        return this.f22710b;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbk(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.Channel, com.google.android.gms.wearable.ChannelClient.Channel
    public final String getPath() {
        return this.f22711c;
    }

    public final int hashCode() {
        return this.f22709a.hashCode();
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, Uri uri, boolean z3) {
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(uri, "uri is null");
        return googleApiClient.enqueue(new zzbl(this, googleApiClient, uri, z3));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        return googleApiClient.enqueue(new zzat(googleApiClient, channelListener, this.f22709a));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        return sendFile(googleApiClient, uri, 0L, -1L);
    }

    public final String toString() {
        int i4 = 0;
        for (char c4 : this.f22709a.toCharArray()) {
            i4 += c4;
        }
        String trim = this.f22709a.trim();
        int length = trim.length();
        if (length > 25) {
            trim = trim.substring(0, 10) + "..." + trim.substring(length - 10, length) + "::" + i4;
        }
        return "Channel{token=" + trim + ", nodeId=" + this.f22710b + ", path=" + this.f22711c + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22709a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22710b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22711c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzb() {
        return this.f22709a;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient, int i4) {
        return googleApiClient.enqueue(new zzbi(this, googleApiClient, i4));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri, long j4, long j5) {
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(this.f22709a, "token is null");
        Preconditions.checkNotNull(uri, "uri is null");
        Preconditions.checkArgument(j4 >= 0, "startOffset is negative: %s", Long.valueOf(j4));
        Preconditions.checkArgument(j5 >= 0 || j5 == -1, "invalid length: %s", Long.valueOf(j5));
        return googleApiClient.enqueue(new zzbm(this, googleApiClient, uri, j4, j5));
    }
}
