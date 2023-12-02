package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;
import javax.annotation.CheckForNull;

@Immutable
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class InternetDomainName {

    /* renamed from: e  reason: collision with root package name */
    private static final CharMatcher f28108e = CharMatcher.anyOf(".。．｡");

    /* renamed from: f  reason: collision with root package name */
    private static final Splitter f28109f = Splitter.on('.');

    /* renamed from: g  reason: collision with root package name */
    private static final Joiner f28110g = Joiner.on('.');

    /* renamed from: h  reason: collision with root package name */
    private static final CharMatcher f28111h;

    /* renamed from: i  reason: collision with root package name */
    private static final CharMatcher f28112i;

    /* renamed from: j  reason: collision with root package name */
    private static final CharMatcher f28113j;

    /* renamed from: k  reason: collision with root package name */
    private static final CharMatcher f28114k;

    /* renamed from: a  reason: collision with root package name */
    private final String f28115a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<String> f28116b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28117c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28118d;

    static {
        CharMatcher anyOf = CharMatcher.anyOf("-_");
        f28111h = anyOf;
        CharMatcher inRange = CharMatcher.inRange('0', '9');
        f28112i = inRange;
        CharMatcher or = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z'));
        f28113j = or;
        f28114k = inRange.or(or).or(anyOf);
    }

    InternetDomainName(String str) {
        boolean z3;
        String lowerCase = Ascii.toLowerCase(f28108e.replaceFrom((CharSequence) str, '.'));
        lowerCase = lowerCase.endsWith(".") ? lowerCase.substring(0, lowerCase.length() - 1) : lowerCase;
        if (lowerCase.length() <= 253) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Domain name too long: '%s':", lowerCase);
        this.f28115a = lowerCase;
        ImmutableList<String> copyOf = ImmutableList.copyOf(f28109f.split(lowerCase));
        this.f28116b = copyOf;
        Preconditions.checkArgument(copyOf.size() <= 127, "Domain has too many parts: '%s'", lowerCase);
        Preconditions.checkArgument(f(copyOf), "Not a valid domain name: '%s'", lowerCase);
        this.f28117c = b(Optional.absent());
        this.f28118d = b(Optional.of(PublicSuffixType.REGISTRY));
    }

    private InternetDomainName a(int i4) {
        Joiner joiner = f28110g;
        ImmutableList<String> immutableList = this.f28116b;
        return from(joiner.join(immutableList.subList(i4, immutableList.size())));
    }

    private int b(Optional<PublicSuffixType> optional) {
        int size = this.f28116b.size();
        for (int i4 = 0; i4 < size; i4++) {
            String join = f28110g.join(this.f28116b.subList(i4, size));
            if (c(optional, Optional.fromNullable(PublicSuffixPatterns.EXACT.get(join)))) {
                return i4;
            }
            if (PublicSuffixPatterns.EXCLUDED.containsKey(join)) {
                return i4 + 1;
            }
            if (d(optional, join)) {
                return i4;
            }
        }
        return -1;
    }

    private static boolean c(Optional<PublicSuffixType> optional, Optional<PublicSuffixType> optional2) {
        if (optional.isPresent()) {
            return optional.equals(optional2);
        }
        return optional2.isPresent();
    }

    private static boolean d(Optional<PublicSuffixType> optional, String str) {
        List<String> splitToList = f28109f.limit(2).splitToList(str);
        if (splitToList.size() == 2 && c(optional, Optional.fromNullable(PublicSuffixPatterns.UNDER.get(splitToList.get(1))))) {
            return true;
        }
        return false;
    }

    private static boolean e(String str, boolean z3) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!f28114k.matchesAllOf(CharMatcher.ascii().retainFrom(str))) {
                return false;
            }
            CharMatcher charMatcher = f28111h;
            if (!charMatcher.matches(str.charAt(0)) && !charMatcher.matches(str.charAt(str.length() - 1))) {
                if (z3 && f28112i.matches(str.charAt(0))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private static boolean f(List<String> list) {
        int size = list.size() - 1;
        if (!e(list.get(size), true)) {
            return false;
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (!e(list.get(i4), false)) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public static InternetDomainName from(String str) {
        return new InternetDomainName((String) Preconditions.checkNotNull(str));
    }

    public static boolean isValid(String str) {
        try {
            from(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public InternetDomainName child(String str) {
        return from(((String) Preconditions.checkNotNull(str)) + "." + this.f28115a);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.f28115a.equals(((InternetDomainName) obj).f28115a);
        }
        return false;
    }

    public boolean hasParent() {
        if (this.f28116b.size() > 1) {
            return true;
        }
        return false;
    }

    public boolean hasPublicSuffix() {
        if (this.f28117c != -1) {
            return true;
        }
        return false;
    }

    public boolean hasRegistrySuffix() {
        if (this.f28118d != -1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f28115a.hashCode();
    }

    public boolean isPublicSuffix() {
        if (this.f28117c == 0) {
            return true;
        }
        return false;
    }

    public boolean isRegistrySuffix() {
        if (this.f28118d == 0) {
            return true;
        }
        return false;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        if (this.f28118d == 1) {
            return true;
        }
        return false;
    }

    public boolean isTopPrivateDomain() {
        if (this.f28117c == 1) {
            return true;
        }
        return false;
    }

    public boolean isUnderPublicSuffix() {
        if (this.f28117c > 0) {
            return true;
        }
        return false;
    }

    public boolean isUnderRegistrySuffix() {
        if (this.f28118d > 0) {
            return true;
        }
        return false;
    }

    public InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.f28115a);
        return a(1);
    }

    public ImmutableList<String> parts() {
        return this.f28116b;
    }

    @CheckForNull
    public InternetDomainName publicSuffix() {
        if (hasPublicSuffix()) {
            return a(this.f28117c);
        }
        return null;
    }

    @CheckForNull
    public InternetDomainName registrySuffix() {
        if (hasRegistrySuffix()) {
            return a(this.f28118d);
        }
        return null;
    }

    public String toString() {
        return this.f28115a;
    }

    public InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix()) {
            return this;
        }
        Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.f28115a);
        return a(this.f28118d - 1);
    }

    public InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain()) {
            return this;
        }
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.f28115a);
        return a(this.f28117c - 1);
    }
}
