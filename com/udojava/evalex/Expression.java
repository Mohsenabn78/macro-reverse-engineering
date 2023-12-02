package com.udojava.evalex;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import org.slf4j.Marker;

/* loaded from: classes6.dex */
public class Expression {
    public static final String MISSING_PARAMETERS_FOR_OPERATOR = "Missing parameter(s) for operator ";
    public static final int OPERATOR_PRECEDENCE_ADDITIVE = 20;
    public static final int OPERATOR_PRECEDENCE_AND = 4;
    public static final int OPERATOR_PRECEDENCE_COMPARISON = 10;
    public static final int OPERATOR_PRECEDENCE_EQUALITY = 7;
    public static final int OPERATOR_PRECEDENCE_MULTIPLICATIVE = 30;
    public static final int OPERATOR_PRECEDENCE_OR = 2;
    public static final int OPERATOR_PRECEDENCE_POWER = 40;
    public static final int OPERATOR_PRECEDENCE_POWER_HIGHER = 80;
    public static final int OPERATOR_PRECEDENCE_UNARY = 60;
    public static final BigDecimal PI;

    /* renamed from: e  reason: collision with root package name */
    public static final BigDecimal f38161e;

    /* renamed from: l  reason: collision with root package name */
    private static final Map<String, BigDecimal> f38162l;

    /* renamed from: m  reason: collision with root package name */
    private static final LazyNumber f38163m;

    /* renamed from: a  reason: collision with root package name */
    private MathContext f38164a;

    /* renamed from: b  reason: collision with root package name */
    private int f38165b;

    /* renamed from: c  reason: collision with root package name */
    private String f38166c;

    /* renamed from: d  reason: collision with root package name */
    private String f38167d;

    /* renamed from: f  reason: collision with root package name */
    private final String f38168f;

    /* renamed from: g  reason: collision with root package name */
    private String f38169g;

    /* renamed from: h  reason: collision with root package name */
    private List<Token> f38170h;

    /* renamed from: i  reason: collision with root package name */
    protected Map<String, LazyOperator> f38171i;

    /* renamed from: j  reason: collision with root package name */
    protected Map<String, com.udojava.evalex.LazyFunction> f38172j;

    /* renamed from: k  reason: collision with root package name */
    protected Map<String, LazyNumber> f38173k;

    /* loaded from: classes6.dex */
    public static class ExpressionException extends RuntimeException {
        private static final long serialVersionUID = 1118142866870779047L;

        public ExpressionException(String str) {
            super(str);
        }

        public ExpressionException(String str, int i4) {
            super(str + " at character position " + i4);
        }
    }

    /* loaded from: classes6.dex */
    public interface LazyNumber {
        BigDecimal eval();

        String getString();
    }

    /* loaded from: classes6.dex */
    public class Token {
        public int pos;
        public String surface = "";
        public x1 type;

        public Token() {
        }

        public void append(char c4) {
            this.surface += c4;
        }

        public char charAt(int i4) {
            return this.surface.charAt(i4);
        }

        public int length() {
            return this.surface.length();
        }

        public String toString() {
            return this.surface;
        }

