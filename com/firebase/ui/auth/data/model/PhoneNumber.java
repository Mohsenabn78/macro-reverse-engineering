package com.firebase.ui.auth.data.model;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class PhoneNumber {

    /* renamed from: d  reason: collision with root package name */
    private static final PhoneNumber f17973d = new PhoneNumber("", "", "");

    /* renamed from: a  reason: collision with root package name */
    private final String f17974a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17975b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17976c;

    public PhoneNumber(String str, String str2, String str3) {
        this.f17974a = str;
        this.f17975b = str2;
        this.f17976c = str3;
    }

    public static PhoneNumber emptyPhone() {
        return f17973d;
    }

    public static boolean isCountryValid(PhoneNumber phoneNumber) {
        if (phoneNumber != null && !f17973d.equals(phoneNumber) && !TextUtils.isEmpty(phoneNumber.getCountryCode()) && !TextUtils.isEmpty(phoneNumber.getCountryIso())) {
            return true;
        }
        return false;
    }

    public static boolean isValid(PhoneNumber phoneNumber) {
        if (phoneNumber != null && !f17973d.equals(phoneNumber) && !TextUtils.isEmpty(phoneNumber.getPhoneNumber()) && !TextUtils.isEmpty(phoneNumber.getCountryCode()) && !TextUtils.isEmpty(phoneNumber.getCountryIso())) {
            return true;
        }
        return false;
    }

    public String getCountryCode() {
        return this.f17976c;
    }

    public String getCountryIso() {
        return this.f17975b;
    }

    public String getPhoneNumber() {
        return this.f17974a;
    }
}
