/********************************************************************************
 * Copyright (c) 2011-2017 Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
import java.io {
	File,
	FileWriter,
	FileInputStream
}
import org.antlr.v4.runtime {
	ANTLRInputStream,
	CommonTokenStream
}

"Converts the given Java file to Ceylon."
shared void convert(String? sourceFile, String? targetFile, Boolean transformGetters = false,
	 Boolean useValues = false) {
	
	value f = File(sourceFile);
	
	value input = ANTLRInputStream(FileInputStream(f));
	value lexer = Java8Lexer(input);
	value tokens = CommonTokenStream(lexer);
	value parser = Java8Parser(tokens);
	
	value tree = parser.compilationUnit();
	
	value fw = FileWriter(File(targetFile));
	
	value scopeTree = ScopeTree();
	
	tree.accept(scopeTree);
	
	value converter = JavaToCeylonConverter(fw, transformGetters, useValues, scopeTree);
	
	tree.accept(converter);
	
	fw.flush();
	fw.close();
}

"Run the module `ceylon.tool.converter.java2ceylon`."
shared void run() {
	if (process.arguments.size == 2) {
		convert(process.arguments[0], process.arguments[1]);
	} else {
		print("Wrong options. Try `ceylon convert --help` for help.");
	}
}
