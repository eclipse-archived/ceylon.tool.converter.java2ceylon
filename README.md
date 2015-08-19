# Java to Ceylon Converter

This is a project to convert java to Ceylon. 
The Main class generates an AST and converts the given java file to Ceylon.
The Main class requires 2 arguments - the location of the source java file and the destination Ceylon file.

## Instructions

###With `ant`

```bash
git clone https://github.com/ceylon/ceylon.tool.converter.java2ceylon.git
cd ceylon.tool.converter.java2ceylon
ant install
```

The buildfile assumes that `ceylon-dist` (including the Ceylon ant files) is a sibling folder; otherwise, you might have to adjust the paths in `build.properties`.

###Usage

If you have the plugin installed,

`ceylon convert 'full/directory/of/java/file.java' 'test.ceylon'`

If you don't have the plugin installed run

`ceylon run ceylon.tool.converter.java2ceylon 'full/directory/of/java/file.java' 'test.ceylon'`

### About AntLR

We ship with a project repo in `repo/` which contains AntLR already pre-imported in a Ceylon
repo, with its name changed to comply with the OSGi it contains, as doing otherwise would
wreak havoc in Eclipse. We can't just import the module directly from Maven Central because
it would use the Maven module name and not the OSGi name it declares.

When a new release of AntLR comes out, we have to manually reimport it with `ceylon import`
using the same `module.xml` file we have in `repo/`.

When they fix their OSGi metadata we can change this: https://github.com/antlr/antlr4/issues/980