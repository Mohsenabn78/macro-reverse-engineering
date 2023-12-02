package com.arlosoft.macrodroid.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class LocaleUtils {

    /* renamed from: b  reason: collision with root package name */
    private static Set f16058b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map f16059c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    private static final Map f16060d = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    private static final List f16057a = Collections.unmodifiableList(Arrays.asList(Locale.getAvailableLocales()));

    public static List availableLocaleList() {
        return f16057a;
    }

    public static Set availableLocaleSet() {
        Set set = f16058b;
        if (set == null) {
            Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(availableLocaleList()));
            f16058b = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    public static List countriesByLanguage(String str) {
        List list = (List) f16060d.get(str);
        if (list == null) {
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                List availableLocaleList = availableLocaleList();
                for (int i4 = 0; i4 < availableLocaleList.size(); i4++) {
                    Locale locale = (Locale) availableLocaleList.get(i4);
                    if (str.equals(locale.getLanguage()) && locale.getCountry().length() != 0 && locale.getVariant().length() == 0) {
                        arrayList.add(locale);
                    }
                }
                list = Collections.unmodifiableList(arrayList);
            } else {
                list = Collections.EMPTY_LIST;
            }
            f16060d.put(str, list);
        }
        return list;
    }

    public static boolean isAvailableLocale(Locale locale) {
        return availableLocaleList().contains(locale);
    }

    public static List languagesByCountry(String str) {
        List list = (List) f16059c.get(str);
        if (list == null) {
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                List availableLocaleList = availableLocaleList();
                for (int i4 = 0; i4 < availableLocaleList.size(); i4++) {
                    Locale locale = (Locale) availableLocaleList.get(i4);
                    if (str.equals(locale.getCountry()) && locale.getVariant().length() == 0) {
                        arrayList.add(locale);
                    }
                }
                list = Collections.unmodifiableList(arrayList);
            } else {
                list = Collections.EMPTY_LIST;
            }
            f16059c.put(str, list);
        }
        return list;
    }

    public static List localeLookupList(Locale locale) {
        return localeLookupList(locale, locale);
    }

    public static Locale toLocale(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.equals("zh-rCN")) {
                return Locale.SIMPLIFIED_CHINESE;
            }
            int length = str.length();
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(1);
            if (charAt >= 'a' && charAt <= 'z' && charAt2 >= 'a' && charAt2 <= 'z') {
                if (length == 2) {
                    return new Locale(str, "");
                }
                if (str.charAt(2) == '_') {
                    char charAt3 = str.charAt(3);
                    if (charAt3 == '_') {
                        return new Locale(str.substring(0, 2), "", str.substring(4));
                    }
                    char charAt4 = str.charAt(4);
                    if (charAt3 >= 'A' && charAt3 <= 'Z' && charAt4 >= 'A' && charAt4 <= 'Z') {
                        if (length == 5) {
                            return new Locale(str.substring(0, 2), str.substring(3, 5));
                        }
                        if (str.charAt(5) == '_') {
                            return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
                        }
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    }
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            throw new IllegalArgumentException("Invalid locale format: " + str);
        } catch (Exception unused) {
            return Locale.getDefault();
        }
    }

    public static List localeLookupList(Locale locale, Locale locale2) {
        ArrayList arrayList = new ArrayList(4);
        if (locale != null) {
            arrayList.add(locale);
            if (locale.getVariant().length() > 0) {
                arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
            }
            if (locale.getCountry().length() > 0) {
                arrayList.add(new Locale(locale.getLanguage(), ""));
            }
            if (!arrayList.contains(locale2)) {
                arrayList.add(locale2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
