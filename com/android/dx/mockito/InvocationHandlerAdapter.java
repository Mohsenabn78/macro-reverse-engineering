package com.android.dx.mockito;

import com.android.dx.stock.ProxyBuilder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.mockito.internal.creation.DelegatingMethod;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.exceptions.VerificationAwareInvocation;
import org.mockito.internal.invocation.ArgumentsProcessor;
import org.mockito.internal.progress.SequenceNumber;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.Location;
import org.mockito.invocation.MockHandler;
import org.mockito.invocation.StubInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class InvocationHandlerAdapter implements InvocationHandler {
    private MockHandler handler;

    /* loaded from: classes2.dex */
    private class ProxyInvocation implements Invocation, VerificationAwareInvocation {
        private final Object[] args;
        private boolean isIgnoredForVerification;
        private final Location location;
        private final Method method;
        private final Object proxy;
        private final Object[] rawArgs;
        private final int sequenceNumber;
        private StubInfo stubInfo;
        private boolean verified;

        @Override // org.mockito.invocation.InvocationOnMock
        public Object callRealMethod() throws Throwable {
            if (!Modifier.isAbstract(this.method.getModifiers())) {
                return ProxyBuilder.callSuper(this.proxy, this.method, this.rawArgs);
            }
            throw Reporter.cannotCallAbstractRealMethod();
        }

        @Override // org.mockito.invocation.InvocationOnMock
        public <T> T getArgument(int i4) {
            return (T) this.args[i4];
        }

        @Override // org.mockito.invocation.InvocationOnMock
        public Object[] getArguments() {
            return this.args;
        }

        @Override // org.mockito.invocation.Invocation, org.mockito.invocation.DescribedInvocation
        public Location getLocation() {
            return this.location;
        }

        @Override // org.mockito.invocation.InvocationOnMock
        public Method getMethod() {
            return this.method;
        }

        @Override // org.mockito.invocation.InvocationOnMock
        public Object getMock() {
            return this.proxy;
        }

        @Override // org.mockito.invocation.Invocation
        public Object[] getRawArguments() {
            return this.rawArgs;
        }

        @Override // org.mockito.invocation.Invocation
        public Class<?> getRawReturnType() {
            return this.method.getReturnType();
        }

        @Override // org.mockito.invocation.Invocation
        public int getSequenceNumber() {
            return this.sequenceNumber;
        }

        @Override // org.mockito.invocation.Invocation
        public void ignoreForVerification() {
            this.isIgnoredForVerification = true;
        }

        @Override // org.mockito.invocation.Invocation
        public boolean isIgnoredForVerification() {
            return this.isIgnoredForVerification;
        }

        @Override // org.mockito.invocation.Invocation, org.mockito.internal.exceptions.VerificationAwareInvocation
        public boolean isVerified() {
            if (!this.verified && !this.isIgnoredForVerification) {
                return false;
            }
            return true;
        }

        @Override // org.mockito.invocation.Invocation
        public void markStubbed(StubInfo stubInfo) {
            this.stubInfo = stubInfo;
        }

        @Override // org.mockito.invocation.Invocation
        public void markVerified() {
            this.verified = true;
        }

        @Override // org.mockito.invocation.Invocation
        public StubInfo stubInfo() {
            return this.stubInfo;
        }

        private ProxyInvocation(Object obj, Method method, Object[] objArr, DelegatingMethod delegatingMethod, int i4, Location location) {
            this.rawArgs = objArr;
            this.proxy = obj;
            this.method = method;
            this.sequenceNumber = i4;
            this.location = location;
            this.args = ArgumentsProcessor.expandArgs(delegatingMethod, objArr);
        }
    }

    public InvocationHandlerAdapter(MockHandler mockHandler) {
        this.handler = mockHandler;
    }

    private static boolean isEqualsMethod(Method method) {
        if (!method.getName().equals("equals") || method.getParameterTypes().length != 1 || method.getParameterTypes()[0] != Object.class) {
            return false;
        }
        return true;
    }

    private static boolean isHashCodeMethod(Method method) {
        if (method.getName().equals("hashCode") && method.getParameterTypes().length == 0) {
            return true;
        }
        return false;
    }

    public MockHandler getHandler() {
        return this.handler;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z3 = false;
        if (objArr == null) {
            objArr = new Object[0];
        }
        Object[] objArr2 = objArr;
        if (isEqualsMethod(method)) {
            if (obj == objArr2[0]) {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        } else if (isHashCodeMethod(method)) {
            return Integer.valueOf(System.identityHashCode(obj));
        } else {
            return this.handler.handle(new ProxyInvocation(obj, method, objArr2, new DelegatingMethod(method), SequenceNumber.next(), new LocationImpl()));
        }
    }

    public void setHandler(MockHandler mockHandler) {
        this.handler = mockHandler;
    }
}
