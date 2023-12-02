package com.udojava.evalex;

import com.udojava.evalex.Expression;
import java.util.List;

/* loaded from: classes6.dex */
public interface LazyFunction {
    String getName();

    int getNumParams();

    boolean isBooleanFunction();

    Expression.LazyNumber lazyEval(List<Expression.LazyNumber> list);

    boolean numParamsVaries();
}
