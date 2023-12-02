package com.arlosoft.macrodroid.utils;

import android.os.Build;
import com.android.dx.io.Opcodes;

/* loaded from: classes3.dex */
public class PieBrightnessLookup {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f16072a = {new int[]{0, 0}, new int[]{1, 6}, new int[]{2, 11}, new int[]{3, 15}, new int[]{4, 19}, new int[]{5, 22}, new int[]{6, 24}, new int[]{7, 27}, new int[]{8, 29}, new int[]{9, 31}, new int[]{10, 33}, new int[]{11, 34}, new int[]{12, 36}, new int[]{13, 38}, new int[]{14, 39}, new int[]{15, 41}, new int[]{16, 42}, new int[]{17, 43}, new int[]{18, 45}, new int[]{19, 46}, new int[]{20, 47}, new int[]{21, 49}, new int[]{22, 50}, new int[]{23, 51}, new int[]{24, 52}, new int[]{25, 53}, new int[]{26, 54}, new int[]{27, 55}, new int[]{28, 56}, new int[]{29, 57}, new int[]{30, 57}, new int[]{31, 57}, new int[]{32, 57}, new int[]{33, 60}, new int[]{34, 60}, new int[]{35, 61}, new int[]{36, 62}, new int[]{37, 62}, new int[]{38, 63}, new int[]{39, 63}, new int[]{40, 64}, new int[]{41, 64}, new int[]{42, 65}, new int[]{43, 65}, new int[]{44, 66}, new int[]{45, 66}, new int[]{46, 67}, new int[]{47, 67}, new int[]{48, 68}, new int[]{49, 68}, new int[]{50, 69}, new int[]{51, 69}, new int[]{52, 70}, new int[]{53, 70}, new int[]{54, 70}, new int[]{55, 71}, new int[]{56, 71}, new int[]{57, 71}, new int[]{58, 72}, new int[]{59, 72}, new int[]{60, 72}, new int[]{61, 73}, new int[]{62, 73}, new int[]{63, 73}, new int[]{64, 74}, new int[]{65, 74}, new int[]{66, 74}, new int[]{67, 75}, new int[]{68, 75}, new int[]{71, 76}, new int[]{73, 76}, new int[]{76, 77}, new int[]{79, 78}, new int[]{80, 78}, new int[]{81, 78}, new int[]{84, 79}, new int[]{86, 80}, new int[]{89, 80}, new int[]{91, 81}, new int[]{94, 81}, new int[]{96, 82}, new int[]{97, 82}, new int[]{98, 82}, new int[]{99, 82}, new int[]{102, 83}, new int[]{104, 83}, new int[]{107, 84}, new int[]{109, 84}, new int[]{112, 85}, new int[]{114, 85}, new int[]{117, 85}, new int[]{119, 86}, new int[]{122, 87}, new int[]{124, 87}, new int[]{127, 87}, new int[]{130, 88}, new int[]{132, 88}, new int[]{133, 88}, new int[]{134, 88}, new int[]{135, 88}, new int[]{136, 88}, new int[]{137, 88}, new int[]{138, 89}, new int[]{139, 89}, new int[]{140, 89}, new int[]{141, 89}, new int[]{142, 89}, new int[]{143, 89}, new int[]{144, 89}, new int[]{145, 90}, new int[]{146, 90}, new int[]{147, 90}, new int[]{148, 90}, new int[]{149, 90}, new int[]{150, 90}, new int[]{151, 90}, new int[]{152, 91}, new int[]{153, 91}, new int[]{154, 91}, new int[]{155, 91}, new int[]{156, 91}, new int[]{157, 91}, new int[]{158, 91}, new int[]{159, 91}, new int[]{160, 91}, new int[]{161, 91}, new int[]{162, 92}, new int[]{163, 92}, new int[]{164, 92}, new int[]{165, 92}, new int[]{166, 92}, new int[]{167, 92}, new int[]{168, 92}, new int[]{169, 92}, new int[]{170, 92}, new int[]{171, 93}, new int[]{172, 93}, new int[]{173, 93}, new int[]{174, 93}, new int[]{175, 93}, new int[]{176, 93}, new int[]{177, 93}, new int[]{178, 93}, new int[]{179, 93}, new int[]{180, 94}, new int[]{181, 94}, new int[]{182, 94}, new int[]{183, 94}, new int[]{184, 94}, new int[]{185, 94}, new int[]{186, 94}, new int[]{187, 94}, new int[]{188, 94}, new int[]{189, 94}, new int[]{190, 95}, new int[]{191, 95}, new int[]{192, 95}, new int[]{193, 95}, new int[]{194, 95}, new int[]{195, 95}, new int[]{196, 95}, new int[]{197, 95}, new int[]{198, 95}, new int[]{199, 95}, new int[]{200, 96}, new int[]{201, 96}, new int[]{202, 96}, new int[]{203, 96}, new int[]{204, 96}, new int[]{205, 96}, new int[]{206, 96}, new int[]{207, 96}, new int[]{Opcodes.ADD_INT_LIT16, 96}, new int[]{Opcodes.RSUB_INT, 96}, new int[]{Opcodes.MUL_INT_LIT16, 96}, new int[]{Opcodes.DIV_INT_LIT16, 96}, new int[]{Opcodes.REM_INT_LIT16, 97}, new int[]{213, 97}, new int[]{Opcodes.OR_INT_LIT16, 97}, new int[]{Opcodes.XOR_INT_LIT16, 97}, new int[]{Opcodes.ADD_INT_LIT8, 97}, new int[]{Opcodes.RSUB_INT_LIT8, 97}, new int[]{Opcodes.MUL_INT_LIT8, 97}, new int[]{Opcodes.DIV_INT_LIT8, 97}, new int[]{Opcodes.REM_INT_LIT8, 97}, new int[]{221, 97}, new int[]{222, 97}, new int[]{Opcodes.XOR_INT_LIT8, 98}, new int[]{Opcodes.SHL_INT_LIT8, 98}, new int[]{Opcodes.SHR_INT_LIT8, 98}, new int[]{Opcodes.USHR_INT_LIT8, 98}, new int[]{227, 98}, new int[]{228, 98}, new int[]{229, 98}, new int[]{230, 98}, new int[]{231, 98}, new int[]{232, 98}, new int[]{233, 98}, new int[]{234, 98}, new int[]{235, 99}, new int[]{236, 99}, new int[]{237, 99}, new int[]{238, 99}, new int[]{239, 99}, new int[]{240, 99}, new int[]{241, 99}, new int[]{242, 99}, new int[]{243, 99}, new int[]{244, 99}, new int[]{245, 99}, new int[]{246, 99}, new int[]{247, 99}, new int[]{248, 100}, new int[]{249, 100}, new int[]{250, 100}, new int[]{251, 100}, new int[]{252, 100}, new int[]{253, 100}, new int[]{254, 100}, new int[]{255, 100}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f16073b = {new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}, new int[]{5, 5}, new int[]{6, 6}, new int[]{7, 7}, new int[]{8, 8}, new int[]{9, 9}, new int[]{10, 10}, new int[]{11, 11}, new int[]{12, 12}, new int[]{13, 13}, new int[]{14, 14}, new int[]{15, 15}, new int[]{16, 16}, new int[]{17, 17}, new int[]{18, 18}, new int[]{19, 19}, new int[]{20, 20}, new int[]{21, 21}, new int[]{22, 22}, new int[]{23, 23}, new int[]{24, 24}, new int[]{25, 25}, new int[]{26, 26}, new int[]{27, 27}, new int[]{28, 28}, new int[]{29, 29}, new int[]{30, 30}, new int[]{31, 31}, new int[]{32, 32}, new int[]{33, 33}, new int[]{34, 34}, new int[]{35, 35}, new int[]{36, 36}, new int[]{37, 37}, new int[]{38, 38}, new int[]{39, 39}, new int[]{40, 40}, new int[]{41, 41}, new int[]{42, 42}, new int[]{43, 43}, new int[]{44, 44}, new int[]{45, 44}, new int[]{46, 45}, new int[]{47, 45}, new int[]{48, 46}, new int[]{49, 46}, new int[]{50, 47}, new int[]{51, 47}, new int[]{52, 48}, new int[]{53, 48}, new int[]{54, 49}, new int[]{55, 50}, new int[]{57, 51}, new int[]{58, 52}, new int[]{60, 53}, new int[]{61, 54}, new int[]{63, 55}, new int[]{64, 56}, new int[]{65, 57}, new int[]{66, 58}, new int[]{67, 59}, new int[]{70, 60}, new int[]{71, 61}, new int[]{73, 62}, new int[]{76, 63}, new int[]{79, 64}, new int[]{80, 65}, new int[]{81, 66}, new int[]{84, 67}, new int[]{86, 68}, new int[]{89, 69}, new int[]{90, 70}, new int[]{92, 71}, new int[]{94, 72}, new int[]{96, 73}, new int[]{98, 74}, new int[]{100, 75}, new int[]{104, 75}, new int[]{107, 76}, new int[]{109, 76}, new int[]{112, 76}, new int[]{114, 77}, new int[]{150, 77}, new int[]{119, 77}, new int[]{122, 77}, new int[]{124, 78}, new int[]{127, 78}, new int[]{130, 78}, new int[]{132, 78}, new int[]{133, 78}, new int[]{134, 79}, new int[]{135, 79}, new int[]{136, 79}, new int[]{137, 79}, new int[]{138, 80}, new int[]{139, 80}, new int[]{140, 80}, new int[]{141, 80}, new int[]{142, 80}, new int[]{143, 81}, new int[]{144, 81}, new int[]{145, 81}, new int[]{146, 81}, new int[]{147, 82}, new int[]{148, 82}, new int[]{149, 82}, new int[]{150, 82}, new int[]{151, 82}, new int[]{152, 83}, new int[]{153, 83}, new int[]{154, 83}, new int[]{155, 83}, new int[]{156, 83}, new int[]{157, 84}, new int[]{158, 84}, new int[]{159, 84}, new int[]{160, 84}, new int[]{161, 84}, new int[]{162, 84}, new int[]{163, 85}, new int[]{164, 85}, new int[]{165, 85}, new int[]{166, 85}, new int[]{167, 85}, new int[]{168, 85}, new int[]{169, 86}, new int[]{170, 86}, new int[]{171, 86}, new int[]{172, 86}, new int[]{173, 87}, new int[]{174, 87}, new int[]{175, 87}, new int[]{176, 87}, new int[]{177, 88}, new int[]{178, 88}, new int[]{179, 88}, new int[]{180, 88}, new int[]{181, 88}, new int[]{182, 89}, new int[]{183, 89}, new int[]{184, 89}, new int[]{185, 89}, new int[]{186, 90}, new int[]{187, 90}, new int[]{188, 90}, new int[]{189, 90}, new int[]{190, 90}, new int[]{191, 91}, new int[]{192, 91}, new int[]{193, 91}, new int[]{194, 91}, new int[]{195, 91}, new int[]{196, 92}, new int[]{197, 92}, new int[]{198, 92}, new int[]{199, 92}, new int[]{200, 92}, new int[]{201, 93}, new int[]{202, 93}, new int[]{203, 93}, new int[]{204, 93}, new int[]{205, 94}, new int[]{206, 94}, new int[]{207, 94}, new int[]{Opcodes.ADD_INT_LIT16, 94}, new int[]{Opcodes.RSUB_INT, 94}, new int[]{Opcodes.MUL_INT_LIT16, 95}, new int[]{Opcodes.DIV_INT_LIT16, 95}, new int[]{Opcodes.REM_INT_LIT16, 95}, new int[]{213, 95}, new int[]{Opcodes.OR_INT_LIT16, 95}, new int[]{Opcodes.XOR_INT_LIT16, 95}, new int[]{Opcodes.ADD_INT_LIT8, 96}, new int[]{Opcodes.RSUB_INT_LIT8, 96}, new int[]{Opcodes.MUL_INT_LIT8, 96}, new int[]{Opcodes.DIV_INT_LIT8, 96}, new int[]{Opcodes.REM_INT_LIT8, 96}, new int[]{221, 96}, new int[]{222, 96}, new int[]{Opcodes.XOR_INT_LIT8, 97}, new int[]{Opcodes.SHL_INT_LIT8, 97}, new int[]{Opcodes.SHR_INT_LIT8, 97}, new int[]{Opcodes.USHR_INT_LIT8, 97}, new int[]{227, 97}, new int[]{228, 97}, new int[]{229, 97}, new int[]{230, 97}, new int[]{231, 98}, new int[]{232, 98}, new int[]{233, 98}, new int[]{234, 98}, new int[]{235, 98}, new int[]{236, 98}, new int[]{237, 98}, new int[]{238, 98}, new int[]{239, 98}, new int[]{240, 98}, new int[]{241, 98}, new int[]{242, 99}, new int[]{243, 99}, new int[]{244, 99}, new int[]{245, 99}, new int[]{246, 99}, new int[]{247, 99}, new int[]{248, 99}, new int[]{249, 99}, new int[]{250, 99}, new int[]{251, 99}, new int[]{252, 99}, new int[]{253, 99}, new int[]{254, 100}, new int[]{255, 100}};

