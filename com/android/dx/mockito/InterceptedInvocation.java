package com.android.dx.mockito;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.exceptions.VerificationAwareInvocation;
import org.mockito.internal.invocation.ArgumentsProcessor;
import org.mockito.internal.invocation.MockitoMethod;
import org.mockito.internal.reporting.PrintSettings;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.Location;
import org.mockito.invocation.StubInfo;

/* loaded from: classes2.dex */
class InterceptedInvocation implements Invocation, VerificationAwareInvocation {
    private final Object[] arguments;
    private boolean isIgnoredForVerification;
    private final Location location = new LocationImpl();
    private final MockitoMethod method;
    private final Object mock;
    private final Object[] rawArguments;
    private final int sequenceNumber;
    private StubInfo stubInfo;
    private final SuperMethod superMethod;
    private boolean verified;

    /* loaded from: classes2.dex */
    interface SuperMethod extends Serializable {
        Object invoke() throws Throwable;

        boolean isInvokable();
    }

    InterceptedInvocation(Object obj, MockitoMethod mockitoMethod, Object[] objArr, SuperMethod superMethod, int i4) {
        this.mock = obj;
        this.method = mockitoMethod;
        this.arguments = ArgumentsProcessor.expandArgs(mockitoMethod, objArr);
        this.rawArguments = objArr;
        this.superMethod = superMethod;
        this.sequenceNumber = i4;
    }

    private boolean equalArguments(Object[] objArr) {
        return Arrays.equals(objArr, this.arguments);
    }

    @Override // org.mockito.invocation.InvocationOnMock
    public Object callRealMethod() throws Throwable {
        if (this.superMethod.isInvokable()) {
            return this.superMethod.invoke();
        }
        throw Reporter.cannotCallAbstractRealMethod();
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        InterceptedInvocation interceptedInvocation = (InterceptedInvocation) obj;
        if (!this.mock.equals(interceptedInvocation.mock) || !this.method.equals(interceptedInvocation.method) || !equalArguments(interceptedInvocation.arguments)) {
            return false;
        }
        return true;
    }

    @Override // org.mockito.invocation.InvocationOnMock
    public <T> T getArgument(int i4) {
        return (T) this.arguments[i4];
    }

    @Override // org.mockito.invocation.InvocationOnMock
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override // org.mockito.invocation.Invocation, org.mockito.invocation.DescribedInvocation
    public Location getLocation() {
        return this.location;
    }

    @Override // org.mockito.invocation.InvocationOnMock
    public Method getMethod() {
        return this.method.getJavaMethod();
    }

    @Override // org.mockito.invocation.InvocationOnMock
    public Object getMock() {
        return this.mock;
    }

    @Override // org.mockito.invocation.Invocation
    public Object[] getRawArguments() {
        return this.rawArguments;
    }

    @Override // org.mockito.invocation.Invocation
    public Class<?> getRawReturnType() {
        return this.method.getReturnType();
    }

    @Override // org.mockito.invocation.Invocation
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public int hashCode() {
        return 1;
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

    @Override // org.mockito.invocation.DescribedInvocation
    public String toString() {
        return new PrintSettings().print(ArgumentsProcessor.argumentsToMatchers(getArguments()), this);
    }
}
