package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class RegexCache {

    /* renamed from: a  reason: collision with root package name */
    private LRUCache<String, Pattern> f32888a;

    /* loaded from: classes5.dex */
    private static class LRUCache<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private LinkedHashMap<K, V> f32889a;

        /* renamed from: b  reason: collision with root package name */
        private int f32890b;

        public LRUCache(int i4) {
            this.f32890b = i4;
            this.f32889a = new LinkedHashMap<K, V>(((i4 * 4) / 3) + 1, 0.75f, true) { // from class: com.google.i18n.phonenumbers.RegexCache.LRUCache.1
                @Override // java.util.LinkedHashMap
                protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    if (size() > LRUCache.this.f32890b) {
                        return true;
                    }
                    return false;
                }
            };
        }

        public synchronized V b(K k4) {
            return this.f32889a.get(k4);
        }

        public synchronized void c(K k4, V v3) {
            this.f32889a.put(k4, v3);
        }
    }

    public RegexCache(int i4) {
        this.f32888a = new LRUCache<>(i4);
    }

    public Pattern getPatternForRegex(String str) {
        Pattern b4 = this.f32888a.b(str);
        if (b4 == null) {
            Pattern compile = Pattern.compile(str);
            this.f32888a.c(str, compile);
            return compile;
        }
        return b4;
    }
}
