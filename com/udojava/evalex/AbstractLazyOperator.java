package com.udojava.evalex;

/* loaded from: classes6.dex */
public abstract class AbstractLazyOperator implements LazyOperator {

    /* renamed from: a  reason: collision with root package name */
    protected String f38149a;

    /* renamed from: b  reason: collision with root package name */
    protected int f38150b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f38151c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f38152d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f38153e;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractLazyOperator(String str, int i4, boolean z3, boolean z4, boolean z5) {
        this.f38149a = str;
        this.f38150b = i4;
        this.f38151c = z3;
        this.f38152d = z4;
        this.f38153e = z5;
    }

    @Override // com.udojava.evalex.LazyOperator
    public String getOper() {
        return this.f38149a;
    }

    @Override // com.udojava.evalex.LazyOperator
    public int getPrecedence() {
        return this.f38150b;
    }

    @Override // com.udojava.evalex.LazyOperator
    public boolean isBooleanOperator() {
        return this.f38152d;
    }

    @Override // com.udojava.evalex.LazyOperator
    public boolean isLeftAssoc() {
        return this.f38151c;
    }

    @Override // com.udojava.evalex.LazyOperator
    public boolean isUnaryOperator() {
        return this.f38153e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractLazyOperator(String str, int i4, boolean z3, boolean z4) {
        this.f38149a = str;
        this.f38150b = i4;
        this.f38151c = z3;
        this.f38152d = z4;
        this.f38153e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractLazyOperator(String str, int i4, boolean z3) {
        this.f38152d = false;
        this.f38149a = str;
        this.f38150b = i4;
        this.f38151c = z3;
        this.f38153e = false;
    }
}
