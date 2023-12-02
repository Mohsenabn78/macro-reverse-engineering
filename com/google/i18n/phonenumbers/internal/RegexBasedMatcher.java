package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.RegexCache;
import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public final class RegexBasedMatcher implements MatcherApi {

    /* renamed from: a  reason: collision with root package name */
    private final RegexCache f32901a = new RegexCache(100);

    private RegexBasedMatcher() {
    }

    public static MatcherApi create() {
        return new RegexBasedMatcher();
    }

    @Override // com.google.i18n.phonenumbers.internal.MatcherApi
    public boolean matchesNationalNumber(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc, boolean z3) {
        Matcher matcher = this.f32901a.getPatternForRegex(phoneNumberDesc.getNationalNumberPattern()).matcher(str);
        if (!matcher.matches() && (!z3 || !matcher.lookingAt())) {
            return false;
        }
        return true;
    }
}