    private static int a(int i4, int i5, boolean z3, boolean z4) {
        int[][] iArr;
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            iArr = f16073b;
        } else {
            iArr = f16072a;
        }
        int length = iArr.length;
        int i6 = !z3 ? 1 : 0;
        if (z4) {
            while (i5 < length) {
                int[] iArr2 = iArr[i5];
                if (iArr2[i6] >= i4) {
                    return iArr2[z3 ? 1 : 0];
                }
                i5++;
            }
            return 0;
        }
        while (i5 >= 0) {
            int[] iArr3 = iArr[i5];
            if (iArr3[i6] <= i4) {
                return iArr3[z3 ? 1 : 0];
            }
            i5--;
        }
        return 0;
    }

    public static int lookup(int i4, boolean z3) {
        int[][] iArr;
        boolean z4;
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            iArr = f16073b;
        } else {
            iArr = f16072a;
        }
        int length = iArr.length - 1;
        if (!z3 && i4 < 24) {
            return a(i4, 0, false, true);
        }
        int i5 = 0;
        int i6 = 0;
        boolean z5 = true;
        while (i5 <= length) {
            i6 = (i5 + length) / 2;
            int i7 = i4 - iArr[i6][!z3 ? 1 : 0];
            if (i7 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (Math.abs(i7) < 2) {
                return a(i4, i6, z3, z4);
            }
            if (z4) {
                i5 = i6 + 1;
            } else {
                length = i6 - 1;
            }
            z5 = z4;
        }
        return a(i4, i6, z3, z5);
    }
}
