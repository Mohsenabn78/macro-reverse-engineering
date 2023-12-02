package com.udojava.evalex;

import java.math.BigDecimal;
import java.util.List;

/* loaded from: classes6.dex */
public interface Function extends LazyFunction {
    BigDecimal eval(List<BigDecimal> list);
}
