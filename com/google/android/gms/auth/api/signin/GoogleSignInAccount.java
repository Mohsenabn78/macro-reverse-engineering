package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
/* loaded from: classes4.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    @NonNull
    @VisibleForTesting
    public static final Clock zaa = DefaultClock.getInstance();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f19799a;
    @Nullable
    @SafeParcelable.Field(getter = "getId", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19800b;
    @Nullable
    @SafeParcelable.Field(getter = "getIdToken", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f19801c;
    @Nullable
    @SafeParcelable.Field(getter = "getEmail", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f19802d;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final String f19803e;
    @Nullable
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final Uri f19804f;
    @Nullable
    @SafeParcelable.Field(getter = "getServerAuthCode", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private String f19805g;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final long f19806h;
    @SafeParcelable.Field(getter = "getObfuscatedIdentifier", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final String f19807i;
    @SafeParcelable.Field(id = 10)

    /* renamed from: j  reason: collision with root package name */
    final List f19808j;
    @Nullable
    @SafeParcelable.Field(getter = "getGivenName", id = 11)

    /* renamed from: k  reason: collision with root package name */
    private final String f19809k;
    @Nullable
    @SafeParcelable.Field(getter = "getFamilyName", id = 12)

    /* renamed from: l  reason: collision with root package name */
    private final String f19810l;

    /* renamed from: m  reason: collision with root package name */
    private final Set f19811m = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3, @Nullable @SafeParcelable.Param(id = 5) String str4, @Nullable @SafeParcelable.Param(id = 6) Uri uri, @Nullable @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) long j4, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List list, @Nullable @SafeParcelable.Param(id = 11) String str7, @Nullable @SafeParcelable.Param(id = 12) String str8) {
        this.f19799a = i4;
        this.f19800b = str;
        this.f19801c = str2;
        this.f19802d = str3;
        this.f19803e = str4;
        this.f19804f = uri;
        this.f19805g = str5;
        this.f19806h = j4;
        this.f19807i = str6;
        this.f19808j = list;
        this.f19809k = str7;
        this.f19810l = str8;
    }

    private static GoogleSignInAccount b(Account account, Set set) {
        return zaa(null, null, account.name, null, null, null, null, 0L, account.name, set);
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignInAccount createDefault() {
        return b(new Account("<<default account>>", "com.google"), new HashSet());
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignInAccount fromAccount(@NonNull Account account) {
        return b(account, new ArraySet());
    }

    @NonNull
    public static GoogleSignInAccount zaa(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l4, @NonNull String str7, @NonNull Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l4.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    @Nullable
    public static GoogleSignInAccount zab(@Nullable String str) throws JSONException {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(jSONArray.getString(i4)));
        }
        String optString2 = jSONObject.optString("id");
        if (jSONObject.has("tokenId")) {
            str2 = jSONObject.optString("tokenId");
        } else {
            str2 = null;
        }
        if (jSONObject.has("email")) {
            str3 = jSONObject.optString("email");
        } else {
            str3 = null;
        }
        if (jSONObject.has("displayName")) {
            str4 = jSONObject.optString("displayName");
        } else {
            str4 = null;
        }
        if (jSONObject.has("givenName")) {
            str5 = jSONObject.optString("givenName");
        } else {
            str5 = null;
        }
        if (jSONObject.has("familyName")) {
            str6 = jSONObject.optString("familyName");
        } else {
            str6 = null;
        }
        GoogleSignInAccount zaa2 = zaa(optString2, str2, str3, str4, str5, str6, uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str7 = jSONObject.optString("serverAuthCode");
        }
        zaa2.f19805g = str7;
        return zaa2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f19807i.equals(this.f19807i) || !googleSignInAccount.getRequestedScopes().equals(getRequestedScopes())) {
            return false;
        }
        return true;
    }

    @Nullable
    public Account getAccount() {
        String str = this.f19802d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    @Nullable
    public String getDisplayName() {
        return this.f19803e;
    }

    @Nullable
    public String getEmail() {
        return this.f19802d;
    }

    @Nullable
    public String getFamilyName() {
        return this.f19810l;
    }

    @Nullable
    public String getGivenName() {
        return this.f19809k;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f19808j);
    }

    @Nullable
    public String getId() {
        return this.f19800b;
    }

    @Nullable
    public String getIdToken() {
        return this.f19801c;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.f19804f;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.f19808j);
        hashSet.addAll(this.f19811m);
        return hashSet;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.f19805g;
    }

    public int hashCode() {
        return ((this.f19807i.hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    @KeepForSdk
    public boolean isExpired() {
        if (zaa.currentTimeMillis() / 1000 >= this.f19806h - 300) {
            return true;
        }
        return false;
    }

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public GoogleSignInAccount requestExtraScopes(@NonNull Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.f19811m, scopeArr);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19799a);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i4, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.f19806h);
        SafeParcelWriter.writeString(parcel, 9, this.f19807i, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.f19808j, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zac() {
        return this.f19807i;
    }

    @NonNull
    public final String zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            Uri photoUrl = getPhotoUrl();
            if (photoUrl != null) {
                jSONObject.put("photoUrl", photoUrl.toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f19806h);
            jSONObject.put("obfuscatedIdentifier", this.f19807i);
            JSONArray jSONArray = new JSONArray();
            List list = this.f19808j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: com.google.android.gms.auth.api.signin.zaa
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }
}
