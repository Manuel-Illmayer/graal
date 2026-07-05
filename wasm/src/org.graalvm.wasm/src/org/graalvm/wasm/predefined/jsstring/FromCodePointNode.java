package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class FromCodePointNode extends WasmBuiltinRootNode {
    protected FromCodePointNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "fromCodePoint";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        // TODO: test edge cases
        var args = WasmArguments.getArguments(frame.getArguments());
        return TruffleString.fromCodePointUncached((int)args[0], TruffleString.Encoding.UTF_16, true);
    }
}
