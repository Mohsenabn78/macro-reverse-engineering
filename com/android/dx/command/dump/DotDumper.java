package com.android.dx.command.dump;

import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.ssa.Optimizer;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.PrintStream;

/* loaded from: classes2.dex */
public class DotDumper implements ParseObserver {
    private final Args args;
    private final byte[] bytes;
    private DirectClassFile classFile;
    private final String filePath;
    private final boolean optimize;
    private final boolean strictParse;

    DotDumper(byte[] bArr, String str, Args args) {
        this.bytes = bArr;
        this.filePath = str;
        this.strictParse = args.strictParse;
        this.optimize = args.optimize;
        this.args = args;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dump(byte[] bArr, String str, Args args) {
        new DotDumper(bArr, str, args).run();
    }

    private void run() {
        ByteArray byteArray = new ByteArray(this.bytes);
        DirectClassFile directClassFile = new DirectClassFile(byteArray, this.filePath, this.strictParse);
        this.classFile = directClassFile;
        StdAttributeFactory stdAttributeFactory = StdAttributeFactory.THE_ONE;
        directClassFile.setAttributeFactory(stdAttributeFactory);
        this.classFile.getMagic();
        DirectClassFile directClassFile2 = new DirectClassFile(byteArray, this.filePath, this.strictParse);
        directClassFile2.setAttributeFactory(stdAttributeFactory);
        directClassFile2.setObserver(this);
        directClassFile2.getMagic();
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void endParsingMember(ByteArray byteArray, int i4, String str, String str2, Member member) {
        if (!(member instanceof Method) || !shouldDumpMethod(str)) {
            return;
        }
        ConcreteMethod concreteMethod = new ConcreteMethod((Method) member, this.classFile, true, true);
        DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
        RopMethod convert = Ropper.convert(concreteMethod, dexTranslationAdvice, this.classFile.getMethods());
        if (this.optimize) {
            boolean isStatic = AccessFlags.isStatic(concreteMethod.getAccessFlags());
            convert = Optimizer.optimize(convert, BaseDumper.computeParamWidth(concreteMethod, isStatic), isStatic, true, dexTranslationAdvice);
        }
        PrintStream printStream = System.out;
        printStream.println("digraph " + str + "{");
        PrintStream printStream2 = System.out;
        printStream2.println("\tfirst -> n" + Hex.u2(convert.getFirstLabel()) + ";");
        BasicBlockList blocks = convert.getBlocks();
        int size = blocks.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            BasicBlock basicBlock = blocks.get(i6);
            int label = basicBlock.getLabel();
            IntList successors = basicBlock.getSuccessors();
            if (successors.size() == 0) {
                PrintStream printStream3 = System.out;
                printStream3.println("\tn" + Hex.u2(label) + " -> returns;");
            } else if (successors.size() == 1) {
                PrintStream printStream4 = System.out;
                printStream4.println("\tn" + Hex.u2(label) + " -> n" + Hex.u2(successors.get(i5)) + ";");
            } else {
                PrintStream printStream5 = System.out;
                printStream5.print("\tn" + Hex.u2(label) + " -> {");
                for (int i7 = 0; i7 < successors.size(); i7++) {
                    int i8 = successors.get(i7);
                    if (i8 != basicBlock.getPrimarySuccessor()) {
                        PrintStream printStream6 = System.out;
                        printStream6.print(" n" + Hex.u2(i8) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    }
                }
                System.out.println("};");
                PrintStream printStream7 = System.out;
                printStream7.println("\tn" + Hex.u2(label) + " -> n" + Hex.u2(basicBlock.getPrimarySuccessor()) + " [label=\"primary\"];");
            }
            i6++;
            i5 = 0;
        }
        System.out.println("}");
    }

    protected boolean shouldDumpMethod(String str) {
        String str2 = this.args.method;
        if (str2 != null && !str2.equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void changeIndent(int i4) {
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void parsed(ByteArray byteArray, int i4, int i5, String str) {
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void startParsingMember(ByteArray byteArray, int i4, String str, String str2) {
    }
}
