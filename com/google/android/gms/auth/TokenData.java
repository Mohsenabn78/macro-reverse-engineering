package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "TokenDataCreator")
/* loaded from: classes4.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzk();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f19614a;
    @SafeParcelable.Field(getter = "getToken", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19615b;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final Long f19616c;
    @SafeParcelable.Field(getter = "isCached", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19617d;
    @SafeParcelable.Field(getter = "isSnowballed", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f19618e;
    @SafeParcelable.Field(getter = "getGrantedScopes", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f19619f;
    @SafeParcelable.Field(getter = "getScopeData", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final String f19620g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public TokenData(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Long l4, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) boolean z4, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) String str2) {
        this.f19614a = i4;
        this.f19615b = Preconditions.checkNotEmpty(str);
        this.f19616c = l4;
        this.f19617d = z3;
        this.f19618e = z4;
        this.f19619f = list;
        this.f19620g = str2;
    }

    @Nullable
    public static TokenData zza(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        if (!TextUtils.equals(this.f19615b, tokenData.f19615b) || !Objects.equal(this.f19616c, tokenData.f19616c) || this.f19617d != tokenData.f19617d || this.f19618e != tokenData.f19618e || !Objects.equal(this.f19619f, tokenData.f19619f) || !Objects.equal(this.f19620g, tokenData.f19620g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19615b, this.f19616c, Boolean.valueOf(this.f19617d), Boolean.valueOf(this.f19618e), this.f19619f, this.f19620g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19614a);
        SafeParcelWriter.writeString(parcel, 2, this.f19615b, false);
        SafeParcelWriter.writeLongObject(parcel, 3, this.f19616c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f19617d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f19618e);
        SafeParcelWriter.writeStringList(parcel, 6, this.f19619f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f19620g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzb() {
        return this.f19615b;
    }
}
