package com.udojava.evalex;

import java.util.Locale;

/* loaded from: classes6.dex */
public abstract class AbstractLazyFunction implements LazyFunction {

    /* renamed from: a  reason: collision with root package name */
    protected String f38146a;

    /* renamed from: b  reason: collision with root package name */
    protected int f38147b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f38148c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractLazyFunction(String str, int i4, boolean z3) {
        this.f38146a = str.toUpperCase(Locale.ROOT);
        this.f38147b = i4;
        this.f38148c = z3;
    }

    @Override // com.udojava.evalex.LazyFunction
    public String getName() {
        return this.f38146a;
    }

    @Override // com.udojava.evalex.LazyFunction
    public int getNumParams() {
        return this.f38147b;
    }

    @Override // com.udojava.evalex.LazyFunction
    public boolean isBooleanFunction() {
        return this.f38148c;
    }

    @Override // com.udojava.evalex.LazyFunction
    public boolean numParamsVaries() {
        if (this.f38147b < 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractLazyFunction(String str, int i4) {
        this(str, i4, false);
    }
}
