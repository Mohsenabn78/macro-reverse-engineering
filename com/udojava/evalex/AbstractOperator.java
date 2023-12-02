package com.udojava.evalex;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;

/* loaded from: classes6.dex */
public abstract class AbstractOperator extends AbstractLazyOperator implements Operator {

    /* loaded from: classes6.dex */
    class a implements Expression.LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Expression.LazyNumber f38154a;

        a(Expression.LazyNumber lazyNumber) {
            this.f38154a = lazyNumber;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return AbstractOperator.this.eval(this.f38154a.eval(), (BigDecimal) null);
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(AbstractOperator.this.eval(this.f38154a.eval(), (BigDecimal) null));
        }
    }

    /* loaded from: classes6.dex */
    class b implements Expression.LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Expression.LazyNumber f38156a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Expression.LazyNumber f38157b;

        b(Expression.LazyNumber lazyNumber, Expression.LazyNumber lazyNumber2) {
            this.f38156a = lazyNumber;
            this.f38157b = lazyNumber2;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return AbstractOperator.this.eval(this.f38156a.eval(), this.f38157b.eval());
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(AbstractOperator.this.eval(this.f38156a.eval(), this.f38157b.eval()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractOperator(String str, int i4, boolean z3, boolean z4, boolean z5) {
        super(str, i4, z3, z4, z5);
    }

    @Override // com.udojava.evalex.LazyOperator
    public Expression.LazyNumber eval(Expression.LazyNumber lazyNumber, Expression.LazyNumber lazyNumber2) {
        if (lazyNumber2 == null) {
            return new a(lazyNumber);
        }
        return new b(lazyNumber, lazyNumber2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractOperator(String str, int i4, boolean z3, boolean z4) {
        super(str, i4, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractOperator(String str, int i4, boolean z3) {
        super(str, i4, z3);
    }
}
