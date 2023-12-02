package com.udojava.evalex;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;

/* loaded from: classes6.dex */
public abstract class AbstractUnaryOperator extends AbstractOperator {

    /* loaded from: classes6.dex */
    class a implements Expression.LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Expression.LazyNumber f38159a;

        a(Expression.LazyNumber lazyNumber) {
            this.f38159a = lazyNumber;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return AbstractUnaryOperator.this.evalUnary(this.f38159a.eval());
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(AbstractUnaryOperator.this.evalUnary(this.f38159a.eval()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractUnaryOperator(String str, int i4, boolean z3) {
        super(str, i4, z3);
    }

    @Override // com.udojava.evalex.AbstractOperator, com.udojava.evalex.LazyOperator
    public Expression.LazyNumber eval(Expression.LazyNumber lazyNumber, Expression.LazyNumber lazyNumber2) {
        if (lazyNumber2 == null) {
            return new a(lazyNumber);
        }
        throw new Expression.ExpressionException("Did not expect a second parameter for unary operator");
    }

    public abstract BigDecimal evalUnary(BigDecimal bigDecimal);

    @Override // com.udojava.evalex.Operator
    public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal2 == null) {
            return evalUnary(bigDecimal);
        }
        throw new Expression.ExpressionException("Did not expect a second parameter for unary operator");
    }
}
