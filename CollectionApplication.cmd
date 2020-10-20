::=============================================================
:: Task 5 - Collection Framework
:: This should be at the same folder as CollectionApplication.jar
:: This is for executing CollectionApplication application
::=============================================================

@ECHO OFF
set file_name=CollectionApplication.jar

:: Check if .jar file available
IF NOT EXIST %~dp0%file_name% (
ECHO Error: CollectionApplication.jar is not found
EXIT /B 2
)


java -jar %~dp0%file_name% %*

