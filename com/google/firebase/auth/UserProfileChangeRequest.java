package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "UserProfileChangeRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes5.dex */
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzaw();
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final String f28950a;
    @Nullable
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f28951b;
    @SafeParcelable.Field(getter = "shouldRemoveDisplayName", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f28952c;
    @SafeParcelable.Field(getter = "shouldRemovePhotoUri", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f28953d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Uri f28954e;

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f28955a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Uri f28956b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f28957c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f28958d;

        @NonNull
        public UserProfileChangeRequest build() {
            String uri;
            String str = this.f28955a;
            Uri uri2 = this.f28956b;
            if (uri2 == null) {
                uri = null;
            } else {
                uri = uri2.toString();
            }
            return new UserProfileChangeRequest(str, uri, this.f28957c, this.f28958d);
        }

        @Nullable
        @KeepForSdk
        public String getDisplayName() {
            return this.f28955a;
        }

        @Nullable
        @KeepForSdk
        public Uri getPhotoUri() {
            return this.f28956b;
        }

        @NonNull
        public Builder setDisplayName(@Nullable String str) {
            if (str == null) {
                this.f28957c = true;
            } else {
                this.f28955a = str;
            }
            return this;
        }

        @NonNull
        public Builder setPhotoUri(@Nullable Uri uri) {
            if (uri == null) {
                this.f28958d = true;
            } else {
                this.f28956b = uri;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public UserProfileChangeRequest(@Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) boolean z4) {
        Uri parse;
        this.f28950a = str;
        this.f28951b = str2;
        this.f28952c = z3;
        this.f28953d = z4;
        if (TextUtils.isEmpty(str2)) {
            parse = null;
        } else {
            parse = Uri.parse(str2);
        }
        this.f28954e = parse;
    }

    @Nullable
    public String getDisplayName() {
        return this.f28950a;
    }

    @Nullable
    public Uri getPhotoUri() {
        return this.f28954e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.f28951b, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f28952c);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f28953d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String zza() {
        return this.f28951b;
    }

    public final boolean zzb() {
        return this.f28952c;
    }

    public final boolean zzc() {
        return this.f28953d;
    }
}
