package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import java.util.Arrays;
import javax.mail.UIDFolder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpandablePositionTranslator.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private long[] f33872a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f33873b;

    /* renamed from: c  reason: collision with root package name */
    private int f33874c;

    /* renamed from: d  reason: collision with root package name */
    private int f33875d;

    /* renamed from: e  reason: collision with root package name */
    private int f33876e;

    /* renamed from: f  reason: collision with root package name */
    private int f33877f = -1;

    /* renamed from: g  reason: collision with root package name */
    private ExpandableItemAdapter f33878g;

    private static int a(long[] jArr, int i4, int i5) {
        int i6 = 0;
        if (i4 <= 0) {
            return 0;
        }
        int i7 = (int) (jArr[0] >>> 32);
        int i8 = (int) (jArr[i4] >>> 32);
        if (i5 <= i7) {
            return 0;
        }
        if (i5 >= i8) {
            return i4;
        }
        int i9 = 0;
        while (i6 < i4) {
            int i10 = (i6 + i4) >>> 1;
            if (((int) (jArr[i10] >>> 32)) < i5) {
                i9 = i6;
                i6 = i10 + 1;
            } else {
                i4 = i10;
            }
        }
        return i9;
    }

    private void d(int i4, boolean z3) {
        long[] jArr;
        int[] iArr;
        int i5 = (i4 + FrameMetricsAggregator.EVERY_DURATION) & InputDeviceCompat.SOURCE_ANY;
        long[] jArr2 = this.f33872a;
        int[] iArr2 = this.f33873b;
        if (jArr2 != null && jArr2.length >= i4) {
            jArr = jArr2;
        } else {
            jArr = new long[i5];
        }
        if (iArr2 != null && iArr2.length >= i4) {
            iArr = iArr2;
        } else {
            iArr = new int[i5];
        }
        if (z3) {
            if (jArr2 != null && jArr2 != jArr) {
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            }
            if (iArr2 != null && iArr2 != iArr) {
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            }
        }
        this.f33872a = jArr;
        this.f33873b = iArr;
    }

    public int A(int i4, int i5) {
        int i6;
        if (i5 <= 0) {
            return 0;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            long j4 = this.f33872a[i4 + i8];
            if ((2147483648L & j4) != 0) {
                int i9 = (int) (j4 & 2147483647L);
                i7 += i9;
                this.f33876e -= i9;
                this.f33875d--;
            }
        }
        int i10 = i7 + i5;
        this.f33874c -= i5;
        int i11 = i4;
        while (true) {
            i6 = this.f33874c;
            if (i11 >= i6) {
                break;
            }
            long[] jArr = this.f33872a;
            int i12 = i11 + i5;
            jArr[i11] = jArr[i12];
            int[] iArr = this.f33873b;
            iArr[i11] = iArr[i12];
            i11++;
        }
        this.f33877f = Math.min(this.f33877f, i6 == 0 ? -1 : i4 - 1);
        return i10;
    }

    public void B(long[] jArr, ExpandableItemAdapter expandableItemAdapter, RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener, RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener) {
        char c4;
        boolean z3;
        int i4;
        if (jArr == null || jArr.length == 0 || this.f33872a == null) {
            return;
        }
        int i5 = this.f33874c;
        long[] jArr2 = new long[i5];
        int i6 = 0;
        while (true) {
            c4 = ' ';
            if (i6 >= this.f33874c) {
                break;
            }
            jArr2[i6] = (this.f33873b[i6] << 32) | i6;
            i6++;
        }
        Arrays.sort(jArr2);
        int i7 = 0;
        int i8 = 0;
        while (i7 < jArr.length) {
            long j4 = jArr[i7];
            int i9 = (int) (j4 >>> c4);
            if ((j4 & 2147483648L) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i10 = i8;
            while (true) {
                if (i8 < i5) {
                    long j5 = jArr2[i8];
                    i4 = i7;
                    int i11 = (int) (j5 >>> c4);
                    boolean z4 = z3;
                    int i12 = (int) (j5 & 2147483647L);
                    if (i11 < i9) {
                        i10 = i8;
                    } else if (i11 == i9) {
                        int i13 = i8 + 1;
                        if (z4) {
                            if ((expandableItemAdapter == null || expandableItemAdapter.onHookGroupExpand(i12, false, null)) && e(i12) && onGroupExpandListener != null) {
                                onGroupExpandListener.onGroupExpand(i12, false, null);
                            }
                        } else if ((expandableItemAdapter == null || expandableItemAdapter.onHookGroupCollapse(i12, false, null)) && c(i12) && onGroupCollapseListener != null) {
                            onGroupCollapseListener.onGroupCollapse(i12, false, null);
                        }
                        i10 = i13;
                    }
                    i8++;
                    i7 = i4;
                    z3 = z4;
                    c4 = ' ';
                } else {
                    i4 = i7;
                    break;
                }
            }
            i7 = i4 + 1;
            i8 = i10;
            c4 = ' ';
        }
    }

    public void b(ExpandableItemAdapter expandableItemAdapter, int i4, boolean z3) {
        long j4;
        int groupCount = expandableItemAdapter.getGroupCount();
        d(groupCount, false);
        long[] jArr = this.f33872a;
        int[] iArr = this.f33873b;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            boolean z4 = true;
            if (i5 < groupCount) {
                long groupId = expandableItemAdapter.getGroupId(i5);
                int childCount = expandableItemAdapter.getChildCount(i5);
                if (i4 != 1 && (i4 == 2 || (!z3 && !expandableItemAdapter.getInitialGroupExpandedState(i5)))) {
                    z4 = false;
                }
                long[] jArr2 = jArr;
                long j5 = childCount | ((i5 + i7) << 32);
                if (z4) {
                    j4 = 2147483648L;
                } else {
                    j4 = 0;
                }
                jArr2[i5] = j5 | j4;
                iArr[i5] = (int) (UIDFolder.MAXUID & groupId);
                if (z4) {
                    i6++;
                    i7 += childCount;
                }
                i5++;
                jArr = jArr2;
            } else {
                this.f33878g = expandableItemAdapter;
                this.f33874c = groupCount;
                this.f33875d = i6;
                this.f33876e = i7;
                this.f33877f = Math.max(0, groupCount - 1);
                return;
            }
        }
    }

    public boolean c(int i4) {
        long[] jArr = this.f33872a;
        long j4 = jArr[i4];
        if ((2147483648L & j4) == 0) {
            return false;
        }
        jArr[i4] = j4 & (-2147483649L);
        this.f33875d--;
        this.f33876e -= (int) (2147483647L & j4);
        this.f33877f = Math.min(this.f33877f, i4);
        return true;
    }

    public boolean e(int i4) {
        long[] jArr = this.f33872a;
        long j4 = jArr[i4];
        if ((j4 & 2147483648L) != 0) {
            return false;
        }
        jArr[i4] = j4 | 2147483648L;
        this.f33875d++;
        this.f33876e += (int) (2147483647L & j4);
        this.f33877f = Math.min(this.f33877f, i4);
        return true;
    }

    public int f(int i4) {
        return (int) (this.f33872a[i4] & 2147483647L);
    }

    public int g() {
        return this.f33874c - this.f33875d;
    }

    public long h(int i4) {
        int i5;
        long j4 = -1;
        if (i4 == -1) {
            return -1L;
        }
        int i6 = this.f33874c;
        int a4 = a(this.f33872a, this.f33877f, i4);
        int i7 = this.f33877f;
        if (a4 == 0) {
            i5 = 0;
        } else {
            i5 = (int) (this.f33872a[a4] >>> 32);
        }
        while (true) {
            if (a4 < i6) {
                long[] jArr = this.f33872a;
                long j5 = jArr[a4];
                jArr[a4] = (i5 << 32) | (UIDFolder.MAXUID & j5);
                if (i5 >= i4) {
                    j4 = a.c(a4);
                    break;
                }
                i5++;
                if ((2147483648L & j5) != 0) {
                    int i8 = (int) (j5 & 2147483647L);
                    if (i8 > 0 && (i5 + i8) - 1 >= i4) {
                        j4 = a.b(a4, i4 - i5);
                        break;
                    }
                    i5 += i8;
                }
                i7 = a4;
                a4++;
            } else {
                a4 = i7;
                break;
            }
        }
        this.f33877f = Math.max(this.f33877f, a4);
        return j4;
    }

    public int i() {
        return this.f33875d;
    }

    public int j(long j4) {
        int i4 = -1;
        if (j4 == -1) {
            return -1;
        }
        int d4 = a.d(j4);
        int a4 = a.a(j4);
        int i5 = this.f33874c;
        if (d4 >= 0 && d4 < i5) {
            if (a4 != -1 && !u(d4)) {
                return -1;
            }
            int max = Math.max(0, Math.min(d4, this.f33877f));
            int i6 = this.f33877f;
            int i7 = (int) (this.f33872a[max] >>> 32);
            while (true) {
                if (max < i5) {
                    long[] jArr = this.f33872a;
                    long j5 = jArr[max];
                    jArr[max] = (i7 << 32) | (UIDFolder.MAXUID & j5);
                    int i8 = (int) (2147483647L & j5);
                    if (max == d4) {
                        if (a4 == -1) {
                            i4 = i7;
                        } else if (a4 < i8) {
                            i4 = i7 + 1 + a4;
                        }
                    } else {
                        i7++;
                        if ((j5 & 2147483648L) != 0) {
                            i7 += i8;
                        }
                        i6 = max;
                        max++;
                    }
                } else {
                    max = i6;
                    break;
                }
            }
            this.f33877f = Math.max(this.f33877f, max);
        }
        return i4;
    }

    public int k() {
        return this.f33874c + this.f33876e;
    }

    public long[] l() {
        long[] jArr = new long[this.f33874c];
        for (int i4 = 0; i4 < this.f33874c; i4++) {
            jArr[i4] = (this.f33872a[i4] & 2147483648L) | (this.f33873b[i4] << 32);
        }
        Arrays.sort(jArr);
        return jArr;
    }

    public int m(int i4) {
        if (u(i4)) {
            return f(i4);
        }
        return 0;
    }

    public void n(int i4, int i5) {
        o(i4, i5, 1);
    }

    public void o(int i4, int i5, int i6) {
        long[] jArr = this.f33872a;
        long j4 = jArr[i4];
        int i7 = (int) (2147483647L & j4);
        if (i5 >= 0 && i5 <= i7) {
            if ((2147483648L & j4) != 0) {
                this.f33876e += i6;
            }
            jArr[i4] = (i7 + i6) | (j4 & (-2147483648L));
            this.f33877f = Math.min(this.f33877f, i4);
            return;
        }
        throw new IllegalStateException("Invalid child position insertChildItems(groupPosition = " + i4 + ", childPositionStart = " + i5 + ", count = " + i6 + ")");
    }

    public int p(int i4, boolean z3) {
        return q(i4, 1, z3);
    }

    public int q(int i4, int i5, boolean z3) {
        long j4;
        int i6;
        if (i5 <= 0) {
            return 0;
        }
        d(this.f33874c + i5, true);
        ExpandableItemAdapter expandableItemAdapter = this.f33878g;
        long[] jArr = this.f33872a;
        int[] iArr = this.f33873b;
        int i7 = i4 - 1;
        int i8 = i7 + i5;
        for (int i9 = (this.f33874c - 1) + i5; i9 > i8; i9--) {
            int i10 = i9 - i5;
            jArr[i9] = jArr[i10];
            iArr[i9] = iArr[i10];
        }
        if (z3) {
            j4 = 2147483648L;
        } else {
            j4 = 0;
        }
        int i11 = i4 + i5;
        int i12 = i4;
        int i13 = 0;
        while (i12 < i11) {
            long groupId = expandableItemAdapter.getGroupId(i12);
            int childCount = expandableItemAdapter.getChildCount(i12);
            jArr[i12] = childCount | (i12 << 32) | j4;
            iArr[i12] = (int) (UIDFolder.MAXUID & groupId);
            i13 += childCount;
            i12++;
            expandableItemAdapter = expandableItemAdapter;
            i7 = i7;
        }
        int i14 = i7;
        int i15 = this.f33874c + i5;
        this.f33874c = i15;
        if (z3) {
            this.f33875d += i5;
            this.f33876e += i13;
        }
        if (i15 == 0) {
            i6 = -1;
        } else {
            i6 = i14;
        }
        this.f33877f = Math.min(this.f33877f, i6);
        if (z3) {
            return i5 + i13;
        }
        return i5;
    }

    public boolean r() {
        if (!t() && this.f33875d != 0) {
            return false;
        }
        return true;
    }

    public boolean s() {
        if (!t() && this.f33875d == this.f33874c) {
            return true;
        }
        return false;
    }

    public boolean t() {
        if (this.f33874c == 0) {
            return true;
        }
        return false;
    }

    public boolean u(int i4) {
        if ((this.f33872a[i4] & 2147483648L) != 0) {
            return true;
        }
        return false;
    }

    public void v(int i4, int i5, int i6, int i7) {
        if (i4 == i6) {
            return;
        }
        long[] jArr = this.f33872a;
        long j4 = jArr[i4];
        int i8 = (int) (j4 & 2147483647L);
        int i9 = (int) (2147483647L & jArr[i6]);
        if (i8 != 0) {
            jArr[i4] = (j4 & (-2147483648L)) | (i8 - 1);
            long j5 = (jArr[i6] & (-2147483648L)) | (i9 + 1);
            jArr[i6] = j5;
            if ((jArr[i4] & 2147483648L) != 0) {
                this.f33876e--;
            }
            if ((j5 & 2147483648L) != 0) {
                this.f33876e++;
            }
            int min = Math.min(i4, i6);
            if (min > 0) {
                this.f33877f = Math.min(this.f33877f, min - 1);
                return;
            } else {
                this.f33877f = -1;
                return;
            }
        }
        throw new IllegalStateException("moveChildItem(fromGroupPosition = " + i4 + ", fromChildPosition = " + i5 + ", toGroupPosition = " + i6 + ", toChildPosition = " + i7 + ")  --- may be a bug.");
    }

    public void w(int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        long j4 = this.f33872a[i4];
        int i6 = this.f33873b[i4];
        if (i5 < i4) {
            for (int i7 = i4; i7 > i5; i7--) {
                long[] jArr = this.f33872a;
                int i8 = i7 - 1;
                jArr[i7] = jArr[i8];
                int[] iArr = this.f33873b;
                iArr[i7] = iArr[i8];
            }
        } else {
            int i9 = i4;
            while (i9 < i5) {
                long[] jArr2 = this.f33872a;
                int i10 = i9 + 1;
                jArr2[i9] = jArr2[i10];
                int[] iArr2 = this.f33873b;
                iArr2[i9] = iArr2[i10];
                i9 = i10;
            }
        }
        this.f33872a[i5] = j4;
        this.f33873b[i5] = i6;
        int min = Math.min(i4, i5);
        if (min > 0) {
            this.f33877f = Math.min(this.f33877f, min - 1);
        } else {
            this.f33877f = -1;
        }
    }

    public void x(int i4, int i5) {
        y(i4, i5, 1);
    }

    public void y(int i4, int i5, int i6) {
        long[] jArr = this.f33872a;
        long j4 = jArr[i4];
        int i7 = (int) (2147483647L & j4);
        if (i5 >= 0 && i5 + i6 <= i7) {
            if ((2147483648L & j4) != 0) {
                this.f33876e -= i6;
            }
            jArr[i4] = (i7 - i6) | (j4 & (-2147483648L));
            this.f33877f = Math.min(this.f33877f, i4 - 1);
            return;
        }
        throw new IllegalStateException("Invalid child position removeChildItems(groupPosition = " + i4 + ", childPosition = " + i5 + ", count = " + i6 + ")");
    }

    public int z(int i4) {
        return A(i4, 1);
    }
}
