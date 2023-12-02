package com.koushikdutta.async.http;

import android.text.TextUtils;
import com.koushikdutta.async.util.TaggedList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public class Headers {

    /* renamed from: a  reason: collision with root package name */
    final Multimap f35027a;

    /* loaded from: classes6.dex */
    class a extends Multimap {
        a() {
        }

        @Override // com.koushikdutta.async.http.Multimap
        protected List<String> a() {
            return new TaggedList();
        }
    }

    public Headers() {
        this.f35027a = new a();
    }

    public static Headers parse(String str) {
        String[] split = str.split("\n");
        Headers headers = new Headers();
        for (String str2 : split) {
            String trim = str2.trim();
            if (!TextUtils.isEmpty(trim)) {
                headers.addLine(trim);
            }
        }
        return headers;
    }

    public Headers add(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.f35027a.add(lowerCase, str2);
        ((TaggedList) this.f35027a.get(lowerCase)).tagNull(str);
        return this;
    }

    public Headers addAll(String str, List<String> list) {
        for (String str2 : list) {
            add(str, str2);
        }
        return this;
    }

    public Headers addLine(String str) {
        if (str != null) {
            String[] split = str.trim().split(":", 2);
            if (split.length == 2) {
                add(split[0].trim(), split[1].trim());
            } else {
                add(split[0].trim(), "");
            }
        }
        return this;
    }

    public String get(String str) {
        return this.f35027a.getString(str.toLowerCase(Locale.US));
    }

    public List<String> getAll(String str) {
        return this.f35027a.get(str.toLowerCase(Locale.US));
    }

    public Multimap getMultiMap() {
        return this.f35027a;
    }

    public String remove(String str) {
        List<String> removeAll = removeAll(str.toLowerCase(Locale.US));
        if (removeAll != null && removeAll.size() != 0) {
            return removeAll.get(0);
        }
        return null;
    }

    public List<String> removeAll(String str) {
        return this.f35027a.remove(str.toLowerCase(Locale.US));
    }

    public Headers set(String str, String str2) {
        if (str2 != null && (str2.contains("\n") || str2.contains("\r"))) {
            throw new IllegalArgumentException("value must not contain a new line or line feed");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.f35027a.put(lowerCase, str2);
        ((TaggedList) this.f35027a.get(lowerCase)).tagNull(str);
        return this;
    }

    public String toPrefixString(String str) {
        StringBuilder stringBuilder = toStringBuilder();
        return stringBuilder.insert(0, str + "\r\n").toString();
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(256);
        for (String str : this.f35027a.keySet()) {
            TaggedList taggedList = (TaggedList) this.f35027a.get(str);
            Iterator<T> it = taggedList.iterator();
            while (it.hasNext()) {
                sb.append((String) taggedList.tag());
                sb.append(": ");
                sb.append((String) it.next());
                sb.append("\r\n");
            }
        }
        sb.append("\r\n");
        return sb;
    }

    public Headers removeAll(Collection<String> collection) {
        for (String str : collection) {
            remove(str);
        }
        return this;
    }

    public Headers(Map<String, List<String>> map) {
        a aVar = new a();
        this.f35027a = aVar;
        aVar.putAll(map);
    }

    public Headers addAll(Map<String, List<String>> map) {
        for (String str : map.keySet()) {
            for (String str2 : map.get(str)) {
                add(str, str2);
            }
        }
        return this;
    }

    public Headers addAll(Headers headers) {
        this.f35027a.putAll(headers.f35027a);
        return this;
    }
}
