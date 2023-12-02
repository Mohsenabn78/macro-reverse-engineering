package com.koushikdutta.async.http;

import android.net.Uri;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes6.dex */
public class Multimap extends LinkedHashMap<String, List<String>> implements Iterable<NameValuePair> {

    /* renamed from: a  reason: collision with root package name */
    private static final StringDecoder f35068a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final StringDecoder f35069b = new b();

    /* loaded from: classes6.dex */
    public interface StringDecoder {
        String decode(String str);
    }

    /* loaded from: classes6.dex */
    static class a implements StringDecoder {
        a() {
        }

        @Override // com.koushikdutta.async.http.Multimap.StringDecoder
        public String decode(String str) {
            return Uri.decode(str);
        }
    }

    /* loaded from: classes6.dex */
    static class b implements StringDecoder {
        b() {
        }

        @Override // com.koushikdutta.async.http.Multimap.StringDecoder
        public String decode(String str) {
            return URLDecoder.decode(str);
        }
    }

    public Multimap() {
    }

    public static Multimap parse(String str, String str2, boolean z3, StringDecoder stringDecoder) {
        String str3;
        Multimap multimap = new Multimap();
        if (str == null) {
            return multimap;
        }
        for (String str4 : str.split(str2)) {
            String[] split = str4.split("=", 2);
            String trim = split[0].trim();
            if (split.length > 1) {
                str3 = split[1];
            } else {
                str3 = null;
            }
            if (z3 && str3 != null && str3.endsWith("\"") && str3.startsWith("\"")) {
                str3 = str3.substring(1, str3.length() - 1);
            }
            if (stringDecoder != null) {
                trim = stringDecoder.decode(trim);
                str3 = stringDecoder.decode(str3);
            }
            multimap.add(trim, str3);
        }
        return multimap;
    }

    public static Multimap parseCommaDelimited(String str) {
        return parse(str, ",", true, null);
    }

    public static Multimap parseQuery(String str) {
        return parse(str, "&", false, f35068a);
    }

    public static Multimap parseSemicolonDelimited(String str) {
        return parse(str, ";", true, null);
    }

    public static Multimap parseUrlEncoded(String str) {
        return parse(str, "&", false, f35069b);
    }

    protected List<String> a() {
        return new ArrayList();
    }

    public void add(String str, String str2) {
        List<String> list = get(str);
        if (list == null) {
            list = a();
            put((Multimap) str, (String) list);
        }
        list.add(str2);
    }

    public String getString(String str) {
        List<String> list = get(str);
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<NameValuePair> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            for (String str2 : (List) get(str)) {
                arrayList.add(new BasicNameValuePair(str, str2));
            }
        }
        return arrayList.iterator();
    }

    public void put(String str, String str2) {
        List<String> a4 = a();
        a4.add(str2);
        put((Multimap) str, (String) a4);
    }

    public Multimap(List<NameValuePair> list) {
        for (NameValuePair nameValuePair : list) {
            add(nameValuePair.getName(), nameValuePair.getValue());
        }
    }

    public Multimap(Multimap multimap) {
        putAll(multimap);
    }
}
