package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.soter.core.model.ConstantsSoter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyRequestCreator")
/* loaded from: classes4.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final int VERSION_CODE = 2;
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    private final int f19790a;
    @SafeParcelable.Field(id = 5)

    /* renamed from: b  reason: collision with root package name */
    private Bundle f19791b;
    @SafeParcelable.Field(id = 4)
    public final byte[] body;
    @SafeParcelable.Field(id = 2)
    public final int httpMethod;
    @SafeParcelable.Field(id = 3)
    public final long timeoutMillis;
    @SafeParcelable.Field(id = 1)
    public final String url;
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int LAST_CODE = 7;

    @KeepForSdkWithMembers
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19792a;

        /* renamed from: b  reason: collision with root package name */
        private int f19793b = ProxyRequest.HTTP_METHOD_GET;

        /* renamed from: c  reason: collision with root package name */
        private long f19794c = ConstantsSoter.FACEID_AUTH_CHECK_TIME;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f19795d = null;

        /* renamed from: e  reason: collision with root package name */
        private Bundle f19796e = new Bundle();

        public Builder(String str) {
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.f19792a = str;
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
            sb.append("The supplied url [ ");
            sb.append(str);
            sb.append("] is not match Patterns.WEB_URL!");
            throw new IllegalArgumentException(sb.toString());
        }

        public ProxyRequest build() {
            if (this.f19795d == null) {
                this.f19795d = new byte[0];
            }
            return new ProxyRequest(2, this.f19792a, this.f19793b, this.f19794c, this.f19795d, this.f19796e);
        }

        public Builder putHeader(String str, String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.f19796e;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.f19795d = bArr;
            return this;
        }

        public Builder setHttpMethod(int i4) {
            boolean z3;
            if (i4 >= 0 && i4 <= ProxyRequest.LAST_CODE) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Unrecognized http method code.");
            this.f19793b = i4;
            return this;
        }

        public Builder setTimeoutMillis(long j4) {
            boolean z3;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "The specified timeout must be non-negative.");
            this.f19794c = j4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ProxyRequest(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) long j4, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.f19790a = i4;
        this.url = str;
        this.httpMethod = i5;
        this.timeoutMillis = j4;
        this.body = bArr;
        this.f19791b = bundle;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f19791b.size());
        for (String str : this.f19791b.keySet()) {
            linkedHashMap.put(str, this.f19791b.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        int i4 = this.httpMethod;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i4);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.f19791b, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f19790a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
