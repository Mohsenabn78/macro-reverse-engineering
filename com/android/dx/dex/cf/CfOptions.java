package com.android.dx.dex.cf;

import java.io.PrintStream;

/* loaded from: classes2.dex */
public class CfOptions {
    public boolean statistics;
    public int positionInfo = 2;
    public boolean localInfo = false;
    public boolean strictNameCheck = true;
    public boolean optimize = false;
    public String optimizeListFile = null;
    public String dontOptimizeListFile = null;
    public PrintStream warn = System.err;
}
