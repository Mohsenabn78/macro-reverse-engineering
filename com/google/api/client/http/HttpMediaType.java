package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class HttpMediaType {

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f25781e = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f25782f = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f25783g;

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f25784h;

    /* renamed from: a  reason: collision with root package name */
    private String f25785a = "application";

    /* renamed from: b  reason: collision with root package name */
    private String f25786b = "octet-stream";

    /* renamed from: c  reason: collision with root package name */
    private final SortedMap<String, String> f25787c = new TreeMap();

    /* renamed from: d  reason: collision with root package name */
    private String f25788d;

    static {
        StringBuilder sb = new StringBuilder("[^\\s/=;\"]+".length() + 14 + "[^\\s/=;\"]+".length() + ";.*".length());
        sb.append("\\s*(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")/(");
        sb.append("[^\\s/=;\"]+");
        sb.append(")");
        sb.append("\\s*(");
        sb.append(";.*");
        sb.append(")?");
        f25783g = Pattern.compile(sb.toString(), 32);
        StringBuilder sb2 = new StringBuilder("\"([^\"]*)\"".length() + 1 + "[^\\s;\"]*".length());
        sb2.append("\"([^\"]*)\"");
        sb2.append("|");
        sb2.append("[^\\s;\"]*");
        String valueOf = String.valueOf(sb2.toString());
        StringBuilder sb3 = new StringBuilder("[^\\s/=;\"]+".length() + 12 + valueOf.length());
        sb3.append("\\s*;\\s*(");
        sb3.append("[^\\s/=;\"]+");
        sb3.append(")");
        sb3.append("=(");
        sb3.append(valueOf);
        sb3.append(")");
        f25784h = Pattern.compile(sb3.toString());
    }

    public HttpMediaType(String str, String str2) {
        setType(str);
        setSubType(str2);
    }

    private HttpMediaType a(String str) {
        Matcher matcher = f25783g.matcher(str);
        Preconditions.checkArgument(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        setType(matcher.group(1));
        setSubType(matcher.group(2));
        String group = matcher.group(3);
        if (group != null) {
            Matcher matcher2 = f25784h.matcher(group);
            while (matcher2.find()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(3);
                if (group3 == null) {
                    group3 = matcher2.group(2);
                }
                setParameter(group2, group3);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String str) {
        return f25782f.matcher(str).matches();
    }

    private static String c(String str) {
        String valueOf = String.valueOf(str.replace("\\", "\\\\").replace("\"", "\\\""));
        StringBuilder sb = new StringBuilder(valueOf.length() + 2);
        sb.append("\"");
        sb.append(valueOf);
        sb.append("\"");
        return sb.toString();
    }

    public String build() {
        String str = this.f25788d;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25785a);
        sb.append('/');
        sb.append(this.f25786b);
        SortedMap<String, String> sortedMap = this.f25787c;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                String value = entry.getValue();
                sb.append("; ");
                sb.append(entry.getKey());
                sb.append("=");
                if (!b(value)) {
                    value = c(value);
                }
                sb.append(value);
            }
        }
        String sb2 = sb.toString();
        this.f25788d = sb2;
        return sb2;
    }

    public void clearParameters() {
        this.f25788d = null;
        this.f25787c.clear();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpMediaType)) {
            return false;
        }
        HttpMediaType httpMediaType = (HttpMediaType) obj;
        if (!equalsIgnoreParameters(httpMediaType) || !this.f25787c.equals(httpMediaType.f25787c)) {
            return false;
        }
        return true;
    }

    public boolean equalsIgnoreParameters(HttpMediaType httpMediaType) {
        return httpMediaType != null && getType().equalsIgnoreCase(httpMediaType.getType()) && getSubType().equalsIgnoreCase(httpMediaType.getSubType());
    }

    public Charset getCharsetParameter() {
        String parameter = getParameter("charset");
        if (parameter == null) {
            return null;
        }
        return Charset.forName(parameter);
    }

    public String getParameter(String str) {
        return this.f25787c.get(str.toLowerCase());
    }

    public Map<String, String> getParameters() {
        return Collections.unmodifiableMap(this.f25787c);
    }

    public String getSubType() {
        return this.f25786b;
    }

    public String getType() {
        return this.f25785a;
    }

    public int hashCode() {
        return build().hashCode();
    }

    public HttpMediaType removeParameter(String str) {
        this.f25788d = null;
        this.f25787c.remove(str.toLowerCase());
        return this;
    }

    public HttpMediaType setCharsetParameter(Charset charset) {
        String name;
        if (charset == null) {
            name = null;
        } else {
            name = charset.name();
        }
        setParameter("charset", name);
        return this;
    }

    public HttpMediaType setParameter(String str, String str2) {
        if (str2 == null) {
            removeParameter(str);
            return this;
        }
        Preconditions.checkArgument(f25782f.matcher(str).matches(), "Name contains reserved characters");
        this.f25788d = null;
        this.f25787c.put(str.toLowerCase(), str2);
        return this;
    }

    public HttpMediaType setSubType(String str) {
        Preconditions.checkArgument(f25781e.matcher(str).matches(), "Subtype contains reserved characters");
        this.f25786b = str;
        this.f25788d = null;
        return this;
    }

    public HttpMediaType setType(String str) {
        Preconditions.checkArgument(f25781e.matcher(str).matches(), "Type contains reserved characters");
        this.f25785a = str;
        this.f25788d = null;
        return this;
    }

    public String toString() {
        return build();
    }

    public static boolean equalsIgnoreParameters(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !new HttpMediaType(str).equalsIgnoreParameters(new HttpMediaType(str2)));
    }

    public HttpMediaType(String str) {
        a(str);
    }
}
