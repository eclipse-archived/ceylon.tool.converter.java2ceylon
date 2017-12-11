# Changes made to the original grammar

## Methods can live outside of classes

This allows easy conversion of single methods instead of whole classes and individual statements.

```g4
compilationUnit
    :	packageDeclaration? importDeclaration* typeDeclaration* EOF
    ;
```

becomes:

```g4
compilationUnit
    :   declaration+
    |   classDeclaration+
    |   (packageDeclaration? importDeclaration* typeDeclaration*) EOF
    ;

declaration
    :   methodDeclaration
    |   fieldDeclaration
    ;

singleStatement
    :   statement
    |   localVariableDeclarationStatement
    ;
```