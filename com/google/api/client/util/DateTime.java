package com.google.api.client.util;

import com.google.firebase.firestore.util.ExponentialBackoff;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes5.dex */
public final class DateTime implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f26099a = TimeZone.getTimeZone("GMT");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f26100b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private static final long serialVersionUID = 1;
    private final boolean dateOnly;
    private final int tzShift;
    private final long value;

    public DateTime(Date date, TimeZone timeZone) {
        this(false, date.getTime(), timeZone == null ? null : Integer.valueOf(timeZone.getOffset(date.getTime()) / 60000));
    }

    private static void a(StringBuilder sb, int i4, int i5) {
        if (i4 < 0) {
            sb.append(SignatureVisitor.SUPER);
            i4 = -i4;
        }
        int i6 = i4;
        while (i6 > 0) {
            i6 /= 10;
            i5--;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append('0');
        }
        if (i4 != 0) {
            sb.append(i4);
        }
    }

    public static DateTime parseRfc3339(String str) throws NumberFormatException {
        boolean z3;
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        int i6;
        int i7;
        Integer num;
        int i8;
        String str2;
        String str3;
        Matcher matcher = f26100b.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3 = "Invalid date/time format: ".concat(valueOf);
            } else {
                str3 = new String("Invalid date/time format: ");
            }
            throw new NumberFormatException(str3);
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        int parseInt2 = Integer.parseInt(matcher.group(2)) - 1;
        int parseInt3 = Integer.parseInt(matcher.group(3));
        if (matcher.group(4) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        String group = matcher.group(9);
        if (group != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 && !z3) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str2 = "Invalid date/time format, cannot specify time zone shift without specifying time: ".concat(valueOf2);
            } else {
                str2 = new String("Invalid date/time format, cannot specify time zone shift without specifying time: ");
            }
            throw new NumberFormatException(str2);
        }
        if (z3) {
            int parseInt4 = Integer.parseInt(matcher.group(5));
            int parseInt5 = Integer.parseInt(matcher.group(6));
            int parseInt6 = Integer.parseInt(matcher.group(7));
            if (matcher.group(8) != null) {
                z5 = z3;
                i4 = (int) (Integer.parseInt(matcher.group(8).substring(1)) / Math.pow(10.0d, matcher.group(8).substring(1).length() - 3));
                i6 = parseInt5;
                i7 = parseInt6;
            } else {
                z5 = z3;
                i6 = parseInt5;
                i7 = parseInt6;
                i4 = 0;
            }
            i5 = parseInt4;
        } else {
            z5 = z3;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f26099a);
        gregorianCalendar.set(parseInt, parseInt2, parseInt3, i5, i6, i7);
        gregorianCalendar.set(14, i4);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (z5 && z4) {
            if (Character.toUpperCase(group.charAt(0)) == 'Z') {
                i8 = 0;
            } else {
                int parseInt7 = (Integer.parseInt(matcher.group(11)) * 60) + Integer.parseInt(matcher.group(12));
                if (matcher.group(10).charAt(0) == '-') {
                    i8 = -parseInt7;
                } else {
                    i8 = parseInt7;
                }
                timeInMillis -= i8 * ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
            }
            num = Integer.valueOf(i8);
        } else {
            num = null;
        }
        return new DateTime(true ^ z5, timeInMillis, num);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) obj;
        if (this.dateOnly == dateTime.dateOnly && this.value == dateTime.value && this.tzShift == dateTime.tzShift) {
            return true;
        }
        return false;
    }

    public int getTimeZoneShift() {
        return this.tzShift;
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        long j4;
        long[] jArr = new long[3];
        jArr[0] = this.value;
        if (this.dateOnly) {
            j4 = 1;
        } else {
            j4 = 0;
        }
        jArr[1] = j4;
        jArr[2] = this.tzShift;
        return Arrays.hashCode(jArr);
    }

    public boolean isDateOnly() {
        return this.dateOnly;
    }

    public String toString() {
        return toStringRfc3339();
    }

    public String toStringRfc3339() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f26099a);
        gregorianCalendar.setTimeInMillis(this.value + (this.tzShift * ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS));
        a(sb, gregorianCalendar.get(1), 4);
        sb.append(SignatureVisitor.SUPER);
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append(SignatureVisitor.SUPER);
        a(sb, gregorianCalendar.get(5), 2);
        if (!this.dateOnly) {
            sb.append('T');
            a(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                a(sb, gregorianCalendar.get(14), 3);
            }
            int i4 = this.tzShift;
            if (i4 == 0) {
                sb.append('Z');
            } else {
                if (i4 > 0) {
                    sb.append(SignatureVisitor.EXTENDS);
                } else {
                    sb.append(SignatureVisitor.SUPER);
                    i4 = -i4;
                }
                a(sb, i4 / 60, 2);
                sb.append(':');
                a(sb, i4 % 60, 2);
            }
        }
        return sb.toString();
    }

    public DateTime(long j4) {
        this(false, j4, null);
    }

    public DateTime(Date date) {
        this(date.getTime());
    }

    public DateTime(long j4, int i4) {
        this(false, j4, Integer.valueOf(i4));
    }

    public DateTime(boolean z3, long j4, Integer num) {
        int offset;
        this.dateOnly = z3;
        this.value = j4;
        if (z3) {
            offset = 0;
        } else {
            offset = num == null ? TimeZone.getDefault().getOffset(j4) / 60000 : num.intValue();
        }
        this.tzShift = offset;
    }

    public DateTime(String str) {
        DateTime parseRfc3339 = parseRfc3339(str);
        this.dateOnly = parseRfc3339.dateOnly;
        this.value = parseRfc3339.value;
        this.tzShift = parseRfc3339.tzShift;
    }
}
