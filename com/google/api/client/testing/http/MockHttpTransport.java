package com.google.api.client.testing.http;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Beta
/* loaded from: classes5.dex */
public class MockHttpTransport extends HttpTransport {

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f26017c;

    /* renamed from: d  reason: collision with root package name */
    private MockLowLevelHttpRequest f26018d;

    /* renamed from: e  reason: collision with root package name */
    private MockLowLevelHttpResponse f26019e;

    @Beta
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Set<String> f26020a;

        /* renamed from: b  reason: collision with root package name */
        MockLowLevelHttpRequest f26021b;

        /* renamed from: c  reason: collision with root package name */
        MockLowLevelHttpResponse f26022c;

        public MockHttpTransport build() {
            return new MockHttpTransport(this);
        }

        public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
            return this.f26021b;
        }

        public final Set<String> getSupportedMethods() {
            return this.f26020a;
        }

        public final Builder setLowLevelHttpRequest(MockLowLevelHttpRequest mockLowLevelHttpRequest) {
            boolean z3;
            if (this.f26022c == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Cannnot set a low level HTTP request when a low level HTTP response has been set.");
            this.f26021b = mockLowLevelHttpRequest;
            return this;
        }

        public final Builder setLowLevelHttpResponse(MockLowLevelHttpResponse mockLowLevelHttpResponse) {
            boolean z3;
            if (this.f26021b == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Cannot set a low level HTTP response when a low level HTTP request has been set.");
            this.f26022c = mockLowLevelHttpResponse;
            return this;
        }

        public final Builder setSupportedMethods(Set<String> set) {
            this.f26020a = set;
            return this;
        }
    }

    public MockHttpTransport() {
    }

    @Deprecated
    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        Preconditions.checkArgument(supportsMethod(str), "HTTP method %s not supported", str);
        MockLowLevelHttpRequest mockLowLevelHttpRequest = this.f26018d;
        if (mockLowLevelHttpRequest != null) {
            return mockLowLevelHttpRequest;
        }
        MockLowLevelHttpRequest mockLowLevelHttpRequest2 = new MockLowLevelHttpRequest(str2);
        MockLowLevelHttpResponse mockLowLevelHttpResponse = this.f26019e;
        if (mockLowLevelHttpResponse != null) {
            mockLowLevelHttpRequest2.setResponse(mockLowLevelHttpResponse);
        }
        return mockLowLevelHttpRequest2;
    }

    public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
        return this.f26018d;
    }

    public final Set<String> getSupportedMethods() {
        Set<String> set = this.f26017c;
        if (set == null) {
            return null;
        }
        return Collections.unmodifiableSet(set);
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) throws IOException {
        Set<String> set = this.f26017c;
        if (set != null && !set.contains(str)) {
            return false;
        }
        return true;
    }

    protected MockHttpTransport(Builder builder) {
        this.f26017c = builder.f26020a;
        this.f26018d = builder.f26021b;
        this.f26019e = builder.f26022c;
    }
}
