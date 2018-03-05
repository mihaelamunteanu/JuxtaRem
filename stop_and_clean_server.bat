set SERVER="C:\Mihaela\Installations\apache-tomcat-9.0.5"
set PROJECT="C:\Mihaela\JuxtaREM\webservices\juxtarem\"
call cd %SERVER%
call echo **********************************************
call %SERVER%\bin\shutdown.bat
call echo **********************************************
call del %SERVER%\logs\*.*
call echo **********************************************
call del %SERVER%\temp\*.*
call echo **********************************************
call rd /s /q %SERVER%\work\Catalina\localhost\
call echo **********************************************
call rd /s /q %SERVER%\webapps\"juxtarem-1.0.0"
call echo **********************************************
call del %SERVER%\webapps\juxtarem-1.0.0.war
call echo **********************************************
call cd %PROJECT%
call echo **********************************************
call mvn clean package -DskipTests -Dmaven.test.skip=true -Dmaven.javadoc.skip=true
call echo **********************************************
call copy "C:\Mihaela\JuxtaREM\webservices\juxtarem\target\juxtarem-1.0.0.war" "C:\Mihaela\Installations\apache-tomcat-9.0.5\webapps\"
call echo **********************************************
call cd %SERVER%\bin
rem call startup.bat
call startup_debug.bat
call cd %PROJECT%



