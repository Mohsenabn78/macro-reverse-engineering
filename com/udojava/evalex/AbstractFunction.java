package com.udojava.evalex;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class AbstractFunction extends AbstractLazyFunction implements Function {

    /* loaded from: classes6.dex */
    class a implements Expression.LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        private List<BigDecimal> f38143a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f38144b;

        a(List list) {
            this.f38144b = list;
        }

        private List<BigDecimal> a() {
            if (this.f38143a == null) {
                this.f38143a = new ArrayList();
                for (Expression.LazyNumber lazyNumber : this.f38144b) {
                    this.f38143a.add(lazyNumber.eval());
                }
            }
            return this.f38143a;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return AbstractFunction.this.eval(a());
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(AbstractFunction.this.eval(a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractFunction(String str, int i4) {
        super(str, i4);
    }

    @Override // com.udojava.evalex.LazyFunction
    public Expression.LazyNumber lazyEval(List<Expression.LazyNumber> list) {
        return new a(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractFunction(String str, int i4, boolean z3) {
        super(str, i4, z3);
    }
}
