package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.array.WasmInt16Array;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class IntoCharCodeArrayNode extends WasmBuiltinRootNode {
    protected IntoCharCodeArrayNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "intoCharCodeArray";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        // todo: test if the array is actually mutated on the wasm side afterwards
        var args = WasmArguments.getArguments(frame.getArguments());
        TruffleString s = TruffleString.fromJavaStringUncached((String) args[0], TruffleString.Encoding.UTF_16);
        var wasmarray = (WasmInt16Array) args[1];
        int start = ((Number)args[2]).intValue();
        int length = s.byteLength(TruffleString.Encoding.UTF_16);
        for (int i = 0; i < length; i++) {
            short charCode = (short) s.readCharUTF16Uncached(i);
            wasmarray.set(start+i, charCode);
        }
        return length;
    }
}
