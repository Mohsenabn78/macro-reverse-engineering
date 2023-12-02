package com.google.type;

import com.google.protobuf.Internal;

/* loaded from: classes6.dex */
public enum CalendarPeriod implements Internal.EnumLite {
    CALENDAR_PERIOD_UNSPECIFIED(0),
    DAY(1),
    WEEK(2),
    FORTNIGHT(3),
    MONTH(4),
    QUARTER(5),
    HALF(6),
    YEAR(7),
    UNRECOGNIZED(-1);
    
    public static final int CALENDAR_PERIOD_UNSPECIFIED_VALUE = 0;
    public static final int DAY_VALUE = 1;
    public static final int FORTNIGHT_VALUE = 3;
    public static final int HALF_VALUE = 6;
    public static final int MONTH_VALUE = 4;
    public static final int QUARTER_VALUE = 5;
    public static final int WEEK_VALUE = 2;
    public static final int YEAR_VALUE = 7;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<CalendarPeriod> f33660a = new Internal.EnumLiteMap<CalendarPeriod>() { // from class: com.google.type.CalendarPeriod.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public CalendarPeriod findValueByNumber(int i4) {
            return CalendarPeriod.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes6.dex */
    private static final class CalendarPeriodVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f33662a = new CalendarPeriodVerifier();

        private CalendarPeriodVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (CalendarPeriod.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    CalendarPeriod(int i4) {
        this.value = i4;
    }

    public static CalendarPeriod forNumber(int i4) {
        switch (i4) {
            case 0:
                return CALENDAR_PERIOD_UNSPECIFIED;
            case 1:
                return DAY;
            case 2:
                return WEEK;
            case 3:
                return FORTNIGHT;
            case 4:
                return MONTH;
            case 5:
                return QUARTER;
            case 6:
                return HALF;
            case 7:
                return YEAR;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<CalendarPeriod> internalGetValueMap() {
        return f33660a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return CalendarPeriodVerifier.f33662a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static CalendarPeriod valueOf(int i4) {
        return forNumber(i4);
    }
}
