package com.google.api.client.auth.openidconnect;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import java.util.Collection;
import java.util.Collections;

@Beta
/* loaded from: classes5.dex */
public class IdTokenVerifier {
    public static final long DEFAULT_TIME_SKEW_SECONDS = 300;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f25532a;

    /* renamed from: b  reason: collision with root package name */
    private final long f25533b;

    /* renamed from: c  reason: collision with root package name */
    private final Collection<String> f25534c;

    /* renamed from: d  reason: collision with root package name */
    private final Collection<String> f25535d;

    @Beta
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Clock f25536a = Clock.SYSTEM;

        /* renamed from: b  reason: collision with root package name */
        long f25537b = 300;

        /* renamed from: c  reason: collision with root package name */
        Collection<String> f25538c;

        /* renamed from: d  reason: collision with root package name */
        Collection<String> f25539d;

        public IdTokenVerifier build() {
            return new IdTokenVerifier(this);
        }

        public final long getAcceptableTimeSkewSeconds() {
            return this.f25537b;
        }

        public final Collection<String> getAudience() {
            return this.f25539d;
        }

        public final Clock getClock() {
            return this.f25536a;
        }

        public final String getIssuer() {
            Collection<String> collection = this.f25538c;
            if (collection == null) {
                return null;
            }
            return collection.iterator().next();
        }

        public final Collection<String> getIssuers() {
            return this.f25538c;
        }

        public Builder setAcceptableTimeSkewSeconds(long j4) {
            boolean z3;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f25537b = j4;
            return this;
        }

        public Builder setAudience(Collection<String> collection) {
            this.f25539d = collection;
            return this;
        }

        public Builder setClock(Clock clock) {
            this.f25536a = (Clock) Preconditions.checkNotNull(clock);
            return this;
        }

        public Builder setIssuer(String str) {
            if (str == null) {
                return setIssuers(null);
            }
            return setIssuers(Collections.singleton(str));
        }

        public Builder setIssuers(Collection<String> collection) {
            boolean z3;
            if (collection != null && collection.isEmpty()) {
                z3 = false;
            } else {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "Issuers must not be empty");
            this.f25538c = collection;
            return this;
        }
    }

    public IdTokenVerifier() {
        this(new Builder());
    }

    public final long getAcceptableTimeSkewSeconds() {
        return this.f25533b;
    }

    public final Collection<String> getAudience() {
        return this.f25535d;
    }

    public final Clock getClock() {
        return this.f25532a;
    }

    public final String getIssuer() {
        Collection<String> collection = this.f25534c;
        if (collection == null) {
            return null;
        }
        return collection.iterator().next();
    }

    public final Collection<String> getIssuers() {
        return this.f25534c;
    }

    public boolean verify(IdToken idToken) {
        Collection<String> collection;
        Collection<String> collection2 = this.f25534c;
        if ((collection2 == null || idToken.verifyIssuer(collection2)) && (((collection = this.f25535d) == null || idToken.verifyAudience(collection)) && idToken.verifyTime(this.f25532a.currentTimeMillis(), this.f25533b))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IdTokenVerifier(Builder builder) {
        this.f25532a = builder.f25536a;
        this.f25533b = builder.f25537b;
        Collection<String> collection = builder.f25538c;
        this.f25534c = collection == null ? null : Collections.unmodifiableCollection(collection);
        Collection<String> collection2 = builder.f25539d;
        this.f25535d = collection2 != null ? Collections.unmodifiableCollection(collection2) : null;
    }
}
