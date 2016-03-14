@echo off
setlocal EnableDelayedExpansion

set "USAGE=[OPTION]... ( FILE [--and FILE]... [--to FILE] )..."
set "DESCRIPTION=Convert Java code to Ceylon"

^

OPTIONS^

^

--help^

    Print this help message.^

    (--help=options prints help for the various options.)^

^

--version^

    Print version information. ^


call %CEYLON_HOME%\bin\ceylon-sh-setup.bat %*

if "%errorlevel%" == "1" (
    exit /b 0
)
%CEYLON% run ceylon.tool.converter.java2ceylon/1.2.3 "%*"
