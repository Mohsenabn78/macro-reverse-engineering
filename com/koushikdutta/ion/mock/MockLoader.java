package com.koushikdutta.ion.mock;

import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.future.ResponseFuture;
import com.koushikdutta.ion.loader.SimpleLoader;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public class MockLoader extends SimpleLoader {

    /* renamed from: a  reason: collision with root package name */
    MockRequestHandler f36088a;

    private MockLoader(MockRequestHandler mockRequestHandler) {
        this.f36088a = mockRequestHandler;
    }

    public static void install(Ion ion, MockRequestHandler mockRequestHandler) {
        MockLoader mockLoader = new MockLoader(mockRequestHandler);
        for (Loader loader : ion.configure().getLoaders()) {
            if (loader instanceof MockLoader) {
                throw new RuntimeException("MockLoader already installed.");
            }
        }
        ion.configure().addLoader(0, mockLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public <T> ResponseFuture<T> load(Ion ion, AsyncHttpRequest asyncHttpRequest, Type type) {
        Object request = this.f36088a.request(asyncHttpRequest.getUri().toString());
        if (request != null) {
            MockResponseFuture mockResponseFuture = new MockResponseFuture(asyncHttpRequest);
            mockResponseFuture.setComplete((MockResponseFuture) request);
            return mockResponseFuture;
        }
        return super.load(ion, asyncHttpRequest, type);
    }
}
