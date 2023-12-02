package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.annotation.IntRange;

/* loaded from: classes6.dex */
public class ItemIdComposer {
    public static final long BIT_MASK_CHILD_ID = 268435455;
    public static final long BIT_MASK_GROUP_ID = 72057593769492480L;
    public static final long BIT_MASK_RESERVED_SIGN_FLAG = Long.MIN_VALUE;
    public static final long BIT_MASK_SEGMENT = 9151314442816847872L;
    public static final int BIT_OFFSET_CHILD_ID = 0;
    public static final int BIT_OFFSET_GROUP_ID = 28;
    public static final int BIT_OFFSET_RESERVED_SIGN_FLAG = 63;
    public static final int BIT_OFFSET_SEGMENT = 56;
    public static final int BIT_WIDTH_CHILD_ID = 28;
    public static final int BIT_WIDTH_GROUP_ID = 28;
    public static final int BIT_WIDTH_RESERVED_SIGN_FLAG = 1;
    public static final int BIT_WIDTH_SEGMENT = 7;
    public static final long MAX_CHILD_ID = 134217727;
    public static final long MAX_GROUP_ID = 134217727;
    public static final int MAX_SEGMENT = 127;
    public static final long MAX_WRAPPED_ID = 36028797018963967L;
    public static final long MIN_CHILD_ID = -134217728;
    public static final long MIN_GROUP_ID = -134217728;
    public static final int MIN_SEGMENT = 0;
    public static final long MIN_WRAPPED_ID = -36028797018963968L;

    private ItemIdComposer() {
    }

    public static long composeExpandableChildId(@IntRange(from = -134217728, to = 134217727) long j4, @IntRange(from = -134217728, to = 134217727) long j5) {
        if (j4 >= -134217728 && j4 <= 134217727) {
            if (j5 >= -134217728 && j5 <= 134217727) {
                return ((j4 << 28) & BIT_MASK_GROUP_ID) | ((j5 << 0) & BIT_MASK_CHILD_ID);
            }
            throw new IllegalArgumentException("Child ID value is out of range. (childId = " + j5 + ")");
        }
        throw new IllegalArgumentException("Group ID value is out of range. (groupId = " + j4 + ")");
    }

    public static long composeExpandableGroupId(@IntRange(from = -134217728, to = 134217727) long j4) {
        if (j4 >= -134217728 && j4 <= 134217727) {
            return ((j4 << 28) & BIT_MASK_GROUP_ID) | BIT_MASK_CHILD_ID;
        }
        throw new IllegalArgumentException("Group ID value is out of range. (groupId = " + j4 + ")");
    }

    public static long composeSegment(@IntRange(from = 0, to = 127) int i4, long j4) {
        if (i4 >= 0 && i4 <= 127) {
            return (j4 & (-9151314442816847873L)) | (i4 << 56);
        }
        throw new IllegalArgumentException("Segment value is out of range. (segment = " + i4 + ")");
    }

    @IntRange(from = -134217728, to = 134217727)
    public static long extractExpandableChildIdPart(long j4) {
        if (j4 == -1 || isExpandableGroup(j4)) {
            return -1L;
        }
        return (j4 << 36) >> 36;
    }

    @IntRange(from = -134217728, to = 134217727)
    public static long extractExpandableGroupIdPart(long j4) {
        if (j4 == -1 || !isExpandableGroup(j4)) {
            return -1L;
        }
        return (j4 << 8) >> 36;
    }

    @IntRange(from = 0, to = 127)
    public static int extractSegmentPart(long j4) {
        return (int) ((j4 & BIT_MASK_SEGMENT) >>> 56);
    }

    public static long extractWrappedIdPart(long j4) {
        if (j4 == -1) {
            return -1L;
        }
        return (j4 << 8) >> 8;
    }

    public static boolean isExpandableGroup(long j4) {
        if (j4 != -1 && (j4 & BIT_MASK_CHILD_ID) == BIT_MASK_CHILD_ID) {
            return true;
        }
        return false;
    }
}