        public void append(String str) {
            this.surface += str;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class UnaryOperator extends AbstractUnaryOperator {
        public UnaryOperator(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }
    }

    /* loaded from: classes6.dex */
    class a extends Operator {
        a(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            boolean z3;
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            boolean z4 = true;
            if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return BigDecimal.ONE;
            }
            if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
                z4 = false;
            }
            if (z4) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class a0 extends Function {
        a0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.tan(Math.toRadians(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class a1 extends Function {
        a1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            if (!list.isEmpty()) {
                BigDecimal bigDecimal = null;
                for (BigDecimal bigDecimal2 : list) {
                    Expression.assertNotNull(bigDecimal2);
                    if (bigDecimal == null || bigDecimal2.compareTo(bigDecimal) > 0) {
                        bigDecimal = bigDecimal2;
                    }
                }
                return bigDecimal;
            }
            throw new ExpressionException("MAX requires at least one parameter");
        }
    }

    /* loaded from: classes6.dex */
    class b extends Operator {
        b(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            if (bigDecimal.compareTo(bigDecimal2) == 1) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class b0 extends Function {
        b0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.cos(Math.toRadians(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class b1 extends Function {
        b1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            if (!list.isEmpty()) {
                BigDecimal bigDecimal = null;
                for (BigDecimal bigDecimal2 : list) {
                    Expression.assertNotNull(bigDecimal2);
                    if (bigDecimal == null || bigDecimal2.compareTo(bigDecimal) < 0) {
                        bigDecimal = bigDecimal2;
                    }
                }
                return bigDecimal;
            }
            throw new ExpressionException("MIN requires at least one parameter");
        }
    }

    /* loaded from: classes6.dex */
    class c extends Operator {
        c(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            if (bigDecimal.compareTo(bigDecimal2) >= 0) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class c0 extends Function {
        c0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.sin(Math.toRadians(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class c1 extends Operator {
        c1(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            return bigDecimal.multiply(bigDecimal2, Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class d extends Operator {
        d(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            if (bigDecimal.compareTo(bigDecimal2) == -1) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class d0 extends Function {
        d0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.asin(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class d1 extends Function {
        d1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return list.get(0).abs(Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class e extends Operator {
        e(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            if (bigDecimal.compareTo(bigDecimal2) <= 0) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class e0 extends Function {
        e0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.acos(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class e1 extends Function {
        e1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.log(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class f extends Operator {
        f(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            if (bigDecimal == bigDecimal2) {
                return BigDecimal.ONE;
            }
            if (bigDecimal != null && bigDecimal2 != null) {
                if (bigDecimal.compareTo(bigDecimal2) == 0) {
                    return BigDecimal.ONE;
                }
                return BigDecimal.ZERO;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class f0 extends Function {
        f0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.atan(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class f1 extends Function {
        f1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.log10(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class g extends Operator {
        g(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return ((Operator) Expression.this.f38171i.get("=")).eval(bigDecimal, bigDecimal2);
        }
    }

    /* loaded from: classes6.dex */
    class g0 extends Operator {
        g0(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            return bigDecimal.add(bigDecimal2, Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class g1 extends Function {
        g1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0), list.get(1));
            return list.get(0).setScale(list.get(1).intValue(), Expression.this.f38164a.getRoundingMode());
        }
    }

    /* loaded from: classes6.dex */
    class h extends Operator {
        h(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            if (bigDecimal == bigDecimal2) {
                return BigDecimal.ZERO;
            }
            if (bigDecimal != null && bigDecimal2 != null) {
                if (bigDecimal.compareTo(bigDecimal2) != 0) {
                    return BigDecimal.ONE;
                }
                return BigDecimal.ZERO;
            }
            return BigDecimal.ONE;
        }
    }

    /* loaded from: classes6.dex */
    class h0 extends Function {
        h0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            if (list.get(0).doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return new BigDecimal(Math.atan(1.0d / list.get(0).doubleValue()), Expression.this.f38164a);
            }
            throw new ExpressionException("Number must not be 0");
        }
    }

    /* loaded from: classes6.dex */
    class h1 extends Function {
        h1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return list.get(0).setScale(0, RoundingMode.FLOOR);
        }
    }

    /* loaded from: classes6.dex */
    class i extends Operator {
        i(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            return ((Operator) Expression.this.f38171i.get("!=")).eval(bigDecimal, bigDecimal2);
        }
    }

    /* loaded from: classes6.dex */
    class i0 extends Function {
        i0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0), list.get(1));
            return new BigDecimal(Math.atan2(list.get(0).doubleValue(), list.get(1).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class i1 extends Function {
        i1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return list.get(0).setScale(0, RoundingMode.CEILING);
        }
    }

    /* loaded from: classes6.dex */
    class j extends UnaryOperator {
        j(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.AbstractUnaryOperator
        public BigDecimal evalUnary(BigDecimal bigDecimal) {
            return bigDecimal.multiply(new BigDecimal(-1));
        }
    }

    /* loaded from: classes6.dex */
    class j0 extends Function {
        j0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.toDegrees(Math.asin(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class j1 extends Function {
        j1(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            BigInteger shiftRight;
            Expression.assertNotNull(list.get(0));
            BigDecimal bigDecimal = list.get(0);
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                return new BigDecimal(0);
            }
            if (bigDecimal.signum() >= 0) {
                BigInteger bigInteger = bigDecimal.movePointRight(Expression.this.f38164a.getPrecision() << 1).toBigInteger();
                BigInteger shiftRight2 = bigInteger.shiftRight((bigInteger.bitLength() + 1) >> 1);
                while (true) {
                    shiftRight = shiftRight2.add(bigInteger.divide(shiftRight2)).shiftRight(1);
                    Thread.yield();
                    BigInteger abs = shiftRight.subtract(shiftRight2).abs();
                    if (abs.compareTo(BigInteger.ZERO) == 0 || abs.compareTo(BigInteger.ONE) == 0) {
                        break;
                    }
                    shiftRight2 = shiftRight;
                }
                return new BigDecimal(shiftRight, Expression.this.f38164a.getPrecision());
            }
            throw new ExpressionException("Argument to SQRT() function must not be negative");
        }
    }

    /* loaded from: classes6.dex */
    class k implements LazyNumber {
        k() {
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return null;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class k0 extends Function {
        k0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.toDegrees(Math.acos(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38210a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LazyNumber f38211b;

        k1(Token token, LazyNumber lazyNumber) {
            this.f38210a = token;
            this.f38211b = lazyNumber;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return Expression.this.f38171i.get(this.f38210a.surface).eval(this.f38211b, null).eval();
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(Expression.this.f38171i.get(this.f38210a.surface).eval(this.f38211b, null).eval());
        }
    }

    /* loaded from: classes6.dex */
    class l extends UnaryOperator {
        l(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.AbstractUnaryOperator
        public BigDecimal evalUnary(BigDecimal bigDecimal) {
            return bigDecimal.multiply(BigDecimal.ONE);
        }
    }

    /* loaded from: classes6.dex */
    class l0 extends Function {
        l0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.toDegrees(Math.atan(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class l1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38215a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LazyNumber f38216b;

        l1(Token token, LazyNumber lazyNumber) {
            this.f38215a = token;
            this.f38216b = lazyNumber;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return Expression.this.f38171i.get(this.f38215a.surface).eval(this.f38216b, null).eval();
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(Expression.this.f38171i.get(this.f38215a.surface).eval(this.f38216b, null).eval());
        }
    }

    /* loaded from: classes6.dex */
    class m extends Function {
        m(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            int intValue = list.get(0).intValue();
            BigDecimal bigDecimal = BigDecimal.ONE;
            for (int i4 = 1; i4 <= intValue; i4++) {
                bigDecimal = bigDecimal.multiply(new BigDecimal(i4));
            }
            return bigDecimal;
        }
    }

    /* loaded from: classes6.dex */
    class m0 extends Function {
        m0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            if (list.get(0).doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return new BigDecimal(Math.toDegrees(Math.atan(1.0d / list.get(0).doubleValue())), Expression.this.f38164a);
            }
            throw new ExpressionException("Number must not be 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class m1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38220a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LazyNumber f38221b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LazyNumber f38222c;

        m1(Token token, LazyNumber lazyNumber, LazyNumber lazyNumber2) {
            this.f38220a = token;
            this.f38221b = lazyNumber;
            this.f38222c = lazyNumber2;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return Expression.this.f38171i.get(this.f38220a.surface).eval(this.f38221b, this.f38222c).eval();
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(Expression.this.f38171i.get(this.f38220a.surface).eval(this.f38221b, this.f38222c).eval());
        }
    }

    /* loaded from: classes6.dex */
    class n extends Function {
        n(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            boolean z3 = false;
            Expression.assertNotNull(list.get(0));
            if (list.get(0).compareTo(BigDecimal.ZERO) == 0) {
                z3 = true;
            }
            if (z3) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class n0 extends Function {
        n0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0), list.get(1));
            return new BigDecimal(Math.toDegrees(Math.atan2(list.get(0).doubleValue(), list.get(1).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class n1 extends Operator {
        n1(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            return bigDecimal.divide(bigDecimal2, Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class o extends LazyFunction {
        o(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.LazyFunction
        public LazyNumber lazyEval(List<LazyNumber> list) {
            return new LazyIfNumber(list);
        }
    }

    /* loaded from: classes6.dex */
    class o0 extends Function {
        o0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.sinh(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class o1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38229a;

        o1(Token token) {
            this.f38229a = token;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            BigDecimal eval;
            LazyNumber lazyNumber = Expression.this.f38173k.get(this.f38229a.surface);
            if (lazyNumber == null) {
                eval = null;
            } else {
                eval = lazyNumber.eval();
            }
            if (eval == null) {
                return null;
            }
            return eval.round(Expression.this.f38164a);
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return Expression.this.f38173k.get(this.f38229a.surface).getString();
        }
    }

    /* loaded from: classes6.dex */
    class p extends Function {
        p(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            return new BigDecimal(Math.random(), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class p0 extends Function {
        p0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.cosh(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class p1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38233a;

        p1(Token token) {
            this.f38233a = token;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            if (this.f38233a.surface.equalsIgnoreCase("NULL")) {
                return null;
            }
            return new BigDecimal(this.f38233a.surface, Expression.this.f38164a);
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return String.valueOf(new BigDecimal(this.f38233a.surface, Expression.this.f38164a));
        }
    }

    /* loaded from: classes6.dex */
    class q extends Function {
        q(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.sin(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class q0 extends Function {
        q0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.tanh(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class q1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38237a;

        q1(Token token) {
            this.f38237a = token;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return null;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return this.f38237a.surface;
        }
    }

    /* loaded from: classes6.dex */
    class r extends Function {
        r(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.cos(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class r0 extends Operator {
        r0(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            return bigDecimal.subtract(bigDecimal2, Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class r1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Token f38241a;

        r1(Token token) {
            this.f38241a = token;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return new BigDecimal(new BigInteger(this.f38241a.surface.substring(2), 16), Expression.this.f38164a);
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return new BigInteger(this.f38241a.surface.substring(2), 16).toString();
        }
    }

    /* loaded from: classes6.dex */
    class s extends Function {
        s(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.tan(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class s0 extends Function {
        s0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.cosh(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class s1 implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, LazyNumber> f38245a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, com.udojava.evalex.LazyFunction> f38246b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, LazyOperator> f38247c;

        /* renamed from: d  reason: collision with root package name */
        private final String f38248d;

        /* renamed from: e  reason: collision with root package name */
        private final MathContext f38249e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f38250f;

        s1(String str) {
            this.f38250f = str;
            this.f38245a = Expression.this.f38173k;
            this.f38246b = Expression.this.f38172j;
            this.f38247c = Expression.this.f38171i;
            this.f38248d = str;
            this.f38249e = Expression.this.f38164a;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            Expression expression = new Expression(this.f38248d, this.f38249e);
            expression.f38173k = this.f38245a;
            expression.f38172j = this.f38246b;
            expression.f38171i = this.f38247c;
            return expression.eval();
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return this.f38248d;
        }
    }

    /* loaded from: classes6.dex */
    class t extends Function {
        t(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.tan(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class t0 extends Function {
        t0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.sinh(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class t1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38254a;

        static {
            int[] iArr = new int[x1.values().length];
            f38254a = iArr;
            try {
                iArr[x1.STRINGPARAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38254a[x1.LITERAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38254a[x1.HEX_LITERAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38254a[x1.VARIABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38254a[x1.FUNCTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38254a[x1.COMMA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38254a[x1.OPERATOR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38254a[x1.UNARY_OPERATOR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38254a[x1.OPEN_PAREN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38254a[x1.CLOSE_PAREN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes6.dex */
    class u extends Function {
        u(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.cos(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class u0 extends Function {
        u0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.tanh(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class u1 extends Operator {
        u1(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            return bigDecimal.remainder(bigDecimal2, Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class v implements LazyNumber {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BigDecimal f38258a;

        v(BigDecimal bigDecimal) {
            this.f38258a = bigDecimal;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public BigDecimal eval() {
            return this.f38258a;
        }

        @Override // com.udojava.evalex.Expression.LazyNumber
        public String getString() {
            return this.f38258a.toPlainString();
        }
    }

    /* loaded from: classes6.dex */
    class v0 extends Function {
        v0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.log(list.get(0).doubleValue() + Math.sqrt(Math.pow(list.get(0).doubleValue(), 2.0d) + 1.0d)), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class v1 extends Operator {
        v1(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            int signum = bigDecimal2.signum();
            double doubleValue = bigDecimal.doubleValue();
            BigDecimal multiply = bigDecimal2.multiply(new BigDecimal(signum));
            BigDecimal remainder = multiply.remainder(BigDecimal.ONE);
            BigDecimal multiply2 = bigDecimal.pow(multiply.subtract(remainder).intValueExact(), Expression.this.f38164a).multiply(BigDecimal.valueOf(Math.pow(doubleValue, remainder.doubleValue())), Expression.this.f38164a);
            if (signum == -1) {
                return BigDecimal.ONE.divide(multiply2, Expression.this.f38164a.getPrecision(), RoundingMode.HALF_UP);
            }
            return multiply2;
        }
    }

    /* loaded from: classes6.dex */
    class w extends Function {
        w(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(1.0d / Math.sin(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class w0 extends Function {
        w0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            if (Double.compare(list.get(0).doubleValue(), 1.0d) >= 0) {
                return new BigDecimal(Math.log(list.get(0).doubleValue() + Math.sqrt(Math.pow(list.get(0).doubleValue(), 2.0d) - 1.0d)), Expression.this.f38164a);
            }
            throw new ExpressionException("Number must be x >= 1");
        }
    }

    /* loaded from: classes6.dex */
    class w1 extends Operator {
        w1(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        @Override // com.udojava.evalex.Operator
        public BigDecimal eval(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            boolean z3;
            Expression.assertNotNull(bigDecimal, bigDecimal2);
            boolean z4 = true;
            if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                return BigDecimal.ZERO;
            }
            if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
                z4 = false;
            }
            if (z4) {
                return BigDecimal.ONE;
            }
            return BigDecimal.ZERO;
        }
    }

    /* loaded from: classes6.dex */
    class x extends Function {
        x(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.sin(Math.toRadians(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class x0 extends Function {
        x0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            if (Math.abs(list.get(0).doubleValue()) <= 1.0d && Math.abs(list.get(0).doubleValue()) != 1.0d) {
                return new BigDecimal(Math.log((list.get(0).doubleValue() + 1.0d) / (1.0d - list.get(0).doubleValue())) * 0.5d, Expression.this.f38164a);
            }
            throw new ExpressionException("Number must be |x| < 1");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum x1 {
        VARIABLE,
        FUNCTION,
        LITERAL,
        OPERATOR,
        UNARY_OPERATOR,
        OPEN_PAREN,
        COMMA,
        CLOSE_PAREN,
        HEX_LITERAL,
        STRINGPARAM
    }

    /* loaded from: classes6.dex */
    class y extends Function {
        y(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.cos(Math.toRadians(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class y0 extends Function {
        y0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.toRadians(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class y1 implements Iterator<Token> {

        /* renamed from: a  reason: collision with root package name */
        private int f38280a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f38281b;

        /* renamed from: c  reason: collision with root package name */
        private Token f38282c;

        /* renamed from: d  reason: collision with root package name */
        private Token f38283d;

        public y1(String str) {
            this.f38283d = new Token();
            this.f38281b = str.trim();
        }

        private char a(Token token) {
            String str = this.f38281b;
            int i4 = this.f38280a;
            this.f38280a = i4 + 1;
            token.append(str.charAt(i4));
            if (this.f38280a >= this.f38281b.length()) {
                return (char) 0;
            }
            return this.f38281b.charAt(this.f38280a);
        }

        private boolean b(char c4) {
            if (c4 != 'x' && c4 != 'X' && ((c4 < '0' || c4 > '9') && ((c4 < 'a' || c4 > 'f') && (c4 < 'A' || c4 > 'F')))) {
                return false;
            }
            return true;
        }

        private char d() {
            if (this.f38280a >= this.f38281b.length() - 1) {
                return (char) 0;
            }
            return this.f38281b.charAt(this.f38280a + 1);
        }

        private char e() {
            int i4 = this.f38280a + 1;
            this.f38280a = i4;
            if (i4 >= this.f38281b.length()) {
                return (char) 0;
            }
            return this.f38281b.charAt(this.f38280a);
        }

        private void f(Token token) {
            char e4 = e();
            while (e4 != '\"' && e4 != 0) {
                e4 = a(token);
            }
            if (e4 != 0) {
                e();
                token.type = x1.STRINGPARAM;
                return;
            }
            throw new TokenizerException("unterminated string literal", token.pos);
        }

        /* JADX WARN: Code restructure failed: missing block: B:142:0x0252, code lost:
            r1 = com.udojava.evalex.Expression.x1.f38275i;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00e7, code lost:
            r0.append(r11.f38281b.substring(r1, r8));
            r11.f38280a = r8;
         */
        @Override // java.util.Iterator
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.udojava.evalex.Expression.Token next() {
            /*
                Method dump skipped, instructions count: 604
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.udojava.evalex.Expression.y1.next():com.udojava.evalex.Expression$Token");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38280a < this.f38281b.length()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new ExpressionException("remove() not supported");
        }
    }

    /* loaded from: classes6.dex */
    class z extends Function {
        z(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.tan(Math.toRadians(list.get(0).doubleValue())), Expression.this.f38164a);
        }
    }

    /* loaded from: classes6.dex */
    class z0 extends Function {
        z0(String str, int i4) {
            super(str, i4);
        }

        @Override // com.udojava.evalex.Function
        public BigDecimal eval(List<BigDecimal> list) {
            Expression.assertNotNull(list.get(0));
            return new BigDecimal(Math.toDegrees(list.get(0).doubleValue()), Expression.this.f38164a);
        }
    }

    static {
        BigDecimal bigDecimal = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679");
        PI = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal("2.71828182845904523536028747135266249775724709369995957496696762772407663");
        f38161e = bigDecimal2;
        HashMap hashMap = new HashMap();
        f38162l = hashMap;
        hashMap.put("e", bigDecimal2);
        hashMap.put("PI", bigDecimal);
        hashMap.put("NULL", null);
        hashMap.put("TRUE", BigDecimal.ONE);
        hashMap.put("FALSE", BigDecimal.ZERO);
        f38163m = new k();
    }

    public Expression(String str) {
        this(str, MathContext.DECIMAL32);
    }

    public static void assertNotNull(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            throw new ArithmeticException("Operand may not be null");
        }
    }

    private Expression d(String str) {
        Map<String, LazyNumber> map = this.f38173k;
        Map<String, com.udojava.evalex.LazyFunction> map2 = this.f38172j;
        Map<String, LazyOperator> map3 = this.f38171i;
        Expression expression = new Expression(str, this.f38164a);
        expression.f38173k = map;
        expression.f38172j = map2;
        expression.f38171i = map3;
        return expression;
    }

    private List<Token> f() {
        if (this.f38170h == null) {
            List<Token> i4 = i(this.f38169g);
            this.f38170h = i4;
            j(i4);
        }
        return this.f38170h;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0054 -> B:4:0x0007). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(java.util.List<com.udojava.evalex.Expression.Token> r6, java.util.Stack<com.udojava.evalex.Expression.Token> r7, com.udojava.evalex.LazyOperator r8) {
        /*
            r5 = this;
            boolean r0 = r7.isEmpty()
            r1 = 0
            if (r0 == 0) goto L9
        L7:
            r0 = r1
            goto Lf
        L9:
            java.lang.Object r0 = r7.peek()
            com.udojava.evalex.Expression$Token r0 = (com.udojava.evalex.Expression.Token) r0
        Lf:
            if (r0 == 0) goto L5e
            com.udojava.evalex.Expression$x1 r2 = r0.type
            com.udojava.evalex.Expression$x1 r3 = com.udojava.evalex.Expression.x1.OPERATOR
            if (r2 == r3) goto L1b
            com.udojava.evalex.Expression$x1 r3 = com.udojava.evalex.Expression.x1.UNARY_OPERATOR
            if (r2 != r3) goto L5e
        L1b:
            boolean r2 = r8.isLeftAssoc()
            if (r2 == 0) goto L35
            int r2 = r8.getPrecedence()
            java.util.Map<java.lang.String, com.udojava.evalex.LazyOperator> r3 = r5.f38171i
            java.lang.String r4 = r0.surface
            java.lang.Object r3 = r3.get(r4)
            com.udojava.evalex.LazyOperator r3 = (com.udojava.evalex.LazyOperator) r3
            int r3 = r3.getPrecedence()
            if (r2 <= r3) goto L49
        L35:
            int r2 = r8.getPrecedence()
            java.util.Map<java.lang.String, com.udojava.evalex.LazyOperator> r3 = r5.f38171i
            java.lang.String r0 = r0.surface
            java.lang.Object r0 = r3.get(r0)
            com.udojava.evalex.LazyOperator r0 = (com.udojava.evalex.LazyOperator) r0
            int r0 = r0.getPrecedence()
            if (r2 >= r0) goto L5e
        L49:
            java.lang.Object r0 = r7.pop()
            r6.add(r0)
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L57
            goto L7
        L57:
            java.lang.Object r0 = r7.peek()
            com.udojava.evalex.Expression$Token r0 = (com.udojava.evalex.Expression.Token) r0
            goto Lf
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.udojava.evalex.Expression.h(java.util.List, java.util.Stack, com.udojava.evalex.LazyOperator):void");
    }

    private List<Token> i(String str) {
        x1 x1Var;
        x1 x1Var2;
        String str2;
        x1 x1Var3;
        List<Token> arrayList = new ArrayList<>();
        Stack<Token> stack = new Stack<>();
        y1 y1Var = new y1(str);
        Token token = null;
        Token token2 = null;
        while (y1Var.hasNext()) {
            Token next = y1Var.next();
            switch (t1.f38254a[next.type.ordinal()]) {
                case 1:
                    stack.push(next);
                    break;
                case 2:
                case 3:
                    if (token != null && ((x1Var = token.type) == x1.LITERAL || x1Var == x1.HEX_LITERAL)) {
                        throw new ExpressionException("Missing operator", next.pos);
                    }
                    arrayList.add(next);
                    break;
                case 4:
                    arrayList.add(next);
                    break;
                case 5:
                    stack.push(next);
                    token2 = next;
                    break;
                case 6:
                    if (token != null && token.type == x1.OPERATOR) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token, token.pos);
                    }
                    while (!stack.isEmpty() && stack.peek().type != x1.OPEN_PAREN) {
                        arrayList.add(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        break;
                    } else if (token2 == null) {
                        throw new ExpressionException("Unexpected comma", next.pos);
                    } else {
                        throw new ExpressionException("Parse error for function " + token2, next.pos);
                    }
                    break;
                case 7:
                    if (token != null && this.f38171i.containsKey(next.surface) && (((x1Var2 = token.type) == x1.COMMA || x1Var2 == x1.OPEN_PAREN) && !this.f38171i.get(next.surface).isUnaryOperator())) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + next, next.pos);
                    }
                    LazyOperator lazyOperator = this.f38171i.get(next.surface);
                    if (lazyOperator != null) {
                        h(arrayList, stack, lazyOperator);
                        stack.push(next);
                        break;
                    } else {
                        throw new ExpressionException("Unknown operator " + next, next.pos + 1);
                    }
                case 8:
                    if (token != null && (x1Var3 = token.type) != x1.OPERATOR && x1Var3 != x1.COMMA && x1Var3 != x1.OPEN_PAREN && x1Var3 != x1.UNARY_OPERATOR) {
                        throw new ExpressionException("Invalid position for unary operator " + next, next.pos);
                    }
                    LazyOperator lazyOperator2 = this.f38171i.get(next.surface);
                    if (lazyOperator2 != null) {
                        h(arrayList, stack, lazyOperator2);
                        stack.push(next);
                        break;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown unary operator ");
                        sb.append(next.surface.substring(0, str2.length() - 1));
                        throw new ExpressionException(sb.toString(), next.pos + 1);
                    }
                    break;
                case 9:
                    if (token != null) {
                        x1 x1Var4 = token.type;
                        if (x1Var4 == x1.LITERAL || x1Var4 == x1.CLOSE_PAREN || x1Var4 == x1.VARIABLE || x1Var4 == x1.HEX_LITERAL) {
                            Token token3 = new Token();
                            token3.append("*");
                            token3.type = x1.OPERATOR;
                            stack.push(token3);
                        }
                        if (token.type == x1.FUNCTION) {
                            arrayList.add(next);
                        }
                    }
                    stack.push(next);
                    break;
                case 10:
                    if (token != null && token.type == x1.OPERATOR && !this.f38171i.get(token.surface).isUnaryOperator()) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token, token.pos);
                    }
                    while (!stack.isEmpty() && stack.peek().type != x1.OPEN_PAREN) {
                        arrayList.add(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                        if (!stack.isEmpty() && stack.peek().type == x1.FUNCTION) {
                            arrayList.add(stack.pop());
                            break;
                        }
                    } else {
                        throw new ExpressionException("Mismatched parentheses");
                    }
                    break;
            }
            token = next;
        }
        while (!stack.isEmpty()) {
            Token pop = stack.pop();
            x1 x1Var5 = pop.type;
            if (x1Var5 != x1.OPEN_PAREN && x1Var5 != x1.CLOSE_PAREN) {
                arrayList.add(pop);
            } else {
                throw new ExpressionException("Mismatched parentheses");
            }
        }
        return arrayList;
    }

    private void j(List<Token> list) {
        int i4;
        Stack stack = new Stack();
        stack.push(0);
        for (Token token : list) {
            int i5 = t1.f38254a[token.type.ordinal()];
            if (i5 != 5) {
                if (i5 != 7) {
                    if (i5 != 8) {
                        if (i5 != 9) {
                            stack.set(stack.size() - 1, Integer.valueOf(((Integer) stack.peek()).intValue() + 1));
                        } else {
                            stack.push(0);
                        }
                    } else if (((Integer) stack.peek()).intValue() < 1) {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token);
                    }
                } else {
                    if (this.f38171i.get(token.surface).isUnaryOperator()) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    if (((Integer) stack.peek()).intValue() >= i4) {
                        if (i4 > 1) {
                            stack.set(stack.size() - 1, Integer.valueOf((((Integer) stack.peek()).intValue() - i4) + 1));
                        }
                    } else {
                        throw new ExpressionException(MISSING_PARAMETERS_FOR_OPERATOR + token);
                    }
                }
            } else {
                com.udojava.evalex.LazyFunction lazyFunction = this.f38172j.get(token.surface.toUpperCase(Locale.ROOT));
                if (lazyFunction != null) {
                    int intValue = ((Integer) stack.pop()).intValue();
                    if (!lazyFunction.numParamsVaries() && intValue != lazyFunction.getNumParams()) {
                        throw new ExpressionException("Function " + token + " expected " + lazyFunction.getNumParams() + " parameters, got " + intValue);
                    } else if (!stack.isEmpty()) {
                        stack.set(stack.size() - 1, Integer.valueOf(((Integer) stack.peek()).intValue() + 1));
                    } else {
                        throw new ExpressionException("Too many function calls, maximum scope exceeded");
                    }
                } else {
                    throw new ExpressionException("Unknown function " + token, token.pos + 1);
                }
            }
        }
        if (stack.size() <= 1) {
            if (((Integer) stack.peek()).intValue() <= 1) {
                if (((Integer) stack.peek()).intValue() >= 1) {
                    return;
                }
                throw new ExpressionException("Empty expression");
            }
            throw new ExpressionException("Too many numbers or variables");
        }
        throw new ExpressionException("Too many unhandled function parameter lists");
    }

    public com.udojava.evalex.Function addFunction(com.udojava.evalex.Function function) {
        return (com.udojava.evalex.Function) this.f38172j.put(function.getName(), function);
    }

    public com.udojava.evalex.LazyFunction addLazyFunction(com.udojava.evalex.LazyFunction lazyFunction) {
        return this.f38172j.put(lazyFunction.getName(), lazyFunction);
    }

    public <OPERATOR extends LazyOperator> OPERATOR addOperator(OPERATOR operator) {
        String oper = operator.getOper();
        if (operator instanceof AbstractUnaryOperator) {
            oper = oper + "u";
        }
        return (OPERATOR) this.f38171i.put(oper, operator);
    }

    public Expression and(String str, String str2) {
        return setVariable(str, str2);
    }

    protected LazyNumber e(BigDecimal bigDecimal) {
        return new v(bigDecimal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Expression expression = (Expression) obj;
        String str = this.f38169g;
        if (str == null) {
            if (expression.f38169g == null) {
                return true;
            }
            return false;
        }
        return str.equals(expression.f38169g);
    }

    public BigDecimal eval() {
        return eval(true);
    }

    protected boolean g(String str) {
        char[] charArray;
        if (str.isEmpty()) {
            return false;
        }
        if (str.charAt(0) == '-' && str.length() == 1) {
            return false;
        }
        if (str.charAt(0) == '+' && str.length() == 1) {
            return false;
        }
        if ((str.charAt(0) == '.' && (str.length() == 1 || !Character.isDigit(str.charAt(1)))) || str.charAt(0) == 'e' || str.charAt(0) == 'E') {
            return false;
        }
        for (char c4 : str.toCharArray()) {
            if (!Character.isDigit(c4) && c4 != '-' && c4 != '.' && c4 != 'e' && c4 != 'E' && c4 != '+') {
                return false;
            }
        }
        return true;
    }

    public Set<String> getDeclaredFunctions() {
        return Collections.unmodifiableSet(this.f38172j.keySet());
    }

    public Set<String> getDeclaredOperators() {
        return Collections.unmodifiableSet(this.f38171i.keySet());
    }

    public Set<String> getDeclaredVariables() {
        return Collections.unmodifiableSet(this.f38173k.keySet());
    }

    public String getExpression() {
        return this.f38169g;
    }

    public Iterator<Token> getExpressionTokenizer() {
        return new y1(this.f38169g);
    }

    public String getOriginalExpression() {
        return this.f38168f;
    }

    public List<String> getUsedVariables() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1(this.f38169g);
        while (y1Var.hasNext()) {
            Token next = y1Var.next();
            String token = next.toString();
            if (next.type == x1.VARIABLE && !f38162l.containsKey(token)) {
                arrayList.add(token);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        String str = this.f38169g;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public List<String> infixNotation() {
        ArrayList arrayList = new ArrayList();
        y1 y1Var = new y1(this.f38169g);
        while (y1Var.hasNext()) {
            Token next = y1Var.next();
            arrayList.add("{" + next.type + ":" + next.surface + "}");
        }
        return arrayList;
    }

    public boolean isBoolean() {
        List<Token> f4 = f();
        if (!f4.isEmpty()) {
            for (int size = f4.size() - 1; size >= 0; size--) {
                Token token = f4.get(size);
                if (!token.surface.equals("IF")) {
                    x1 x1Var = token.type;
                    if (x1Var == x1.FUNCTION) {
                        return this.f38172j.get(token.surface).isBooleanFunction();
                    }
                    if (x1Var == x1.OPERATOR) {
                        return this.f38171i.get(token.surface).isBooleanOperator();
                    }
                }
            }
            return false;
        }
        return false;
    }

    public Expression setFirstVariableCharacters(String str) {
        this.f38166c = str;
        return this;
    }

    public Expression setPrecision(int i4) {
        this.f38164a = new MathContext(i4);
        return this;
    }

    public Expression setRoundingMode(RoundingMode roundingMode) {
        this.f38164a = new MathContext(this.f38164a.getPrecision(), roundingMode);
        return this;
    }

    public Expression setVariable(String str, BigDecimal bigDecimal) {
        return setVariable(str, e(bigDecimal));
    }

    public Expression setVariableCharacters(String str) {
        this.f38167d = str;
        return this;
    }

    public String toRPN() {
        StringBuilder sb = new StringBuilder();
        for (Token token : f()) {
            if (sb.length() != 0) {
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            if (token.type == x1.VARIABLE && this.f38173k.containsKey(token.surface)) {
                String string = this.f38173k.get(token.surface).getString();
                if (g(string)) {
                    sb.append(token.toString());
                } else {
                    sb.append(d(string).toRPN());
                }
            } else {
                sb.append(token.toString());
            }
        }
        return sb.toString();
    }

    public String toString() {
        return this.f38169g;
    }

    public Expression with(String str, BigDecimal bigDecimal) {
        return setVariable(str, bigDecimal);
    }

    /* loaded from: classes6.dex */
    public abstract class Function extends AbstractFunction {
        public Function(String str, int i4) {
            super(str, i4);
        }

        public Function(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class LazyFunction extends AbstractLazyFunction {
        public LazyFunction(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }

        public LazyFunction(String str, int i4) {
            super(str, i4);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class Operator extends AbstractOperator {
        public Operator(String str, int i4, boolean z3, boolean z4, boolean z5) {
            super(str, i4, z3, z4, z5);
        }

        public Operator(String str, int i4, boolean z3, boolean z4) {
            super(str, i4, z3, z4);
        }

        public Operator(String str, int i4, boolean z3) {
            super(str, i4, z3);
        }
    }

    public Expression(String str, MathContext mathContext) {
        this(str, ExpressionSettings.builder().mathContext(mathContext).build());
    }

    public static void assertNotNull(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal == null) {
            throw new ArithmeticException("First operand may not be null");
        }
        if (bigDecimal2 == null) {
            throw new ArithmeticException("Second operand may not be null");
        }
    }

    public Expression and(String str, BigDecimal bigDecimal) {
        return setVariable(str, bigDecimal);
    }

    public BigDecimal eval(boolean z3) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Token token : f()) {
            switch (t1.f38254a[token.type.ordinal()]) {
                case 1:
                    arrayDeque.push(new q1(token));
                    break;
                case 2:
                    arrayDeque.push(new p1(token));
                    break;
                case 3:
                    arrayDeque.push(new r1(token));
                    break;
                case 4:
                    if (this.f38173k.containsKey(token.surface)) {
                        arrayDeque.push(new o1(token));
                        break;
                    } else {
                        throw new ExpressionException("Unknown operator or function: " + token);
                    }
                case 5:
                    com.udojava.evalex.LazyFunction lazyFunction = this.f38172j.get(token.surface.toUpperCase(Locale.ROOT));
                    ArrayList arrayList = new ArrayList(!lazyFunction.numParamsVaries() ? lazyFunction.getNumParams() : 0);
                    while (!arrayDeque.isEmpty() && arrayDeque.peek() != f38163m) {
                        arrayList.add(0, arrayDeque.pop());
                    }
                    if (arrayDeque.peek() == f38163m) {
                        arrayDeque.pop();
                    }
                    arrayDeque.push(lazyFunction.lazyEval(arrayList));
                    break;
                case 6:
                default:
                    throw new ExpressionException("Unexpected token " + token.surface, token.pos);
                case 7:
                    if (this.f38171i.get(token.surface).isUnaryOperator()) {
                        arrayDeque.push(new l1(token, (LazyNumber) arrayDeque.pop()));
                        break;
                    } else {
                        arrayDeque.push(new m1(token, (LazyNumber) arrayDeque.pop(), (LazyNumber) arrayDeque.pop()));
                        break;
                    }
                case 8:
                    arrayDeque.push(new k1(token, (LazyNumber) arrayDeque.pop()));
                    break;
                case 9:
                    arrayDeque.push(f38163m);
                    break;
            }
        }
        BigDecimal eval = ((LazyNumber) arrayDeque.pop()).eval();
        if (eval == null) {
            return null;
        }
        return z3 ? eval.stripTrailingZeros() : eval;
    }

    public Expression setVariable(String str, LazyNumber lazyNumber) {
        this.f38173k.put(str, lazyNumber);
        return this;
    }

    public Expression with(String str, LazyNumber lazyNumber) {
        return setVariable(str, lazyNumber);
    }

    public Expression and(String str, LazyNumber lazyNumber) {
        return setVariable(str, lazyNumber);
    }

    public Expression setVariable(String str, String str2) {
        if (g(str2)) {
            this.f38173k.put(str, e(new BigDecimal(str2, this.f38164a)));
        } else if (str2.equalsIgnoreCase("null")) {
            this.f38173k.put(str, null);
        } else {
            this.f38173k.put(str, new s1(str2));
            this.f38170h = null;
        }
        return this;
    }

    public Expression with(String str, String str2) {
        return setVariable(str, str2);
    }

    public Expression(String str, ExpressionSettings expressionSettings) {
        this.f38165b = 40;
        this.f38166c = "_";
        this.f38167d = "_";
        this.f38169g = null;
        this.f38170h = null;
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.f38171i = new TreeMap(comparator);
        this.f38172j = new TreeMap(comparator);
        this.f38173k = new TreeMap(comparator);
        this.f38164a = expressionSettings.getMathContext();
        this.f38165b = expressionSettings.getPowerOperatorPrecedence();
        this.f38169g = str;
        this.f38168f = str;
        addOperator(new g0(Marker.ANY_NON_NULL_MARKER, 20, true));
        addOperator(new r0("-", 20, true));
        addOperator(new c1("*", 30, true));
        addOperator(new n1(RemoteSettings.FORWARD_SLASH_STRING, 30, true));
        addOperator(new u1("%", 30, true));
        addOperator(new v1("^", this.f38165b, false));
        addOperator(new w1("&&", 4, false, true));
        addOperator(new a("||", 2, false, true));
        addOperator(new b(">", 10, false, true));
        addOperator(new c(">=", 10, false, true));
        addOperator(new d("<", 10, false, true));
        addOperator(new e("<=", 10, false, true));
        addOperator(new f("=", 7, false, true));
        addOperator(new g("==", 7, false, true));
        addOperator(new h("!=", 7, false, true));
        addOperator(new i("<>", 7, false, true));
        addOperator(new j("-", 60, false));
        addOperator(new l(Marker.ANY_NON_NULL_MARKER, 60, false));
        addFunction(new m("FACT", 1, false));
        addFunction(new n("NOT", 1, true));
        addLazyFunction(new o("IF", 3));
        addFunction(new p("RANDOM", 0));
        addFunction(new q("SINR", 1));
        addFunction(new r("COSR", 1));
        addFunction(new s("TANR", 1));
        addFunction(new t("COTR", 1));
        addFunction(new u("SECR", 1));
        addFunction(new w("CSCR", 1));
        addFunction(new x("SIN", 1));
        addFunction(new y("COS", 1));
        addFunction(new z("TAN", 1));
        addFunction(new a0("COT", 1));
        addFunction(new b0("SEC", 1));
        addFunction(new c0("CSC", 1));
        addFunction(new d0("ASINR", 1));
        addFunction(new e0("ACOSR", 1));
        addFunction(new f0("ATANR", 1));
        addFunction(new h0("ACOTR", 1));
        addFunction(new i0("ATAN2R", 2));
        addFunction(new j0("ASIN", 1));
        addFunction(new k0("ACOS", 1));
        addFunction(new l0("ATAN", 1));
        addFunction(new m0("ACOT", 1));
        addFunction(new n0("ATAN2", 2));
        addFunction(new o0("SINH", 1));
        addFunction(new p0("COSH", 1));
        addFunction(new q0("TANH", 1));
        addFunction(new s0("SECH", 1));
        addFunction(new t0("CSCH", 1));
        addFunction(new u0("COTH", 1));
        addFunction(new v0("ASINH", 1));
        addFunction(new w0("ACOSH", 1));
        addFunction(new x0("ATANH", 1));
        addFunction(new y0("RAD", 1));
        addFunction(new z0("DEG", 1));
        addFunction(new a1("MAX", -1));
        addFunction(new b1("MIN", -1));
        addFunction(new d1("ABS", 1));
        addFunction(new e1("LOG", 1));
        addFunction(new f1("LOG10", 1));
        addFunction(new g1("ROUND", 2));
        addFunction(new h1("FLOOR", 1));
        addFunction(new i1("CEILING", 1));
        addFunction(new j1("SQRT", 1));
        for (Map.Entry<String, BigDecimal> entry : f38162l.entrySet()) {
            BigDecimal value = entry.getValue();
            this.f38173k.put(entry.getKey(), value == null ? null : e(value));
        }
    }
}
