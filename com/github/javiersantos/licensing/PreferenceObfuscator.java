package com.github.javiersantos.licensing;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;

/* loaded from: classes3.dex */
public class PreferenceObfuscator {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f18392a;

    /* renamed from: b  reason: collision with root package name */
    private final Obfuscator f18393b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences.Editor f18394c = null;

    public PreferenceObfuscator(SharedPreferences sharedPreferences, Obfuscator obfuscator) {
        this.f18392a = sharedPreferences;
        this.f18393b = obfuscator;
    }

    public void commit() {
        SharedPreferences.Editor editor = this.f18394c;
        if (editor != null) {
            editor.commit();
            this.f18394c = null;
        }
    }

    public String getString(String str, String str2) {
        String string = this.f18392a.getString(str, null);
        if (string != null) {
            try {
                return this.f18393b.unobfuscate(string, str);
            } catch (ValidationException unused) {
                Log.w("PreferenceObfuscator", "Validation error while reading preference: " + str);
                return str2;
            }
        }
        return str2;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void putString(String str, String str2) {
        if (this.f18394c == null) {
            this.f18394c = this.f18392a.edit();
        }
        this.f18394c.putString(str, this.f18393b.obfuscate(str2, str));
    }
}
