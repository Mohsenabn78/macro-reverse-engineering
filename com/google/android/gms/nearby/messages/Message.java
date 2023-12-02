package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zzni;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "MessageCreator")
/* loaded from: classes4.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    @NonNull
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    @NonNull
    @Deprecated
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    @NonNull
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    @NonNull
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    final int f22373a;
    @SafeParcelable.Field(getter = "getContent", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22374b;
    @SafeParcelable.Field(getter = "getType", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final String f22375c;
    @SafeParcelable.Field(getter = "getNamespace", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final String f22376d;
    @SafeParcelable.Field(id = 4)
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    final zzni[] f22377e;
    @SafeParcelable.Field(getter = "getProjectId", id = 5)

    /* renamed from: f  reason: collision with root package name */
    private final long f22378f;
    @NonNull
    public static final Parcelable.Creator<Message> CREATOR = new zza();

    /* renamed from: g  reason: collision with root package name */
    private static final zzni[] f22372g = {zzni.zza};

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Message(@SafeParcelable.Param(id = 1000) int i4, @NonNull @SafeParcelable.Param(id = 1) byte[] bArr, @Nullable @SafeParcelable.Param(id = 3) String str, @NonNull @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 4) zzni[] zzniVarArr, @SafeParcelable.Param(id = 5) long j4) {
        this.f22373a = i4;
        this.f22375c = (String) Preconditions.checkNotNull(str2);
        this.f22376d = str == null ? "" : str;
        this.f22378f = j4;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        Preconditions.checkArgument(length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(length), Integer.valueOf((int) MAX_CONTENT_SIZE_BYTES));
        this.f22374b = bArr;
        this.f22377e = (zzniVarArr == null || zzniVarArr.length == 0) ? f22372g : zzniVarArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (TextUtils.equals(this.f22376d, message.f22376d) && TextUtils.equals(this.f22375c, message.f22375c) && Arrays.equals(this.f22374b, message.f22374b) && this.f22378f == message.f22378f) {
            return true;
        }
        return false;
    }

    @NonNull
    public byte[] getContent() {
        return this.f22374b;
    }

    @NonNull
    public String getNamespace() {
        return this.f22376d;
    }

    @NonNull
    public String getType() {
        return this.f22375c;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22376d, this.f22375c, Integer.valueOf(Arrays.hashCode(this.f22374b)), Long.valueOf(this.f22378f));
    }

    @NonNull
    public String toString() {
        int length;
        String str = this.f22376d;
        String str2 = this.f22375c;
        byte[] bArr = this.f22374b;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        return "Message{namespace='" + str + "', type='" + str2 + "', content=[" + length + " bytes]}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.f22377e, i4, false);
        SafeParcelWriter.writeLong(parcel, 5, this.f22378f);
        SafeParcelWriter.writeInt(parcel, 1000, this.f22373a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza(@NonNull String str) {
        if (MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType())) {
            return true;
        }
        return false;
    }

    public Message(@NonNull byte[] bArr) {
        this(bArr, "", "", f22372g, 0L);
    }

    public Message(@NonNull byte[] bArr, @NonNull String str) {
        this(bArr, "", str, f22372g, 0L);
    }

    public Message(@NonNull byte[] bArr, @NonNull String str, @NonNull String str2) {
        this(bArr, MESSAGE_NAMESPACE_RESERVED, MESSAGE_TYPE_AUDIO_BYTES, f22372g, 0L);
    }

    public Message(byte[] bArr, String str, String str2, @Nullable zzni[] zzniVarArr, long j4) {
        this(2, bArr, str, str2, zzniVarArr, 0L);
    }
}
