package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class CompareNode extends WasmBuiltinRootNode {
    protected CompareNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "compare";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        // TODO: confirm java compareTo method is the same as js `<` operator
        var args = WasmArguments.getArguments(frame.getArguments());
        String first = (String)args[0];
        String second = (String)args[1];
        int comp = first.compareTo(second);
        return comp == 0 ? 0 : (comp < 0 ? -1 : 1); // docs say Integer.compare returns "a value less than 0"... so thats not even the same
    }
}
