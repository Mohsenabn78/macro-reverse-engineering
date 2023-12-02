package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
/* loaded from: classes4.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    @NonNull
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    @NonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;

    /* renamed from: l  reason: collision with root package name */
    private static final Comparator f19819l;
    @NonNull
    @VisibleForTesting
    public static final Scope zaa = new Scope(Scopes.PROFILE);
    @NonNull
    @VisibleForTesting
    public static final Scope zab = new Scope("email");
    @NonNull
    @VisibleForTesting
    public static final Scope zac = new Scope(Scopes.OPEN_ID);
    @NonNull
    @VisibleForTesting
    public static final Scope zad;
    @NonNull
    @VisibleForTesting
    public static final Scope zae;
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f19820a;
    @SafeParcelable.Field(getter = "getScopes", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f19821b;
    @Nullable
    @SafeParcelable.Field(getter = "getAccount", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private Account f19822c;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private boolean f19823d;
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f19824e;
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19825f;
    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private String f19826g;
    @Nullable
    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private String f19827h;
    @SafeParcelable.Field(getter = "getExtensions", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f19828i;
    @Nullable
    @SafeParcelable.Field(getter = "getLogSessionId", id = 10)

    /* renamed from: j  reason: collision with root package name */
    private String f19829j;

    /* renamed from: k  reason: collision with root package name */
    private Map f19830k;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Set f19831a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f19832b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19833c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19834d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f19835e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Account f19836f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f19837g;

        /* renamed from: h  reason: collision with root package name */
        private Map f19838h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private String f19839i;

        public Builder() {
            this.f19831a = new HashSet();
            this.f19838h = new HashMap();
        }

        private final String a(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.f19835e;
            boolean z3 = true;
            if (str2 != null && !str2.equals(str)) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "two different server client ids provided");
            return str;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addExtension(@NonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.f19838h.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                List<Scope> impliedScopes = googleSignInOptionsExtension.getImpliedScopes();
                if (impliedScopes != null) {
                    this.f19831a.addAll(impliedScopes);
                }
                this.f19838h.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        @NonNull
        public GoogleSignInOptions build() {
            if (this.f19831a.contains(GoogleSignInOptions.zae)) {
                Set set = this.f19831a;
                Scope scope = GoogleSignInOptions.zad;
                if (set.contains(scope)) {
                    this.f19831a.remove(scope);
                }
            }
            if (this.f19834d && (this.f19836f == null || !this.f19831a.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(new ArrayList(this.f19831a), this.f19836f, this.f19834d, this.f19832b, this.f19833c, this.f19835e, this.f19837g, this.f19838h, this.f19839i);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestEmail() {
            this.f19831a.add(GoogleSignInOptions.zab);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestId() {
            this.f19831a.add(GoogleSignInOptions.zac);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestIdToken(@NonNull String str) {
            this.f19834d = true;
            a(str);
            this.f19835e = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestProfile() {
            this.f19831a.add(GoogleSignInOptions.zaa);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestScopes(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            this.f19831a.add(scope);
            this.f19831a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestServerAuthCode(@NonNull String str) {
            requestServerAuthCode(str, false);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setAccountName(@NonNull String str) {
            this.f19836f = new Account(Preconditions.checkNotEmpty(str), "com.google");
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setHostedDomain(@NonNull String str) {
            this.f19837g = Preconditions.checkNotEmpty(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder setLogSessionId(@NonNull String str) {
            this.f19839i = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder requestServerAuthCode(@NonNull String str, boolean z3) {
            this.f19832b = true;
            a(str);
            this.f19835e = str;
            this.f19833c = z3;
            return this;
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f19831a = new HashSet();
            this.f19838h = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            this.f19831a = new HashSet(googleSignInOptions.f19821b);
            this.f19832b = googleSignInOptions.f19824e;
            this.f19833c = googleSignInOptions.f19825f;
            this.f19834d = googleSignInOptions.f19823d;
            this.f19835e = googleSignInOptions.f19826g;
            this.f19836f = googleSignInOptions.f19822c;
            this.f19837g = googleSignInOptions.f19827h;
            this.f19838h = GoogleSignInOptions.l(googleSignInOptions.f19828i);
            this.f19839i = googleSignInOptions.f19829j;
        }
    }

    static {
        Scope scope = new Scope(Scopes.GAMES_LITE);
        zad = scope;
        zae = new Scope(Scopes.GAMES);
        Builder builder = new Builder();
        builder.requestId();
        builder.requestProfile();
        DEFAULT_SIGN_IN = builder.build();
        Builder builder2 = new Builder();
        builder2.requestScopes(scope, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = builder2.build();
        CREATOR = new zae();
        f19819l = new zac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map l(@Nullable List list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    @Nullable
    public static GoogleSignInOptions zab(@Nullable String str) throws JSONException {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(jSONArray.getString(i4)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, "com.google");
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z3 = jSONObject.getBoolean("idTokenRequested");
        boolean z4 = jSONObject.getBoolean("serverAuthRequested");
        boolean z5 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z3, z4, z5, str3, str4, new HashMap(), (String) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r1.equals(r4.getAccount()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r1 = r3.f19828i     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 > 0) goto L90
            java.util.ArrayList r1 = r4.f19828i     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 <= 0) goto L18
            goto L90
        L18:
            java.util.ArrayList r1 = r3.f19821b     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L90
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.util.ArrayList r1 = r3.f19821b     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L35
            goto L90
        L35:
            android.accounts.Account r1 = r3.f19822c     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L90
            goto L4a
        L40:
            android.accounts.Account r2 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
        L4a:
            java.lang.String r1 = r3.f19826g     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            goto L6a
        L5d:
            java.lang.String r1 = r3.f19826g     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r2 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L6a
            goto L90
        L6a:
            boolean r1 = r3.f19825f     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f19823d     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.isIdTokenRequested()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.f19824e     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.isServerAuthCodeRequested()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.lang.String r1 = r3.f19829j     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r4 = r4.getLogSessionId()     // Catch: java.lang.ClassCastException -> L90
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L90
            if (r4 == 0) goto L90
            r4 = 1
            return r4
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @Nullable
    @KeepForSdk
    public Account getAccount() {
        return this.f19822c;
    }

    @NonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.f19828i;
    }

    @Nullable
    @KeepForSdk
    public String getLogSessionId() {
        return this.f19829j;
    }

    @NonNull
    public Scope[] getScopeArray() {
        ArrayList arrayList = this.f19821b;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @NonNull
    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.f19821b);
    }

    @Nullable
    @KeepForSdk
    public String getServerClientId() {
        return this.f19826g;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f19821b;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((Scope) arrayList2.get(i4)).getScopeUri());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.addObject(arrayList);
        hashAccumulator.addObject(this.f19822c);
        hashAccumulator.addObject(this.f19826g);
        hashAccumulator.zaa(this.f19825f);
        hashAccumulator.zaa(this.f19823d);
        hashAccumulator.zaa(this.f19824e);
        hashAccumulator.addObject(this.f19829j);
        return hashAccumulator.hash();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.f19825f;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.f19823d;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.f19824e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f19820a);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i4, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.f19827h, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zaf() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f19821b, f19819l);
            Iterator it = this.f19821b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f19822c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f19823d);
            jSONObject.put("forceCodeForRefreshToken", this.f19825f);
            jSONObject.put("serverAuthRequested", this.f19824e);
            if (!TextUtils.isEmpty(this.f19826g)) {
                jSONObject.put("serverClientId", this.f19826g);
            }
            if (!TextUtils.isEmpty(this.f19827h)) {
                jSONObject.put("hostedDomain", this.f19827h);
            }
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) ArrayList arrayList, @Nullable @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) boolean z4, @SafeParcelable.Param(id = 6) boolean z5, @Nullable @SafeParcelable.Param(id = 7) String str, @Nullable @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList arrayList2, @Nullable @SafeParcelable.Param(id = 10) String str3) {
        this(i4, arrayList, account, z3, z4, z5, str, str2, l(arrayList2), str3);
    }

    private GoogleSignInOptions(int i4, ArrayList arrayList, @Nullable Account account, boolean z3, boolean z4, boolean z5, @Nullable String str, @Nullable String str2, Map map, @Nullable String str3) {
        this.f19820a = i4;
        this.f19821b = arrayList;
        this.f19822c = account;
        this.f19823d = z3;
        this.f19824e = z4;
        this.f19825f = z5;
        this.f19826g = str;
        this.f19827h = str2;
        this.f19828i = new ArrayList(map.values());
        this.f19830k = map;
        this.f19829j = str3;
    }
}
