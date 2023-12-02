package com.tencent.soter.core.model;

import android.util.Log;

/* loaded from: classes6.dex */
public class SLogger {
    private static ISoterLogger mLoggerImp = new DefaultSoterLogger();

    /* loaded from: classes6.dex */
    private static class DefaultSoterLogger implements ISoterLogger {
        private DefaultSoterLogger() {
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void d(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void e(String str, String str2, Object... objArr) {
            try {
                Log.e(str, String.format(str2, objArr));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void i(String str, String str2, Object... objArr) {
            try {
                Log.i(str, String.format(str2, objArr));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void printErrStackTrace(String str, Throwable th, String str2) {
            th.printStackTrace();
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void v(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void w(String str, String str2, Object... objArr) {
            try {
                Log.w(str, String.format(str2, objArr));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        mLoggerImp.d(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        mLoggerImp.e(str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        mLoggerImp.i(str, str2, objArr);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2) {
        mLoggerImp.printErrStackTrace(str, th, str2);
    }

    public static void setLogImp(ISoterLogger iSoterLogger) {
        if (iSoterLogger != null) {
            mLoggerImp = iSoterLogger;
            return;
        }
        throw new RuntimeException("logInstance can not be null");
    }

    public static void v(String str, String str2, Object... objArr) {
        mLoggerImp.v(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        mLoggerImp.w(str, str2, objArr);
    }
}
