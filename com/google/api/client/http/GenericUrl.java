package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.escape.CharEscapers;
import com.google.api.client.util.escape.Escaper;
import com.google.api.client.util.escape.PercentEscaper;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes5.dex */
public class GenericUrl extends GenericData {

    /* renamed from: i  reason: collision with root package name */
    private static final Escaper f25761i = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);

    /* renamed from: c  reason: collision with root package name */
    private String f25762c;

    /* renamed from: d  reason: collision with root package name */
    private String f25763d;

    /* renamed from: e  reason: collision with root package name */
    private String f25764e;

    /* renamed from: f  reason: collision with root package name */
    private int f25765f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f25766g;

    /* renamed from: h  reason: collision with root package name */
    private String f25767h;

    public GenericUrl() {
        this.f25765f = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z3 = true;
        for (Map.Entry<String, Object> entry : set) {
            Object value = entry.getValue();
            if (value != null) {
                String escapeUriQuery = CharEscapers.escapeUriQuery(entry.getKey());
                if (value instanceof Collection) {
                    for (Object obj : (Collection) value) {
                        z3 = c(z3, sb, escapeUriQuery, obj);
                    }
                } else {
                    z3 = c(z3, sb, escapeUriQuery, value);
                }
            }
        }
    }

    private static boolean c(boolean z3, StringBuilder sb, String str, Object obj) {
        if (z3) {
            sb.append('?');
            z3 = false;
        } else {
            sb.append(Typography.amp);
        }
        sb.append(str);
        String escapeUriQuery = CharEscapers.escapeUriQuery(obj.toString());
        if (escapeUriQuery.length() != 0) {
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(escapeUriQuery);
        }
        return z3;
    }

    private void d(StringBuilder sb) {
        int size = this.f25766g.size();
        for (int i4 = 0; i4 < size; i4++) {
            String str = this.f25766g.get(i4);
            if (i4 != 0) {
                sb.append('/');
            }
            if (str.length() != 0) {
                sb.append(CharEscapers.escapeUriPath(str));
            }
        }
    }

    private static URL e(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    private static URI f(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static List<String> toPathParts(String str) {
        boolean z3;
        String substring;
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            boolean z4 = true;
            int i4 = 0;
            while (z4) {
                int indexOf = str.indexOf(47, i4);
                if (indexOf != -1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    substring = str.substring(i4, indexOf);
                } else {
                    substring = str.substring(i4);
                }
                arrayList.add(CharEscapers.decodeUri(substring));
                i4 = indexOf + 1;
                z4 = z3;
            }
            return arrayList;
        }
        return null;
    }

    public void appendRawPath(String str) {
        String str2;
        if (str != null && str.length() != 0) {
            List<String> pathParts = toPathParts(str);
            List<String> list = this.f25766g;
            if (list != null && !list.isEmpty()) {
                int size = this.f25766g.size();
                List<String> list2 = this.f25766g;
                int i4 = size - 1;
                String valueOf = String.valueOf(list2.get(i4));
                String valueOf2 = String.valueOf(pathParts.get(0));
                if (valueOf2.length() != 0) {
                    str2 = valueOf.concat(valueOf2);
                } else {
                    str2 = new String(valueOf);
                }
                list2.set(i4, str2);
                this.f25766g.addAll(pathParts.subList(1, pathParts.size()));
                return;
            }
            this.f25766g = pathParts;
        }
    }

    public final String build() {
        String valueOf = String.valueOf(buildAuthority());
        String valueOf2 = String.valueOf(buildRelativeUrl());
        if (valueOf2.length() != 0) {
            return valueOf.concat(valueOf2);
        }
        return new String(valueOf);
    }

    public final String buildAuthority() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) Preconditions.checkNotNull(this.f25762c));
        sb.append("://");
        String str = this.f25764e;
        if (str != null) {
            sb.append(CharEscapers.escapeUriUserInfo(str));
            sb.append('@');
        }
        sb.append((String) Preconditions.checkNotNull(this.f25763d));
        int i4 = this.f25765f;
        if (i4 != -1) {
            sb.append(':');
            sb.append(i4);
        }
        return sb.toString();
    }

    public final String buildRelativeUrl() {
        StringBuilder sb = new StringBuilder();
        if (this.f25766g != null) {
            d(sb);
        }
        a(entrySet(), sb);
        String str = this.f25767h;
        if (str != null) {
            sb.append('#');
            sb.append(f25761i.escape(str));
        }
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof GenericUrl)) {
            return build().equals(((GenericUrl) obj).toString());
        }
        return false;
    }

    public Collection<Object> getAll(String str) {
        Object obj = get(str);
        if (obj == null) {
            return Collections.emptySet();
        }
        if (obj instanceof Collection) {
            return Collections.unmodifiableCollection((Collection) obj);
        }
        return Collections.singleton(obj);
    }

    public Object getFirst(String str) {
        Object obj = get(str);
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            if (it.hasNext()) {
                return it.next();
            }
            return null;
        }
        return obj;
    }

    public String getFragment() {
        return this.f25767h;
    }

    public String getHost() {
        return this.f25763d;
    }

    public List<String> getPathParts() {
        return this.f25766g;
    }

    public int getPort() {
        return this.f25765f;
    }

    public String getRawPath() {
        if (this.f25766g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        d(sb);
        return sb.toString();
    }

    public final String getScheme() {
        return this.f25762c;
    }

    public final String getUserInfo() {
        return this.f25764e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return build().hashCode();
    }

    public final void setFragment(String str) {
        this.f25767h = str;
    }

    public final void setHost(String str) {
        this.f25763d = (String) Preconditions.checkNotNull(str);
    }

    public void setPathParts(List<String> list) {
        this.f25766g = list;
    }

    public final void setPort(int i4) {
        boolean z3;
        if (i4 >= -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "expected port >= -1");
        this.f25765f = i4;
    }

    public void setRawPath(String str) {
        this.f25766g = toPathParts(str);
    }

    public final void setScheme(String str) {
        this.f25762c = (String) Preconditions.checkNotNull(str);
    }

    public final void setUserInfo(String str) {
        this.f25764e = str;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return build();
    }

    public final URI toURI() {
        return f(build());
    }

    public final URL toURL() {
        return e(build());
    }

    @Override // com.google.api.client.util.GenericData
    public GenericUrl set(String str, Object obj) {
        return (GenericUrl) super.set(str, obj);
    }

    public final URL toURL(String str) {
        try {
            return new URL(toURL(), str);
        } catch (MalformedURLException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public GenericUrl(String str) {
        this(e(str));
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenericUrl clone() {
        GenericUrl genericUrl = (GenericUrl) super.clone();
        if (this.f25766g != null) {
            genericUrl.f25766g = new ArrayList(this.f25766g);
        }
        return genericUrl;
    }

    public GenericUrl(URI uri) {
        this(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getRawPath(), uri.getRawFragment(), uri.getRawQuery(), uri.getRawUserInfo());
    }

    public GenericUrl(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private GenericUrl(String str, String str2, int i4, String str3, String str4, String str5, String str6) {
        this.f25765f = -1;
        this.f25762c = str.toLowerCase();
        this.f25763d = str2;
        this.f25765f = i4;
        this.f25766g = toPathParts(str3);
        this.f25767h = str4 != null ? CharEscapers.decodeUri(str4) : null;
        if (str5 != null) {
            UrlEncodedParser.parse(str5, this);
        }
        this.f25764e = str6 != null ? CharEscapers.decodeUri(str6) : null;
    }
}
