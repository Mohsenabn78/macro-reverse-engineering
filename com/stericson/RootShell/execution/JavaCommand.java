package com.stericson.RootShell.execution;

import android.content.Context;

/* loaded from: classes6.dex */
public class JavaCommand extends Command {
    public JavaCommand(int i4, Context context, String... strArr) {
        super(i4, strArr);
        this.f37443b = context;
        this.f37442a = true;
    }

    @Override // com.stericson.RootShell.execution.Command
    public void commandOutput(int i4, String str) {
        super.commandOutput(i4, str);
    }

    public JavaCommand(int i4, boolean z3, Context context, String... strArr) {
        super(i4, z3, strArr);
        this.f37443b = context;
        this.f37442a = true;
    }

    public JavaCommand(int i4, int i5, Context context, String... strArr) {
        super(i4, i5, strArr);
        this.f37443b = context;
        this.f37442a = true;
    }

    @Override // com.stericson.RootShell.execution.Command
    public void commandCompleted(int i4, int i5) {
    }

    @Override // com.stericson.RootShell.execution.Command
    public void commandTerminated(int i4, String str) {
    }
}
