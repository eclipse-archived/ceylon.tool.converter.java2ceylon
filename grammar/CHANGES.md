# Changes made to the original grammar

## Methods can live outside of classes

This allows easy conversion of single methods instead of whole classes.

```
compilationUnit
	:	packageDeclaration? importDeclaration* typeDeclaration* EOF
	;
```

becomes:

```
compilationUnit
	:	methodDeclaration+ | (packageDeclaration? importDeclaration* typeDeclaration*) EOF
	;
```