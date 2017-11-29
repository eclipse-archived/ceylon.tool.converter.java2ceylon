/********************************************************************************
 * Copyright (c) 2011-2017 Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
import org.eclipse.ceylon.common.tool {
	description,
	description__SETTER,
	option__SETTER,
	summary,
	CeylonBaseTool,
	argument__SETTER
}
import java.lang {
	JString=String
}
import java.util {
	JList=List
}

summary ("Convert Java code to Ceylon")
description ("ceylon convert \"full/directory/of/java/file.java\" \"test.ceylon\"")
shared class CeylonConvertTool() extends CeylonBaseTool() {
	argument__SETTER { multiplicity = "2"; }
	shared variable JList<JString>? arguments = null;
	
	description__SETTER ("Transform getters to properties, use `--tranform-getters`")
	option__SETTER
	shared variable Boolean transformGetters = false;
	
	description__SETTER ("Transform getters to properties, use `--use-values`")
	option__SETTER
	shared variable Boolean useValues = false;
	
	shared actual void run() {
		if (exists v = arguments) {
			convert(v.get(0).string, v.get(1).string, transformGetters, useValues);
		} else {
			print("Wrong options. Try `ceylon convert --help` for help.");
		}
	}
}
