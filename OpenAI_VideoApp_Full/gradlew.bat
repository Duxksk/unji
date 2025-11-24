@rem
@rem Copyright 2015-2023 
@rem
@rem Licensed under the Apache License, Version 2.0
@rem

@echo off
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

set CLASSPATH=%~dp0\gradle\wrapper\gradle-wrapper.jar

set CMD_LINE_ARGS=%*

"%JAVA_HOME%\bin\java.exe" %DEFAULT_JVM_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 exit /b %ERRORLEVEL%
