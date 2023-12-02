package com.udojava.evalex;

import java.math.BigDecimal;

/* loaded from: classes6.dex */
public interface Operator extends LazyOperator {
    BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2);
}
