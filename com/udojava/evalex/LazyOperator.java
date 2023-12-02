package com.udojava.evalex;

import com.udojava.evalex.Expression;

/* loaded from: classes6.dex */
public interface LazyOperator {
    Expression.LazyNumber eval(Expression.LazyNumber lazyNumber, Expression.LazyNumber lazyNumber2);

    String getOper();

    int getPrecedence();

    boolean isBooleanOperator();

    boolean isLeftAssoc();

    boolean isUnaryOperator();
}
