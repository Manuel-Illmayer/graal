package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class CodePointAtNode extends WasmBuiltinRootNode {
    protected CodePointAtNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "codePointAt";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        // TODO: check the following methods
        // TruffleString.CodePointAtIndexNode
        // TruffleString.CodePointAtByteIndexNode
        // TruffleString.CodePointAtIndexUTF32Node
        var args = WasmArguments.getArguments(frame.getArguments());
        TruffleString s = TruffleString.fromJavaStringUncached((String) args[0], TruffleString.Encoding.UTF_16);
        int i = (int) args[1];
        return TruffleString.CodePointAtIndexNode.create().execute(s, i, TruffleString.Encoding.UTF_16);
    }
}
