package com.android.dx.command.dump;

import com.android.dx.cf.code.BasicBlocker;
import com.android.dx.cf.code.ByteBlock;
import com.android.dx.cf.code.ByteBlockList;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.CodeObserver;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.cst.CstType;
import com.android.dx.ssa.Optimizer;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.PrintStream;
import org.joni.constants.internal.StackType;

/* loaded from: classes2.dex */
public class BlockDumper extends BaseDumper {
    protected DirectClassFile classFile;
    private boolean first;
    private boolean optimize;
    private boolean rop;
    protected boolean suppressDump;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockDumper(byte[] bArr, PrintStream printStream, String str, boolean z3, Args args) {
        super(bArr, printStream, str, args);
        this.rop = z3;
        this.classFile = null;
        this.suppressDump = true;
        this.first = true;
        this.optimize = args.optimize;
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, boolean z3, Args args) {
        new BlockDumper(bArr, printStream, str, z3, args).dump();
    }

    private void regularDump(ConcreteMethod concreteMethod) {
        String human;
        BytecodeArray code = concreteMethod.getCode();
        ByteArray bytes = code.getBytes();
        ByteBlockList identifyBlocks = BasicBlocker.identifyBlocks(concreteMethod);
        int size = identifyBlocks.size();
        CodeObserver codeObserver = new CodeObserver(bytes, this);
        setAt(bytes, 0);
        this.suppressDump = false;
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            ByteBlock byteBlock = identifyBlocks.get(i4);
            int start = byteBlock.getStart();
            int end = byteBlock.getEnd();
            if (i5 < start) {
                parsed(bytes, i5, start - i5, "dead code " + Hex.u2(i5) + ".." + Hex.u2(start));
            }
            parsed(bytes, start, 0, "block " + Hex.u2(byteBlock.getLabel()) + ": " + Hex.u2(start) + ".." + Hex.u2(end));
            changeIndent(1);
            while (start < end) {
                int parseInstruction = code.parseInstruction(start, codeObserver);
                codeObserver.setPreviousOffset(start);
                start += parseInstruction;
            }
            IntList successors = byteBlock.getSuccessors();
            int size2 = successors.size();
            if (size2 == 0) {
                parsed(bytes, end, 0, "returns");
            } else {
                for (int i6 = 0; i6 < size2; i6++) {
                    int i7 = successors.get(i6);
                    parsed(bytes, end, 0, "next " + Hex.u2(i7));
                }
            }
            ByteCatchList catches = byteBlock.getCatches();
            int size3 = catches.size();
            for (int i8 = 0; i8 < size3; i8++) {
                ByteCatchList.Item item = catches.get(i8);
                CstType exceptionClass = item.getExceptionClass();
                StringBuilder sb = new StringBuilder();
                sb.append("catch ");
                if (exceptionClass == CstType.OBJECT) {
                    human = "<any>";
                } else {
                    human = exceptionClass.toHuman();
                }
                sb.append(human);
                sb.append(" -> ");
                sb.append(Hex.u2(item.getHandlerPc()));
                parsed(bytes, end, 0, sb.toString());
            }
            changeIndent(-1);
            i4++;
            i5 = end;
        }
        int size4 = bytes.size();
        if (i5 < size4) {
            parsed(bytes, i5, size4 - i5, "dead code " + Hex.u2(i5) + ".." + Hex.u2(size4));
        }
        this.suppressDump = true;
    }

    private void ropDump(ConcreteMethod concreteMethod) {
        DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
        ByteArray bytes = concreteMethod.getCode().getBytes();
        RopMethod convert = Ropper.convert(concreteMethod, dexTranslationAdvice, this.classFile.getMethods());
        StringBuffer stringBuffer = new StringBuffer(2000);
        if (this.optimize) {
            boolean isStatic = AccessFlags.isStatic(concreteMethod.getAccessFlags());
            convert = Optimizer.optimize(convert, BaseDumper.computeParamWidth(concreteMethod, isStatic), isStatic, true, dexTranslationAdvice);
        }
        BasicBlockList blocks = convert.getBlocks();
        int[] labelsInOrder = blocks.getLabelsInOrder();
        stringBuffer.append("first " + Hex.u2(convert.getFirstLabel()) + "\n");
        for (int i4 : labelsInOrder) {
            BasicBlock basicBlock = blocks.get(blocks.indexOfLabel(i4));
            stringBuffer.append("block ");
            stringBuffer.append(Hex.u2(i4));
            stringBuffer.append("\n");
            IntList labelToPredecessors = convert.labelToPredecessors(i4);
            int size = labelToPredecessors.size();
            for (int i5 = 0; i5 < size; i5++) {
                stringBuffer.append("  pred ");
                stringBuffer.append(Hex.u2(labelToPredecessors.get(i5)));
                stringBuffer.append("\n");
            }
            InsnList insns = basicBlock.getInsns();
            int size2 = insns.size();
            for (int i6 = 0; i6 < size2; i6++) {
                insns.get(i6);
                stringBuffer.append("  ");
                stringBuffer.append(insns.get(i6).toHuman());
                stringBuffer.append("\n");
            }
            IntList successors = basicBlock.getSuccessors();
            int size3 = successors.size();
            if (size3 == 0) {
                stringBuffer.append("  returns\n");
            } else {
                int primarySuccessor = basicBlock.getPrimarySuccessor();
                for (int i7 = 0; i7 < size3; i7++) {
                    int i8 = successors.get(i7);
                    stringBuffer.append("  next ");
                    stringBuffer.append(Hex.u2(i8));
                    if (size3 != 1 && i8 == primarySuccessor) {
                        stringBuffer.append(" *");
                    }
                    stringBuffer.append("\n");
                }
            }
        }
        this.suppressDump = false;
        setAt(bytes, 0);
        parsed(bytes, 0, bytes.size(), stringBuffer.toString());
        this.suppressDump = true;
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void changeIndent(int i4) {
        if (!this.suppressDump) {
            super.changeIndent(i4);
        }
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void endParsingMember(ByteArray byteArray, int i4, String str, String str2, Member member) {
        if (!(member instanceof Method) || !shouldDumpMethod(str) || (member.getAccessFlags() & StackType.POS) != 0) {
            return;
        }
        ConcreteMethod concreteMethod = new ConcreteMethod((Method) member, this.classFile, true, true);
        if (this.rop) {
            ropDump(concreteMethod);
        } else {
            regularDump(concreteMethod);
        }
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void parsed(ByteArray byteArray, int i4, int i5, String str) {
        if (!this.suppressDump) {
            super.parsed(byteArray, i4, i5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldDumpMethod(String str) {
        String str2 = this.args.method;
        if (str2 != null && !str2.equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.command.dump.BaseDumper, com.android.dx.cf.iface.ParseObserver
    public void startParsingMember(ByteArray byteArray, int i4, String str, String str2) {
        if (str2.indexOf(40) < 0 || !shouldDumpMethod(str)) {
            return;
        }
        setAt(byteArray, i4);
        this.suppressDump = false;
        if (this.first) {
            this.first = false;
        } else {
            parsed(byteArray, i4, 0, "\n");
        }
        parsed(byteArray, i4, 0, "method " + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2);
        this.suppressDump = true;
    }

    public void dump() {
        ByteArray byteArray = new ByteArray(getBytes());
        DirectClassFile directClassFile = new DirectClassFile(byteArray, getFilePath(), getStrictParse());
        this.classFile = directClassFile;
        StdAttributeFactory stdAttributeFactory = StdAttributeFactory.THE_ONE;
        directClassFile.setAttributeFactory(stdAttributeFactory);
        this.classFile.getMagic();
        DirectClassFile directClassFile2 = new DirectClassFile(byteArray, getFilePath(), getStrictParse());
        directClassFile2.setAttributeFactory(stdAttributeFactory);
        directClassFile2.setObserver(this);
        directClassFile2.getMagic();
    }
}
