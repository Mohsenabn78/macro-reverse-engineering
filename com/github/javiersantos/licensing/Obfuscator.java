package com.github.javiersantos.licensing;

/* loaded from: classes3.dex */
public interface Obfuscator {
    String obfuscate(String str, String str2);

    String unobfuscate(String str, String str2) throws ValidationException;
}
