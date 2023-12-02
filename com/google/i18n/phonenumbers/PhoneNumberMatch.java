package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonenumber;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class PhoneNumberMatch {

    /* renamed from: a  reason: collision with root package name */
    private final int f32823a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32824b;

    /* renamed from: c  reason: collision with root package name */
    private final Phonenumber.PhoneNumber f32825c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneNumberMatch(int i4, String str, Phonenumber.PhoneNumber phoneNumber) {
        if (i4 >= 0) {
            if (str != null && phoneNumber != null) {
                this.f32823a = i4;
                this.f32824b = str;
                this.f32825c = phoneNumber;
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException("Start index must be >= 0.");
    }

    public int end() {
        return this.f32823a + this.f32824b.length();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNumberMatch)) {
            return false;
        }
        PhoneNumberMatch phoneNumberMatch = (PhoneNumberMatch) obj;
        if (this.f32824b.equals(phoneNumberMatch.f32824b) && this.f32823a == phoneNumberMatch.f32823a && this.f32825c.equals(phoneNumberMatch.f32825c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f32823a), this.f32824b, this.f32825c});
    }

    public Phonenumber.PhoneNumber number() {
        return this.f32825c;
    }

    public String rawString() {
        return this.f32824b;
    }

    public int start() {
        return this.f32823a;
    }

    public String toString() {
        return "PhoneNumberMatch [" + start() + "," + end() + ") " + this.f32824b;
    }
}
