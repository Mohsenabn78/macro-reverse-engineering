package com.afollestad.materialdialogs.util;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes2.dex */
public class TypefaceHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleArrayMap<String, Typeface> f1206a = new SimpleArrayMap<>();

    public static Typeface get(Context context, String str) {
        SimpleArrayMap<String, Typeface> simpleArrayMap = f1206a;
        synchronized (simpleArrayMap) {
            if (!simpleArrayMap.containsKey(str)) {
                try {
                    Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", str));
                    simpleArrayMap.put(str, createFromAsset);
                    return createFromAsset;
                } catch (RuntimeException unused) {
                    return null;
                }
            }
            return simpleArrayMap.get(str);
        }
    }
}
