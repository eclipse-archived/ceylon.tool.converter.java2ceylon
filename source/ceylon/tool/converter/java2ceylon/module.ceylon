/********************************************************************************
 * Copyright (c) {date} Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
native("jvm")
suppressWarnings("ceylonNamespace")
module ceylon.tool.converter.java2ceylon "1.3.4-SNAPSHOT" {
	shared import org.eclipse.ceylon.common "1.3.4-SNAPSHOT";
	shared import org.eclipse.ceylon.cli "1.3.4-SNAPSHOT";
	shared import java.base "7";
	shared import "org.antlr.antlr4-runtime-osgi" "4.5.1";
	import ceylon.interop.java "1.3.4-SNAPSHOT";
}
