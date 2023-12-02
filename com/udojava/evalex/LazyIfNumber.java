package com.udojava.evalex;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;
import java.util.List;

/* loaded from: classes6.dex */
public class LazyIfNumber implements Expression.LazyNumber {

    /* renamed from: a  reason: collision with root package name */
    private List<Expression.LazyNumber> f38291a;

    public LazyIfNumber(List<Expression.LazyNumber> list) {
        this.f38291a = list;
    }

    private void a(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            return;
        }
        throw new ArithmeticException("Operand may not be null");
    }

    @Override // com.udojava.evalex.Expression.LazyNumber
    public BigDecimal eval() {
        Expression.LazyNumber lazyNumber;
        boolean z3 = false;
        BigDecimal eval = this.f38291a.get(0).eval();
        a(eval);
        if (eval.compareTo(BigDecimal.ZERO) != 0) {
            z3 = true;
        }
        List<Expression.LazyNumber> list = this.f38291a;
        if (z3) {
            lazyNumber = list.get(1);
        } else {
            lazyNumber = list.get(2);
        }
        return lazyNumber.eval();
    }

    @Override // com.udojava.evalex.Expression.LazyNumber
    public String getString() {
        return this.f38291a.get(0).getString();
    }
}
