package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zznk;
import com.google.android.gms.nearby.messages.internal.zzac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "MessageFilterCreator")
/* loaded from: classes4.dex */
public class MessageFilter extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
    @NonNull
    public static final MessageFilter INCLUDE_ALL_MY_TYPES;
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    final int f22379a;
    @SafeParcelable.Field(getter = "getMessageTypes", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final List f22380b;
    @SafeParcelable.Field(getter = "getDeviceFilters", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final List f22381c;
    @SafeParcelable.Field(getter = "getIncludeAllMyTypes", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22382d;
    @SafeParcelable.Field(getter = "getBleFilters", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private final List f22383e;
    @SafeParcelable.Field(getter = "getNumRawAudioBytes", id = 5)

    /* renamed from: f  reason: collision with root package name */
    private final int f22384f;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private boolean f22388d;

        /* renamed from: a  reason: collision with root package name */
        private final Set f22385a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private final List f22386b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final Set f22387c = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        private int f22389e = 0;

        private final Builder a(String str, String str2) {
            this.f22385a.add(new zzac(str, str2));
            return this;
        }

        @NonNull
        public MessageFilter build() {
            boolean z3 = true;
            if (!this.f22388d && this.f22385a.isEmpty()) {
                z3 = false;
            }
            Preconditions.checkState(z3, "At least one of the include methods must be called.");
            return new MessageFilter(2, new ArrayList(this.f22385a), this.f22386b, this.f22388d, new ArrayList(this.f22387c), this.f22389e);
        }

        @NonNull
        public Builder includeAllMyTypes() {
            this.f22388d = true;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder includeAudioBytes(int i4) {
            boolean z3;
            boolean z4;
            boolean z5 = true;
            if (this.f22389e == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "includeAudioBytes() can only be called once per MessageFilter instance.");
            String str = "Invalid value for numAudioBytes: " + i4;
            if (i4 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, str);
            if (i4 > 10) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
            this.f22389e = i4;
            return this;
        }

        @NonNull
        public Builder includeEddystoneUids(@NonNull String str, @Nullable String str2) {
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            this.f22386b.add(zznk.zza(str, str2));
            return this;
        }

        @NonNull
        public Builder includeFilter(@NonNull MessageFilter messageFilter) {
            this.f22385a.addAll(messageFilter.zzc());
            this.f22386b.addAll(messageFilter.b());
            this.f22387c.addAll(messageFilter.zza());
            this.f22388d = messageFilter.zzd() | this.f22388d;
            return this;
        }

        @NonNull
        public Builder includeIBeaconIds(@NonNull UUID uuid, @Nullable Short sh, @Nullable Short sh2) {
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.f22386b.add(zznk.zzb(uuid, sh, sh2));
            return this;
        }

        @NonNull
        public Builder includeNamespacedType(@NonNull String str, @NonNull String str2) {
            boolean z3;
            boolean z4;
            if (str != null && !str.isEmpty() && !str.contains("*")) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "namespace(%s) cannot be null, empty or contain (*).", str);
            if (str2 != null && !str2.contains("*")) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "type(%s) cannot be null or contain (*).", str2);
            a(str, str2);
            return this;
        }
    }

    static {
        Builder builder = new Builder();
        builder.includeAllMyTypes();
        INCLUDE_ALL_MY_TYPES = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MessageFilter(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) List list2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) List list3, @SafeParcelable.Param(id = 5) int i5) {
        this.f22379a = i4;
        this.f22380b = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.f22382d = z3;
        this.f22381c = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.f22383e = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.f22384f = i5;
    }

    final List b() {
        return this.f22381c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        if (this.f22382d == messageFilter.f22382d && Objects.equal(this.f22380b, messageFilter.f22380b) && Objects.equal(this.f22381c, messageFilter.f22381c) && Objects.equal(this.f22383e, messageFilter.f22383e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22380b, this.f22381c, Boolean.valueOf(this.f22382d), this.f22383e);
    }

    @NonNull
    public String toString() {
        boolean z3 = this.f22382d;
        String valueOf = String.valueOf(this.f22380b);
        return "MessageFilter{includeAllMyTypes=" + z3 + ", messageTypes=" + valueOf + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f22380b, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f22381c, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f22382d);
        SafeParcelWriter.writeTypedList(parcel, 4, this.f22383e, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f22384f);
        SafeParcelWriter.writeInt(parcel, 1000, this.f22379a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final List zza() {
        return this.f22383e;
    }

    @NonNull
    public final List zzc() {
        return this.f22380b;
    }

    public final boolean zzd() {
        return this.f22382d;
    }
}
