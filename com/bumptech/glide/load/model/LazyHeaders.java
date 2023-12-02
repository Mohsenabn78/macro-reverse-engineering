package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LazyHeaders implements Headers {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, List<LazyHeaderFactory>> f17145a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Map<String, String> f17146b;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private static final String f17147d;

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, List<LazyHeaderFactory>> f17148e;

        /* renamed from: a  reason: collision with root package name */
        private boolean f17149a = true;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, List<LazyHeaderFactory>> f17150b = f17148e;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17151c = true;

        static {
            String d4 = d();
            f17147d = d4;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(d4)) {
                hashMap.put("User-Agent", Collections.singletonList(new a(d4)));
            }
            f17148e = Collections.unmodifiableMap(hashMap);
        }

        private Map<String, List<LazyHeaderFactory>> a() {
            HashMap hashMap = new HashMap(this.f17150b.size());
            for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f17150b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        private void b() {
            if (this.f17149a) {
                this.f17149a = false;
                this.f17150b = a();
            }
        }

        private List<LazyHeaderFactory> c(String str) {
            List<LazyHeaderFactory> list = this.f17150b.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                this.f17150b.put(str, arrayList);
                return arrayList;
            }
            return list;
        }

        @VisibleForTesting
        static String d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = property.charAt(i4);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public Builder addHeader(@NonNull String str, @NonNull String str2) {
            return addHeader(str, new a(str2));
        }

        public LazyHeaders build() {
            this.f17149a = true;
            return new LazyHeaders(this.f17150b);
        }

        public Builder setHeader(@NonNull String str, @Nullable String str2) {
            return setHeader(str, str2 == null ? null : new a(str2));
        }

        public Builder addHeader(@NonNull String str, @NonNull LazyHeaderFactory lazyHeaderFactory) {
            if (this.f17151c && "User-Agent".equalsIgnoreCase(str)) {
                return setHeader(str, lazyHeaderFactory);
            }
            b();
            c(str).add(lazyHeaderFactory);
            return this;
        }

        public Builder setHeader(@NonNull String str, @Nullable LazyHeaderFactory lazyHeaderFactory) {
            b();
            if (lazyHeaderFactory == null) {
                this.f17150b.remove(str);
            } else {
                List<LazyHeaderFactory> c4 = c(str);
                c4.clear();
                c4.add(lazyHeaderFactory);
            }
            if (this.f17151c && "User-Agent".equalsIgnoreCase(str)) {
                this.f17151c = false;
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    static final class a implements LazyHeaderFactory {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f17152a;

        a(@NonNull String str) {
            this.f17152a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.f17152a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f17152a.equals(((a) obj).f17152a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17152a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f17152a + "'}";
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f17145a = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            String buildHeader = list.get(i4).buildHeader();
            if (!TextUtils.isEmpty(buildHeader)) {
                sb.append(buildHeader);
                if (i4 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f17145a.entrySet()) {
            String a4 = a(entry.getValue());
            if (!TextUtils.isEmpty(a4)) {
                hashMap.put(entry.getKey(), a4);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f17145a.equals(((LazyHeaders) obj).f17145a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.f17146b == null) {
            synchronized (this) {
                if (this.f17146b == null) {
                    this.f17146b = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f17146b;
    }

    public int hashCode() {
        return this.f17145a.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f17145a + '}';
    }
}
