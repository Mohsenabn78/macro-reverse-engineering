package com.sun.activation.registries;

/* loaded from: classes6.dex */
public class MimeTypeEntry {

    /* renamed from: a  reason: collision with root package name */
    private String f37565a;

    /* renamed from: b  reason: collision with root package name */
    private String f37566b;

    public MimeTypeEntry(String str, String str2) {
        this.f37565a = str;
        this.f37566b = str2;
    }

    public String getFileExtension() {
        return this.f37566b;
    }

    public String getMIMEType() {
        return this.f37565a;
    }

    public String toString() {
        return "MIMETypeEntry: " + this.f37565a + ", " + this.f37566b;
    }
}
