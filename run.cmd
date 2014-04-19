REM ------------------
REM    Check/ set variable
REM ------------------
if not defined ANT_HOME goto ERR_1
echo ANT_HOME=%ANT_HOME%
set ANT_BAT_FILE=%ANT_HOME%/bin/ant.bat
set ANT_OPTS=-Xms512m -Xmx512m

REM if not exist %ANT_BAT_FILE% goto ERR_2

:SET_CMDLINE_MODULE
REM ------------------
REM    set the CMDLINE_MODULE
REM ------------------
set CMDLINE_MODULE=
if NOT "%1" == "" (
    set CMDLINE_MODULE=-Dcmdline.module=%1
)

REM ------------------
REM    Call the ant
REM ------------------
@echo on
call "%ANT_BAT_FILE%" -lib lib %CMDLINE_MODULE%
