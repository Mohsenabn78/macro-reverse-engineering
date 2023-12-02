package com.google.type;

import com.google.protobuf.Internal;

/* loaded from: classes6.dex */
public enum DayOfWeek implements Internal.EnumLite {
    DAY_OF_WEEK_UNSPECIFIED(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    UNRECOGNIZED(-1);
    
    public static final int DAY_OF_WEEK_UNSPECIFIED_VALUE = 0;
    public static final int FRIDAY_VALUE = 5;
    public static final int MONDAY_VALUE = 1;
    public static final int SATURDAY_VALUE = 6;
    public static final int SUNDAY_VALUE = 7;
    public static final int THURSDAY_VALUE = 4;
    public static final int TUESDAY_VALUE = 2;
    public static final int WEDNESDAY_VALUE = 3;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<DayOfWeek> f33667a = new Internal.EnumLiteMap<DayOfWeek>() { // from class: com.google.type.DayOfWeek.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public DayOfWeek findValueByNumber(int i4) {
            return DayOfWeek.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes6.dex */
    private static final class DayOfWeekVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f33669a = new DayOfWeekVerifier();

        private DayOfWeekVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (DayOfWeek.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    DayOfWeek(int i4) {
        this.value = i4;
    }

    public static DayOfWeek forNumber(int i4) {
        switch (i4) {
            case 0:
                return DAY_OF_WEEK_UNSPECIFIED;
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            case 7:
                return SUNDAY;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<DayOfWeek> internalGetValueMap() {
        return f33667a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DayOfWeekVerifier.f33669a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static DayOfWeek valueOf(int i4) {
        return forNumber(i4);
    }
}
