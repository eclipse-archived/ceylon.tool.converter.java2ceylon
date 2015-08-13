import java.io {
	File,
	BufferedWriter,
	FileWriter,
	FileInputStream
}
import org.antlr.v4.runtime {
	ANTLRInputStream,
	CommonTokenStream,
	ParserRuleContext
}
import org.antlr.v4.runtime.tree {
	ParseTreeWalker
}

"Converts the given Java file to Ceylon."
shared void convert(String? file1, String? file2, Boolean transformGetters = false) {

	File f = File(file1);
	
	ANTLRInputStream input = ANTLRInputStream(FileInputStream(f));
	Java8Lexer lexer = Java8Lexer(input);
	CommonTokenStream tokens = CommonTokenStream(lexer);
	Java8Parser parser = Java8Parser(tokens);
	
	ParserRuleContext tree = parser.compilationUnit();
	// tree.inspect(parser);
	
	BufferedWriter bw = BufferedWriter(FileWriter(File(file2)));
	
	JavaToCeylonConverter converter = JavaToCeylonConverter(bw, transformGetters);
	
	// Java8Listener listener = new Java8Listener(this);
	
	ParseTreeWalker.\iDEFAULT.walk(converter, tree);
	converter.close();
}

"Run the module `com.redhat.ceylon.converter`."
shared void run() {
	if (process.arguments.size != 2) {
		print("First Argument: original java file.\nSecond Argument: destination ceylon file");
	} else {
		convert(process.arguments[0], process.arguments[1]);
	}
}
