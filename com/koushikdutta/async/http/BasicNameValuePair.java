package com.koushikdutta.async.http;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final String f35025a;

    /* renamed from: b  reason: collision with root package name */
    private final String f35026b;

    public BasicNameValuePair(String str, String str2) {
        if (str != null) {
            this.f35025a = str;
            this.f35026b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        if (!this.f35025a.equals(basicNameValuePair.f35025a) || !TextUtils.equals(this.f35026b, basicNameValuePair.f35026b)) {
            return false;
        }
        return true;
    }

    @Override // com.koushikdutta.async.http.NameValuePair
    public String getName() {
        return this.f35025a;
    }

    @Override // com.koushikdutta.async.http.NameValuePair
    public String getValue() {
        return this.f35026b;
    }

    public int hashCode() {
        return this.f35025a.hashCode() ^ this.f35026b.hashCode();
    }

    public String toString() {
        return this.f35025a + "=" + this.f35026b;
    }
}
