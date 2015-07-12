package com.rohit.converter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * 
 * @author rohitmohan96
 * 
 */
public class Main {

	/**
	 * Main Method
	 * 
	 * @author rohitmohan96
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("First Argument: original java file.\nSecond Argument: destination ceylon file");
		} else {
			File f = new File(args[0]);

			ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(f));
			Java8Lexer lexer = new Java8Lexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			Java8Parser parser = new Java8Parser(tokens);

			ParserRuleContext tree = (ParserRuleContext) parser.compilationUnit();
			// tree.inspect(parser);

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(args[1])));

			JavaToCeylonConverter converter = new JavaToCeylonConverter(bw);

			// Java8Listener listener = new Java8Listener(this);

			ParseTreeWalker.DEFAULT.walk(converter, tree);

			converter.close();
		}
	}
}