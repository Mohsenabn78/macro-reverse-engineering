package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "GetSignInIntentRequestCreator")
/* loaded from: classes4.dex */
public class GetSignInIntentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getServerClientId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f19766a;
    @Nullable
    @SafeParcelable.Field(getter = "getHostedDomainFilter", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19767b;
    @Nullable
    @SafeParcelable.Field(getter = "getSessionId", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private String f19768c;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19769a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f19770b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f19771c;

        public final GetSignInIntentRequest build() {
            return new GetSignInIntentRequest(this.f19769a, this.f19770b, this.f19771c);
        }

        public final Builder filterByHostedDomain(@Nullable String str) {
            this.f19770b = str;
            return this;
        }

        public final Builder setServerClientId(String str) {
            Preconditions.checkNotNull(str);
            this.f19769a = str;
            return this;
        }

        public final Builder zzf(@Nullable String str) {
            this.f19771c = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GetSignInIntentRequest(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3) {
        Preconditions.checkNotNull(str);
        this.f19766a = str;
        this.f19767b = str2;
        this.f19768c = str3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zzc(GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.checkNotNull(getSignInIntentRequest);
        Builder filterByHostedDomain = builder().setServerClientId(getSignInIntentRequest.getServerClientId()).filterByHostedDomain(getSignInIntentRequest.getHostedDomainFilter());
        String str = getSignInIntentRequest.f19768c;
        if (str != null) {
            filterByHostedDomain.zzf(str);
        }
        return filterByHostedDomain;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        if (!Objects.equal(this.f19766a, getSignInIntentRequest.f19766a) || !Objects.equal(this.f19767b, getSignInIntentRequest.f19767b) || !Objects.equal(this.f19768c, getSignInIntentRequest.f19768c)) {
            return false;
        }
        return true;
    }

    @Nullable
    public String getHostedDomainFilter() {
        return this.f19767b;
    }

    public String getServerClientId() {
        return this.f19766a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19766a, this.f19767b, this.f19768c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 2, getHostedDomainFilter(), false);
        SafeParcelWriter.writeString(parcel, 3, this.f19768c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
