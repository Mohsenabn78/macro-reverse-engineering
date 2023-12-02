package com.luckycatlabs.sunrisesunset.calculator;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.luckycatlabs.sunrisesunset.Zenith;
import com.luckycatlabs.sunrisesunset.dto.Location;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class SolarEventCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final Location f36125a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f36126b;

    public SolarEventCalculator(Location location, String str) {
        this.f36125a = location;
        this.f36126b = TimeZone.getTimeZone(str);
    }

    private BigDecimal a(BigDecimal bigDecimal, Calendar calendar) {
        if (this.f36126b.inDaylightTime(calendar.getTime())) {
            bigDecimal = bigDecimal.add(BigDecimal.ONE);
        }
        if (bigDecimal.doubleValue() > 24.0d) {
            return bigDecimal.subtract(BigDecimal.valueOf(24L));
        }
        return bigDecimal;
    }

    private BigDecimal b(Zenith zenith, Calendar calendar, boolean z3) {
        calendar.setTimeZone(this.f36126b);
        BigDecimal o4 = o(calendar, Boolean.valueOf(z3));
        BigDecimal t3 = t(p(o4));
        BigDecimal i4 = i(t3, zenith);
        if (i4.doubleValue() >= -1.0d && i4.doubleValue() <= 1.0d) {
            return l(k(t3, o4, s(i4, Boolean.valueOf(z3))), calendar);
        }
        return null;
    }

    private BigDecimal c(BigDecimal bigDecimal) {
        return v(bigDecimal, BigDecimal.valueOf(0.017453292519943295d));
    }

    private BigDecimal d(BigDecimal bigDecimal) {
        return v(bigDecimal, new BigDecimal(57.29577951308232d));
    }

    private BigDecimal e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.divide(bigDecimal2, 4, RoundingMode.HALF_EVEN);
    }

    private BigDecimal f(BigDecimal bigDecimal) {
        return w(BigDecimal.valueOf(Math.acos(bigDecimal.doubleValue())));
    }

    private BigDecimal g() {
        return e(this.f36125a.getLongitude(), BigDecimal.valueOf(15L));
    }

    private BigDecimal h(BigDecimal bigDecimal) {
        return w(BigDecimal.valueOf(Math.cos(BigDecimal.valueOf(Math.asin(bigDecimal.doubleValue())).doubleValue())));
    }

    private BigDecimal i(BigDecimal bigDecimal, Zenith zenith) {
        BigDecimal r4 = r(bigDecimal);
        BigDecimal h4 = h(r4);
        return w(e(BigDecimal.valueOf(Math.cos(c(zenith.degrees()).doubleValue())).subtract(r4.multiply(BigDecimal.valueOf(Math.sin(c(this.f36125a.getLatitude()).doubleValue())))), h4.multiply(BigDecimal.valueOf(Math.cos(c(this.f36125a.getLatitude()).doubleValue())))));
    }

    private BigDecimal j(Calendar calendar) {
        return new BigDecimal(calendar.get(6));
    }

    private BigDecimal k(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        BigDecimal q4 = q(bigDecimal);
        BigDecimal subtract = bigDecimal3.add(q4).subtract(bigDecimal2.multiply(new BigDecimal("0.06571"))).subtract(new BigDecimal("6.622"));
        if (subtract.doubleValue() < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            subtract = subtract.add(BigDecimal.valueOf(24L));
        } else if (subtract.doubleValue() > 24.0d) {
            subtract = subtract.subtract(BigDecimal.valueOf(24L));
        }
        return w(subtract);
    }

    private BigDecimal l(BigDecimal bigDecimal, Calendar calendar) {
        return a(bigDecimal.subtract(g()).add(u(calendar)), calendar);
    }

    private String n(BigDecimal bigDecimal) {
        String[] split;
        String plainString;
        String valueOf;
        if (bigDecimal == null) {
            return "99:99";
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) == -1) {
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(24.0d));
        }
        int i4 = 0;
        int parseInt = Integer.parseInt(bigDecimal.toPlainString().split("\\.")[0]);
        BigDecimal scale = new BigDecimal("0." + split[1]).multiply(BigDecimal.valueOf(60L)).setScale(0, RoundingMode.HALF_EVEN);
        if (scale.intValue() == 60) {
            scale = BigDecimal.ZERO;
            parseInt++;
        }
        if (parseInt != 24) {
            i4 = parseInt;
        }
        if (scale.intValue() < 10) {
            plainString = "0" + scale.toPlainString();
        } else {
            plainString = scale.toPlainString();
        }
        if (i4 < 10) {
            valueOf = "0" + String.valueOf(i4);
        } else {
            valueOf = String.valueOf(i4);
        }
        return valueOf + ":" + plainString;
    }

    private BigDecimal o(Calendar calendar, Boolean bool) {
        int i4;
        if (bool.booleanValue()) {
            i4 = 6;
        } else {
            i4 = 18;
        }
        return w(j(calendar).add(e(BigDecimal.valueOf(i4).subtract(g()), BigDecimal.valueOf(24L))));
    }

    private BigDecimal p(BigDecimal bigDecimal) {
        return w(v(new BigDecimal("0.9856"), bigDecimal).subtract(new BigDecimal("3.289")));
    }

    private BigDecimal q(BigDecimal bigDecimal) {
        BigDecimal w3 = w(d(new BigDecimal(Math.atan(c(v(d(new BigDecimal(Math.tan(c(bigDecimal).doubleValue()))), new BigDecimal("0.91764"))).doubleValue()))));
        if (w3.doubleValue() < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            w3 = w3.add(BigDecimal.valueOf(360L));
        } else if (w3.doubleValue() > 360.0d) {
            w3 = w3.subtract(BigDecimal.valueOf(360L));
        }
        BigDecimal valueOf = BigDecimal.valueOf(90L);
        return e(w3.add(bigDecimal.divide(valueOf, 0, RoundingMode.FLOOR).multiply(valueOf).subtract(w3.divide(valueOf, 0, RoundingMode.FLOOR).multiply(valueOf))), BigDecimal.valueOf(15L));
    }

    private BigDecimal r(BigDecimal bigDecimal) {
        return w(BigDecimal.valueOf(Math.sin(c(bigDecimal).doubleValue())).multiply(new BigDecimal("0.39782")));
    }

    private BigDecimal s(BigDecimal bigDecimal, Boolean bool) {
        BigDecimal d4 = d(f(bigDecimal));
        if (bool.booleanValue()) {
            d4 = BigDecimal.valueOf(360L).subtract(d4);
        }
        return e(d4, BigDecimal.valueOf(15L));
    }

    private BigDecimal t(BigDecimal bigDecimal) {
        BigDecimal add = bigDecimal.add(v(new BigDecimal(Math.sin(c(bigDecimal).doubleValue())), new BigDecimal("1.916"))).add(v(new BigDecimal(Math.sin(v(c(bigDecimal), BigDecimal.valueOf(2L)).doubleValue())), new BigDecimal("0.020")).add(new BigDecimal("282.634")));
        if (add.doubleValue() > 360.0d) {
            add = add.subtract(BigDecimal.valueOf(360L));
        }
        return w(add);
    }

    private BigDecimal u(Calendar calendar) {
        return new BigDecimal(calendar.get(15)).divide(new BigDecimal(3600000), new MathContext(2));
    }

    private BigDecimal v(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return w(bigDecimal.multiply(bigDecimal2));
    }

    private BigDecimal w(BigDecimal bigDecimal) {
        return bigDecimal.setScale(4, RoundingMode.HALF_EVEN);
    }

    public Calendar computeSunriseCalendar(Zenith zenith, Calendar calendar) {
        return m(b(zenith, calendar, true), calendar);
    }

    public String computeSunriseTime(Zenith zenith, Calendar calendar) {
        return n(b(zenith, calendar, true));
    }

    public Calendar computeSunsetCalendar(Zenith zenith, Calendar calendar) {
        return m(b(zenith, calendar, false), calendar);
    }

    public String computeSunsetTime(Zenith zenith, Calendar calendar) {
        return n(b(zenith, calendar, false));
    }

    protected Calendar m(BigDecimal bigDecimal, Calendar calendar) {
        if (bigDecimal == null) {
            return null;
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        if (bigDecimal.compareTo(BigDecimal.ZERO) == -1) {
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(24.0d));
            calendar2.add(11, -24);
        }
        String[] split = bigDecimal.toPlainString().split("\\.");
        int parseInt = Integer.parseInt(split[0]);
        BigDecimal scale = new BigDecimal("0." + split[1]).multiply(BigDecimal.valueOf(60L)).setScale(0, RoundingMode.HALF_EVEN);
        if (scale.intValue() == 60) {
            scale = BigDecimal.ZERO;
            parseInt++;
        }
        if (parseInt == 24) {
            parseInt = 0;
        }
        calendar2.set(11, parseInt);
        calendar2.set(12, scale.intValue());
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        calendar2.setTimeZone(calendar.getTimeZone());
        return calendar2;
    }

    public SolarEventCalculator(Location location, TimeZone timeZone) {
        this.f36125a = location;
        this.f36126b = timeZone;
    }
}
