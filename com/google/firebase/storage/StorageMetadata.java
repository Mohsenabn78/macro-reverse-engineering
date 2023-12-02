package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.internal.Slashes;
import com.google.firebase.storage.internal.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class StorageMetadata {

    /* renamed from: a  reason: collision with root package name */
    private String f32225a;

    /* renamed from: b  reason: collision with root package name */
    private FirebaseStorage f32226b;

    /* renamed from: c  reason: collision with root package name */
    private StorageReference f32227c;

    /* renamed from: d  reason: collision with root package name */
    private String f32228d;

    /* renamed from: e  reason: collision with root package name */
    private String f32229e;

    /* renamed from: f  reason: collision with root package name */
    private MetadataValue<String> f32230f;

    /* renamed from: g  reason: collision with root package name */
    private String f32231g;

    /* renamed from: h  reason: collision with root package name */
    private String f32232h;

    /* renamed from: i  reason: collision with root package name */
    private String f32233i;

    /* renamed from: j  reason: collision with root package name */
    private long f32234j;

    /* renamed from: k  reason: collision with root package name */
    private String f32235k;

    /* renamed from: l  reason: collision with root package name */
    private MetadataValue<String> f32236l;

    /* renamed from: m  reason: collision with root package name */
    private MetadataValue<String> f32237m;

    /* renamed from: n  reason: collision with root package name */
    private MetadataValue<String> f32238n;

    /* renamed from: o  reason: collision with root package name */
    private MetadataValue<String> f32239o;

    /* renamed from: p  reason: collision with root package name */
    private MetadataValue<Map<String, String>> f32240p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class MetadataValue<T> {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f32243a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final T f32244b;

        MetadataValue(@Nullable T t3, boolean z3) {
            this.f32243a = z3;
            this.f32244b = t3;
        }

        static <T> MetadataValue<T> c(T t3) {
            return new MetadataValue<>(t3, false);
        }

        static <T> MetadataValue<T> d(@Nullable T t3) {
            return new MetadataValue<>(t3, true);
        }

        @Nullable
        T a() {
            return this.f32244b;
        }

        boolean b() {
            return this.f32243a;
        }
    }

    @Nullable
    public String getBucket() {
        return this.f32228d;
    }

    @Nullable
    public String getCacheControl() {
        return this.f32236l.a();
    }

    @Nullable
    public String getContentDisposition() {
        return this.f32237m.a();
    }

    @Nullable
    public String getContentEncoding() {
        return this.f32238n.a();
    }

    @Nullable
    public String getContentLanguage() {
        return this.f32239o.a();
    }

    @Nullable
    public String getContentType() {
        return this.f32230f.a();
    }

    public long getCreationTimeMillis() {
        return Util.parseDateTime(this.f32232h);
    }

    @Nullable
    public String getCustomMetadata(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f32240p.a().get(str);
    }

    @NonNull
    public Set<String> getCustomMetadataKeys() {
        return this.f32240p.a().keySet();
    }

    @Nullable
    public String getGeneration() {
        return this.f32229e;
    }

    @Nullable
    public String getMd5Hash() {
        return this.f32235k;
    }

    @Nullable
    public String getMetadataGeneration() {
        return this.f32231g;
    }

    @Nullable
    public String getName() {
        String path = getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf != -1) {
            return path.substring(lastIndexOf + 1);
        }
        return path;
    }

    @NonNull
    public String getPath() {
        String str = this.f32225a;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public StorageReference getReference() {
        StorageReference storageReference = this.f32227c;
        if (storageReference == null && this.f32226b != null) {
            String bucket = getBucket();
            String path = getPath();
            if (!TextUtils.isEmpty(bucket) && !TextUtils.isEmpty(path)) {
                return new StorageReference(new Uri.Builder().scheme("gs").authority(bucket).encodedPath(Slashes.preserveSlashEncode(path)).build(), this.f32226b);
            }
            return null;
        }
        return storageReference;
    }

    public long getSizeBytes() {
        return this.f32234j;
    }

    public long getUpdatedTimeMillis() {
        return Util.parseDateTime(this.f32233i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public JSONObject v() {
        HashMap hashMap = new HashMap();
        if (this.f32230f.b()) {
            hashMap.put("contentType", getContentType());
        }
        if (this.f32240p.b()) {
            hashMap.put("metadata", new JSONObject(this.f32240p.a()));
        }
        if (this.f32236l.b()) {
            hashMap.put("cacheControl", getCacheControl());
        }
        if (this.f32237m.b()) {
            hashMap.put("contentDisposition", getContentDisposition());
        }
        if (this.f32238n.b()) {
            hashMap.put("contentEncoding", getContentEncoding());
        }
        if (this.f32239o.b()) {
            hashMap.put("contentLanguage", getContentLanguage());
        }
        return new JSONObject(hashMap);
    }

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        StorageMetadata f32241a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32242b;

        public Builder() {
            this.f32241a = new StorageMetadata();
        }

        @Nullable
        private String a(JSONObject jSONObject, String str) throws JSONException {
            if (jSONObject.has(str) && !jSONObject.isNull(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        private void b(JSONObject jSONObject) throws JSONException {
            this.f32241a.f32229e = jSONObject.optString("generation");
            this.f32241a.f32225a = jSONObject.optString("name");
            this.f32241a.f32228d = jSONObject.optString("bucket");
            this.f32241a.f32231g = jSONObject.optString("metageneration");
            this.f32241a.f32232h = jSONObject.optString("timeCreated");
            this.f32241a.f32233i = jSONObject.optString("updated");
            this.f32241a.f32234j = jSONObject.optLong("size");
            this.f32241a.f32235k = jSONObject.optString("md5Hash");
            if (jSONObject.has("metadata") && !jSONObject.isNull("metadata")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    setCustomMetadata(next, jSONObject2.getString(next));
                }
            }
            String a4 = a(jSONObject, "contentType");
            if (a4 != null) {
                setContentType(a4);
            }
            String a5 = a(jSONObject, "cacheControl");
            if (a5 != null) {
                setCacheControl(a5);
            }
            String a6 = a(jSONObject, "contentDisposition");
            if (a6 != null) {
                setContentDisposition(a6);
            }
            String a7 = a(jSONObject, "contentEncoding");
            if (a7 != null) {
                setContentEncoding(a7);
            }
            String a8 = a(jSONObject, "contentLanguage");
            if (a8 != null) {
                setContentLanguage(a8);
            }
        }

        @NonNull
        public StorageMetadata build() {
            return new StorageMetadata(this.f32242b);
        }

        @Nullable
        public String getCacheControl() {
            return (String) this.f32241a.f32236l.a();
        }

        @Nullable
        public String getContentDisposition() {
            return (String) this.f32241a.f32237m.a();
        }

        @Nullable
        public String getContentEncoding() {
            return (String) this.f32241a.f32238n.a();
        }

        @Nullable
        public String getContentLanguage() {
            return (String) this.f32241a.f32239o.a();
        }

        @Nullable
        public String getContentType() {
            return (String) this.f32241a.f32230f.a();
        }

        @NonNull
        public Builder setCacheControl(@Nullable String str) {
            this.f32241a.f32236l = MetadataValue.d(str);
            return this;
        }

        @NonNull
        public Builder setContentDisposition(@Nullable String str) {
            this.f32241a.f32237m = MetadataValue.d(str);
            return this;
        }

        @NonNull
        public Builder setContentEncoding(@Nullable String str) {
            this.f32241a.f32238n = MetadataValue.d(str);
            return this;
        }

        @NonNull
        public Builder setContentLanguage(@Nullable String str) {
            this.f32241a.f32239o = MetadataValue.d(str);
            return this;
        }

        @NonNull
        public Builder setContentType(@Nullable String str) {
            this.f32241a.f32230f = MetadataValue.d(str);
            return this;
        }

        @NonNull
        public Builder setCustomMetadata(@NonNull String str, @Nullable String str2) {
            if (!this.f32241a.f32240p.b()) {
                this.f32241a.f32240p = MetadataValue.d(new HashMap());
            }
            ((Map) this.f32241a.f32240p.a()).put(str, str2);
            return this;
        }

        public Builder(@NonNull StorageMetadata storageMetadata) {
            this.f32241a = new StorageMetadata(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(JSONObject jSONObject, StorageReference storageReference) throws JSONException {
            this(jSONObject);
            this.f32241a.f32227c = storageReference;
        }

        Builder(JSONObject jSONObject) throws JSONException {
            this.f32241a = new StorageMetadata();
            if (jSONObject != null) {
                b(jSONObject);
                this.f32242b = true;
            }
        }
    }

    public StorageMetadata() {
        this.f32225a = null;
        this.f32226b = null;
        this.f32227c = null;
        this.f32228d = null;
        this.f32229e = null;
        this.f32230f = MetadataValue.c("");
        this.f32231g = null;
        this.f32232h = null;
        this.f32233i = null;
        this.f32235k = null;
        this.f32236l = MetadataValue.c("");
        this.f32237m = MetadataValue.c("");
        this.f32238n = MetadataValue.c("");
        this.f32239o = MetadataValue.c("");
        this.f32240p = MetadataValue.c(Collections.emptyMap());
    }

    private StorageMetadata(@NonNull StorageMetadata storageMetadata, boolean z3) {
        this.f32225a = null;
        this.f32226b = null;
        this.f32227c = null;
        this.f32228d = null;
        this.f32229e = null;
        this.f32230f = MetadataValue.c("");
        this.f32231g = null;
        this.f32232h = null;
        this.f32233i = null;
        this.f32235k = null;
        this.f32236l = MetadataValue.c("");
        this.f32237m = MetadataValue.c("");
        this.f32238n = MetadataValue.c("");
        this.f32239o = MetadataValue.c("");
        this.f32240p = MetadataValue.c(Collections.emptyMap());
        Preconditions.checkNotNull(storageMetadata);
        this.f32225a = storageMetadata.f32225a;
        this.f32226b = storageMetadata.f32226b;
        this.f32227c = storageMetadata.f32227c;
        this.f32228d = storageMetadata.f32228d;
        this.f32230f = storageMetadata.f32230f;
        this.f32236l = storageMetadata.f32236l;
        this.f32237m = storageMetadata.f32237m;
        this.f32238n = storageMetadata.f32238n;
        this.f32239o = storageMetadata.f32239o;
        this.f32240p = storageMetadata.f32240p;
        if (z3) {
            this.f32235k = storageMetadata.f32235k;
            this.f32234j = storageMetadata.f32234j;
            this.f32233i = storageMetadata.f32233i;
            this.f32232h = storageMetadata.f32232h;
            this.f32231g = storageMetadata.f32231g;
            this.f32229e = storageMetadata.f32229e;
        }
    }
}
