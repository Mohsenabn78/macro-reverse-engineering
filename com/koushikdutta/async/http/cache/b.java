package com.koushikdutta.async.http.cache;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RawHeaders.java */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: f  reason: collision with root package name */
    private static final Comparator<String> f35203f = new a();

    /* renamed from: b  reason: collision with root package name */
    private String f35205b;

    /* renamed from: e  reason: collision with root package name */
    private String f35208e;

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f35204a = new ArrayList(20);

    /* renamed from: c  reason: collision with root package name */
    private int f35206c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f35207d = -1;

    /* compiled from: RawHeaders.java */
    /* loaded from: classes6.dex */
    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    public static b d(Map<String, List<String>> map) {
        b bVar = new b();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key != null) {
                bVar.b(key, value);
            } else if (!value.isEmpty()) {
                bVar.o(value.get(value.size() - 1));
            }
        }
        return bVar;
    }

    public void a(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                PrintStream printStream = System.err;
                printStream.println("Ignoring HTTP header field '" + str + "' because its value is null");
                return;
            }
            this.f35204a.add(str);
            this.f35204a.add(str2.trim());
            return;
        }
        throw new IllegalArgumentException("fieldName == null");
    }

    public void b(String str, List<String> list) {
        for (String str2 : list) {
            a(str, str2);
        }
    }

    public void c(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf == -1) {
            a("", str);
        } else {
            a(str.substring(0, indexOf), str.substring(indexOf + 1));
        }
    }

    public String e(String str) {
        for (int size = this.f35204a.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase(this.f35204a.get(size))) {
                return this.f35204a.get(size + 1);
            }
        }
        return null;
    }

    public b f(Set<String> set) {
        b bVar = new b();
        for (int i4 = 0; i4 < this.f35204a.size(); i4 += 2) {
            String str = this.f35204a.get(i4);
            if (set.contains(str)) {
                bVar.a(str, this.f35204a.get(i4 + 1));
            }
        }
        return bVar;
    }

    public String g(int i4) {
        int i5 = i4 * 2;
        if (i5 >= 0 && i5 < this.f35204a.size()) {
            return this.f35204a.get(i5);
        }
        return null;
    }

    public int h() {
        return this.f35207d;
    }

    public String i() {
        return this.f35208e;
    }

    public String j() {
        return this.f35205b;
    }

    public String k(int i4) {
        int i5 = (i4 * 2) + 1;
        if (i5 >= 0 && i5 < this.f35204a.size()) {
            return this.f35204a.get(i5);
        }
        return null;
    }

    public int l() {
        return this.f35204a.size() / 2;
    }

    public void m(String str) {
        for (int i4 = 0; i4 < this.f35204a.size(); i4 += 2) {
            if (str.equalsIgnoreCase(this.f35204a.get(i4))) {
                this.f35204a.remove(i4);
                this.f35204a.remove(i4);
            }
        }
    }

    public void n(String str, String str2) {
        m(str);
        a(str, str2);
    }

    public void o(String str) {
        String trim = str.trim();
        this.f35205b = trim;
        if (trim != null && trim.startsWith("HTTP/")) {
            String trim2 = trim.trim();
            int indexOf = trim2.indexOf(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR) + 1;
            if (indexOf == 0) {
                return;
            }
            if (trim2.charAt(indexOf - 2) != '1') {
                this.f35206c = 0;
            }
            int i4 = indexOf + 3;
            if (i4 > trim2.length()) {
                i4 = trim2.length();
            }
            this.f35207d = Integer.parseInt(trim2.substring(indexOf, i4));
            int i5 = i4 + 1;
            if (i5 <= trim2.length()) {
                this.f35208e = trim2.substring(i5);
            }
        }
    }

    public String p() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(this.f35205b);
        sb.append("\r\n");
        for (int i4 = 0; i4 < this.f35204a.size(); i4 += 2) {
            sb.append(this.f35204a.get(i4));
            sb.append(": ");
            sb.append(this.f35204a.get(i4 + 1));
            sb.append("\r\n");
        }
        sb.append("\r\n");
        return sb.toString();
    }

    public Map<String, List<String>> q() {
        TreeMap treeMap = new TreeMap(f35203f);
        for (int i4 = 0; i4 < this.f35204a.size(); i4 += 2) {
            String str = this.f35204a.get(i4);
            String str2 = this.f35204a.get(i4 + 1);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(str2);
            treeMap.put(str, Collections.unmodifiableList(arrayList));
        }
        String str3 = this.f35205b;
        if (str3 != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str3)));
        }
        return Collections.unmodifiableMap(treeMap);
    }
}
